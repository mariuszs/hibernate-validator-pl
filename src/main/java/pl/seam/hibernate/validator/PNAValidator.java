package pl.seam.hibernate.validator;

import org.hibernate.validator.Validator;

/**
 * Hibernet Validator for Pocztowe Numery Adresowe - PNA
 * 
 * http://pl.wikipedia.org/wiki/Kod_pocztowy
 * 
 * @author marian
 * @version 0.3
 */
public class PNAValidator extends ValidatorBase implements Validator<PNA> {

	public void initialize(PNA configuration) {

	}

	public boolean isValid(Object value) {
		if (value == null) {
			return true;
		}

		String pna;

		if (value instanceof String) {
			pna = (String) value;
			pna = removeNonDigit(pna);
		} else if (value instanceof Long) {
			Long longValue = (Long) value;
			pna = longValue.toString();
		} else
			return false;

        return pna.length() == 5;

    }

}
