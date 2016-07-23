package de.mathisneunzig.progag.economy;

public class TaxManager {
	
	double tax;
	
	public boolean setTax(double newTax) {
		
		if(newTax - tax >= -2 && newTax - tax <= 2)
		
		this.tax = newTax;
		
		return false;
		
	}
	
	public double getTax() {
		
		return 0.0;
		
	}
	
}
