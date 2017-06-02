package ciphers;
/**
 * Class BifidCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * A Bifid Cipher is similar in structure to a Polybius Cipher, but slightly harder to
 * decrypt due to some scrambling of coordinates. To encrypt a message, write the
 * coordinates of the letter in the GridKey for each letter, then regroup the pairs
 * starting with the x-coordinates and then the y-coordinates and find the letters
 * in the grid at those coordinates.
 * 
 * For example, if the coordinates of a short message were to be written down as
 * (0,1) and (4,2), the regrouped coordinates would be (0,4) and (1,2), and the
 * encrypted message would consist of the letters found at (0,4) and (1,2).
 * 
 * To decrypt a Bifid Cipher, you would go in the opposite direction - write down
 * all the coordinates in a straight line, split it in two, and group off the coordinates.
 * Those are the original coordinates.
 * 
 * Information courtesy of braingle.com
 */
public class BifidCipher extends PolybiusCipher {
	/**
	 * Constructor for Objects of class BifidCipher
	 * @param key		The key with which to construct the GridKey.
	 */
	public BifidCipher(String key) {
		super(key);
	}
	/**
	 * Decrypts a message with the Bifid Cipher
	 * @param str		the message to be decrypted
	 * @precondition	ciphertext is uppercase with no spaces.
	 * @return			the decrypted String
	 */
	public String decrypt(String str) {
		String numbers = super.encrypt(str);
		int[][] temp = new int[2][str.length()];
		for (int i=0; i<2; i++) {
			for (int j=0; j<str.length(); j++){
				temp[i][j] = Integer.parseInt(numbers.substring(0, 1));
				numbers = numbers.substring(1);
			}
		}
		String nums = "";
		for (int i=0; i<str.length(); i++) {
			nums+=""+temp[0][i]+temp[1][i];
		}
		return super.decrypt(nums);
	}
	/**
	 * Encrypts a message as specified above.
	 * @param str		the String to be encrypted
	 * @precondition	plaintext is uppercase with no spaces.
	 * @return			the encrypted String
	 */
	public String encrypt(String str) {
		int[][] temp = new int[2][str.length()];
		for (int i=0; i<str.length(); i++) {
			String letter = str.substring(i, i+1);
			int[] coords = find(letter);
			temp[0][i] = coords[0];
			temp[1][i] = coords[1];
		}
		String numbers = "";
		for (int i=0; i<2; i++) {
			for (int j=0; j<str.length(); j++) {
				numbers+=temp[i][j];
			}
		}
		return super.decrypt(numbers);
	}
}
