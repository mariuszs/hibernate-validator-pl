package pl.seam.hibernate.validator;

import org.hibernate.validator.Validator;

import pl.seam.validator.Validators;

/**
 * Hibernete Validator for NIP (Numer Identyfikacji Podatkowej)
 * 
 * http://pl.wikipedia.org/wiki/NIP
 * 
 * @author marian
 * @version 0.3
 */
public class NIPValidator extends ValidatorBase implements Validator<NIP> {

	public void initialize(NIP configuration) {

	}

	public boolean isValid(Object value) {
		if (value == null) {
			return true;
		}

		String nip = null;

		if (value instanceof String) {
			nip = (String) value;
			nip = removeNonDigit(nip);
		} else if (value instanceof Long) {
			Long longValue = (Long) value;
			nip = longValue.toString();
		} else
			return false;

		return Validators.isValidNIP(nip);

	}

}
