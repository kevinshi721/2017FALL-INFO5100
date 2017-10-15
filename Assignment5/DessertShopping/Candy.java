
public class Candy extends DessertItem {

	double weight;
    int priceInCents;

    public Candy(String name, double weight, int priceInCents) {
        super(name);
        this.weight = weight;
        this.priceInCents = priceInCents;
    }

    @Override
    public int getCost() {
        return (int) Math.round(priceInCents * weight);
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public double getWeight() {
        return weight;
    }

}