/*Class exhibits behaviour of LargePluginHybridCar
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transport.car.large.modern;

import com.sap.transportInterfaces.Car;

public class LargePluginHybridCar implements Car {
	private static Double co2e = 126.0;
	@Override
	public Double getco2emission() {
		// TODO Auto-generated method stub
		return co2e;
	}

}
