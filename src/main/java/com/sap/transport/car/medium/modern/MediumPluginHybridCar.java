package com.sap.transport.car.medium.modern;

import com.sap.transportInterfaces.Car;

public class MediumPluginHybridCar implements Car {
	private static Double co2e = 110.0;
	@Override
	public Double getCo2e() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
