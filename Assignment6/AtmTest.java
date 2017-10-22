import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class AtmTest {
	
	public static void main (String[] args) {
		ArrayList<User> userData = new ArrayList<User>();
		userData.add (new User("Kevin", 10, "1812 12th Ave","206 3908853", "1234567", "abc"));
		userData.add (new User("Rita", 9, "1812 12th Ave","206 3908852", "1234566", "abc"));
		
		Atm atm = new Atm(1000000, userData);
		atm.run();
	}
}

class User{
	String name;
	int age;
	String address;
	String phoneNumber;
	String bankAccountNumber;
	double balance;
	String password;
	ArrayList <Transaction> trans = new ArrayList<Transaction>();
	
	public User(String name, int age, String address, String phoneNumber, String bankAccountNumber, String password) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bankAccountNumber= bankAccountNumber;
		this.password = password;
	}
	
	public User(String bankAccountNumber, String password) {
		this.password = password;
		this.bankAccountNumber = bankAccountNumber;
				
	}
	
	public User(double balance) {
		this.balance = balance;
	}
	
	public void transRecord(Transaction t) {
		trans.add(t);
	}
}

class Transaction{
	
	String tranName;
	int tranAmo;
	
	public Transaction( String tranName, int tranAmo) {
		this.tranAmo = tranAmo;
		this.tranName = tranName;
	}	
}

class Atm{
	private double availableAmountInMachine;
	private double transactionFee;
	ArrayList<User> userData;
	User currentUser;
	
	public Atm (double availableAmountInMachine, ArrayList<User> userData){
		this.availableAmountInMachine = availableAmountInMachine;
		this.userData = userData;
	}
	
	public void run() {
		this.atmAuthentic();
	}
	
	public void atmAuthentic() {
		System.out.println("Are you a current user? (Y/N): ");
		Scanner s = new Scanner(System.in);
		String ans = s.nextLine();
		if(ans.equals("N")) {
			System.out.print("Please enter your Name: ");
			String newName = s.nextLine();
			System.out.print("Please enter your Age: ");
			String newAge = s.nextLine();
			System.out.print("Please enter your Address: ");
			String newAddress = s.nextLine();
			System.out.print("Please enter your Phone Number: ");
			String newPhoneNumber = s.nextLine();
			System.out.print("Please enter your Account Password: ");
			String newPassword = s.nextLine();
			String newBankAccountNumber = UUID.randomUUID().toString();
			User newUser = new User(newName, Integer.parseInt(newAge), newAddress, newPhoneNumber,newBankAccountNumber, newPassword);
			userData.add(newUser);
			
			System.out.println("Your new account has created:");
			System.out.println(newUser);
		
		}else {
			System.out.println("Please enter your Account Number: ");
			String accNum = s.nextLine();
			System.out.println("Please enter your Password: ");
			String accPsd = s.nextLine();
			new User(accNum, accPsd);
			for (User temp1 : userData) {
				if(temp1.bankAccountNumber.equals(accNum) && temp1.password.equals(accPsd)) {
					this.currentUser = temp1;
					atmTransaction();
					break;
				}else {
					System.out.println("Invalid User Data.");
					break;
				}
			}	
		}	
	}
	
	public void atmTransaction(){
		System.out.println("Please select from one of the followings transaction:");
		System.out.println("1. Check Available Balance");
		System.out.println("2. Withdraw");
		System.out.println("3. Deposit");
		System.out.println("4. Print Recent Transactions");
		System.out.println("5. Change Password");
		System.out.println("6. Exit");
		
		Scanner s = new Scanner(System.in);
		int tranNum = Integer.parseInt(s.nextLine());
		
		switch(tranNum){
			case 1:
				System.out.println("Your balance is " + currentUser.balance);
				break;
			case 2:
				System.out.println("Please enter withdraw amount:");
				int wdAmo = Integer.parseInt(s.nextLine());
				if (wdAmo > currentUser.balance || wdAmo > availableAmountInMachine ) {
					System.out.println("Insufficient balance");
				} else {
					System.out.println("Please take your money");
					transactionFee = wdAmo * 0.05;
					currentUser.balance  = currentUser.balance - (wdAmo + transactionFee);
					availableAmountInMachine  = availableAmountInMachine - wdAmo;
					currentUser.transRecord(new Transaction("Withdraw", wdAmo));
				}
				break;
			case 3:
				System.out.println("Please enter deposit amout:");
				int dpAmo = Integer.parseInt(s.nextLine());
				currentUser.balance  = currentUser.balance + dpAmo;
				System.out.println("You have deposited " + dpAmo);
				System.out.println("Your new balance is " + currentUser.balance);
				availableAmountInMachine  = availableAmountInMachine + dpAmo;
				currentUser.transRecord(new Transaction("Deposit", dpAmo));
				break;
			case 4:
				System.out.println("Recent 10 Transactions: ");
                if (!currentUser.trans.isEmpty()) {
                    for (int i = 0; i <= currentUser.trans.size() && i < 10; i++)
                        System.out.println(currentUser.trans.get(i));
                }
                System.out.println();
                break;
			case 5:
				System.out.print("Please enter your Name: ");
				String tempName = s.nextLine();
				System.out.print("Please enter your Age: ");
				String tempAge = s.nextLine();
				System.out.print("Please enter your Phone Number: ");
				String tempPhoneNumber = s.nextLine();
				if (tempName.equals(currentUser.name) && Integer.parseInt(tempAge) == currentUser.age && tempPhoneNumber.equals(currentUser.phoneNumber)) {
					System.out.print("Please enter your new Password: ");
					currentUser.password = s.nextLine();
					System.out.print("Your Password has been updated!");
					break;
				}
			case 6:
				System.out.println("Thanks you!");
				System.exit(0);
				break;
		}	
	}
}