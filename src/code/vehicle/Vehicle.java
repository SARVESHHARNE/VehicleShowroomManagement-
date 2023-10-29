package code.vehicle;

import java.time.LocalDate;
import code.enums.Color;

public class Vehicle implements Comparable<Vehicle>{

	private String chasisNO;
	private Color clr;
	private double price;
	private LocalDate manDate;
	private String company;
	private boolean isAvailable;
	
	
	public Vehicle(String chasisNO, Color clr, double price, LocalDate manDate, String company) {
		super();
		this.chasisNO = chasisNO;
		this.clr = clr;
		this.price = price;
		this.manDate = manDate;
		this.company = company;
		this.isAvailable = true;
	}

	public Vehicle(String chasisNO) {
		super();
		this.chasisNO = chasisNO;
	}

	public String getChasisNO() {
		return chasisNO;
	}

	public Color getClr() {
		return clr;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getManDate() {
		return manDate;
	}

	public String getCompany() {
		return company;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setChasisNO(String chasisNO) {
		this.chasisNO = chasisNO;
	}

	public void setClr(Color clr) {
		this.clr = clr;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setManDate(LocalDate manDate) {
		this.manDate = manDate;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNO=" + chasisNO + ", clr=" + clr + ", price=" + (price+clr.v) + ", manDate=" +manDate+ ", company=" + company + ", isAvailable=" + isAvailable + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vehicle) {
			if (this.chasisNO.equals(((Vehicle) obj).chasisNO)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Vehicle o) {
		return this.chasisNO.compareTo(o.chasisNO);
	}
}
