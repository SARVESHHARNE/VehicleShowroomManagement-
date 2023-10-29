package code.ValidationRules;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import code.Exception.InvalidFormateException;
import code.enums.Color;
import code.vehicle.Vehicle;

public class ShowroomValidations {
	public static LocalDate parseAndValidateDate(String date) throws ParseException, InvalidFormateException{
		if(LocalDate.parse(date).isBefore(LocalDate.parse("2021-01-01"))) {
			throw new InvalidFormateException("Date is before 01-01-2021");
		}
		return LocalDate.parse(date);
	}

	public static void checkDuplicate(String chasisNo,List<Vehicle> list) throws InvalidFormateException {
		if(list.contains(new Vehicle(chasisNo)))
			throw new InvalidFormateException("duplicate entry");
	}
	
	public static Vehicle parseAndCheckInpts(String chasisNO, String clr, double price, String manDate, String company,List<Vehicle> list) throws ParseException, InvalidFormateException {
		LocalDate l =parseAndValidateDate(manDate);
		checkDuplicate(chasisNO, list);
		return new Vehicle(chasisNO, Color.valueOf(clr.toUpperCase()), price, l, company);
	}
	
}
