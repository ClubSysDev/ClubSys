package app;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

public class Encrypter
{
	private static SecretKey key;
	private static Cipher ecipher;
	private static Cipher dcipher;
	
	static{
		try 
		{
			key = KeyGenerator.getInstance("AES").generateKey();
			ecipher = Cipher.getInstance("AES");
			dcipher = Cipher.getInstance("AES");
			
			ecipher.init(Cipher.ENCRYPT_MODE, key);
			dcipher.init(Cipher.DECRYPT_MODE, key);

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String encrypt(String pass) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException
	{
		byte[] utf8 = pass.getBytes("UTF8");
		byte[] enc = ecipher.doFinal(utf8);
		enc = BASE64EncoderStream.encode(enc);	
		
		return new String(enc);
		
	}
	public static String decrypt(String pass) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		byte[] dec = BASE64DecoderStream.decode(pass.getBytes());
		byte[] utf8 = dcipher.doFinal(dec);
		
		return new String(utf8, "UTF8");
	}
}
