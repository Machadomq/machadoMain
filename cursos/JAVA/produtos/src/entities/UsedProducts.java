package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProducts extends Products {

	private Date manufactureDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public UsedProducts(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		return getName() + " Used" + " $" + getPrice() + " manufacture:" + sdf.format(manufactureDate);
	}
}
