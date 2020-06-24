package com.sap.transport.car.medium.conventional;

import com.sap.transportInterfaces.Car;

public class MediumPetrolCar implements Car {
	private static Double co2e = 192.0;
	@Override
	public Double getCo2e() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
