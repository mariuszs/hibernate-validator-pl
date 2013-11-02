package pl.seam.hibernate.validator;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.Validator;

/**
 * Hibernet Validator for String that contains only ASCII printable characters
 * 
 * http://jakarta.apache.org/commons/lang/api/org/apache/commons/lang/StringUtils.html
 * 
 * @author marian
 */
public class AsciiPrintableValidator extends ValidatorBase implements
		Validator<AsciiPrintable> {

	public void initialize(AsciiPrintable configuration) {

	}

	public boolean isValid(Object value) {
		if (value == null) {
			return true;
		}

		String ascii = null;

		if (value instanceof String) {
			ascii = (String) value;
		} else
			return false;

        return StringUtils.isAsciiPrintable(ascii);

    }
}
