/*Class exhibits behaviour of Train
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transport.other;
import com.sap.transportInterfaces.PublicVehicle;

public class Train implements PublicVehicle{
	private static Double co2e = 6.0;
	@Override
	public Double getco2emission() {
		return co2e;
	}


	

}
