package de.mathisneunzig.progag.transport;

public enum TicketType {
	
	HOURLY(1.5),
	DAILY(3),
	WEEKLY(20),
	MONTHLY(70);
	
	final double price;
	
	private TicketType(double price) {
		
		this.price = price;
		
	}
	
	public double getPrice() {
		
		return price;
		
	}
	
}