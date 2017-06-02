package ciphers;
/**
 * Abstract Class Cipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * All Ciphers in the package extend this class. Ciphers encrypt and decrypt messages.
 */
public abstract class Cipher {
	/**
	 * Encrypts a message.
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext
	 */
	public abstract String encrypt(String message);
	/**
	 * Decrypts a code.
	 * @precondition	Ciphertext is uppercase with no spaces.
	 * @param code		Ciphertext
	 * @return			Plaintext
	 */
	public abstract String decrypt(String code);
}
