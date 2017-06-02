package user_interface;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import ciphers.*;

/**
 * Class FourSquarePage
 * @author Emily Liu
 * @author TutorialsPoint
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for the Four Square Cipher
 */
public class FourSquarePage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private JPanel controlPanel;
	private CipherRunner runner;

	/**
	 * Constructor for objects of class FourSquarePage
	 */
	public FourSquarePage() {
		runner = new CipherRunner();
		prepareGUI();
		respond();
	}
	
	/**
	 * Returns the main frame of the class. Called in DigraphPage to summon
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
		mainFrame = new JFrame("Four Square Cipher");
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
		headerLabel.setText("Four Square Cipher");

		JLabel enter = new JLabel("Text here: ", JLabel.LEFT);
		JLabel key1 = new JLabel("key 1: ");
		JLabel key2 = new JLabel("key 2: ");
		final JTextField text = new JTextField(8);
		final JTextField keyText1 = new JTextField(8);
		final JTextField keyText2 = new JTextField(8);

		JButton encrypt = new JButton("Encrypt");
		JButton decrypt = new JButton("Decrypt");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");

		
		//code buttons
		encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FourSquareCipher f = new FourSquareCipher(keyText1.getText().toUpperCase(),
						keyText2.getText().toUpperCase());
					statusLabel.setText(runner.encrypt(f, text.getText()));
				} catch (NullPointerException n) {
					statusLabel.setText("Make sure all fields are completed");
				}
			}
		});
		
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FourSquareCipher f = new FourSquareCipher(keyText1.getText().toUpperCase(),
							keyText2.getText().toUpperCase());
					statusLabel.setText(runner.decrypt(f, text.getText()));
				} catch (NullPointerException n) {
					statusLabel.setText("Make sure all fields are completed");
				}
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "In this cipher, two GridKeys and two square alphabets are written as such:\n"
			               		+ "\n[alphabet][GridKey]\n"
			               		+ "[GridKey][alphabet]\n\n"
			               		+ "To encrypt a message, one would break it up into digraphs and locate\n"
			               		+ "the letters on the top left and bottom right alphabets. Similar to a\n"
			               		+ "Playfair Cipher, these letters form two opposite ends of a rectangle.\n"
			               		+ "The other vertices of the rectangle point to letters in the GridKeys,\n"
			               		+ "which are used to encrypt the message.\n"
			               		+ "\nTo decrypt, one would use digraphs again but locate the letters in\n"
			               		+ "the GridKey which map back to the plaintext in the alphabet.\n\n"
			               		+ "(Information courtesy of learncryptography.com)");
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
		controlPanel.add(key1, con);
		con.gridwidth = 2;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 1;
		controlPanel.add(keyText1, con);
		con.gridx = 0;
		con.gridy = 3;
		controlPanel.add(key2, con);
		con.gridwidth = 2;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 1;
		controlPanel.add(keyText2, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = 1;
		con.gridx = 1;
		con.gridy = 4;
		controlPanel.add(encrypt, con);
		con.gridx = 2;
		con.gridy = 4;
		controlPanel.add(decrypt, con);
		con.gridx = 1;
		con.gridy = 5;
		controlPanel.add(info, con);
		con.gridx = 2;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
