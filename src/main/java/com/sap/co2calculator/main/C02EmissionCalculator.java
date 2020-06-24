package com.sap.co2calculator.main;
import com.sap.transportFactory.TransportFactory;

public class C02EmissionCalculator {

	private String[] getcommandlineargs(String[] args) {
		Integer length = args.length;
		String[] inputs = new String[length];
		int i = 0;
		while (i < length) {

			if (args[i].contains("--transportation-method"))
				if(args[i].contains("=")) {
					String [] arr = args[i].split("=");
					inputs[0] = arr[1];
				}
				else
				{
				inputs[0] = args[i + 1];
				}
			else if (args[i].contains("--distance"))
				if(args[i].contains("=")) {
					String [] arr = args[i].split("=");
					inputs[1] = arr[1];
				}
				else {
				inputs[1] = args[i + 1]; 
				}
			else if (args[i].contains("--unit-of-distance"))
				if(args[i].contains("=")) {
					String [] arr = args[i].split("=");
					inputs[1] = arr[1];
				}
				else
				{
				inputs[2] = args[i + 1];
				}
			else if (args[i].contains("--output"))
				if(args[i].contains("=")) {
					String [] arr = args[i].split("=");
					inputs[1] = arr[1];
				}
				else
				{
				inputs[3] = args[i + 1];
				}

			++i;
		}
		return inputs;

	}

	private Double convert(Double amount) {

		return amount / 1000.0;
	}

	private Double calcuateco2(String[] inputs,TransportFactory tf) {
    
		Double co2e = tf.getTransport(inputs[0]).getCo2e();
		String uod = inputs[2];
		if (uod != null &&  uod.contentEquals("m") ) {
			co2e = convert(co2e);
		}
		
		

		Double distance = Double.parseDouble(inputs[1]);
		if ( uod == null || uod.contentEquals("km") ) {
			distance = distance/1000;
		}
		
		return  Math.round((distance * co2e)*10.0)/10.0;

	}
	
	public Double processemission(String[] args) {
		
		String [] inp = getcommandlineargs(args);
		Double calculatedco2 = calcuateco2(inp,new TransportFactory());
		return  calculatedco2;
		
	}

	public static void main(String[] args) {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		Double calculatedco2 = co2emissioncalc.processemission(args);

		System.out.println("Your trip caused" + " " + calculatedco2 + " " + "of CO2-equivalent.");

	}

}