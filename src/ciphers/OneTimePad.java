package ciphers;
/**
 * Class OneTimePad
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * The OneTimePad is a special type of Vigenere Cipher in which instead
 * of a predetermined key, the pad is a random string of letters. One Time
 * Pads are among the most secure type of ciphers, because a message of N
 * characters has an equal probablility of mapping to any other message of N
 * characters. The main weakness of the One Time Pad is that because the pad is
 * random, it must be shared beforehand between the two parties.
 * 
 * Information courtesy of Khan Academy
 */
public class OneTimePad extends VigenereCipher {
	private String key;
	/**
	 * Constructor for OneTimePad. Initializes the key as an empty String.
	 */
	public OneTimePad(){
		key = "";
	}
	/**
	 * Encrypts a code after custom-generating a random key.
	 * @precondition	plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext
	 */
	public String encrypt(String message) {
		key = ""; // Reset key
		for (int i=0; i<message.length(); i++) {
			key += String.valueOf((char)((int)(Math.random()*26+65)));
		}
		return super.encrypt(message, key);
	}
	/**
	 * Decrypts a code according to this specific key.
	 * @precondition	ciphertext is uppercase with no spaces.
	 * @precondition	Must have called "encrypt" first.
	 * @param code		Ciphertext
	 * @return			Plaintext
	 */
	public String decrypt(String code) {
		return super.decrypt(code, key);
	}
	/**
	 * Returns the value of key at the moment. The value of the key will change with each cipher.
	 * @return			the current value of key
	 */
	public String getCurrentKey() {
		return key;
	}
}
