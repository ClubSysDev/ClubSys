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
				
//				String encPassword = Encrypter.decrypt(password);
				customerList.add(new Customer(id,name, CVR, address, email, phone, password));
				
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
			preparedStatement = DBConnector.getConnection().prepareStatement("INSERT INTO kunder VALUES(?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2,customer.getName());
			preparedStatement.setInt(3,customer.getCVR());
			preparedStatement.setString(4,customer.getAddress());
			preparedStatement.setString(5,customer.getEmail());
			preparedStatement.setInt(6,customer.getPhone());
			preparedStatement.setString(7,customer.getPassword());
			
			preparedStatement.executeUpdate();
			
			DBConnector.disconnect();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Customer customer)
	{
		DBConnector.connect();
		try 
		{
			System.out.println("updating " + customer.getName() +", with id " + customer.getId());
			preparedStatement = DBConnector.getConnection().prepareStatement("UPDATE kunder SET "
					+ "firmaNavn = ?, CVR = ?, adresse = ?, email = ?, telefon = ?, password = ?"
					+ "WHERE kundeID = " + customer.getId());
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setInt(2, customer.getCVR());
			preparedStatement.setString(3, customer.getAddress());
			preparedStatement.setString(4,customer.getEmail());
			preparedStatement.setInt(5, customer.getPhone());
			preparedStatement.setString(6,customer.getPassword());
			
			preparedStatement.executeUpdate();
			
			DBConnector.disconnect();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void delete(Customer customer)
	{
		DBConnector.connect();
		try {
			preparedStatement = DBConnector.getConnection().prepareStatement("DELETE FROM kunder WHERE kundeID = " + customer.getId());
			preparedStatement.executeUpdate();
			
			DBConnector.disconnect();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
