package com.sap.transport.other;
import com.sap.transportInterfaces.PublicVehicle;

public class Train implements PublicVehicle{
	private static Double co2e = 6.0;
	@Override
	public Double getCo2e() {
		return co2e;
	}


	

}
