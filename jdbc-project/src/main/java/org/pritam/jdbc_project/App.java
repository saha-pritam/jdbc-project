package org.pritam.jdbc_project;

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
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n1.Display All Customer" 
							+ "\n2.Display Customer By ID" 
							+ "\n3.Display Customer By City"
							+ "\n4.Display Customer By Country" 
							+ "\n9.Exit");
			System.out.print("Enter Your Choice :- ");
			int n = sc.nextInt();
			try {
				if (n == 1)
					Customers.printCustomers(customersDAO.getCustomersBy(null, null));
				else if (n == 2) {
					System.out.print("Enter the Customer ID :- ");
					int id = sc.nextInt();
					Customers.printCustomers(customersDAO.getCustomersBy("customerid", Integer.toString(id)));
				}
				else if (n == 3) {
					System.out.print("Enter the City :- ");
					if(sc.hasNextLine())
						sc.nextLine();
					String city = sc.nextLine();
					Customers.printCustomers(customersDAO.getCustomersBy("city", city));
				}else if (n == 4) {
					System.out.print("Enter the Country :- ");
					if(sc.hasNextLine())
						sc.nextLine();
					sc.reset();
					String country = sc.nextLine();
					Customers.printCustomers(customersDAO.getCustomersBy("country", country));
				} else if (n == 9) {
					customersDAO.closeConnection();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
