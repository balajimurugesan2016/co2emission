/*Class exhibits behaviour of Bus
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transport.other;
import com.sap.transportInterfaces.PublicVehicle;

public class Bus  implements PublicVehicle {
	private static Double co2e = 27.0;
	@Override
	public Double getco2emission() {
		return co2e;
	}

	
	

	
}
