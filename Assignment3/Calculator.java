/*
5. Create a calculator that can perform the following features. (Total Score 4)
i. The calculator should be able to perform Addition, subtraction, multiplication, division. (Score 2) 
ii. Should be able to perform squareRoot, square, cube. (Score 1)
iii. Should be able to convert ‘Fahrenheitn-Celsius’ , ‘Feet-Inches’. (Score 1)

Extra Credit(Score 2)
The calculator should be able to solve a quadratic equation and return the solution as array.
i. This function should take three arguments.
ii. For example, if quadratic equation is Ax2 + Bx + C. The function should take A,B,C as arguments and return a solution as array.
*/

import java.util.Arrays;

public class Calculator {

		public static void main(String[] args) {
				Calculator test = new Calculator();
		        System.out.println(Arrays.toString(test.quadraticEquation(1, 2, 3)));
		        System.out.println(Arrays.toString(test.quadraticEquation(0, 1, 1)));
		        System.out.println(Arrays.toString(test.quadraticEquation(0, 0, 1)));
		        System.out.println(Arrays.toString(test.quadraticEquation(1, 0, 1)));
		        System.out.println(Arrays.toString(test.quadraticEquation(1, 0, -1)));
	    }
		
		public double addition(double a, double b) {
				return a + b;
		}
		
		public double subtraction(double a, double b) {
				return a - b;
		}

		public double multiplication(double a, double b) {
				return a * b;
		}

		public double division(double a, double b) {
				if (b == 0) {
					System.out.println("error");
				}
				// Add else here? Otherwise, if b == 0, we will still excute a / b.
				// Or is it intentional?
				return a / b;
		}
		
		public double squareRoot(double a) {
				if (a < 0) {
					System.out.println("error");	
				}
				return Math.sqrt(a);
		}

		public double square(double a) {
				return a * a;
		}
		
		public double cube(double a) {
				return a * a * a;
		}
		
		public double fToC(double a) {
				return (a - 32) / 1.8;
		}
		
		public double cToF(double a) {
				return a * 1.8 + 32;
		}
		
		public double fToI(double a) {
				return a * 12;
		}
		
		public double iTof(double a) {
				return a / 12;
		}
		
		public double[] quadraticEquation (double A, double B, double C) {
				if (A == 0) {
			            if (B == 0) {
				                System.out.println("no real number solution");
				                return null;
			            } else {
			                	return new double[]{- C / B};
			            }
		        } else {
			            double discriminant = B * B - 4 * A * C;
			            if (discriminant < 0) {
				                System.out.println("no real number solution");
				                return null;
			            } else {
				                double x1 = (-1 * B + Math.sqrt(discriminant)) / (2 * A);
				                double x2 = (-1 * B - Math.sqrt(discriminant)) / (2 * A);
				                return new double[]{x1, x2};
		            }
		        }
		}
}
