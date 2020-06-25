package com.sap.co2calculator.main;

import java.util.HashMap;

import com.sap.transportFactory.TransportFactory;

public class C02EmissionCalculator {

	private HashMap<String, String> getcommandlineargs(String[] args) {
		Integer length = args.length;
		HashMap<String, String> inputs = new HashMap<String, String>();
		int i = 0;
		while (i < length) {

			if (args[i].contains("--transportation-method"))
				addinputs(inputs, args, i, "--transportation-method");
			else if (args[i].contains("--distance"))
				addinputs(inputs, args, i, "--distance");
			else if (args[i].contains("--unit-of-distance"))
				addinputs(inputs, args, i, "--unit-of-distance");
			else if (args[i].contains("--output"))
				addinputs(inputs, args, i, "--output");

			++i;
		}
		return inputs;

	}

	private void addinputs(HashMap<String, String> inputs, String[] args, Integer i, String desc) {

		if (args[i].contains("=")) {
			String[] arr = args[i].split("=");
			inputs.put(desc, arr[1]);
		} else {
			inputs.put(desc, args[i + 1]);
		}
	}

	private Double calcuateco2(HashMap<String, String> inputs, TransportFactory tf) {

		Double co2e = tf.getTransport(inputs.get("--transportation-method")).getCo2e();
		String uod = inputs.get("--unit-of-distance");
		if (uod != null && uod.contentEquals("m")) {
			co2e = co2e / 1000;
		}

		Double distance = Double.parseDouble(inputs.get("--distance"));
		if (uod == null || uod.contentEquals("km")) {
			distance = distance / 1000;
		}

		return Math.round((distance * co2e) * 10.0) / 10.0;

	}

	private Double calcuateco2foroutput(HashMap<String, String> inputs, TransportFactory tf) {

		Double co2e = tf.getTransport(inputs.get("--transportation-method")).getCo2e();
		String output = inputs.get("--output");
		String uod = inputs.get("--unit-of-distance");
		Double distance = Double.parseDouble(inputs.get("--distance"));
	
		if (output.contentEquals("kg") && uod.contentEquals("m")) {
			co2e = co2e / 1000;
			distance = distance / 1000;

		}
		else if (output.contentEquals("g") && uod.contentEquals("m") ) {
			co2e = co2e / 1000;		

		}
		else if (output.contentEquals("kg") && uod.contentEquals("km")) {
			co2e = co2e / 1000;		
			
		}
		
		
	
		
		return Math.round((distance * co2e) * 10.0) / 10.0;

	}

	//Concatenate unit when output unit is present and emission is double 
	private String appendUnit(HashMap<String, String> inp, Double co2, String output) {

		return co2 + output;

	}
	//Concatenate unit when output unit is present and emission is integer 
	private String appendUnit(HashMap<String, String> inp, Integer co2, String output) {

		return co2 + output;

	}
	//Concatenate unit when output unit is absent and emission is double 
	private String appendUnit(HashMap<String, String> inp, Double co2) {

		String uod = inp.get("--unit-of-distance");

		if (uod == null || uod.equalsIgnoreCase("km")) {

			return co2 + "kg";
		} else {
			return co2 + "g";
		}

	}
	//Concatenate unit when output unit is absent and emission is integer 
	private String appendUnit(HashMap<String, String> inp, Integer co2) {

		String uod = inp.get("--unit-of-distance");

		if (uod == null || uod.equalsIgnoreCase("km")) {

			return co2 + "kg";
		} else {
			return co2 + "g";
		}

	}

	public String processemission(String[] args) {
		Double calculatedco2 = 0.0;
		HashMap<String, String> inp = getcommandlineargs(args);
		String op = inp.get("--output");
		if (op == null) {
			calculatedco2 = calcuateco2(inp, new TransportFactory());

			String text = Double.toString(Math.abs(calculatedco2));
			int integerPlaces = text.indexOf('.');
			if (text.charAt(integerPlaces + 1) == '0') {

				return appendUnit(inp, calculatedco2.intValue());

			}

			return appendUnit(inp, calculatedco2);
		} else {
			calculatedco2 = calcuateco2foroutput(inp, new TransportFactory());
			String text = Double.toString(Math.abs(calculatedco2));
			int integerPlaces = text.indexOf('.');
			if (text.charAt(integerPlaces + 1) == '0') {

				return appendUnit(inp, calculatedco2.intValue(), op);

			}
			return appendUnit(inp, calculatedco2, op);
		}
	
	}
	
	public String processemission1(String[] args) {
		Double calculatedco2 = 0.0;
		HashMap<String, String> inp = getcommandlineargs(args);
		String output = inp.get("--output");
		String uod = inp.get("--unit-of-distance");
		if(output == null && uod == null )
		{
			inp.put("--output","kg");
			inp.put("--unit-of-distance","km");
		
		}
		else if(output == null && uod.contentEquals("km"))
		{
			inp.put("--output","kg");
				
		}
		else if(output == null && uod.contentEquals("m"))
		{
			inp.put("--output","g");
					
		}
		else if(uod == null && output.contentEquals("kg")  || uod == null && output.contentEquals("g")) {
			
			inp.put("--unit-of-distance","km");
		}
    		
			calculatedco2 = calcuateco2foroutput(inp, new TransportFactory());
			String text = Double.toString(Math.abs(calculatedco2));
			int integerPlaces = text.indexOf('.');
			if (text.charAt(integerPlaces + 1) == '0') {

				return appendUnit(inp, calculatedco2.intValue(), inp.get("--output"));

			}
			return appendUnit(inp, calculatedco2, inp.get("--output"));

	
	}

	public static void main(String[] args) {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String calculatedco2 = co2emissioncalc.processemission(args);

		System.out.println("Your trip caused" + " " + calculatedco2 + " " + "of CO2-equivalent.");

	}

}