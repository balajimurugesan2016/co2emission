package com.sap.transportTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.sap.co2calculator.main.C02EmissionCalculator;

public class C02emisscalctest {
	@Test
	public void mediumdieselcartest() {	
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method medium-diesel-car --distance 15 --unit-of-distance km";
		String []args = command.split("\\s");
		assertEquals("2.6kg", co2emissioncalc.processemission(args));		
	}
	
	@Test
	public void largepetrolcartest() {	
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--distance 1800.5 --transportation-method large-petrol-car";
		String []args = command.split("\\s");
		assertEquals("507.7kg", co2emissioncalc.processemission(args));
	}
	
	@Test
	public void trainmetertest() {	
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14500 --unit-of-distance m";
		String []args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processemission(args));
	}
	
	@Test
	public void trainmeteroutputkgtest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14500 --unit-of-distance m --output kg";
		String []args = command.split("\\s");
		assertEquals("0.1kg", co2emissioncalc.processemission(args));
			
	}
	
	@Test
	public void dieselcarequalstotest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--unit-of-distance=km --distance 15 --transportation-method=medium-diesel-car";
		String []args = command.split("\\s");
		assertEquals("2.6kg", co2emissioncalc.processemission(args));
		
		
	}
	
}
