package entities;

public class ImportedProducts extends Products {

	private Double custumFee;

	public ImportedProducts(String name, Double price, Double custumFee) {
		super(name, price);
		this.custumFee = custumFee;
	}

	public Double getCustumFee() {
		return custumFee;
	}

	public void setCustumFee(Double custumFee) {
		this.custumFee = custumFee;
	}

	public double totalPrice() {
		return getPrice() + getCustumFee();
	}

	@Override
	public String priceTag() {
		return getName() + " $" + totalPrice() + " (customs fee:" + custumFee + ")";
	}

}
