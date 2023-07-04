
/**A special calculator for displaying BigInt
*After selecting 2 numbers displays all the operations on the numbers
*
*@author Idan Calvo
*@version 1.0
*/

import java.util.Scanner;

public class MainOperator {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		testBigIntCalculator();

	}

	public static void testBigIntCalculator() {
		int flag = 0; // out of loop or repeat calculation
		BigInt bi1 = null;
		BigInt bi2 = null;
		System.out.println("Welcome to \nthe BigInt Calculator");

		while (flag == 0) {
			System.out.println("choose two BigInt numbers...");
			flag = 1;
			
			while (flag == 1) {
				bi1 = chooseBigInt("first"); // First number selection
				if (bi1 != null) {
					flag = 2;
				}
			}

			while (flag == 2) {
				bi2 = chooseBigInt("second"); // second number selection
				if (bi2 != null) {
					flag = 3;
				}
			}
			
			System.out.println(showSL(bi1, bi2)); // Presenting <>= between two BigInt numbers
			System.out.println(showArithmetic(bi1, bi2, '+')); // Displays the addition operation
			System.out.println(showArithmetic(bi1, bi2, '-')); // Displays the subtraction operation
			System.out.println(showArithmetic(bi1, bi2, '*')); // Displays the multiplication operation

			try {
				System.out.println(showArithmetic(bi1, bi2, '/')); // Displays the multiplication operation
			} catch (Exception e) {
				System.out.println("You can not divide by 0");
			}

			System.out.println("\nFor further calculation press 0");
			System.out.println("To exit, click on any other number");

			String str = sc.nextLine();

			flag = 1;
			if (str != null && str.length() > 0) {
				flag = (str.charAt(0)) - '0';
			}

		}
	}// testBigIntCalculator

	public static BigInt chooseBigInt(String str) {
		System.out.print("\nThe " + str + " number is: ");
		str = sc.nextLine();
		BigInt tempBigInt;
		
		try {
			tempBigInt = new BigInt(str);
		} catch (Exception e) {
			System.out.println("Invalid input");
			tempBigInt = null;
		}
		
		return tempBigInt;
	}// chooseBigInt

	public static String showArithmetic(BigInt bi1, BigInt bi2, char c) {
		String str = new String(); // String that displays the calculation

		str += bi1.toString();
		str += " " + c + " ";
		str += bi2.toString(); // The second rational number after the reduction
		str += " = ";

		if (c == '+') {
			str += (bi1.plus(bi2)).toString(); // Addition operations
		} else {
			if (c == '-') {
				str += (bi1.minus(bi2)).toString(); // Subtraction operations
			} else {
				if (c == '*') {
					str += (bi1.multiply(bi2)).toString(); // Multiplication operations
				} else {
					if (c == '/') {
						str += (bi1.divide(bi2)).toString(); // Subtraction operations
					}
				}
			}
		}
		return str;
	}// showArithmetic

	
	public static String showSL(BigInt bi1, BigInt bi2) {
		String str = new String(); // String that displays the calculation

		str += bi1.toString(); // The first BigInt number

		if (bi1.equals(bi2)) { // Are they equal ?
			str += " = ";
		} else {
			if (bi1.compareTo(bi2) > 0) { // Is bi1 bigger than bi2?
				str += " > ";
			} else { // Is bi2 bigger than bi1 ?
				str += " < ";
			}
		}
		str += bi2.toString();
		; // The second BigInt number
		return str;
	}// showSL

}// MainOperator
