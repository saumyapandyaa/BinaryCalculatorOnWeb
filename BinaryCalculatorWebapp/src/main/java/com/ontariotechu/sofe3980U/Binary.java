package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
	private String number = "0"; // string containing the binary value '0' or '1'

	/**
	 * A constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should contain only zeros or
	 *               ones with any length and order. otherwise, the value of "0"
	 *               will be stored. Trailing zeros will be excluded and empty
	 *               string will be considered as zero.
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}

		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}

		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);

		// Ensure empty strings are replaced with "0"
		if (this.number.isEmpty()) {
			this.number = "0";
		}
	}

	/**
	 * Return the binary value of the variable
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue() {
		return this.number;
	}

	/**
	 * Adding two binary variables. For more information, visit
	 * <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers
	 * </a>.
	 *
	 * @param num1 The first addend object
	 * @param num2 The second addend object
	 * @return A binary variable with a value of <i>num1+num2</i>.
	 */
	public static Binary add(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		// initial variable
		int carry = 0;
		String num3 = ""; // the binary value of the sum
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
		{
			int sum = carry; // previous carry
			if (ind1 >= 0) { // if num1 has a digit to add
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if (ind2 >= 0) { // if num2 has a digit to add
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind2--; // update ind2
			}
			carry = sum / 2; // the new carry
			sum = sum % 2; // the resultant digit
			num3 = ((sum == 0) ? "0" : "1") + num3; // convert sum to string and append it to num3
		}
		Binary result = new Binary(num3); // create a binary object with the calculated value.
		return result;

	}

	// Multiplying two binary numbers
	public static Binary multiply(Binary num1, Binary num2) {
		// Convert both binary numbers to their decimal (integer) equivalents
		int decimal1 = Integer.parseInt(num1.number, 2); // base 2 for binary
		int decimal2 = Integer.parseInt(num2.number, 2);

		// Multiply the decimal numbers
		int resultDecimal = decimal1 * decimal2;

		// Convert the result back to binary string
		String resultBinary = Integer.toBinaryString(resultDecimal);

		// Return the result as a Binary object
		return new Binary(resultBinary);
	}

	// Performing a bitwise AND operation on two binary numbers
	public static Binary AND(Binary num1, Binary num2) {
		// Make sure the lengths of the binary strings are the same by padding the
		// shorter one
		int maxLength = Math.max(num1.number.length(), num2.number.length());
		StringBuilder num1Padded = new StringBuilder(num1.number);
		StringBuilder num2Padded = new StringBuilder(num2.number);

		while (num1Padded.length() < maxLength) {
			num1Padded.insert(0, "0");
		}

		while (num2Padded.length() < maxLength) {
			num2Padded.insert(0, "0");
		}

		// Perform the AND operation
		StringBuilder resultBinary = new StringBuilder();
		for (int i = 0; i < maxLength; i++) {
			char bit1 = num1Padded.charAt(i);
			char bit2 = num2Padded.charAt(i);
			resultBinary.append((bit1 == '1' && bit2 == '1') ? '1' : '0');
		}

		// Return the result as a Binary object
		return new Binary(resultBinary.toString());
	}

	// Performing a bitwise OR operation on two binary numbers
	public static Binary OR(Binary num1, Binary num2) {
		// Make sure the lengths of the binary strings are the same by padding the
		// shorter one
		int maxLength = Math.max(num1.number.length(), num2.number.length());
		StringBuilder num1Padded = new StringBuilder(num1.number);
		StringBuilder num2Padded = new StringBuilder(num2.number);

		while (num1Padded.length() < maxLength) {
			num1Padded.insert(0, "0");
		}

		while (num2Padded.length() < maxLength) {
			num2Padded.insert(0, "0");
		}

		// Perform the OR operation
		StringBuilder resultBinary = new StringBuilder();
		for (int i = 0; i < maxLength; i++) {
			char bit1 = num1Padded.charAt(i);
			char bit2 = num2Padded.charAt(i);
			resultBinary.append((bit1 == '1' || bit2 == '1') ? '1' : '0');
		}

		// Return the result as a Binary object
		return new Binary(resultBinary.toString());
	}

}
