/*
1.Find the error in the following code and explain in few lines why it is wrong. (Score 1) 
*/

public class Book {
		int size;
		int price;
		//double price;
		String name;
		
		public Book(int size) {
				this.size = size;
		}
		
		public Book(int size, int price, String name) {
				super(); 
				// there seems no parent class, just remove it
				this.size = size;
				this.price = price;
				this.name = name;
		}
		
		public Book(int price) {
		// duplicated method, change to "public Book(double price) {"，or "public Book(int size, int price)""
				this.price = price;
		}
		
		public setName(String name) { 
		// error is because of "the missing of return type", there is two way to solve this error
		// 1) change to "public String getName(String name){", it's better to use "get" here
		// 2) if you want to use "set", you don't have to "return" any value, so make the function returns void type
		//	  and change "return name" to "this.name = name"
				return name;
		}
}