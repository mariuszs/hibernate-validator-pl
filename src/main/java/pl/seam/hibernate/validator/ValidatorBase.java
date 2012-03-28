package pl.seam.hibernate.validator;


public abstract class ValidatorBase {
	protected String removeNonDigit(String input) {
		return input.replaceAll("\\D*", "");
	}

}
