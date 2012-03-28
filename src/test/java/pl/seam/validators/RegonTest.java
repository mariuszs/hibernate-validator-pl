package pl.seam.validators;

import pl.seam.hibernate.validator.REGONValidator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Regonp.
 */
public class RegonTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RegonTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RegonTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	REGONValidator val = new REGONValidator();

		String regon = null;
		assert val.isValid(regon) : "Regon jest poprawny - nie wymagane pole!"
				+ regon;
		regon = "";
		assert !val.isValid(regon) : "Regon jest niepoprawny!" + regon;
		// 7 cyfr
		regon = "435436436";

		assert !val.isValid(regon) : "Regon jest niepoprawny!" + regon;
		regon = "123456785";
		assert val.isValid(regon) : "Regon jest poprawny!" + regon;
		// 14 cyfr
		regon = "12345658512347";

		assert !val.isValid(regon) : "Regon jest niepoprawny!" + regon;
		regon = "12345678512347";
		assert val.isValid(regon) : "Regon jest poprawny!" + regon;

		Long regonLong = 123453785L;
		assert !val.isValid(regonLong) : "Regon jest niepoprawny!" + regon;

		regonLong = 123456785L;
		assert val.isValid(regonLong) : "Regon jest poprawny!" + regon;

		assert !val.isValid(4) : "Regon jest niepoprawny!" + regon;
        //assertTrue( true );
    }
}
