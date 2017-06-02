package user_interface;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import ciphers.*;

/**
 * Class AutokeyPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for the Autokey Cipher
 */
public class AutokeyPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private JPanel controlPanel;
	private CipherRunner runner;

	/**
	 * Constructor for Objects of class AutokeyCipher
	 */
	public AutokeyPage() {
		runner = new CipherRunner();
		prepareGUI();
		respond();
	}
	
	/**
	 * Returns the main frame of the class. Called in PolyAlphabeticPage to summon
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
		mainFrame = new JFrame("Autokey Cipher");
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
		headerLabel.setText("Autokey Cipher");
		JLabel enter = new JLabel("Text here: ", JLabel.LEFT);
		JLabel key = new JLabel("key: ");
		final JTextField text = new JTextField(8);
		final JTextField keyText = new JTextField(8);
		JButton encrypt = new JButton("Encrypt");
		JButton decrypt = new JButton("Decrypt");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");

		//code the button functions
		encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					AutokeyCipher aut = new AutokeyCipher(keyText.getText().toUpperCase());
					statusLabel.setText(runner.encrypt(aut, text.getText()));
				} catch (Exception ex) {
					statusLabel.setText("Make sure all fields have valid input.");
				}
			}
		});
		
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					AutokeyCipher aut = new AutokeyCipher(keyText.getText().toUpperCase());
					statusLabel.setText(runner.decrypt(aut, text.getText()));	
				} catch (Exception ex) {
					statusLabel.setText("Make sure all fields have valid input.");
				}
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "The Autokey Cipher, like the Viginere Cipher, is a polyalphabetic cipher\n"
			               		+ "where each letter of the plaintext is shifted a certain amount according\n"
			               		+ "to a String key. In the Autokey Cipher, the message is appended to a\n"
			               		+ "predetermined key and encrypted using the new key. To decrypt the Autokey\n"
			               		+ "Cipher, you would need to know the key to decryptsmall amounts of the\n"
			               		+ "message at a time."
			               		+ "\n\n(Information courtesy of braingle.com)");
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
			}
		});
		
		//place the components
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
