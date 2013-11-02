package pl.seam.validators;

import org.junit.Test;
import pl.seam.hibernate.validator.ValidatorBase;

import static org.junit.Assert.assertEquals;

public class ValidatorHierarchyTest {
    private static class ValidatorBaseExt extends ValidatorBase {
        public String removeNonDigit(String str) {
            return super.removeNonDigit(str);
        }
    }
    private static final ValidatorBaseExt vb = new ValidatorBaseExt();

    @Test
    public void remove_alpha() {
        assertEquals("123", vb.removeNonDigit("123ABC"));
    }

    @Test
    public void remove_non_digit() {
        assertEquals("123", vb.removeNonDigit("~123!ABC?"));
    }
}
