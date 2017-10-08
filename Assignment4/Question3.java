
public class Question3 {

	public static void main(String args[]){
        IpAddress ip = new IpAddress("216.27.6.136");
        System.out.println(ip.getDottedDecimal());
        System.out.println(ip.getOctet(4));
        System.out.println(ip.getOctet(1));
        System.out.println(ip.getOctet(3));
        System.out.println(ip.getOctet(2));
	}
}	

class IpAddress{
	
	protected String dottedDecimal;
	protected int firstOctet;
	protected int secondOctet;
	protected int thirdOctet;
	protected int fourthOctet;
	
	public IpAddress (String ipAdd) {
		dottedDecimal = ipAdd;
		String[] ipStr = ipAdd.split("\\.");
		firstOctet = Integer.parseInt(ipStr[0]);
		secondOctet = Integer.parseInt(ipStr[1]);
		thirdOctet = Integer.parseInt(ipStr[2]);
		fourthOctet = Integer.parseInt(ipStr[3]);
	}
	
	public String getDottedDecimal(){
		return dottedDecimal;
	}
	
	public int getOctet (int x) {
		if (x == 1) {
			return firstOctet;
		}
		if (x == 2) {
			return secondOctet;
		}
		if (x == 3) {
			return thirdOctet;
		}
		if (x == 4) {
			return fourthOctet;
		}
		else {
		 return 00;	
		}
	}

}
