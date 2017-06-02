package ciphers;
import java.util.ArrayList;
/**
 * Class TwoSquareCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * A TwoSquareCipher is similar to a Playfair Cipher in that it employs digraphs
 * and GridKeys. In the TwoSquareCipher, there are two keys that are used to form
 * grids. For each digraph, each letter is located in one of the two GridKeys, and
 * is encrypted in the same manner as a Playfair Cipher. Decryption is the reverse.
 * 
 * Information courtesy of learncryptography.com
 */
public class TwoSquareCipher extends Cipher{
	GridKey key1, key2;
	/**
	 * Constructor for TwoSquareCipher
	 * @param strKey1		The first key
	 * @param strKey2		The second key
	 */
	public TwoSquareCipher(String strKey1, String strKey2) {
		key1 = new GridKey(strKey1);
		key2 = new GridKey(strKey2);
	}
	/**
	 * Partitions a message into digraphs
	 * @param message		message
	 * @return				message, as digraphs
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
	 * Returns the coordinates of the specified letter in the specified gridKey
	 * @param letter		the letter to be found
	 * @param gridKey		the GridKey in which to find the letter
	 * @return				The coordinates
	 */
	private int[] lookup(String letter, GridKey gridKey) {
		int[] ret = new int[2];
		for (int row=0; row<5; row++) {
			for (int col=0; col<5; col++) {
				if (gridKey.get(row,col).equals(letter)){
					ret[0] = row;
					ret[1] = col;
				}
			}
		}
		return ret;
	}
	/**
	 * Encrypts a message.
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext
	 */
	public String encrypt(String message) {
		ArrayList<String> groups = partition(message);
		String ret = "";
		for (int i=0; i<groups.size(); i++) {
			String segment = groups.get(i);
			int[] firstCoords = lookup(segment.substring(0,1), key1);
			int[] secondCoords = lookup(segment.substring(1), key2);
			ret+=key2.get(secondCoords[0],firstCoords[1]);
			ret+=key1.get(firstCoords[0],secondCoords[1]);
		}
		return ret;
	}
	/**
	 * Decrypts a code.
	 * @precondition	Ciphertext is uppercase with no spaces.
	 * @param code		Ciphertext
	 * @return			Plaintext
	 */
	public String decrypt(String code) {
		ArrayList<String> groups = partition(code);
		String ret = "";
		for (int i=0; i<groups.size(); i++) {
			String segment = groups.get(i);
			int[] firstCoords = lookup(segment.substring(0,1), key2);
			int[] secondCoords = lookup(segment.substring(1), key1);
			ret+=key1.get(secondCoords[0],firstCoords[1]);
			ret+=key2.get(firstCoords[0],secondCoords[1]);
		}
		return ret;
	}
}
