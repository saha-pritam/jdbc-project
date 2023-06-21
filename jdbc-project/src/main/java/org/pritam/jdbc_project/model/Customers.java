package org.pritam.jdbc_project.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	public static void printCustomers(List<Customers> customers) {
		System.out.printf("%-15s%-40s%-40s%-40s%-40s%-40s%-40s\n","Customer ID","Customer Name","Contact Name","Address","City","Postal Code","Country");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(Customers customer:customers) {
			System.out.printf("%-15s%-40s%-40s%-40s%-40s%-40s%-40s\n",customer.getCustomerId(),customer.getCustomerName(),customer.getContactName(),customer.getAddress(),customer.getCity(),customer.getPostalCode(),customer.getCountry());
		}
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
}
