/*Class exhibits Factory which produces vehicle instances on demand from the Calculator class
 * Factory is followed as we have many vehicles of the same type
* @author  Balaji Vengatesh Murugesan
* @version 1.0
* @since   2020-06-25 */
package com.sap.transportFactory;

import com.sap.transport.car.large.conventional.LargeDieselCar;
import com.sap.transport.car.large.conventional.LargepetrolCar;
import com.sap.transport.car.large.modern.LargeElectricCar;
import com.sap.transport.car.large.modern.LargePluginHybridCar;
import com.sap.transport.car.medium.conventional.MediumDieselCar;
import com.sap.transport.car.medium.conventional.MediumPetrolCar;
import com.sap.transport.car.medium.modern.MediumElectricCar;
import com.sap.transport.car.medium.modern.MediumPluginHybridCar;
import com.sap.transport.car.small.conventional.SmallDieselCar;
import com.sap.transport.car.small.conventional.SmallPetrolCar;
import com.sap.transport.car.small.modern.SmallElectricCar;
import com.sap.transport.car.small.modern.SmallPluginHybridCar;
import com.sap.transport.other.Bus;
import com.sap.transport.other.Train;
import com.sap.transportInterfaces.Transport;

public class TransportFactory {
	
	
	
	public Transport getTransport(String name) {
		
		switch(name) {
		
		case ("small-diesel-car"):
			return new SmallDieselCar();
		case ("small-petrol-car"):
			return new SmallPetrolCar();	
		case ("small-plugin-hybrid-car"):
			return new SmallPluginHybridCar();
		case ("small-electric-car"):
			return new SmallElectricCar();
		case ("medium-diesel-car"):
			return  new MediumDieselCar();
		case ("medium-petrol-car"):
			return new MediumPetrolCar();
		case ("medium-plugin-hybrid-car"):
			return new MediumPluginHybridCar();
		case ("medium-electric-car"):
			return new MediumElectricCar();
		case ("large-diesel-car"):
			return new  LargeDieselCar();
		case ("large-petrol-car"):
			return new LargepetrolCar();
		case ("large-plugin-hybrid-car"):
			return new LargePluginHybridCar();
		case ("large-electric-car"):
			return new LargeElectricCar();
		case ("bus"):
			return new Bus();
		case ("train"):
			return new Train();
		default:
			return null;
			
		
		
		}
		
		
	}

}
