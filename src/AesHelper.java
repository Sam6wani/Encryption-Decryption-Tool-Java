import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
// Handles encryption and decryption calculations
public class AesHelper {
	
	private static final String CYPHER_ALGORITHM = "AES";

	private static String adjustKeyLength(String key) {
		int keyLength = key.length();
		if (keyLength < 16) { // Pad with zeros if Key length is less
			// than 16
			return String.format("%-16s", key).replace(' ', '0');
		} else if (keyLength < 24) { // Pad with zeros if Key length
			// is less
			// than 24
			return String.format("%-24s", key).replace(' ', '0');
		} else if (keyLength < 32) { // Pad with zeros if Key length
			// is less
			// than 32
			return String.format("%-32s", key).replace(' ', '0');
		} else if (keyLength > 32) { // Truncate if Key length is
			// greater than
			// 32
			return key.substring(0, 32);
		}
		return key;
	}
	
	public static byte[] encrypt(String message, String encryptionKey) throws  IllegalBlockSizeException, NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException {
		// Truncate or pad the encryptionKey to 128, 192, or 256 bits
		encryptionKey = adjustKeyLength(encryptionKey);
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionKey.getBytes(), CYPHER_ALGORITHM);
		Cipher cipher = Cipher.getInstance(CYPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		return cipher.doFinal(message.getBytes());
	}

	public static String decrypt(byte[] encryptedMessage, String encryptionKey) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException,
			NoSuchAlgorithmException, IllegalBlockSizeException {
		// Truncate or pad the encryptionKey to 128, 192, or 256 bits
		encryptionKey = adjustKeyLength(encryptionKey);

		SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionKey.getBytes(), CYPHER_ALGORITHM);
		Cipher cipher = Cipher.getInstance(CYPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		byte[] decryptedBytes = cipher.doFinal(encryptedMessage);
		return new String(decryptedBytes);
	}
}
