package com.sap.transport.car.small.modern;

import com.sap.transportInterfaces.Car;

public class SmallElectricCar implements Car {
	private static Double co2e = 50.0;
	@Override
	public Double getCo2e() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
