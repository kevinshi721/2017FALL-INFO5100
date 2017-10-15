public class IceCream extends DessertItem{
	
	int cost;
	
	public IceCream (String name, int cost) {
		super(name);
		this.cost = cost;
	}
	
	public String getDesertName() {
		return super.name;
	}
	
	@Override
	public int getCost() {
		return cost;
	}
}
