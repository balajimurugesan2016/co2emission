package com.sap.transport.car.large.modern;

import com.sap.transportInterfaces.Car;

public class LargePluginHybridCar implements Car {
	private static Double co2e = 126.0;
	@Override
	public Double getCo2e() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
