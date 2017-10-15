
public class Cookie extends DessertItem {
	
	int number;
    float price;

    public Cookie (String name, int number, int price) {
        super(name);
        this.number= number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public int getCost() {
        return (int) Math.round (price * number / 12);
    }
}
