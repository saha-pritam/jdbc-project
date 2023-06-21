package org.pritam.jdbc_project.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pritam.jdbc_project.ConnectionProvider.ConnectionProvider;
import org.pritam.jdbc_project.model.City;
import org.pritam.jdbc_project.model.Country;
import org.pritam.jdbc_project.model.Customers;

public class CustomersDAO {
	private Connection connection;
	
	public CustomersDAO() {
		super();
		connection = ConnectionProvider.getConnection();
	}
	
	/**
	 * This method will return the list of customer based on passed columnName and columnValue
	 * Example for conditional query like "select * from Customers where CustomerId = 1" then use the method as getCustomersBy("CustomerID","1");
	 * Example for conditional query like "select * from Customers where CustomerName = 'Pritam'" then use the method as getCustomersBy("CustomerName","Pritam");
	 * Example for non conditional query like "select * from Customers" then use the method as getCustomersBy(null,null);
	 * @param columnName
	 * @param columnValue
	 * @return
	 * @throws Exception
	 */
	public List<Customers> getCustomersBy(String columnName, String columnValue)throws Exception {
		String query = "select * from Customers";
		if(columnName!=null && columnValue!=null ) {
			if(columnName.equalsIgnoreCase("customerId"))
				query+=" where "+columnName+"="+columnValue;
			else
				query+=" where "+columnName+"=\'"+columnValue+"\'";
		}
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		List<Customers> customers = new ArrayList<Customers>();
		while(resultSet.next()) {
			customers.add(new Customers(resultSet.getInt("customerId"),
					resultSet.getString("customerName"),
					resultSet.getString("contactName"),
					resultSet.getString("address"),
					resultSet.getString("city"),
					resultSet.getString("postalCode"),
					resultSet.getString("country")));
		}
		resultSet.close();
		statement.close();
		return customers;
	}
	
	/**
	 * This method will add the Customers data to the customers table.
	 * @param customers
	 * @throws SQLException
	 */
	public void insertCustomer(Customers customers) throws SQLException {
		String query="insert into customers(CustomerName,ContactName,Address,City,PostalCode,Country) values(?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, customers.getCustomerName());
		preparedStatement.setString(2, customers.getContactName());
		preparedStatement.setString(3, customers.getAddress());
		preparedStatement.setString(4, customers.getCity());
		preparedStatement.setString(5, customers.getPostalCode());
		preparedStatement.setString(6, customers.getCountry());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	/**
	 * This method will update every details of the customers based on customerId if exists else it will do nothing.
	 * @param customers
	 * @throws SQLException
	 */
	public void updateCustomer(Customers customers) throws SQLException {
		String query="update customers set customerName=?, contactName=?, address=?, city=?, postalCode=?, country=? where customerId=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, customers.getCustomerName());
		preparedStatement.setString(2, customers.getContactName());
		preparedStatement.setString(3, customers.getAddress());
		preparedStatement.setString(4, customers.getCity());
		preparedStatement.setString(5, customers.getPostalCode());
		preparedStatement.setString(6, customers.getCountry());
		preparedStatement.setInt(7, customers.getCustomerId());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	/**
	 * This method will delete the customer based on passed id only if the id exists otherwise it will do nothing.
	 * @param id
	 * @throws SQLException
	 */
	public void deleteCustomer(int id) throws SQLException {
		String query="delete from customers where customerid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	/**
	 * This method will provide a summary as a list of customer count per city.
	 * @return List<City>
	 * @throws SQLException
	 */
	public List<City> getSummaryByCity() throws SQLException {
		CallableStatement callableStatement = connection.prepareCall("call getSummeryByCity()");
		ResultSet resultSet = callableStatement.executeQuery();
		List<City> cities = new ArrayList<City>();
		while(resultSet.next()) {
			cities.add(new City(resultSet.getString(1),resultSet.getInt(2)));
		}
		resultSet.close();
		callableStatement.close();
		return cities;
	}
	
	/**
	 * This method will provide a summary as a list of customer count per country.
	 * @return List<Country>
	 * @throws SQLException
	 */
	public List<Country> getSummaryByCountry() throws SQLException {
		CallableStatement callableStatement = connection.prepareCall("call getSummeryByCountry()");
		ResultSet resultSet = callableStatement.executeQuery();
		List<Country> countries = new ArrayList<Country>();
		while(resultSet.next()) {
			countries.add(new Country(resultSet.getString(1),resultSet.getInt(2)));
		}
		resultSet.close();
		callableStatement.close();
		return countries;
	}
	/**
	 * This method is used to close the connection provided by the ConnectionProvider class.
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
