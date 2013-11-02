package pl.seam.hibernate.validator;

import org.hibernate.validator.Validator;

import static org.apache.commons.lang3.StringUtils.lowerCase;

/**
 * Hibernet Validator for String that contains only lower case letters.
 * <p/>
 * http://jakarta.apache.org/commons/lang/api/org/apache/commons/lang/StringUtils.html
 *
 * @author marian
 */
public class LowerCaseValidator extends ValidatorBase implements
        Validator<LowerCase> {

    public void initialize(LowerCase configuration) {
    }

    public boolean isValid(Object value) {
        if (value == null) {
            return true;
        }

        if (!(value instanceof String)) {
            return false;
        }

        String alpha = (String) value;

        return alpha.equals(lowerCase(alpha));

    }
}
