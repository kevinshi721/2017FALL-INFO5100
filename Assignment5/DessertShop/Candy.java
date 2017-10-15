
public class Candy extends DessertItem {
	
	double weight;
	int priceCandy;

	public Candy(String name, double weight, int priceCandy) {
		super(name);
		this.weight = weight;
		this.priceCandy = priceCandy;
	}

	@Override
	public int getCost() {
		return (int) Math.round(priceCandy * weight);
	}

	public int getPriceCandy() {
		return priceCandy;
	}

	public double getWeight() {
		return weight;
	}
}