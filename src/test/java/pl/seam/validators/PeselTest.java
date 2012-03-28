package pl.seam.validators;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.seam.hibernate.validator.PESELValidator;

/**
 * Unit test for PESEL.
 */
public class PeselTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public PeselTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(PeselTest.class);
	}

	public void testApp() {
		PESELValidator val = new PESELValidator();

		String pesel = null;
		assert val.isValid(pesel) : "Pesel jest poprawny - nie wymagane pole!"
				+ pesel;
		pesel = "";
		assert !val.isValid(pesel) : "Pesel jest niepoprawny!" + pesel;

		pesel = "44052401458";
		assert !val.isValid(pesel) : "Pesel jest niepoprawny!" + pesel;
		
		pesel = "44051401458";
		assert val.isValid(pesel) : "Pesel jest poprawny!" + pesel;

		Long PeselLong = 44052401458L;
		assert !val.isValid(PeselLong) : "Pesel jest niepoprawny!" + pesel;

		PeselLong = 44051401458L;
		assert val.isValid(PeselLong) : "Pesel jest poprawny!" + pesel;

		assert !val.isValid(4) : "Pesel jest niepoprawny!" + pesel;
		// assertTrue( true );
	}
}
