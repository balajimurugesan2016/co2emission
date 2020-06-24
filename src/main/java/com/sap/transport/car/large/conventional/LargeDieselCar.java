package com.sap.transport.car.large.conventional;

import com.sap.transportInterfaces.Car;

public class LargeDieselCar implements Car {
	private static Double co2e = 209.0;
	@Override
	public Double getCo2e() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
