package pl.seam.validators;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.seam.hibernate.validator.PNAValidator;

/**
 * Unit test for Regonp.
 */
public class PNATest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PNATest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PNATest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	PNAValidator val = new PNAValidator();

		String pna = null;
		assert val.isValid(pna) : "Kod pocztowy jest poprawny - nie wymagane pole!" + pna;
		pna = "";
		assert !val.isValid(pna) : "Kod pocztowy jest niepoprawny!" + pna;
		// 7 cyfr
		pna = "555-444";

		assert !val.isValid(pna) : "Kod pocztowy jest niepoprawny!" + pna;
		pna = "44-444";
		assert val.isValid(pna) : "Kod pocztowy jest poprawny!" + pna;
		assert val.isValid(pna) : "Kod pocztowy jest poprawny!" + pna;

		Long pnaLong = 343523L;
		assert !val.isValid(pnaLong) : "Kod pocztowy jest niepoprawny!" + pna;

		pnaLong = 33444L;
		assert val.isValid(pnaLong) : "Kod pocztowy jest poprawny!" + pna;

		assert !val.isValid(4) : "Kod pocztowy jest niepoprawny!" + pna;
		assert !val.isValid("we324") : "Kod pocztowy jest niepoprawny!" + pna;
        //assertTrue( true );
    }
}
