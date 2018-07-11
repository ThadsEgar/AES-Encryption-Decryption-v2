import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.*;


public class Encryptor {
	//resources needed by Encryptor
	public byte[] keyValue;
	public static final String ALGORITHM = "AES";
	
	public Encryptor(String key)
	{
		//Put
		this.keyValue = key.getBytes();
	}
	
	public String encrypt(String data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		//create cipher instance and initialize using key
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		Key key = genKey();
		cipher.init(Cipher.ENCRYPT_MODE,key);
		
		//encode the byte array
		byte[] encryptedValue = cipher.doFinal(data.getBytes());
		String encryptedValueString = new String(Base64.getEncoder().encode(encryptedValue));
		
		//return
		return encryptedValueString;
	}
	
	public Key genKey()
	{
		Key key = new SecretKeySpec(keyValue,ALGORITHM);
		return key;
	}
}
