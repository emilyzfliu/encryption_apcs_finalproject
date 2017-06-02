package ciphers;
/**
 * Class BeaufortCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * A cipher similar in structure to the Vigenere Cipher. While the Vigenere Cipher "adds"
 * the values of the plaintext letter and the letter in the key, the Beaufort Cipher
 * "subtracts" the value of the plaintext from the value of the key. Because of this,
 * Beaufort Ciphers can be encrypted and decrypted in the same way.
 * 
 * Information courtesy of braingle.com
 */
public class BeaufortCipher extends VigenereCipher {
	/**
	 * Constructor for objects of class BeaufortCipher
	 * @param key
	 */
	public BeaufortCipher(String key) {
		super(key);
	}
	/**
	 * Encrypts a letter according to a key by "subtracting" it. Overrides encryptLetter
	 * in CaesarCipher.
	 * @param c		the char value of the letter.
	 * @param key	the int value of the key.
	 * @return		the encrypted letter
	 */
	protected String encryptLetter(char c, int key) {
		int index = c-65;
		int ret = key-index+65;
		if (ret<65) ret+=26;
		return String.valueOf((char)ret);
	}
	/**
	 * Decrypts a letter according to a key by "subtracting" it. Overrides decryptLetter
	 * in CaesarCipher.
	 * @param c		the char value of the letter.
	 * @param key	the int value of the key.
	 * @return		the decrypted letter
	 */
	protected String decryptLetter(char c, int key) {
		return encryptLetter(c, key);
	}
}
