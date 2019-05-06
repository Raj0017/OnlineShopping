package net.kzm.shopingBackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", billing=" + billing + ", shipping=" + shipping + "]";
	}
	public int getId() {
		return id;
	}
	
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@ManyToOne
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="address_line_one")
	@NotBlank(message="please enter Address!!!")
	private String addressLineOne;
	@NotBlank(message="please enter Address line two!!")
	@Column(name="address_line_two")
	private String addressLineTwo;
	
	@NotBlank(message="please enter city!!")
	private String city;
	
	@NotBlank(message="please enter State!!")
	private String state;
	@NotBlank(message="please enter Country")
	private String country;
	@NotBlank(message="please enter Postal code!!")
	@Column(name="postal_code")
	private String postalCode;
	@Column(name="biling")
	private boolean billing;
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	private boolean shipping;
	
	private int userId;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	

}
