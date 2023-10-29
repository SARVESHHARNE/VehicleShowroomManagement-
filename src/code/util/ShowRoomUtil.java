package code.util;

import java.util.List;

import code.Exception.InvalidFormateException;
import code.vehicle.Vehicle;

public class ShowRoomUtil {
	public static Vehicle getVehicle(String chasisNo,List<Vehicle> list) throws InvalidFormateException {
		int ind = list.indexOf(new Vehicle(chasisNo));
		if(ind<0)
			throw new InvalidFormateException("Invalid chasisNo");
		
		return list.get(ind);
	}

}
