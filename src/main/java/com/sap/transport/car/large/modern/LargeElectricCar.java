package com.sap.transport.car.large.modern;

import com.sap.transportInterfaces.Car;

public class LargeElectricCar implements Car {
	private static Double co2e = 73.0;
	@Override
	public Double getCo2e() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
