/**Extra-large integers
 * Supports large numbers up to 10^32 - 1
 * Supports calculation: plus, minus, multiply, divide
 *@author Idan Calvo
 *@version 1.0
 */

import java.lang.*;
import java.util.ArrayList;

public class BigInt implements Comparable<BigInt> {

	private final static int NUM1_BIGGER = 1;
	private final static int NUM2_BIGGER = -1;
	private final static int NUM1_EQ_NUM2 = 0;

	private final static int PLUS = 1;
	private final static int MINUS = -1;

//#Fields
	private ArrayList<Character> number;
	private boolean Positive; // Is the number positive?

//#Constructor
	public BigInt(String sNumber) {
		if (sNumber == null || sNumber.length() == 0) {
			sNumber = setDefaultNum(sNumber);///זריקה
		}
		this.number = new ArrayList<Character>();
		this.Positive = (sNumber.charAt(0) != '-');
		
		sNumber = cutSign(sNumber); // Removes the Sign (+ or -) if it exists.
		sNumber = cutZiro(sNumber); // Removes zeros Unnecessary.
		setNum(sNumber); // Initialize the number

		if (this.number.get(0)=='0') {
			this.Positive=true;
		}
	
	}

//#Methods

//---help to initialize----------------------------------------------------	

	// Removes the Sign (+ or -) if it exists.
	private String cutSign(String sNumber) {
		char c = sNumber.charAt(0);
		if (c == '+' || c == '-') {
			sNumber = sNumber.substring(1);
			if (sNumber.length() == 0) {
				sNumber = setDefaultNum(sNumber);
			}
		}
		return sNumber;
	}

	// Removes zeros Unnecessary.
	private String cutZiro(String sNumber) {
		char c = sNumber.charAt(0);
		while (sNumber.length() > 1 && c == '0') {
			sNumber = sNumber.substring(1);
			c = sNumber.charAt(0);
		}
		return sNumber;
	}

	// Initialize the number into the array
	private void setNum(String sNumber) {
		if (!(sNumber.matches("[0-9]+"))) {
			sNumber = setDefaultNum(sNumber);
		}
		char c;
		for (int i = 0; i < sNumber.length(); i++) {
			c = sNumber.charAt(i);
			number.add(c);
		}
	}

	// Initializes default number 0
	private String setDefaultNum(String sNumber) throws IllegalArgumentException {
		throw new IllegalArgumentException();
//		sNumber = "0";
//		this.Positive = true;
//		return sNumber;
	}

//---plus and minus Functions--------------------------------------------------	

	// plus operation
	public BigInt plus(BigInt other) {
		String num1 = this.toString();
		String num2 = other.toString();
		String num3 = new String("");

		boolean pos1 = this.Positive;
		boolean pos2 = other.positiv();

		num1 = cutSign(num1);
		num2 = cutSign(num2);

		int size1 = num1.length();
		int size2 = num2.length();

		if (size1 > size2) { // Adds zeros to num2
			num2 = fixziro(num2, size1 - size2);
		} else {
			if (size1 < size2) { // Adds zeros to num1
				num1 = fixziro(num1, size2 - size1);
			}
		}

		if (pos1 & pos2) {// Positive + Positive
			num3 = ppp(num1, num2);
		} else {
			if (pos1 & !pos2) {// Positive + Negative
				num3 = ppm(num1, num2);
			} else {
				if (!pos1 & pos2) {// Negative + Positive
					num3 = mpp(num1, num2);
				} else {
					if (!pos1 & !pos2) {// Negative + Negative
						num3 = mpm(num1, num2);
					} // if
				} // else
			} // else
		} // else
		return new BigInt(num3);
	}// plus

	// minus operation
	public BigInt minus(BigInt other) {
		String num1 = this.toString();
		String num2 = other.toString();
		String num3 = new String("");

		boolean pos1 = this.Positive;
		boolean pos2 = other.positiv();

		num1 = cutSign(num1);
		num2 = cutSign(num2);

		int size1 = num1.length();
		int size2 = num2.length();

		if (size1 > size2) {
			num2 = fixziro(num2, size1 - size2);
		} else {
			if (size1 < size2) {
				num1 = fixziro(num1, size2 - size1);
			}
		}

		if (pos1 & pos2) {// Positive - Positive
			num3 = pmp(num1, num2);
		} else {
			if (pos1 & !pos2) {// Positive - Negative
				num3 = pmm(num1, num2);
			} else {
				if (!pos1 & pos2) {// Negative - Positive
					num3 = mmp(num1, num2);
				} else {
					if (!pos1 & !pos2) {// Negative - Negative
						num3 = mmm(num1, num2);
					} // if
				} // else
			} // else
		} // else
		return new BigInt(num3);
	}// minus

	// Positive + Positive
	private String ppp(String num1, String num2) {
		String ans = new String("");
		int size1 = num1.length(); // ==num2.length()
		char remainer = '0';
		for (int i = size1 - 1; i >= 0; i--) {
			ans = plusMinusChars(num1.charAt(i), num2.charAt(i), remainer, PLUS) + ans;
			remainer = ans.charAt(0);
			ans = ans.substring(1);
		}
		return remainer + ans;
	}

	// Positive - Positive
	private String pmp(String num1, String num2) {
		String ans = new String("");
		int bigere = num1isbigger(num1, num2); // 1->num1 bigger, 2->num2 bigger, 0->num1==num2,

		switch (bigere) {
		case NUM2_BIGGER:
			ans = '-' + SubStr(num2, num1);
			break;
		case NUM1_EQ_NUM2:
			ans = "0";
			break;
		default: // NUM1_BIGGER
			ans = SubStr(num1, num2);
		}

		return ans;
	}

	// Positive + Negative (== Positive - Positive)
	private String ppm(String num1, String num2) {
		return pmp(num1, num2);
	}

	// Negative + Positive (== Positive + Negative &Swapping places)
	private String mpp(String num1, String num2) {
		return ppm(num2, num1);
	}

	// Negative + Negative (== -(Positive + Positive) )
	private String mpm(String num1, String num2) {
		return '-' + ppp(num1, num2);
	}

	// Negative - Negative (== Positive - Positive &Swapping places)
	private String mmm(String num1, String num2) {
		return pmp(num2, num1);
	}

	// Negative - Positive (== -(Positive + Positive) )
	private String mmp(String num1, String num2) {
		return '-' + ppp(num1, num2);
	}

	// Positive - Negative (== Positive + Positive )
	private String pmm(String num1, String num2) {
		return ppp(num1, num2);
	}

//---multiply and divide Functions--------------------------------------------------	

	// multiply operation
	public BigInt multiply(BigInt other) {
		String num1 = this.toString();
		String num2 = other.toString();
		String num3 = new String("");
		BigInt ans = new BigInt("0");

		boolean pos1 = this.Positive;
		boolean pos2 = other.positiv();
		boolean pos3 = (pos1) && (pos2) || ((!pos1) && (!pos2));

		num1 = cutSign(num1);
		num2 = cutSign(num2);

		int size1 = num1.length();
		int size2 = num2.length();

		if (size1 > size2) { // Adds zeros to num2
			num2 = fixziro(num2, size1 - size2);
			size2 = num2.length();
		} else {
			if (size1 < size2) { // Adds zeros to num1
				num1 = fixziro(num1, size2 - size1);
				size1 = num1.length();
			}
		}

		String strZiros1 = new String("");
		String strZiros2 = new String("");

		for (int i = size1 - 1; i >= 0; i--) {
			for (int j = size2 - 1; j >= 0; j--) {
				num3 = multChars(num1.charAt(i), num2.charAt(j)) + strZiros1 + strZiros2;
				ans = ans.plus(new BigInt(num3));
				strZiros1 = strZiros1 + '0';
			}
			strZiros1 = ""; // Multiplication by 10 long multiplication
			strZiros2 = strZiros2 + "0"; // Multiplication by 10 long multiplication
		}
		if (!pos3) { // Updating sign
			ans = new BigInt("-" + ans);
		}
		return ans;

	}

	// divide operation
	public BigInt divide(BigInt other) {
		if (other == null || other.equals(new BigInt("0"))) {
			throw new ArithmeticException();
		}

		String num1 = this.toString();
		String num2 = other.toString();
		String num3 = new String("0");

		boolean pos1 = this.Positive;
		boolean pos2 = other.positiv();
		boolean pos3 = (pos1) && (pos2) || ((!pos1) && (!pos2));

		num1 = cutSign(num1);
		num2 = cutSign(num2);

		int size1 = num1.length();
		int size2 = num2.length();

		if (size1 > size2) { // Adds zeros to num2
			num2 = fixziro(num2, size1 - size2);
			size2 = num2.length();
		} else {
			if (size1 < size2) { // Adds zeros to num1
				num1 = fixziro(num1, size2 - size1);
				size1 = num1.length();
			}
		}
		String strZiros1 = new String("");

		while (num1isbigger(num1, num2) == NUM1_BIGGER) {// Counted several times that num2 entered in num1
			num1 = pmp(num1, num2);
			num3 = ppp(num3, strZiros1 + "1");
			if (num3.charAt(0) == '0') {
				num3 = num3.substring(1);
			} else {
				strZiros1 = strZiros1 + "0";
			}
		}

		if (num1isbigger(num1, num2) == NUM1_EQ_NUM2) {
			num3 = ppp(num3, strZiros1 + "1");
		}

		if (!pos3) { // Updating sign
			num3 = "-" + num3;
		}
		return new BigInt(num3);
	}

//---universal help Functions--------------------------------------------------

	// Adds zeros for the numbers to be the same length
	private String fixziro(String num, int i) {
		while (i > 0) {
			num = '0' + num;
			i--;
		}
		return num;
	}

	// calculate plus or minus between 2 char
	private String plusMinusChars(char c1, char c2, char remainer, int operation) {
		char ans = (char) ('0' + (c1 - '0') + operation * (c2 - '0') + operation * (remainer - '0'));
		remainer = '0';

		if (ans > '9') {
			remainer = '1';
			ans = (char) (ans - 10);
		}
		if (ans < '0') {
			remainer = '1';
			ans = (char) (ans + 10);
		}

		return "" + remainer + ans;
	}

	// help to minus function
	private String SubStr(String num1, String num2) {
		String ans = new String("");
		int size1 = num1.length(); // ==num2.length()
		char remainer = '0';
		for (int i = size1 - 1; i >= 0; i--) {
			ans = plusMinusChars(num1.charAt(i), num2.charAt(i), remainer, MINUS) + ans;
			remainer = ans.charAt(0);
			ans = ans.substring(1);
		}
		return ans;
	}

	// calculate multiply between 2 char
	private String multChars(char c1, char c2) {
		int remainer = 0;
		char ans = (char) ('0' + (c1 - '0') * (c2 - '0'));

		while (ans > '9') {
			remainer++;
			ans = (char) (ans - 10);
		}
		return "" + remainer + ans;
	}

	// help to compare function [return:1->num1 bigger, 2->num2 bigger,
	// 0->num1==num2]
	private int num1isbigger(String num1, String num2) {
		int ans = NUM1_EQ_NUM2;
		int size1 = num1.length(); // ==num2.length()
		for (int i = 0; (ans == NUM1_EQ_NUM2) && (i < size1); i++) {
			if (num1.charAt(i) > num2.charAt(i)) {
				ans = NUM1_BIGGER;
			} else {
				if (num1.charAt(i) < num2.charAt(i)) {
					ans = NUM2_BIGGER;
				}
			}
		}
		return ans;
	}

//-----------------------------------------------------------

	// BigInt to String
	@Override
	public String toString() {
		String ans = new String("");
		if (!Positive) {
			ans += '-';
		}
		for (int i = 0; i < (this.number).size(); i++) {
			ans += number.get(i);
		}
		
		return ans;
	}

	// Is the number positive?
	public boolean positiv() {
		return this.Positive;
	}

	// Compares two numbers
	@Override
	public boolean equals(Object other) {

		if (other instanceof BigInt) {

			String num1 = this.toString();
			String num2 = other.toString();
			boolean pos1 = this.Positive;
			boolean pos2 = ((BigInt) other).positiv();

			if ((pos1) && (pos2) || ((!pos1) && (!pos2))) {// The numbers with the same sign
				num1 = cutSign(num1);
				num2 = cutSign(num2);

				int size1 = num1.length();
				int size2 = num2.length();

				if (size1 > size2) { // Adds zeros to num2
					num2 = fixziro(num2, size1 - size2);
				} else {
					if (size1 < size2) { // Adds zeros to num1
						num1 = fixziro(num1, size2 - size1);
					}
				}
				return (num1isbigger(num1, num2) == NUM1_EQ_NUM2);
			}
		}
		return false; // The numbers with a different sign
	}

	// compare 2 BigInt
	@Override
	public int compareTo(BigInt other) {
		if (other != null) {
			if (this.equals(other)) {
				return NUM1_EQ_NUM2;
			}
			else {
				if ((this.minus(other)).Positive) {
					return NUM1_BIGGER;
				}
				else {
					return NUM2_BIGGER;
				}
			}
		}
		return NUM1_BIGGER;
	}

// -----------------------------------------------------------
}
