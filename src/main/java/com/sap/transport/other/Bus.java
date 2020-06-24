package com.sap.transport.other;
import com.sap.transportInterfaces.PublicVehicle;

public class Bus  implements PublicVehicle {
	private static Double co2e = 27.0;
	@Override
	public Double getCo2e() {
		return co2e;
	}

	
	

	
}
