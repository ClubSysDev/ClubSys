package app;

import java.util.List;

import data.appdata.Customer;
import data.database.CustomerDB;

public class Main {

	private static CustomerList customerList = new CustomerList();
	
	public static void main(String[] args) {
		CustomerDB customerDB = new CustomerDB();
		
//		customerDB.addCustomer(new Customer(1,"Navn",1234,"Adresse","mail",12345678,"password"));
		
		
		List<Customer> list = customerList.getCustomers();
		
		Customer customer = list.get(0);
	
		System.out.println(customer.getPassword());
		
	}

}
