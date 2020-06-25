/*Class calculates the  C02 emissions from different vehicles in service 
  Class takes inputs via command line and executes it against stored C02 values
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.co2calculator.main;

import java.util.HashMap;

import com.sap.transportFactory.TransportFactory;

public class C02EmissionCalculator {

	private HashMap<String, String> convertInputsToHashMap(String[] args) {
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

	private Double calcuateCo2(HashMap<String, String> inputs, TransportFactory tf) {

		Double co2e = tf.getTransport(inputs.get("--transportation-method")).getco2emission();
		String output = inputs.get("--output");
		String uod = inputs.get("--unit-of-distance");
		Double distance = Double.parseDouble(inputs.get("--distance"));

		if (output.contentEquals("kg") && uod.contentEquals("m")) {
			co2e = co2e / 1000;
			distance = distance / 1000;

		} else if (output.contentEquals("g") && uod.contentEquals("m")) {
			co2e = co2e / 1000;

		} else if (output.contentEquals("kg") && uod.contentEquals("km")) {
			co2e = co2e / 1000;

		}

		return Math.round((distance * co2e) * 10.0) / 10.0;

	}

	// Concatenate unit when output unit is present and emission is double
	private String appendUnit(HashMap<String, String> inp, Double co2, String output) {

		return co2 + output;

	}

	// Concatenate unit when output unit is present and emission is integer
	private String appendUnit(HashMap<String, String> inp, Integer co2, String output) {

		return co2 + output;

	}

	// Filling up unit names for easy calculation
	private void updateInputMap(HashMap<String, String> inp) {

		String output = inp.get("--output");
		String uod = inp.get("--unit-of-distance");
		if (output == null && uod == null) {
			inp.put("--output", "kg");
			inp.put("--unit-of-distance", "km");

		} else if (output == null && uod.contentEquals("km")) {
			inp.put("--output", "kg");

		} else if (output == null && uod.contentEquals("m")) {
			inp.put("--output", "g");

		} else if (uod == null && output.contentEquals("kg") || uod == null && output.contentEquals("g")) {

			inp.put("--unit-of-distance", "km");
		}

	}

	public Boolean validateInputs(HashMap<String, String> inp) {
		if (inp.get("--distance") == null || inp.get("--transportation-method") == null
				|| inp.get("--distance").isEmpty() || inp.get("--transportation-method").isEmpty()) {

			return false;
		} else {
			return true;
		}
	}

	// Process steps one by one
	public String processSteps(String[] args) {
		Double calculatedco2 = 0.0;
		HashMap<String, String> inp = convertInputsToHashMap(args);
		updateInputMap(inp);

		if (validateInputs(inp)) {
			calculatedco2 = calcuateCo2(inp, new TransportFactory());
			String text = Double.toString(Math.abs(calculatedco2));
			int integerPlaces = text.indexOf('.');
			if (text.charAt(integerPlaces + 1) == '0') {

				return appendUnit(inp, calculatedco2.intValue(), inp.get("--output"));

			}
			return appendUnit(inp, calculatedco2, inp.get("--output"));
		} else {
			return null;
		}

	}

	public static void main(String[] args) {
		try {
			C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();

			String calculatedco2 = co2emissioncalc.processSteps(args);

			if (calculatedco2 != null) {

				System.out.println("Your trip caused" + " " + calculatedco2 + " " + "of CO2-equivalent.");
			} else {
				System.out.println("Incorrect inputs:Distance or Transportation method fields is/are empty");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

}