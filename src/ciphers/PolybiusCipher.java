package ciphers;
/**
 * Class PolybiusCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * A Polybius Cipher is a special type of substitution cipher where instead of
 * each letter mapping to a certain String, it maps to a set of coordinates. These
 * are the coordinates to a GridKey that contains most of the letters in the alphabet.
 * 
 * Information courtesy of learncryptography.com
 */
public class PolybiusCipher extends Cipher{
	GridKey grid;
	/**
	 * Constructor for PolybiusCipher
	 * @param key		the key with which to set up the grid
	 */
	public PolybiusCipher(String key) {
		grid = new GridKey(key);
	}
	/**
	 * Constructor for Polybius Cipher. Sets up grid with regular alphabet.
	 */
	public PolybiusCipher() {
		this("");
	}
	/**
	 * Encrypts a message.
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext
	 */
	public String encrypt(String code) {
		int[][] coords = new int[code.length()][2];
		for (int i=0; i<code.length(); i++) {
			String temp = code.substring(i, i+1);
			int[] coord = find(temp);
			coords[i][0] = coord[0];
			coords[i][1] = coord[1];
		}
		String ret = "";
		for (int[] c: coords) {
			ret+=""+c[0]+c[1];
		}
		return ret;
	}
	/**
	 * Finds the position of a certain letter in the GridKey
	 * @param s		the letter to be found
	 * @return		coordinates
	 */
	protected int[] find(String s) {
		int [] ret = new int[2];
		for (int row=0; row<grid.getKey().length; row++) {
			for (int col = 0; col<grid.getKey()[0].length; col++) {
				if (grid.get(row, col).equals(s)){
					ret[0] = row;
					ret[1] = col;
					break;
				}
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
	public String decrypt(String message) {
		String ret = "";
		String temp = message;
		while (temp.length()>0) {
			String row = temp.substring(0, 1);
			String col = temp.substring(1,2);
			temp = temp.substring(2);
			ret+=grid.get(Integer.parseInt(row,10),Integer.parseInt(col,10));
		}
		return ret;
	}
}
