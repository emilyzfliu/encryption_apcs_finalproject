package ciphers;

/**
 * Class AutokeyCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * The Autokey Cipher, like the Viginere Cipher, is a polyalphabetic cipher where
 * each letter of the plaintext is shifted a certain amount according to a String key.
 * In the Autokey Cipher, the message is appended to a predetermined key and encrypted
 * using the new key. To decrypt the Autokey Cipher, you would need to know the key to decrypt
 * small amounts of the message at a time.
 * 
 * Information courtesy of braingle.com
 */

public class AutokeyCipher extends VigenereCipher {
	/**
	 * Constructor for objects of class AutokeyCipher
	 * @param key		The original key.
	 */
	public AutokeyCipher(String key) {
		super(key);
	}
	/**
	 * Modifies the key according to the message parameter and encrypts it
	 * similar to a Vigenere Cipher.
	 * @param message	The message to be encrypted.
	 * @precondition	plaintext is uppercase with no spaces.
	 * @return			the encrypted String
	 */
	public String encrypt(String message) {
		String ret = super.encrypt(message.substring(0, getKey().length()));
		ret+=super.encrypt(message.substring(getKey().length()), message);
		return ret;
	}
	/**
	 * Decrypts a code.
	 * @precondition	Ciphertext is uppercase with no spaces.
	 * @param code		Ciphertext
	 * @return			Plaintext
	 */
	public String decrypt(String message) {
		return decrypt(message, getKey());
	}
	/**
	 * Decrypts a code recursively using an initial key.
	 * @precondition	Ciphertext is uppercase with no spaces.
	 * @param code		Ciphertext
	 * @return			Plaintext
	 */
	public String decrypt(String message, String key) {
		if (message.length()<=key.length()) {
			String ret = super.decrypt(message,key);
			return ret;
		}
		String ret = super.decrypt(message.substring(0, key.length()), key);
		return ret+decrypt(message.substring(key.length()), ret);
	}
}
