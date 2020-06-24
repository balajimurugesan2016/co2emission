package com.sap.transport.car.large.conventional;

import com.sap.transportInterfaces.Car;

public class LargepetrolCar implements Car {
	private static Double co2e = 282.0;
	@Override
	public Double getCo2e() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
