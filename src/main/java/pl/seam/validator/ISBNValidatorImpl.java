package pl.seam.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Code borrowed from Commons Validator, modificated to use java.util.regex
 * 
 * A class for validating 10 digit ISBN codes. Based on this <a
 * href="http://www.isbn.org/standards/home/isbn/international/html/usm4.htm">
 * algorithm</a>
 * 
 * @version $Revision: 478334 $ $Date: 2006-11-22 21:31:54 +0000 (Wed, 22 Nov
 *          2006) $
 * @since Validator 1.2.0
 */
public class ISBNValidatorImpl {

	private static final String SEP = "(\\-|\\s)";
	private static final String GROUP = "(\\d{1,5})";
	private static final String PUBLISHER = "(\\d{1,7})";
	private static final String TITLE = "(\\d{1,6})";
	private static final String CHECK = "([0-9X])";

	/**
	 * ISBN consists of 4 groups of numbers separated by either dashes (-) or
	 * spaces. The first group is 1-5 characters, second 1-7, third 1-6, and
	 * fourth is 1 digit or an X.
	 */
	private static final String ISBN_PATTERN = "^" + GROUP + SEP + PUBLISHER
			+ SEP + TITLE + SEP + CHECK + "$";

	/**
	 * Default Constructor.
	 */
	public ISBNValidatorImpl() {
		super();
	}

	/**
	 * If the ISBN is formatted with space or dash separators its format is
	 * validated. Then the digits in the number are weighted, summed, and
	 * divided by 11 according to the ISBN algorithm. If the result is zero, the
	 * ISBN is valid. This method accepts formatted or raw ISBN codes.
	 * 
	 * @param isbn
	 *            Candidate ISBN number to be validated. <code>null</code> is
	 *            considered invalid.
	 * @return true if the string is a valid ISBN code.
	 */
	public boolean isValid(String isbn) {
		if (isbn == null || isbn.length() < 10 || isbn.length() > 13) {
			return false;
		}

		if (isFormatted(isbn) && !isValidPattern(isbn)) {
			return false;
		}

		isbn = clean(isbn);
		if (isbn.length() != 10) {
			return false;
		}

		return (sum(isbn) % 11) == 0;
	}

	/**
	 * Returns the sum of the weighted ISBN characters.
	 */
	private int sum(String isbn) {
		int total = 0;
		for (int i = 0; i < 9; i++) {
			int weight = 10 - i;
			total += (weight * toInt(isbn.charAt(i)));
		}
		total += toInt(isbn.charAt(9)); // add check digit
		return total;
	}

	/**
	 * Removes all non-digit characters except for 'X' which is a valid ISBN
	 * character.
	 */
	private String clean(String isbn) {
		StringBuilder buf = new StringBuilder(10);

		for (int i = 0; i < isbn.length(); i++) {
			char digit = isbn.charAt(i);
			if (Character.isDigit(digit) || (digit == 'X')) {
				buf.append(digit);
			}
		}

		return buf.toString();
	}

	/**
	 * Returns the numeric value represented by the character. If the character
	 * is not a digit but an 'X', 10 is returned.
	 */
	private int toInt(char ch) {
		return (ch == 'X') ? 10 : Character.getNumericValue(ch);
	}

	/**
	 * Returns true if the ISBN contains one of the separator characters space
	 * or dash.
	 */
	private boolean isFormatted(String isbn) {
		return ((isbn.indexOf('-') != -1) || (isbn.indexOf(' ') != -1));
	}

	/**
	 * Returns true if the ISBN is formatted properly.
	 */
	private boolean isValidPattern(String isbn) {
		Pattern p = Pattern.compile(ISBN_PATTERN);
		Matcher m = p.matcher(isbn);
		return m.matches();

	}

}
