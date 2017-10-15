
public class DessertShoppe {
	public final static double taxRateF = 10;
    public final static  int recepitWidth = 29;
    public final static int maxLengthOfItemName = 25;
    public final static int lengthOfCostDisplay = 6;
    public final static String storeName = "M & M Dessert Shoppe";

    public static String cents2dollarsAndCents(int centsAmount) {
        	
    		String dollar = "";

        if (centsAmount < 0) {
            dollar += "-";
            centsAmount *= -1;
        }

        int temp = centsAmount / 100;
        centsAmount = centsAmount % 100;

        if (temp > 0) {
            dollar += temp;
        }
        
        dollar += ".";

        if (centsAmount < 10) {
            dollar += "0";
        }
        
        dollar += centsAmount;

        return dollar;
    }
}
