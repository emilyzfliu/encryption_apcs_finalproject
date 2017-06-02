package ciphers;
/**
 * Class GridKey
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Helper class for classes PlayfairCipher, FourSquareCipher, TwoSquareCipher,
 * and KeywordCipher. Fills a String matrix with the letters of the alphabet, with
 * each letter occuring only once, to be used as a key for the above ciphers.
 */
public class GridKey {
	private String[][] table;
	private int currentPos = 0;
	private String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
			"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	/**
	 * Constructor for class GridKey
	 * @param key		the key to be written to the grid
	 * @param rows		the number of rows
	 * @param cols		the number of columns
	 * @precondition	rows*cols<=26
	 */
	public GridKey(String key, int rows, int cols) {
		table = new String[rows][cols];
		for (int i=0; i<key.length(); i++) {
			writeToGrid(key.substring(i, i+1));
		}
		fillInRest();
	}
	/**
	 * Constructor for class GridKey, creates a square matrix
	 * @param key		the key to be written to the grid
	 */
	public GridKey(String key) {
		this(key, 5, 5);
	}
	/**
	 * Constructs a GridKey with a square matrix and no key.
	 */
	public GridKey(){
		this("");
	}
	/**
	 * Puts the specified character in the current available location if not
	 * already in key
	 * @param character		the character to be written to the grid
	 * @return				true if able to put character in grid; otherwise,
	 * 						false
	 */
	private boolean writeToGrid(String character) {
		if (!keyContains(character)) {
			table[currentPos/table[0].length][currentPos%table[0].length] = character;
			currentPos++;
			return true;
		}
		return false;
	}
	/**
	 * Determines whether a certain character is present in table
	 * @param character		the character
	 * @return
	 */
	private boolean keyContains(String character) {
		for (int row=0; row<table.length; row++) {
			for (int col=0; col<table[row].length; col++) {
				if (table[row][col]!=null &&
						table[row][col].equals(character))
					return true;
			}
		}
		return false;
	}
	/**
	 * Fills in the remaining blank spaces of table with letters of the alphabet
	 */
	private void fillInRest() {
		int index = 0;
		while (currentPos<26 && currentPos<table.length*table[0].length) {
			if (!writeToGrid(alphabet[index%26])) {
				index++;
			}
		}
	}
	/**
	 * Gets the table
	 * @return		table
	 */
	public String[][] getKey() {
		return table;
	}
	/**
	 * Returns the String at the specified location.
	 * @param row		the specified row
	 * @param col		the specified column
	 * @return			the String at (row, col)
	 */
	public String get(int row,int col) {
		return table[row][col];
	}
}
