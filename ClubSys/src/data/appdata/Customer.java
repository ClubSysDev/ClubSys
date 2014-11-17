package data.appdata;
import java.io.UnsupportedEncodingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import app.Encrypter;

public class Customer 
{

	private String name;
	private int CVR;
	private String Address;
	private String email;
	private int phone;
	private String password;


	public Customer(String name, int CVR, String address, String email, int phone, String password) 
	{
		this.name = name;
		this.CVR = CVR;
		this.Address = address;
		this.email = email;
		this.phone = phone;
		try
		{
			this.password = Encrypter.encrypt(password);
		} catch (UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e)
		{
			e.printStackTrace();
		}
	}
	
	public Customer()
	{
		
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCVR()
	{
		return CVR;
	}

	public void setCVR(int cVR)
	{
		CVR = cVR;
	}

	public String getAddress()
	{
		return Address;
	}

	public void setAddress(String address)
	{
		Address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getPhone()
	{
		return phone;
	}

	public void setPhone(int phone)
	{
		this.phone = phone;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		try
		{
			this.password = Encrypter.encrypt(password);
		} 
		catch (UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e)
		{
			e.printStackTrace();
		} 
		

	}

}