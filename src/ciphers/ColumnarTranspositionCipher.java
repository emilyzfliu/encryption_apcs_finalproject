package ciphers;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class ColumnarTranspositionCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Similar in structure to the Rail Fence Cipher. After the message is written out on the
 * "rails", the individual "rails" are sorted according to the order of letters in
 * the key.
 * 
 * To decrypt, split the code into the correct number of rails and order the pieces
 * according to the keyword.
 * 
 * Like the Rail Fence Cipher, filler letters can be added to ensure the message fits
 * perfectly on the rails. However, this makes the message easier to decrypt due to the
 * fact that the length of the key must be a factor of the length of the ciphertext.
 * 
 * Information courtesy of braingle.com
 */
public class ColumnarTranspositionCipher extends Cipher {
	private String key;
	private char[] keyArray;
	private ArrayList<ArrayList<String>> grid;
	/**
	 * Constructor for objects of class ColumnarTranspositionCipher.
	 * @param key		the key, which will be written onto a String and a sorted array.
	 */
	public ColumnarTranspositionCipher(String key) {
		grid = new ArrayList<ArrayList<String>>();
		this.key = key;
		keyArray = key.toCharArray();
		Arrays.sort(keyArray);
		for (int i=0; i<key.length(); i++) {
			grid.add(new ArrayList<String>());
		}
		
	}
	/**
	 * Pads the message with filler and writes to the grid array, which is then
	 * selection sorted.
	 * @param message		the message to be written
	 */
	private void writeToGrid(String message) {
		while (message.length()%grid.size()!=0) {
			message+=String.valueOf((char)((int)(Math.random()*26+65)));
		}
		int index = 0;
		for (int i=0; i<message.length(); i++) {
			grid.get(index%grid.size()).add(message.substring(index, index+1));
			index++;
		}
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		for (int i=0; i<keyArray.length; i++) {
			int dex = find(key, keyArray[i]);
			temp.add(grid.get(dex));
		}
		grid = temp;
	}
	/**
	 * Encrypts a message.
	 * @param code		the message to be encrypted
	 * @precondition	plaintext is uppercase with no spaces.
	 * @return			the encrypted code
	 */
	public String encrypt(String code) {
		writeToGrid(code);
		String ret = "";
		for (ArrayList<String> rail: grid) {
			for (int i=0; i<rail.size(); i++) {
				ret+=rail.get(i);
			}
		}
		return ret;
	}
	/**
	 * Decrypts a message.
	 * @param message		the message to be decrypted
	 * @precondition	ciphertext is uppercase with no spaces.
	 * @return			the decrypted code
	 */
	public String decrypt(String message) {
		String[] segs = partition(message, key.length());
		int[] order = new int[segs.length];	
		for (int i=0; i<order.length; i++) {
			order[i] = find(key, keyArray[i]);
		}
		String ret = "";
		for (int i=0; i<message.length()/key.length(); i++) {
			for (int j=0; j<order.length; j++) {
				int pos = indexOf(order,j);
				ret+=segs[pos].substring(0,1);
				segs[pos] = segs[pos].substring(1);
			}
		}
		return ret;
	}
	/**
	 * Finds the index of a char ch in a string str.
	 * @param str		the string
	 * @param ch		the char
	 * @return			the index of ch
	 */
	private int find(String str, char ch) {
		for (int i=0; i<str.length(); i++) {
			if (ch==str.charAt(i)) return i;
		}
		return -1;
	}
	/**
	 * Splits a code into equal sized partitions, to be decrypted.
	 * @param message		the message to be partitioned
	 * @param pieces		the number of partitions
	 * @return				the partitioned code
	 */
	private String[] partition(String message, int pieces) {
		String[] ret = new String[pieces];
		int factor = message.length()/pieces;
		for (int i=0; i<ret.length; i++) {
			ret[i] = message.substring(factor*i, factor*(i+1));
		}
		return ret;
	}
	/**
	 * Finds the index of a number key in an array
	 * @param nums		the array
	 * @param key		the number
	 * @return			the index of key
	 */
	private int indexOf(int[] nums, int key) {
		for (int i=0; i<nums.length; i++) {
			if (key==nums[i]) return i;
		}
		return -1;
	}
}
