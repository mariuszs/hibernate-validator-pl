package pl.seam.validators;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import pl.seam.hibernate.validator.NIPValidator;

public class NIPTest {

	@Test
	public void nip() {
		NIPValidator val = new NIPValidator();

		assertThat(val.isValid(null)).isTrue();
		assertThat(val.isValid("")).isFalse();

		assertThat(val.isValid("1235563218")).isFalse();
		assertThat(val.isValid("1234563218")).isTrue();

		assertThat(val.isValid("106-00-00-062")).isTrue();
		assertThat(val.isValid("123-456-78-19")).isTrue();
		assertThat(val.isValid("123-45-67-819")).isTrue();
	}

	@Test
	public void shouldBeValidNip() {
		NIPValidator val = new NIPValidator();

		assertThat(val.isValid("9511315100")).isTrue();
	}

	@Test
	public void shouldBeNeverValidNip() {
		NIPValidator val = new NIPValidator();

		assertThat(val.isValid("123456789-0")).isFalse();
		assertThat(val.isValid("123456789-1")).isFalse();
		assertThat(val.isValid("123456789-2")).isFalse();
		assertThat(val.isValid("123456789-3")).isFalse();
		assertThat(val.isValid("123456789-4")).isFalse();
		assertThat(val.isValid("123456789-5")).isFalse();
		assertThat(val.isValid("123456789-6")).isFalse();
		assertThat(val.isValid("123456789-7")).isFalse();
		assertThat(val.isValid("123456789-8")).isFalse();
		assertThat(val.isValid("123456789-9")).isFalse();
	
		// bezsensowny, ale czy powinien sie walidowac?
		assertThat(val.isValid("000-000-000-0")).isTrue();
	}

}
