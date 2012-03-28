package pl.seam.validators;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.seam.hibernate.validator.AlphaValidator;
import pl.seam.hibernate.validator.AsciiPrintableValidator;

/**
 * Unit test for Regonp.
 */
public class CustomTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CustomTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CustomTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	AlphaValidator val = new AlphaValidator();

		
		assert val.isValid("sdfsfw") : "Kod pocztowy jest poprawny - nie wymagane pole!"
				;
		
		assert !val.isValid("sdfs3fdgf") : "Kod pocztowy jest niepoprawny!" ;

		assert !val.isValid(345345435L) : "Kod pocztowy jest niepoprawny!" ;

    }
    public void asciiTestApp()
    {
    	AsciiPrintableValidator val = new AsciiPrintableValidator();

		
		assert val.isValid("!ab-c~sfw") : "Kod pocztowy jest poprawny - nie wymagane pole!"
				;
		
		assert !val.isValid("sds�fs3!ab-c~gf") : "Kod pocztowy jest niepoprawny!" ;

		assert !val.isValid(345345435L) : "Kod pocztowy jest niepoprawny!" ;

    }
}
