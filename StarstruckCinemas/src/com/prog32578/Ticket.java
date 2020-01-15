package com.prog32578;

import java.io.Serializable;

// in retrospect, this class should be named something more intuitive like 'MovieOrder'
public class Ticket implements Serializable {
	// this class handles 1 feature, multiple tickets (more than one feature = more than 1 instance)
	private static final long serialVersionUID = -4639311030354213968L;
	
	private String cinemaId;
	private String featName;
	private String seatsSold;
	private final String capacity = "100";
	private double amount; // how many of the same tickets per order
	
	private String featDate;
	private String featTime;
	private String type;
	private double price;
	private double total;
	private boolean isMember;
	
	public Ticket() {}
	
	public Ticket(String cinemaId, String featName, String capacity, String seatsSold, String featDate, String featTime, String type, int price) {
		this.cinemaId = "AV" + (Integer.parseInt(cinemaId) + 1);
		this.featName = featName;
		this.seatsSold = seatsSold;
		this.featDate = featDate;
		this.featTime = featTime;
		this.type = type;
		this.price = price;
	}

	public String getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getFeatName() {
		return featName;
	}

	public void setFeatName(String featName) {
		this.featName = featName;
	}

	public String getSeatsSold() {
		return seatsSold;
	}

	public void setSeatsSold(String seatsSold) {
		this.seatsSold = seatsSold;
	}
	
	public void setSeatsLeft(String seats) {
		
	}

	public String getFeatDate() {
		return featDate;
	}

	public void setFeatDate(String featDate) {
		this.featDate = featDate;
	}

	public String getFeatTime() {
		return featTime;
	}

	public void setFeatTime(String featTime) {
		this.featTime = featTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(String admit, boolean itistrue) {
		switch (admit) {
		case "general": if(itistrue) {this.price = 15 - (15 * 0.2);} else this.price = 15;
		break;
		case "age-specific": if(itistrue) {this.price = 5 - (5 * 0.2);} else this.price = 5;
		break;
		case "special": if(itistrue) {this.price = 5 - (5 * 0.2);} else this.price = 5;
		break;
		default:
			break;
		}
	}
		
	public double getTotal() {
		return total;
	}

	public void setTotal(boolean isMember) {
		double localTotal = getAmount() * getPrice();
		if(isMember==true) {
			this.total = localTotal - (localTotal * 0.2);
		} else this.total = localTotal;
	}

	public String getCapacity() {
		return capacity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	
	
}
