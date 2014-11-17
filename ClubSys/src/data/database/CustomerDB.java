package data.database;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import app.Encrypter;
import data.appdata.Customer;

public class CustomerDB
{
	
	PreparedStatement preparedStatement = null;
	ResultSet result = null;

	public List<Customer> getCustomer()
	{
		DBConnector.connect();
		
		List<Customer> customerList = new ArrayList<Customer>();
		try 
		{
			preparedStatement = DBConnector.getConnection().prepareStatement("SELECT * FROM kunder");
			
			result = preparedStatement.executeQuery();
			
			
			while(result.next())
			{
				int id = result.getInt("kundeID");
				String name = result.getString("firmaNavn");
				int CVR = result.getInt("CVR");
				String address = result.getString("adresse");
				String email = result.getString("email");
				int phone = result.getInt("telefon");
				String password = result.getString("password");
				
				customerList.add(new Customer(name, CVR, address, email, phone, password));
			}
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnector.disconnect();
		return customerList;
	}

	public void addCustomer(Customer customer) 
	{
		DBConnector.connect();
		
		try 
		{
			preparedStatement = DBConnector.getConnection().prepareStatement("INSERT INTO kunder VALUES(default, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1,customer.getName());
			preparedStatement.setInt(2,customer.getCVR());
			preparedStatement.setString(3,customer.getAddress());
			preparedStatement.setString(4,customer.getEmail());
			preparedStatement.setInt(5,customer.getPhone());
			preparedStatement.setString(6,customer.getPassword());
			
			preparedStatement.executeUpdate();
			
			DBConnector.disconnect();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
