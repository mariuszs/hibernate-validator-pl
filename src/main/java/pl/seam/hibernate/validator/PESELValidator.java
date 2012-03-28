package pl.seam.hibernate.validator;

import org.hibernate.validator.Validator;

import pl.seam.validator.Validators;

/**
 * Hibernet Validator for PESEL (Powszechny Elektroniczny System Ewidencji
 * Ludnosci)
 * 
 * http://pl.wikipedia.org/wiki/PESEL
 * 
 * @author marian
 * @version 0.3
 */
public class PESELValidator extends ValidatorBase implements Validator<PESEL> {

	public void initialize(PESEL configuration) {

	}

	public boolean isValid(Object value) {
		if (value == null) {
			return true;
		}

		String pesel = null;

		if (value instanceof String) {
			pesel = (String) value;
			pesel = removeNonDigit(pesel);
		} else if (value instanceof Long) {
			Long longValue = (Long) value;
			pesel = longValue.toString();
		} else
			return false;

		return Validators.isValidPESEL(pesel);

	}

}
