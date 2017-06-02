package ciphers;


/**
 * Class AtbashCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * The Atbash Cipher maps each letter of the alphabet to its corresponding letter in
 * the reversed alphabet. For example, A would map to Z, B would map to Y, and so on.
 * Because reversing an alphabet twice would return the original alphabet, the steps
 * for encrypting and decrypting an Atbash Cipher are identical.
 * 
 * Information courtesy of braingle.com
 */

public class AtbashCipher extends CaesarCipher{
	private static String[] alphabet = {"Z","Y","X","W","V","U","T","S","R","Q","P",
			"O","N","M","L","K","J","I","H","G","F","E","D","C","B","A"};
	/**
	 * Returns a reversed alphabet.
	 * @return alphabet
	 */
	public String[] getAlphabet() {
		return alphabet;
	}
}
