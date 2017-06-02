package ciphers;
/**
 * Class CaesarCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * The simplest cipher, and one of the most widely known. Given a key, add that value
 * to each letter of the plaintext to get the ciphertext. Because there are only 26
 * possibilities, the Caesar Cipher can be easily broken with modern software.
 */
public class CaesarCipher extends Cipher{
	private String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
			"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private int key;
	/**
	 * Constructor for objects of class CaesarCipher
	 * @param key		A String containing an integer value that will be the key.
	 */
	public CaesarCipher(String key) {
		this(Integer.parseInt(key,10));
	}
	/**
	 * Constructor for objects of class CaesarCipher
	 * @param key		Integer value for the key
	 */
	public CaesarCipher(int key) {
		this.key = key%26;
	}
	/**
	 * Default constructor - the key has a value of zero. Called in subclass constructors.
	 */
	public CaesarCipher(){}
	public String[] getAlphabet() {
		return alphabet;
	}
	/**
	 * Decrypts a letter, given a key.
	 * @param c		the letter to be decrypted
	 * @param key	the key with which to decrypt the letter
	 * @return		the decrypted letter
	 */
	protected String decryptLetter(char c, int key) {
		int index = c-65;
		if (index-key<0) return getAlphabet()[index-key+26];
		return getAlphabet()[index-key];
	}
	/**
	 * Encrypts a letter, given a key.
	 * @param c		the letter to be encrypted
	 * @param key	the key with which to encrypt the letter
	 * @return		the encrypted letter
	 */
	protected String encryptLetter(char c, int key) {
		int index = c-65;
		if (index+key>=26) return getAlphabet()[(index+key)%26];
		return getAlphabet()[index+key];
	}
	/**
	 * Decrypts a message with the instance variable key.
	 * @param code		the message to be decrypted
	 * @precondition	ciphertext is uppercase with no spaces.
	 * @return			the decrypted code
	 */
	public String decrypt(String code) {
		return decrypt(code, key);
	}
	/**
	 * Decrypts a message given a key.
	 * @param code		the message to be decrypted
	 * @param key		the key with which to decrypt the letter
	 * @precondition	ciphertext is uppercase with no spaces.
	 * @return			the decrypted code
	 */
	public String decrypt(String code, int key) {
		StringBuilder crypt = new StringBuilder(code);
		StringBuilder cracked = new StringBuilder();
		for (int i=0; i<crypt.length(); i++) {
			cracked.append(decryptLetter(crypt.charAt(i), key));
		}
		return cracked.toString();
	}
	/**
	 * Encrypts a message with the instance variable key.
	 * @param code		the message to be encrypted
	 * @precondition	plaintext is uppercase with no spaces.
	 * @return			the encrypted code
	 */
	public String encrypt(String message) {
		return encrypt(message, key);
	}
	/**
	 * Encrypts a message given a key.
	 * @param code		the message to be encrypted
	 * @param key		the key with which to encrypt the letter
	 * @precondition	plaintext is uppercase with no spaces.
	 * @return			the encrypted code
	 */
	public String encrypt(String message, int key) {
		StringBuilder original = new StringBuilder(message);
		StringBuilder encrypted = new StringBuilder();
		for (int i=0; i<original.length(); i++) {
			encrypted.append(encryptLetter(original.charAt(i), key));
		}
		return encrypted.toString();
	}
}
