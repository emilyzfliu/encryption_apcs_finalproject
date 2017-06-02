package ciphers;
import java.util.*;
/**
 * Class FourSquareCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * In this cipher, two GridKeys and two square alphabets are written as such:
 * 
 * [alphabet][GridKey]
 * [GridKey][alphabet]
 * 
 * To encrypt a message, one would break it up into digraphs (letter pairs)
 * and locate the letters on the top left and bottom right alphabets. Similar to a
 * Playfair Cipher, these letters form two opposite ends of a rectangle.
 * The other vertices of the rectangle point to letters in the GridKeys,
 * which are used to encrypt the message.
 * 
 * To decrypt, one would use digraphs again but locate the letters in the GridKey which
 * map back to the plaintext in the alphabet.
 * 
 * Information courtesy of learncryptography.com
 */
public class FourSquareCipher extends Cipher{
	GridKey key1, key2;
	private String[][] alphabet = {{"A","B","C","D","E"},{"F","G","H","I","J"},
			{"K","L","M","N","O"},{"P","R","S","T","U"},{"V","W","X","Y","Z"}};
	/**
	 * Constructor for class FourSquareCipher
	 * @param strKey1		the key for the first GridKey
	 * @param strKey2		the key for the second GridKey
	 */
	public FourSquareCipher(String strKey1, String strKey2) {
		key1 = new GridKey(strKey1);
		key2 = new GridKey(strKey2);
	}
	/**
	 * Splits a message into digraphs.
	 * @param message
	 * @return			the digraphs
	 */
	private ArrayList<String> partition(String message) {
		ArrayList<String> ret = new ArrayList<String>();
		String temp = message;
		if (temp.length()%2==1) temp+="Z";
		for (int i=0; i<temp.length()/2; i++) {
			ret.add(temp.substring(2*i, 2*i+2));
		}
		return ret;
	}
	/**
	 * Finds the coordinates of a letter in a String matrix.
	 * @param letter	the letter to be found
	 * @param grid		the grid
	 * @return			the coordinates of letter
	 */
	private int[] lookup(String letter, String[][] grid) {
		int[] ret = new int[2];
		for (int row=0; row<5; row++) {
			for (int col=0; col<5; col++) {
				if (grid[row][col].equals(letter)){
					ret[0] = row;
					ret[1] = col;
				}
			}
		}
		return ret;
	}
	/**
	 * Encrypts a message.
	 * @param message		the message to be encrypted
	 * @precondition	plaintext is uppercase with no spaces.
	 * @return			the encrypted code
	 */
	public String encrypt(String message) {
		ArrayList<String> groups = partition(message);
		String ret = "";
		for (int i=0; i<groups.size(); i++) {
			String segment = groups.get(i);
			int[] firstCoords = lookup(segment.substring(0,1), alphabet);
			int[] secondCoords = lookup(segment.substring(1), alphabet);
			ret+=key1.get(firstCoords[0],secondCoords[1]);
			ret+=key2.get(secondCoords[0],firstCoords[1]);
		}
		return ret;
	}
	/**
	 * Decrypts a message.
	 * @param code		the message to be decrypted
	 * @precondition	ciphertext is uppercase with no spaces.
	 * @return			the decrypted code
	 */
	public String decrypt(String code) {
		ArrayList<String> groups = partition(code);
		String[][] gridKey1 = key1.getKey();
		String[][] gridKey2 = key2.getKey();
		String ret = "";
		for (int i=0; i<groups.size(); i++) {
			String segment = groups.get(i);
			int[] firstCoords = lookup(segment.substring(0,1), gridKey1);
			int[] secondCoords = lookup(segment.substring(1), gridKey2);
			ret+=alphabet[firstCoords[0]][secondCoords[1]];
			ret+=alphabet[secondCoords[0]][firstCoords[1]];
		}
		return ret;
	}
}
