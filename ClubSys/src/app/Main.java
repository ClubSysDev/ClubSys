package app;

import java.util.List;

import data.appdata.Customer;
import data.database.CustomerDB;

public class Main {

	private static CustomerList customerList = new CustomerList();
	
	public static void main(String[] args) {
		CustomerDB customerDB = new CustomerDB();
		
		List<Customer> list = customerList.getCustomers();
		
		for(Customer c : list)
		{
			System.out.println(c.getName() + ", " + c.getPassword());
		}
		
	}

}
