package org.pritam.jdbc_project.model;

import java.util.List;

public class City {
	private String cityName;
	private int totalCustomers;
	public City(String cityName, int totalCustomers) {
		super();
		this.cityName = cityName;
		this.totalCustomers = totalCustomers;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String city) {
		this.cityName = city;
	}
	public int getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public static void printCitySummary(List<City> cities) {
		System.out.printf("%-40s%-20s\n","City","Total Customers");
		System.out.println("--------------------------------------------------------");
		for(City city:cities) {
			System.out.printf("%-40s%-20s\n",city.getCityName(),city.getTotalCustomers());
		}
	}
}
