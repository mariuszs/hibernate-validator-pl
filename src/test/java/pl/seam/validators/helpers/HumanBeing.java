package pl.seam.validators.helpers;

import pl.seam.hibernate.validator.Alpha;

public class HumanBeing {
	@Alpha
	private String name;

	@Alpha(allowNumeric = true)
	private String phone;
	@Alpha(allowNumeric = true, allowSpace = true)
	private String phoneWithSpaces;
	@Alpha(allowSpace = true)
	private String names;
	@Alpha
	private String optionalGender;

	public HumanBeing setOptionalGender(String optionalGender) {
		this.optionalGender = optionalGender;
		return this;
	}

	public HumanBeing setNames(String names) {
		this.names = names;
		return this;
	}

	public HumanBeing setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public HumanBeing setPhoneWithSpaces(String phoneWithSpaces) {
		this.phoneWithSpaces = phoneWithSpaces;
		return this;
	}

	public HumanBeing(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPhoneWithSpaces() {
		return phoneWithSpaces;
	}

	public String getNames() {
		return names;
	}

	public String getOptionalGender() {
		return optionalGender;
	}
}