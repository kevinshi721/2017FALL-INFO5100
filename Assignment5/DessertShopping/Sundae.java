
public class Sundae extends IceCream {
	String toppingName;
    int toppingCost;
    int iceCreamCost;

    public Sundae(String iceCreamName, int iceCreamCost, String toppingName, int toppingCost) {
        super(iceCreamName, iceCreamCost);
        this.toppingCost = toppingCost;
        this.toppingName = toppingName;
    }

    public String getToppingName() {
        return toppingName;
    }

    public String getIceCreamName() {
        return super.getDesertName();
    }

    @Override
    public int getCost() {
        return super.getCost() + this.toppingCost;
    }
}
