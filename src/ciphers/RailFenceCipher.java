package ciphers;
import java.util.ArrayList;
/**
 * Class RailFenceCipher
 * @author Emily Liu
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * In a RailFenceCipher, the message is written out horizontally across a certain number
 * of "rails" and then read off vertically by rail to encrypt it. To decrypt a message,
 * you would separate it into equal sized substrings, which you would read off
 * horizontally, effectively reversing the encryption procedure.
 * 
 * Note that if the plaintext does not fit perfectly across the rails, filler letters
 * can be added so that it does. However, this decreases the security of the cipher, as
 * an outside party may be able to calculate the number of rails by factorizing
 * the length of the ciphertext.
 * 
 * Information courtesy of braingle.com
 */
public class RailFenceCipher extends Cipher {
	private ArrayList<ArrayList<String>> rails;
	/**
	 * Constructor for RailFenceCipher
	 * @param numRails		The number of rails.
	 */
	public RailFenceCipher (int numRails) {
		rails = new ArrayList<ArrayList<String>>();
		for (int i=0; i<numRails; i++) {
			rails.add(new ArrayList<String>());
		}
	}
	/**
	 * Constructor for RailFenceCipher that passes a String instead of an int
	 * @param numRails		The number of rails.
	 */
	public RailFenceCipher(String rails){
		this(Integer.parseInt(rails));
	};
	/**
	 * Writes a message to the rails.
	 * @param message		Plaintext message
	 */
	protected void writeToRails(String message) {
		while (message.length()%rails.size()!=0) {
			message+=String.valueOf((char)((int)(Math.random()*26+65)));
		}
		int index = 0;
		for (int i=0; i<message.length(); i++) {
			rails.get(index%rails.size()).add(message.substring(index, index+1));
			index++;
		}
	}
	/**
	 * Encrypts a message.
	 * @precondition		Plaintext is uppercase with no spaces.
	 * @param message		Plaintext
	 * @return				Ciphertext
	 */
	public String encrypt(String message) {
		writeToRails(message);
		String ret = "";
		for (ArrayList<String> rail: rails) {
			for (int i=0; i<rail.size(); i++) {
				ret+=rail.get(i);
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
		int len = message.length()/rails.size();
		String ret = "";
		int index = 0;
		int modCount = 0;
		while (ret.length()<message.length()) {
			ret+=message.substring(index, index+1);
			index+=len;
			if (index>=message.length()) {
				modCount++;
				index = modCount;
			}
		}
		return ret;
	}
}
