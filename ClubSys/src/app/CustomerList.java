package app;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import data.appdata.Customer;
import data.database.CustomerDB;

public class CustomerList {
	private CustomerDB customerDB = new CustomerDB();
	private List<Customer> customerList;
	private CustomerController customerController;
	
	public List<Customer> getCustomers()
	{
		return customerDB.getCustomer();
	}
	
	public void addCustomer(Customer customer)
	{
		//			customer.setPassword(Encrypter.encrypt(customer.getPassword()));
		customerDB.addCustomer(customer);
	}
}
