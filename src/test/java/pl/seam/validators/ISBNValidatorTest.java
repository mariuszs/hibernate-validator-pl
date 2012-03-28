package pl.seam.validators;

import pl.seam.validator.ISBNValidatorImpl;
import junit.framework.TestCase;

/**
 * ISBNValidator Test Case.
 * 
 * @version $Revision: 478334 $ $Date: 2006-11-22 21:31:54 +0000 (Wed, 22 Nov
 *          2006) $
 */
public class ISBNValidatorTest extends TestCase {

	private static final String VALID_ISBN_RAW = "1930110995";
	private static final String VALID_ISBN_DASHES = "1-930110-99-5";
	private static final String VALID_ISBN_SPACES = "1 930110 99 5";
	private static final String VALID_ISBN_X = "0-201-63385-X";
	private static final String INVALID_ISBN = "068-556-98-45";

	public ISBNValidatorTest(String name) {
		super(name);
	}

	public void testIsValid() throws Exception {
		ISBNValidatorImpl validator = new ISBNValidatorImpl();
		assertFalse(validator.isValid(null));
		assertFalse(validator.isValid(""));
		assertFalse(validator.isValid("1"));
		assertFalse(validator.isValid("12345678901234"));
		assertFalse(validator.isValid("dsasdsadsads"));
		assertFalse(validator.isValid("535365"));
		assertFalse(validator.isValid("I love sparrows!"));
		assertFalse(validator.isValid("--1 930110 99 5"));
		assertFalse(validator.isValid("1 930110 99 5--"));
		assertFalse(validator.isValid("1 930110-99 5-"));

		assertTrue(validator.isValid(VALID_ISBN_RAW));
		assertTrue(validator.isValid(VALID_ISBN_DASHES));
		assertTrue(validator.isValid(VALID_ISBN_SPACES));
		assertTrue(validator.isValid(VALID_ISBN_X));
		assertFalse(validator.isValid(INVALID_ISBN));
	}

}
