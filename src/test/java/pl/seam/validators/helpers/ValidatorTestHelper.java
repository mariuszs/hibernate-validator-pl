package pl.seam.validators.helpers;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidStateException;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * User: <a href="http://javaunderhood.wordpress.com">Maciej Kreft</a>
 */
public class ValidatorTestHelper {
    public static void assertTrueOrShowErrors(HumanBeing hb, ClassValidator<HumanBeing> cv, boolean shouldFail) {
        Exception exc = null;
        try {
            cv.assertValid(hb);
        } catch (InvalidStateException ise) {
            exc = ise;
        }
        assertTrue(showErrMsg(hb, cv),(exc == null) == shouldFail);
    }

    private static String showErrMsg(HumanBeing hb, ClassValidator<HumanBeing> cv) {
        return Arrays.toString(cv.getInvalidValues(hb));
    }
}
