package net.ash.shoppingBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="user_id")
	private long userId;
	@Column(name="address_line_one")
	private String addrsLine1;
	@Column(name="address_line_two")
	private String addrsLine2;
	
	private String city;
	
	private String state;
	
	private String country;
	@Column(name="postal_code")
	private String postalCode;
	@Column(name="is_billing")
	private boolean isBilling;
	@Column(name="is_shipping")
	private boolean isShipping;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAddrsLine1() {
		return addrsLine1;
	}
	public void setAddrsLine1(String addrsLine1) {
		this.addrsLine1 = addrsLine1;
	}
	public String getAddrsLine2() {
		return addrsLine2;
	}
	public void setAddrsLine2(String addrsLine2) {
		this.addrsLine2 = addrsLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isBilling() {
		return isBilling;
	}
	public void setBilling(boolean isBilling) {
		this.isBilling = isBilling;
	}
	public boolean isShipping() {
		return isShipping;
	}
	public void setShipping(boolean isShipping) {
		this.isShipping = isShipping;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", addrsLine1=" + addrsLine1 + ", addrsLine2=" + addrsLine2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", isBilling=" + isBilling + ", isShipping=" + isShipping + "]";
	}
	
	
}
