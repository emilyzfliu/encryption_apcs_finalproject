package ciphers;
/**
 * Class VigenereCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * The Vigenere Cipher is a polyalphabetic extension of the Caesar Cipher in which
 * you encrypt letters based on a keyword instead of a key integer. The keyword is
 * repeated multiple times, and you "add" the letters of the ciphertext and plaintext
 * at a certain location.
 * 
 * Decryption of the Vigenere Cipher without knowledge of the key isn't as easy as
 * brute-forcing the Caesar Cipher, but is still doable without a computer. The main
 * weakness of the Vigenere Cipher is that the keyword is always repeated (a weakness
 * that isn't found in some of Vig's derivative ciphers, such as the One Time Pad). Thus,
 * by testing different possible lengths of the keyword, (taking every nth letter), you
 * can find a frequency "fingerprint" that is identical (or nearly identical) to the
 * fingerprint in plaintext. This fingerprint is found in any cipher where one letter
 * always maps to a certain other letter or combination of letters.
 * 
 * Information courtesy of Khan Academy
 */
public class VigenereCipher extends CaesarCipher{
	private String key;
	/**
	 * Constructor for objects of class VigenereCipher
	 * @param key		Designated keyword
	 */
	public VigenereCipher(String key) {
		this.key = key;
	}
	/**
	 * Default constructor. Creates a key that does nothing.
	 */
	public VigenereCipher(){this("A");}
	/**
	 * Returns the key
	 * @return		key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * Finds the number corresponding to the letter of the alphabet.
	 * @param letter		the letter
	 * @return				its position in the alphabet
	 */
	protected static int correspond(String letter) {
		char c = letter.charAt(0);
		return c-65;
	}
	/**
	 * Encrypts a message given a key.
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @param key			The key to encrypt the message with
	 * @return				Ciphertext
	 */
	public String encrypt(String message, String key) {
		message = message.toUpperCase();
		StringBuilder original = new StringBuilder(message);
		StringBuilder encrypted = new StringBuilder();
		int index = 0;
		for (int i=0; i<original.length(); i++) {
			encrypted.append(encryptLetter
					(original.charAt(i), correspond(key.substring(index, index+1))));
			index++;
			if (index==key.length()) index = 0;
		}
		return encrypted.toString();
	}
	/**
	 * Encrypts a message.
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext
	 */
	public String encrypt(String message) {
		return encrypt(message, key);
	}
	/**
	 * Decrypts a code given a key.
	 * @precondition	Ciphertext is uppercase with no spaces.
	 * @param code		Ciphertext
	 * @param key		Key with which to decrypt the message
	 * @return			Plaintext
	 */
	public String decrypt(String code, String key) {
		code=code.toUpperCase();
		int index = 0;
		StringBuilder crypt = new StringBuilder(code);
		StringBuilder cracked = new StringBuilder();
		for (int i=0; i<crypt.length(); i++) {
			cracked.append(decryptLetter
					(crypt.charAt(i), correspond(key.substring(index, index+1))));
			index++;
			if (index==key.length()) index = 0;
		}
		return cracked.toString();
	}
	/**
	 * Decrypts a code.
	 * @precondition	Ciphertext is uppercase with no spaces.
	 * @param code		Ciphertext
	 * @return			Plaintext
	 */
	public String decrypt(String code) {
		code=code.toUpperCase();
		int index = 0;
		StringBuilder crypt = new StringBuilder(code);
		StringBuilder cracked = new StringBuilder();
		for (int i=0; i<crypt.length(); i++) {
			cracked.append(decryptLetter
					(crypt.charAt(i), correspond(key.substring(index, index+1))));
			index++;
			if (index==key.length()) index = 0;
		}
		return cracked.toString();
	}
}
