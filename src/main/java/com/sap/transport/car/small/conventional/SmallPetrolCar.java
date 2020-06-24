package com.sap.transport.car.small.conventional;

import com.sap.transportInterfaces.Car;

public class SmallPetrolCar implements Car {
	
	private static Double co2e = 154.0;
	@Override
	public Double getCo2e() {
		
		return co2e;
	}

	
}
