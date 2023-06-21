package org.pritam.jdbc_project.model;

import java.util.List;

public class Country {
	private String countryName;
	private int totalCustomers;
	public Country(String countryName, int totalCustomers) {
		super();
		this.countryName = countryName;
		this.totalCustomers = totalCustomers;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String city) {
		this.countryName = city;
	}
	public int getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public static void printCountrySummary(List<Country> countries) {
		System.out.printf("%-40s%-20s\n","Country","Total Customers");
		System.out.println("--------------------------------------------------------");
		for(Country country:countries) {
			System.out.printf("%-40s%-20s\n",country.getCountryName(),country.getTotalCustomers());
		}
	}
}
