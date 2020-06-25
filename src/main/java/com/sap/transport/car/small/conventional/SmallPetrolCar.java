/*Class exhibits behaviour of SmallPetrol Car
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transport.car.small.conventional;

import com.sap.transportInterfaces.Car;

public class SmallPetrolCar implements Car {
	
	private static Double co2e = 154.0;
	@Override
	public Double getco2emission() {
		
		return co2e;
	}

	
}
