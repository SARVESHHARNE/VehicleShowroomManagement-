package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static code.ValidationRules.ShowroomValidations.*;
import static code.util.ShowRoomUtil.getVehicle; 

import code.Exception.InvalidFormateException;
import code.vehicle.Vehicle;

public class TestShowRoom {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Vehicle> showRoom = new ArrayList<>();
			boolean exit = false;
			while (exit != true) {
				System.out.println("1.Add Vehicle 2.Display all 3.search vehicle 4.applyDiscount 5.discount on oldVehicle 6.remove vehicle 0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter chasisNO,clr(WHITE|BLACK|SILVER|GREY),price,manDate(yyyy-mm-dd),company");
						showRoom.add(parseAndCheckInpts(sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), showRoom));
						break;
					case 2:
						for(Vehicle v:showRoom) {
							System.out.println(v);
						}
						break;
					case 3:
						System.out.println("Enter chasisNo");
						String chno=sc.next();
						System.out.println(getVehicle(chno, showRoom));
						break;
					case 4: 
						System.out.println("Enter chasisNo and Discount");
						chno=sc.next();
						double dis=sc.nextDouble();
						Vehicle v=getVehicle(chno, showRoom);
						v.setPrice(v.getPrice()-dis);
						System.out.println("Discount Applied");
						break;
					case 5:
						System.out.println("Enter date & Discount");
						LocalDate l = LocalDate.parse(sc.next());
						dis=sc.nextDouble();
						for(Vehicle i:showRoom) {
							if(i.getManDate().isBefore(l))
								i.setPrice(i.getPrice()-dis);
						}
						break;
					case 6:
						System.out.println("Enter chasisNo ");
						
						if(showRoom.remove(new Vehicle(sc.next()))) {
							System.out.println("Removed succesfully");
						}else {
							System.out.println("invalid chasisNo");
						}
						break;
					case 0:
						exit=true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}// end of try-with-resorces
	}
}
