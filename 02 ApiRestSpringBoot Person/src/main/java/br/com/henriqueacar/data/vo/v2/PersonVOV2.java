package br.com.henriqueacar.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.github.dozermapper.core.Mapping;

public class PersonVOV2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	private Long key;
	
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	private Date birthday;
	
	public PersonVOV2() {
		
	}

	/**
	 * @return the key
	 */
	public Long getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Long key) {
		this.key = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birthday, firstName, gender, key, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVOV2 other = (PersonVOV2) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthday, other.birthday)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(key, other.key) && Objects.equals(lastName, other.lastName);
	}
}
