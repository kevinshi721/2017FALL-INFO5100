package practice;

public class Assignment2 {
	
	public static void main (String[] args) {
		
	/* Question 1*/
		
		DoubleSalary k = new DoubleSalary ();
		// Would be better if using a constructor to assign value to name and hours.
		k.name = "K";
		k.hours = 0;
		k.calculate ();
		DoubleSalary r = new DoubleSalary ();
		r.name = "R";
		r.hours = 47;
		r.calculate ();
		DoubleSalary j = new DoubleSalary ();
		j.name = "J";
		j.hours = 57;
		j.calculate ();

		
	/* Question 2*/	

		AddDigit test = new AddDigit ();
		test.x = 123;
		test.addDigit ();
		
	/* Question 3*/
		
		PerfectNumber pn = new PerfectNumber();
		pn.n = 15;
		pn.pnCalc ();
		
	/* Question 4*/
		
		PizzaSelection a = new PizzaSelection ("beef", 12, 1);
		PizzaPrice b = new PizzaPrice ();
		b.pizzaSize = 12;
		b.pizzaAmount = 1;
		b.priceCalc ();
	
	/* Question 5*/
		
	/* Question 6*/
		printIsoscelesTriangle x = new printIsoscelesTriangle ();
		x.n =6;
		x.triangle();
		
	}
}


/*
1. Write a java function to calculate the salary of an employee based on the following rules.
		i. function takes input of number of hours an employee worked and returns the salary.
		ii.  The first 36 hours worked are paid at a rate of 15.0, then the next 5 hours are paid at a rate of 15 * 1.5. Hours after that up to a max of 48 are paid at a rate of 15 * 2.
		
		Here is the prototype you can work with
		
		public double employeeSalary( double hours){		
		}
*/


class DoubleSalary{
	String name;
	double hours;
	double salary;
	
	// Would recommend against using nested if
	// rather use 
	// if <= 0
	// else if <= 36
	// else if <= 41
	// else if <= 48
	// else
	public void calculate() {
		
		if (hours <= 0) {
			// name is not initiated.
			System.out.println (name + ", No Pain, No Pay");	
		}
		else {
			if (hours <= 36) {
			salary = hours * 15;
			System.out.println (name + "'s salary is " + salary);
		}
			else {
				if (hours <= 41) {
					salary = 36 * 15 + (hours - 36) * 15 * 1.5;
					System.out.println (name + "'s salary is " + salary);
				}	
				else {
					if (hours <= 48) {
						salary = 36 * 15 + 7 * 15 * 1.5 + (hours - 41) * 15 * 2.0;
						System.out.println (name + "'s salary is " + salary);
					}
					else {
						System.out.println (name +", you cannot work over 48 hours, please re-enter!");
					}
				}
			}
		}		
	}
}

/*
2. Write a java function that adds all the digits of an integer until it is single digit.
		i. function takes an integer as input and returns its sum of digits.
		ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.

		Here is the prototype you can work with
	
		public int addDigits( int input){
		}
*/

class AddDigit{
	int x;
	
	// please add constructor like
	// public AddDigit(int x){
        //     this.x = x;
        // }
	
	public void addDigit(){
		while (x >= 10) 
		{
			x = x / 10 + x % 10;
		}
		System.out.println(x);
				}
		}
	}
}


class PerfectNumber {
	
	int n;
	int a;
	int b;
	int sum;
	// add constructor
	public void pnCalc() {
		
		if (n <= 1) {
			System.out.println ("There is not a perfect number between 1 and " + n);
		}
		else {
			for (a = 1; a < n; a++) {
				int sum = 0;
				for (b = 1; b < a; b++) {
				
					if (a % b == 0) {
						sum = sum + b;
						}
					}
				if ( sum == a) {
					System.out.println(sum + " ");
				}
			}
		}
	}
}


/*
4. Write a java class called pizza with (Add detail as needed) : 
		i. Create at least 3 attributes :pizza type , unit price and loyalty points. More attributes are welcome to have. 
		ii. Create constructors . Extra-credit of 0.5 point if you write more than 1 right constructor to this class
*/

class PizzaSelection {
		
    // would need a map here to record type and price
    private static Map<String, int> PIZZA_MENU = ImmutableMap.of("a", 1, "b", 2, "c", 3);
	String pizzaType;
	int unitPrice;
	int pizzaSize;
	int pizzaAmount;
	
	PizzaSelection (String pizzaType, int pizzaSize, int pizzaAmount) {
		System.out.println("New Pizza Ordered");
	}
	
    // get pizza price by type
    public int getPizzaPrice(String type){
        return PIZZA_MENU.get(type);
    }
}

class PizzaPrice{
	
	int unitPrice;
	int loyaltyPoints;
	int sum;
	int pizzaSize;
	int pizzaAmount;
	
	public void priceCalc () {
		if	(pizzaSize > 9) {
			unitPrice = unitPrice + 2;
		}
		sum = unitPrice * pizzaAmount;
		loyaltyPoints = sum * 10;
		System.out.println("Total price is USD " + sum + ", you will get " + loyaltyPoints + " loyaltyPoints");
	}
}


/*
5. Write a java class called customer (Add detail as needed) : 
		i. Create Attributes: customer name and which pizzas customer has ordered. 
		ii. Think about what kind of data structure can be used to record the pizza name and 
		number of each kind of pizza.( Give me your thought, Extra credit of 1 point)
		iii. In main method , sum up how much money the customer spent.
*/

class Customer{
	
	String name;
	String pizzaType;
	int pizzaAmount;
	
	//table array? not sure about such data structure
    // answer: no table structor needed.
    public Customer(String name, String pizzaType, int pizzaAmount){
        this.name = name;
	this.pizzaType = pizzaType;
	this.pizzaAmount = pizzaAmount;
    }
	
   public static void main(String[] args){
       Customer kevin = new Customer("kevin", "a", 2);
       int sum = kevin.pizzaAmount * PizzaSelection.getPizzaPrice(kevin.type);
   }
	
}	

/*
6. Write a Java program that generates an isosceles right angled triangle made of asterisks. 
i. function should take input of one equal side as integer. Other than the edges the inner part of the triangle should be empty.
ii. For example input is 6. the function should print—

*
**
* *
*  *
*   *
******
*/

class printIsoscelesTriangle{
	int n;
	int a;
	int b;
	int c;
	
	public void triangle() {
		
	
		if (n == 0) {
			System.out.println("please enter an interger > 0");
		} 
		else {
			for (a = 1 ; a <= n; a++) {
				if (a != n) {
					for (b =1 ; b <= a; b++ ) {
						if (b == 1)
							System.out.print("*");
						else if (b == a) 
							System.out.print("*");
						else
							System.out.print(" ");
					}
					System.out.print("\n");
				}
				else {
					for (c = 1 ; c <= n; c++) {
						System.out.print("*");
					}
				}
			}		
		}
	}
}	
