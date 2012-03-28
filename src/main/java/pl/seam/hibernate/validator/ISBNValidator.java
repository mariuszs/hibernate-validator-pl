package pl.seam.hibernate.validator;

import org.hibernate.validator.Validator;

import pl.seam.validator.ISBNValidatorImpl;

/**
 * Hibernet Validator for ISBN
 * 
 * @author marian
 */
public class ISBNValidator extends ValidatorBase implements Validator<ISBN> {

	public void initialize(ISBN configuration) {

	}

	public boolean isValid(Object value) {
		if (value == null) {
			return true;
		}

		String alpha = null;

		if (value instanceof String) {
			alpha = (String) value;
			ISBNValidatorImpl val = new ISBNValidatorImpl();

			if (val.isValid(alpha)) {
				return true;
			}
		}
		return false;
	}

}
