package ciphers;
/**
 * Class KeywordCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Similar to a Caesar Cipher, a Keyword Cipher operates
 * by mapping one letter of the alphabet to its position in another
 * scrambled alphabet. This "scrambled" alphabet is made by first using
 * a keyword and then putting the remaining letters of the alphabet
 * after said keyword. To encrypt, simply find the letter in the key alphabet
 * that has the same position as the plaintext does in the actual alphabet,
 * and to decrypt, find the index of the ciphertext in the key alphabet
 * and the plaintext would be at that position in the conventional alphabet.
 * 
 * Information courtesy of braingle.com
 */
public class KeywordCipher extends CaesarCipher{
	private GridKey newAlphabet;
	/**
	 * Constructor for objects of class KeywordCipher
	 * @param key		The key with which to set up the new alphabet
	 */
	public KeywordCipher(String key) {
		newAlphabet = new GridKey(key, 1, 26);
	}
	/**
	 * Given a letter, returns the letter in the position of that letter
	 * in the key alphabet.
	 * @param c		the letter to be encrypted
	 * @param key	Included in order to override method in CaesarCipher
	 * @return		the encrypted letter
	 */
	protected String encryptLetter(char c, int key) {
		int index = c-65;
		if (index<0) return ""+c;
		return newAlphabet.getKey()[0][index];
	}
	/**
	 * Given a letter, returns the letter that has the position this
	 * letter has in the key alphabet.
	 * @param c		The letter in question
	 * @param key	Included in order to override method in CaesarCipher
	 * @return		the decrypted letter
	 */
	protected String decryptLetter(char c, int key) {
		int index = getIndex(c)+65;
		return String.valueOf((char)index);
	}
	/**
	 * Returns the index of a certain letter.
	 * @param c		the letter in question
	 * @return		the index of c
	 */
	private int getIndex(char c) {
		for (int i=0; i<26; i++) {
			if (newAlphabet.getKey()[0][i].equals(Character.toString(c))) return i;
		}
		return -1;
	}
}
