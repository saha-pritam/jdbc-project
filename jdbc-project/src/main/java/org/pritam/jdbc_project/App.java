package org.pritam.jdbc_project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.pritam.jdbc_project.ConnectionProvider.ConnectionProvider;
import org.pritam.jdbc_project.DAO.CustomersDAO;
import org.pritam.jdbc_project.model.City;
import org.pritam.jdbc_project.model.Country;
import org.pritam.jdbc_project.model.Customers;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		CustomersDAO customersDAO = new CustomersDAO();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\n1.Display All Customer" 
							+ "\n2.Display Customer By ID" 
							+ "\n3.Display Customer By City"
							+ "\n4.Display Customer By Country" 
							+ "\n5.Insert Customer"
							+ "\n6.Update Customer"
							+ "\n9.Exit");
			System.out.print("Enter Your Choice :- ");
			int n = Integer.parseInt(br.readLine());
			try {
				if (n == 1)
					Customers.printCustomers(customersDAO.getCustomersBy(null, null));
				else if (n == 2) {
					System.out.print("Enter the Customer ID :- ");
					int id = Integer.parseInt(br.readLine());
					Customers.printCustomers(customersDAO.getCustomersBy("customerid", Integer.toString(id)));
				}
				else if (n == 3) {
					System.out.print("Enter the City :- ");
					String city = br.readLine();
					Customers.printCustomers(customersDAO.getCustomersBy("city", city));
				}
				else if (n == 4) {
					System.out.print("Enter the Country :- ");
					String country = br.readLine();
					Customers.printCustomers(customersDAO.getCustomersBy("country", country));
				}
				else if(n==5 || n==6 ) {
					int customerID=0;
					if(n==6) {
						System.out.print("Enter the ID of the customer whose data you want to update :- ");
						customerID=Integer.parseInt(br.readLine());
					}
					
					System.out.print((n==5)?"Enter the name :- ":"Enter the new name if you want to edit else type the existing name :- ");
					String customerName=br.readLine();
					
					System.out.print((n==5)?"Enter the contact name :- ":"Enter the new contact name if you want to edit else type the existing contact name :- ");
					String contactName=br.readLine();
					
					System.out.print((n==5)?"Enter the address :- ":"Enter the new address if you want to edit else type the existing address :- ");
					String address=br.readLine();
					
					System.out.print((n==5)?"Enter the city :- ":"Enter the new city if you want to edit else type the existing city :- ");
					String city=br.readLine();
					
					System.out.print((n==5)?"Enter the postal code :- ":"Enter the new postal code if you want to edit else type the existing postal code :- ");
					String postalCode=br.readLine();
					
					System.out.print((n==5)?"Enter the country :- ":"Enter the new country if you want to edit else type the existing country :- ");
					String country=br.readLine();
					
					Customers customer = new Customers(customerID,customerName,contactName,address,city,postalCode,country);
					if(n==5)
						customersDAO.insertCustomer(customer);
					else
						customersDAO.updateCustomer(customer);	
				}
				else if (n == 9) {
					customersDAO.closeConnection();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
