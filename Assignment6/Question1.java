public class Question1 {

	public static void main(String[] args) throws MyIndexOutOfBoundException {
		int lowerBound = 0;
		int upperBound = 9;
		int index = 10;

		try {
			if (index < lowerBound || index > upperBound)
				throw new MyIndexOutOfBoundException(lowerBound, upperBound, index);
		} catch (MyIndexOutOfBoundException me) {
			System.out.println(me);
		}
	}
}

class MyIndexOutOfBoundException extends Exception{
	private int lower;
	private int upper;
	private int index;
	
	public MyIndexOutOfBoundException(int lower, int upper, int index) {
		this.lower = lower;
		this.upper = upper;
		this.index = index;
	}

	public String toString() {
	return "Error Message: Index: " + index + " , but Lower bound: " + lower + " Upper bound: " + upper;
	}
}