package org.pritam.jdbc_project.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customers {
	private int customerId;
	private String customerName;
	private String contactName;
	private String address;
	private String city;
	private String postalCode;
	private String country;
	
	public Customers(int customerId, String customerName, String contactName, String address, String city,
			String postalCode, String country) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public static Customers resultSetToCustomer(ResultSet resultSet) {
		Customers customer=null;
		try {
			customer = new Customers(resultSet.getInt("CustomerID"),
					resultSet.getString("CustomerName"),
					resultSet.getString("ContactName"),
					resultSet.getString("Address"),
					resultSet.getString("City"),
					resultSet.getString("PostalCode"),
					resultSet.getString("Country"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + ", contactName=" + contactName
				+ ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + ", country=" + country
				+ "]";
	}
	
}
