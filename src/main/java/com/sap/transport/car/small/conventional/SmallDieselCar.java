package com.sap.transport.car.small.conventional;

import com.sap.transportInterfaces.Car;

public class SmallDieselCar implements Car {

	private static Double co2e = 142.0;
	@Override
	public Double getCo2e() {
		// TODO Auto-generated method stub
		return co2e;
	}


}
