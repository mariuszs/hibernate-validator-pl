package pl.seam.hibernate.validator;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.Validator;

/**
 * Hibernet Validator for String that contains only lower case letters.
 * 
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

		if (!alpha.equals(StringUtils.lowerCase(alpha))) {
			return false;
		}

		return true;

	}
}
