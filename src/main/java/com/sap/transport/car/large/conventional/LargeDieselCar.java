/*Class exhibits behaviour of LargeDiesel Car
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transport.car.large.conventional;

import com.sap.transportInterfaces.Car;

public class LargeDieselCar implements Car {
	private static Double co2e = 209.0;
	@Override
	public Double getco2emission() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
