package ciphers;

/**
 * Class CipherRunner
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * This class will run any Cipher, after processing the text such that they are valid parameters
 * for the encrypt and decrypt methods.
 */
public class CipherRunner {
	/**
	 * Decrypts a message using a cipher.
	 * @param c			The cipher used to decrypt
	 * @param message	Ciphertext
	 * @return			Plaintext
	 */
	public String decrypt(Cipher c, String message) {
		return c.decrypt(message.toUpperCase());
	}
	/**
	 * Encrypts a message using a cipher
	 * @param c			The cipher used to encrypt
	 * @param message	Plaintext
	 * @return			Ciphertext
	 */
	public String encrypt(Cipher c, String message) {
		return c.encrypt(removeSpaces(message.toUpperCase()));
	}
	private String removeSpaces(String str) {
		String ret = "";
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i)!=' ') ret+=String.valueOf(str.charAt(i));
		}
		return ret;
	}
}
