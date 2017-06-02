package ciphers;
import java.util.*;
/**
 * Class PlayfairCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * The Playfair Cipher employs a Gridkey to encrypt digraphs. What this means
 * is that first the plaintext is split into pairs of two, with some letter being added
 * at the end if there's an odd number (In this case, "Z"). For each digraph, the letters
 * are located on the grid, and are encrypted as follows:
 * 
 * If they are on different rows and different columns, they are on the vertices
 * of a rectangle. In this case, the ciphertext is the other two vertices.
 * 
 * If they are on the same row, the ciphertext is the letter at the position of each
 * letter shifted to the right, wrapping around if on the end.
 * 
 * If they are on the same column, the ciphertext is in the position of each letter
 * shifted downwords, again wrapping around as needed.
 * 
 * Decryption is the reverse process.
 * 
 * Information courtesy of learncryptography.com
 */
public class PlayfairCipher extends Cipher{
	GridKey key;
	/**
	 * Constructor for PlayfairCipher.
	 * @param strKey	key with which to write the GridKey
	 */
	public PlayfairCipher (String strKey) {
		key = new GridKey(strKey);
	}
	/**
	 * Splits message into digraphs
	 * @param message		the message
	 * @return				the message, in digraphs
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
	 * Finds the coordinates of a certain letter in the GridKey
	 * @param letter		the specified letter
	 * @return				coordinates
	 */
	private int[] lookup(String letter) {
		int[] ret = new int[2];
		for (int row=0; row<5; row++) {
			for (int col=0; col<5; col++) {
				if (key.getKey()[row][col].equals(letter)){
					ret[0] = row;
					ret[1] = col;
				}
			}
		}
		return ret;
	}
	/**
	 * Encrypts a code.
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext
	 */
	public String encrypt(String message) {
		ArrayList<String> groups = partition(message);
		String[][] gridKey = key.getKey();
		String ret = "";
		for (int i=0; i<groups.size(); i++) {
			String segment = groups.get(i);
			int[] firstCoords = lookup(segment.substring(0,1));
			int[] secondCoords = lookup(segment.substring(1));
			if (firstCoords[1]==secondCoords[1]) {
				ret+=gridKey[(firstCoords[0]+1)%5][firstCoords[1]];
				ret+=gridKey[(secondCoords[0]+1)%5][secondCoords[1]];
			}
			else if (firstCoords[0]==secondCoords[0]) {
				ret+=gridKey[firstCoords[0]][(firstCoords[1]+1)%5];
				ret+=gridKey[secondCoords[0]][(secondCoords[1]+1)%5];
			}
			else {
				ret+=gridKey[firstCoords[0]][secondCoords[1]];
				ret+=gridKey[secondCoords[0]][firstCoords[1]];
			}
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
		String[][] gridKey = key.getKey();
		String ret = "";
		for (int i=0; i<groups.size(); i++) {
			String segment = groups.get(i);
			int[] firstCoords = lookup(segment.substring(0,1));
			int[] secondCoords = lookup(segment.substring(1));
			if (firstCoords[1]==secondCoords[1]) {
				ret+=gridKey[(firstCoords[0]-1+5)%5][firstCoords[1]];
				ret+=gridKey[(secondCoords[0]-1+5)%5][secondCoords[1]];
			}
			else if (firstCoords[0]==secondCoords[0]) {
				ret+=gridKey[firstCoords[0]][(firstCoords[1]-1+5)%5];
				ret+=gridKey[secondCoords[0]][(secondCoords[1]-1+5)%5];
			}
			else {
				ret+=gridKey[firstCoords[0]][secondCoords[1]];
				ret+=gridKey[secondCoords[0]][firstCoords[1]];
			}
		}
		return ret;
	}
}
