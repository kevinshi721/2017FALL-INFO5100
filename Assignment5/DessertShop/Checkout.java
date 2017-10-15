import java.util.ArrayList;

public class Checkout {
	protected  double taxRate;

	ArrayList<DessertItem> items = new ArrayList<DessertItem>();

	public Checkout() {
		taxRate = DessertShoppe.taxRateF;
	}

	public int numberOfItems() {
		return items.size();
	}

	public void enterItem(DessertItem item) {
		items.add(item);
	}

	public void clear() {
		items.clear();
	}

	public int totalCost() {
		int totalCost = 0;
		for (DessertItem item : items) {
			totalCost += item.getCost();
		}
		return totalCost;
	}

	public int totalTax() {
		return Math.round(Math.round(totalCost() * taxRate / 100));
	}

	public String toString() {
		String receipt = "";
		String itemPayment = "";
		String itemClass = "";
		receipt += "\t\t" + DessertShoppe.storeName + "\n";
		receipt += "\t\t------------------------\n";

		for (DessertItem item : items) {
			String s1= item.getName();
			itemPayment = DessertShoppe.cents2dollarsAndCents(item.getCost());
			while (itemPayment.length() > DessertShoppe.lengthOfCostDisplay) {
				itemPayment = " " + itemPayment;
			}
			itemClass = item.getClass().getName().toString();

			if (itemClass.contains("IceCream")) {
				while ((s1.length() < DessertShoppe.maxLengthOfItemName)) {
					s1 += " ";
				}
				receipt += s1 + itemPayment + "\n";

			} else if (itemClass.contains("Candy")) {
				receipt += ((Candy) item).getWeight() + " lbs. @ " +
						DessertShoppe.cents2dollarsAndCents(((Candy) item).getPriceCandy()) + " /1b.\n";
				while (s1.length() < DessertShoppe.maxLengthOfItemName) {
                		s1 += " ";
				}
				receipt += s1 + itemPayment + "\n";

			} else if (itemClass.contains("Sundae")) {
				receipt += ((Sundae) item).getToppingName() + " Sundae with\n";
				s1 = ((Sundae) item).getIceCreamName();
				while (s1.length() < DessertShoppe.maxLengthOfItemName) {
					s1 += " ";
				}
				receipt += s1 + itemPayment + "\n";

			} else if (itemClass.contains("Cookie")){
				receipt += ((Cookie) item).getNumber() + " @ " + ((Cookie) item).getPrice() + " /lb.\n";
				while (s1.length() < DessertShoppe.maxLengthOfItemName) {
					s1 += " ";
				}
				receipt += s1 + itemPayment + "\n";
			}
		}

		String str = "\nTax";
		String tax = DessertShoppe.cents2dollarsAndCents(totalTax());
		while (str.length() <= DessertShoppe.recepitWidth - tax.length()) {
			str += " ";
		}
		receipt += str + tax;

		String totalPayment = DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax());
		str = "\nTotal Cost";
		while ((str.length() <= DessertShoppe.recepitWidth - totalPayment.length())){
			str += " ";
		}

		receipt += str + totalPayment;

		return receipt;
	}
}