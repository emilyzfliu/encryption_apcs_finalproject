package ciphers;
/**
 * Class TrifidCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Similar to how a Bifid Cipher extends a Polybius Cipher to two GridKeys, a
 * Trifid Cipher extends the Bifid Cipher to three GridKeys. Each 3 by 3 grid
 * contains some portion of the alphabet, with the last grid having one null value.
 * Encrypting and decrypting a Trifid cipher is nearly identical to a Bifid Cipher,
 * except each letter will have three coordinates instead of two. Thus, to decrypt,
 * you would need to split the ciphertext into three substrings (or, in this case, write it
 * to a matrix with three rows).
 * 
 * Information courtesy of braingle.com
 */
public class TrifidCipher extends Cipher{
	GridKey grid;
	/**
	 * Constructor for TrifidCipher. Constructs a GridKey with 9 rows and 3 columns
	 * that has a certain key.
	 * @param key		the key to be written to the grid
	 */
	public TrifidCipher(String key) {
		grid = new GridKey(key, 9, 3);
	}
	/**
	 * Default constructor. Constructs a 9 by 3 GridKey with the alphabet in order.
	 */
	public TrifidCipher() {
		this("");
	}
	/**
	 * Decrypts a code.
	 * @precondition	Ciphertext is uppercase with no spaces.
	 * @param code		Ciphertext
	 * @return			Plaintext
	 */
	public String decrypt(String str) {
		String numbers = "";
		for (int i=0; i<str.length(); i++) {
			int[] coords = find(str.substring(i, i+1));
			numbers+=""+coords[0]+coords[1]+coords[2];
		}
		int[][] temp = new int[3][str.length()];
		for (int i=0; i<3; i++) {
			for (int j=0; j<str.length(); j++){
				temp[i][j] = Integer.parseInt(numbers.substring(0, 1));
				numbers = numbers.substring(1);
			}
		}
		String nums = "";
		for (int i=0; i<str.length(); i++) {
			nums+=""+temp[0][i]+temp[1][i]+temp[2][i];
		}
		return decryptNums(nums);
	}
	/**
	 * Encrypts a message.
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext
	 */
	public String encrypt(String str) {
		return decryptNums(encryptToNums(str));
	}
	/**
	 * Encrypts a message to its coordinates
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext in the form of numbers.
	 */
	public String encryptToNums(String str) {
		int[][] temp = new int[3][str.length()];
		for (int i=0; i<str.length(); i++) {
			String letter = str.substring(i, i+1);
			int[] coords = find(letter);
			temp[0][i] = coords[0];
			temp[1][i] = coords[1];
			temp[2][i] = coords[2];
		}
		String numbers = "";
		for (int i=0; i<3; i++) {
			for (int j=0; j<str.length(); j++) {
				numbers+=temp[i][j];
			}
		}
		return numbers;
	}
	/**
	 * Decrypts a string of numbers.
	 * @precondition	Ciphertext is uppercase with no spaces.
	 * @param code		Ciphertext in the form of numbers
	 * @return			Ciphertext with the regular alphabet
	 */
	private String decryptNums(String numbers) {
		String ret = "";
		while (numbers.length()>0) {
			String seg = numbers.substring(0, 3);
			String add = grid.get(Integer.parseInt(seg.substring(0,1))*3+
					Integer.parseInt(seg.substring(1,2)), Integer.parseInt(seg.substring(2)));
			if (add==null) add="A";
			ret+=add;
			numbers = numbers.substring(3);
		}
		return ret;
	}
	/**
	 * Finds the coordinates of a certain letter in the GridKey
	 * @param s				the specified letter
	 * @return				coordinates
	 */
	protected int[] find(String s) {
		int [] ret = new int[3];
		for (int row=0; row<grid.getKey().length; row++) {
			for (int col = 0; col<grid.getKey()[0].length; col++) {
				if (grid.get(row, col).equals(s)){
					ret[0] = row/3;
					ret[1] = row%3;
					ret[2] = col;
					return ret;
				}
			}
		}
		return ret;
	}
}
