package user_interface;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import ciphers.*;

/**
 * Class ColumnarTranspositionPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for Columnar Transposition Cipher
 */
public class ColumnarTranspositionPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private JPanel controlPanel;
	private CipherRunner runner;

	/**
	 * Constructor for objects of class ColumnarTranspositionPage
	 */
	public ColumnarTranspositionPage() {
		runner = new CipherRunner();
		prepareGUI();
		respond();
	}
	
	/**
	 * Returns the main frame of the class. Called in TranspositionPage to summon
	 * this page with a button.
	 * @return		mainFrame
	 */
	public JFrame mainFrame() {
		return mainFrame;
	}

	/**
	 * Initializes all the instance variables and places them in their respective locations.
	 */
	private void prepareGUI() {
		mainFrame = new JFrame("Columnar Transposition Cipher");
		mainFrame.setSize(450, 450);
		mainFrame.setLayout(new GridLayout(3, 3));
		mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridBagLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	/**
	 * Interacts with the user.
	 * Initializes the labels, text fields, and buttons and places them in the appropriate locations
	 */
	private void respond() {
		//initialize
		headerLabel.setText("Columnar Transposition Cipher");

		JLabel enter = new JLabel("Text here: ", JLabel.LEFT);
		JLabel key = new JLabel("key: ");
		final JTextField text = new JTextField(8);
		final JTextField keyText = new JTextField(8);

		JButton encrypt = new JButton("Encrypt");
		JButton decrypt = new JButton("Decrypt");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");

		
		//code buttons
		encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					ColumnarTranspositionCipher c =
						new ColumnarTranspositionCipher(keyText.getText().toUpperCase());
					checkForDoubles(keyText.getText());
					statusLabel.setText(runner.encrypt(c, text.getText()));
				} catch (NullPointerException n) {
					statusLabel.setText("Make sure all fields are completed");
				} catch (IllegalArgumentException a) {
					statusLabel.setText("This version of the cipher does not accept duplicates in the key.");
				}catch (Exception ex) {
					statusLabel.setText("Make sure all fields have valid input.");
				}
			}
			/**
			 * checks a string for doubles.
			 * @param str		the string
			 * @return			true if it has duplicated letters; otherwise,
			 * 					false
			 */
			private void checkForDoubles(String str) {
				boolean[] boo = new boolean[255];
				for (int i=0; i<str.length(); i++) {
					char c = str.charAt(i);
					if (boo[c]==true) {
						throw new IllegalArgumentException();
					}
					boo[c] = true;
				}
			}
		});
		
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					ColumnarTranspositionCipher c =
						new ColumnarTranspositionCipher(keyText.getText().toUpperCase());
					statusLabel.setText(runner.decrypt(c, text.getText()));
				} catch (NullPointerException n) {
					statusLabel.setText("Make sure all fields are completed");
				} catch (Exception ex) {
					statusLabel.setText("Make sure all fields have valid input.");
				}
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "Similar in structure to the Rail Fence Cipher. After the\n"
			               		+ "message is written out on the \"rails\", the individual\n"
			               		+ " \"rails\" are sorted according to the order of letters in the key.\n"
			               		+ "This program will only accept keys with one of each letter.\n"
			               		+ "\nTo decrypt, split the code into the correct number of rails\n"
			               		+ "and order the pieces according to the keyword.\n"
			               		+ "\nLike the Rail Fence Cipher, filler letters can be added to ensure\n"
			               		+ "the message fits perfectly on the rails. However, this makes the message\n"
			               		+ "easier to decrypt due to the fact that the length of the key must be\n"
			               		+ "a factor of the length of the ciphertext.\n\n"
			               		+ "(Information courtesy of braingle.com)");
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
			}
		});
		
		
		//place components
		GridBagConstraints con = new GridBagConstraints();
		con.gridwidth = 3;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 0;
		con.gridy = 0;
		controlPanel.add(enter, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 1;
		con.gridx = 0;
		controlPanel.add(text, con);
		con.gridwidth = 1;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 0;
		con.gridy = 2;
		controlPanel.add(key, con);
		con.gridwidth = 2;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 1;
		controlPanel.add(keyText, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = 1;
		con.gridx = 1;
		con.gridy = 3;
		controlPanel.add(encrypt, con);
		con.gridx = 2;
		con.gridy = 3;
		controlPanel.add(decrypt, con);
		con.gridy = 4;
		con.gridx = 1;
		controlPanel.add(info, con);
		con.gridx = 2;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
