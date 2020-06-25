/*Interface Transport abstracts the getco2emission(getco2emission method)
* Additional logic specific to PublicVehicle can be abstracted here and implemented in the implementing classes
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transportInterfaces;

public interface Transport {
    
	//The method gets the carbon emissions present in the classes
	public Double getco2emission();

	}
