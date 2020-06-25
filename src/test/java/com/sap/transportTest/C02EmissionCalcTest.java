package com.sap.transportTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.sap.co2calculator.main.C02EmissionCalculator;
import com.sap.transportFactory.TransportFactory;

import org.junit.jupiter.api.Test;


public class C02EmissionCalcTest {
	@Test
	public void mediumdieselcartest() {	
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method medium-diesel-car --distance 15 --unit-of-distance km";
		String []args = command.split("\\s");
		assertEquals("2.6kg", co2emissioncalc.processemission1(args));		
	}
	
	@Test
	public void largepetrolcartest() {	
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--distance 1800.5 --transportation-method large-petrol-car";
		String []args = command.split("\\s");
		assertEquals("507.7kg", co2emissioncalc.processemission1(args));
	}
	
	@Test
	public void trainmetertest() {	
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14500 --unit-of-distance m";
		String []args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processemission1(args));
	}
	
	@Test
	public void trainmeteroutputkgtest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14500 --unit-of-distance m --output kg";
		String []args = command.split("\\s");
		assertEquals("0.1kg", co2emissioncalc.processemission1(args));
			
	}
	
	@Test
	public void dieselcarequalstotest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--unit-of-distance=km --distance 15 --transportation-method=medium-diesel-car";
		String []args = command.split("\\s");
		assertEquals("2.6kg", co2emissioncalc.processemission1(args));
		
		
	}
	
	@Test
	public void trainkmoutputgmtest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14.5 --unit-of-distance km --output g";
		String []args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processemission1(args));
			
	}
	
	@Test
	public void trainkmoutputdefgmtest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14.5  --output g";
		String []args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processemission1(args));
			
	}
	
	@Test
	public void trainkmoutputdefkgtest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14.5  --output kg";
		String []args = command.split("\\s");
		assertEquals("0.1kg", co2emissioncalc.processemission1(args));
			
	}
	
	@Test
	public void trainmeteroutputgramtest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14500 --unit-of-distance m --output g";
		String []args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processemission1(args));
			
	}
	
	@Test
	public void TestInstancesTransportFactory() {
		TransportFactory tf = new TransportFactory();
		
		assertEquals(142.0,  tf.getTransport("small-diesel-car").getCo2e());
		assertEquals(154.0,  tf.getTransport("small-petrol-car").getCo2e());
		assertEquals(73.0,  tf.getTransport("small-plugin-hybrid-car").getCo2e());
		assertEquals(50.0,  tf.getTransport("small-electric-car").getCo2e());
		assertEquals(171.0,  tf.getTransport("medium-diesel-car").getCo2e());
		assertEquals(192.0,  tf.getTransport("medium-petrol-car").getCo2e());
		assertEquals(110.0,  tf.getTransport("medium-plugin-hybrid-car").getCo2e());
		assertEquals(58.0,  tf.getTransport("medium-electric-car").getCo2e());
		assertEquals(209.0,  tf.getTransport("large-diesel-car").getCo2e());
		assertEquals(282.0,  tf.getTransport("large-petrol-car").getCo2e());
		assertEquals(126.0,  tf.getTransport("large-plugin-hybrid-car").getCo2e());
		assertEquals(73.0,  tf.getTransport("large-electric-car").getCo2e());
		assertEquals(27.0,  tf.getTransport("bus").getCo2e());
		assertEquals(6.0,  tf.getTransport("train").getCo2e());
			
	}
	
	

}
