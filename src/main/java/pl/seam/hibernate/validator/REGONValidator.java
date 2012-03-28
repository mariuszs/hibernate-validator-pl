package pl.seam.hibernate.validator;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.Validator;

import pl.seam.validator.Validators;

/**
 * Hibernet Validator for REGON (Rejestr Gospodarki Narodowej)
 * 
 * http://pl.wikipedia.org/wiki/REGON
 * 
 * @author marian <mariuszs@gmail.com>
 * @version 0.3
 */
public class REGONValidator extends ValidatorBase implements Validator<REGON> {

	private boolean digitsOnly;

	public void initialize(REGON configuration) {
		digitsOnly = configuration.digitsOnly();
	}

	public boolean isValid(Object value) {
		if (value == null) {
			return true;
		}

		String regon = null;

		if (value instanceof String) {
			if (digitsOnly) {
				regon = (String) value;
				if (!StringUtils.isNumeric(regon)) {
					return false;
				}

			} else {
				regon = removeNonDigit((String) value);
			}
		} else if (value instanceof Long) {
			Long longValue = (Long) value;
			regon = longValue.toString();
		} else
			return false;

		return Validators.isValidREGON(regon);

	}

}
