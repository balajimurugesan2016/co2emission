/*Class exhibits behaviour of SmallElectric Car
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transport.car.small.modern;

import com.sap.transportInterfaces.Car;

public class SmallElectricCar implements Car {
	private static Double co2e = 50.0;
	@Override
	public Double getco2emission() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
