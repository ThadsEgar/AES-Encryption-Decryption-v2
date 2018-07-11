import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.*;

public class Decryptor {
	public byte[] keyValue;
	public static final String ALGORITHM = "AES";
	
	public Decryptor(String key)
	{
		//
		this.keyValue = key.getBytes();
	}
	
	public String decrypt(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		//create cipher instance and initialize using key
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		Key key = genKey();
		cipher.init(Cipher.DECRYPT_MODE,key);
				
		//encode the byte array
		byte[] decryptedValue = cipher.doFinal(data.getBytes());
		String decryptedValueString = new String(Base64.getEncoder().encode(decryptedValue));
				
		//return
		return decryptedValueString;
	}
	
	public Key genKey()
	{
		Key key = new SecretKeySpec(keyValue,ALGORITHM);
		return key;
	}
	

}
