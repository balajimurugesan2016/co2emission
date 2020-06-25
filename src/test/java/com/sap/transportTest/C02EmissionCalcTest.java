/*Class tests  C02 emissions from different vehicles in service 
  Class takes inputs via command line and executes it against stored C02 values
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transportTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sap.co2calculator.main.C02EmissionCalculator;
import com.sap.transportFactory.TransportFactory;

import org.junit.jupiter.api.Test;

public class C02EmissionCalcTest {
	@Test
	public void mediumDieselCarTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method medium-diesel-car --distance 15 --unit-of-distance km";
		String[] args = command.split("\\s");
		assertEquals("2.6kg", co2emissioncalc.processSteps(args));
	}

	@Test
	public void largePetrolCarTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--distance 1800.5 --transportation-method large-petrol-car";
		String[] args = command.split("\\s");
		assertEquals("507.7kg", co2emissioncalc.processSteps(args));
	}

	@Test
	public void trainMeterTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14500 --unit-of-distance m";
		String[] args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processSteps(args));
	}

	@Test
	public void trainMeterOutputKGTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14500 --unit-of-distance m --output kg";
		String[] args = command.split("\\s");
		assertEquals("0.1kg", co2emissioncalc.processSteps(args));

	}

	@Test
	public void dieselCarEqualsToTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--unit-of-distance=km --distance 15 --transportation-method=medium-diesel-car";
		String[] args = command.split("\\s");
		assertEquals("2.6kg", co2emissioncalc.processSteps(args));

	}

	@Test
	public void dieselcarEqualsToAllTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--unit-of-distance=km --distance=15 --transportation-method=medium-diesel-car";
		String[] args = command.split("\\s");
		assertEquals("2.6kg", co2emissioncalc.processSteps(args));

	}

	@Test
	public void trainKmOutputGmTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14.5 --unit-of-distance km --output g";
		String[] args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processSteps(args));

	}

	@Test
	public void trainKmOutputDefGmTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14.5  --output g";
		String[] args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processSteps(args));

	}

	@Test
	public void trainKmOutputDefKgTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14.5  --output kg";
		String[] args = command.split("\\s");
		assertEquals("0.1kg", co2emissioncalc.processSteps(args));

	}

	@Test
	public void trainMeterOutputGramTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method train --distance 14500 --unit-of-distance m --output g";
		String[] args = command.split("\\s");
		assertEquals("87g", co2emissioncalc.processSteps(args));

	}

	@Test
	public void illegalvaluesTest() {
		C02EmissionCalculator co2emissioncalc = new C02EmissionCalculator();
		String command = "--transportation-method   --distance   --unit-of-distance m --output g";
		String[] args = command.split("\\s");
		assertEquals(null, co2emissioncalc.processSteps(args));

	}

	@Test
	public void TestInstancesTransportFactory() {
		TransportFactory tf = new TransportFactory();

		assertEquals(142.0, tf.getTransport("small-diesel-car").getco2emission());
		assertEquals(154.0, tf.getTransport("small-petrol-car").getco2emission());
		assertEquals(73.0, tf.getTransport("small-plugin-hybrid-car").getco2emission());
		assertEquals(50.0, tf.getTransport("small-electric-car").getco2emission());
		assertEquals(171.0, tf.getTransport("medium-diesel-car").getco2emission());
		assertEquals(192.0, tf.getTransport("medium-petrol-car").getco2emission());
		assertEquals(110.0, tf.getTransport("medium-plugin-hybrid-car").getco2emission());
		assertEquals(58.0, tf.getTransport("medium-electric-car").getco2emission());
		assertEquals(209.0, tf.getTransport("large-diesel-car").getco2emission());
		assertEquals(282.0, tf.getTransport("large-petrol-car").getco2emission());
		assertEquals(126.0, tf.getTransport("large-plugin-hybrid-car").getco2emission());
		assertEquals(73.0, tf.getTransport("large-electric-car").getco2emission());
		assertEquals(27.0, tf.getTransport("bus").getco2emission());
		assertEquals(6.0, tf.getTransport("train").getco2emission());

	}

}
