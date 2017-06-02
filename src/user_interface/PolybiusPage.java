package user_interface;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import ciphers.*;

/**
 * Class PolybiusPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for Polybius Cipher
 */
public class PolybiusPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private JPanel controlPanel;
	private CipherRunner runner;

	/**
	 * Constructor for objects of class PolybiusPage
	 */
	public PolybiusPage() {
		runner = new CipherRunner();
		prepareGUI();
		respond();
	}
	
	/**
	 * Returns the main frame of the class. Called in CoordinatePage to summon
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
		mainFrame = new JFrame("Polybius Cipher");
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
		headerLabel.setText("Polybius Cipher");

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
					PolybiusCipher pol = new PolybiusCipher(keyText.getText().toUpperCase());
					statusLabel.setText(runner.encrypt(pol, text.getText()));
				} catch (NullPointerException n) {
					statusLabel.setText("Make sure all fields are completed");
				} catch (Exception ex) {
					statusLabel.setText("Make sure all fields have valid input.");
				}
			}
		});
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					PolybiusCipher pol = new PolybiusCipher(keyText.getText().toUpperCase());
					statusLabel.setText(runner.decrypt(pol, text.getText()));
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
			               , "A Polybius Cipher is a special type of substitution cipher where instead\n"
			               		+ "of each letter mapping to a certain String, it maps to a set of\n"
			               		+ "coordinates. These are the coordinates to a GridKey that contains most of\n"
			               		+ "the letters in the alphabet. \n\n"
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
		con.gridx = 1;
		con.gridy = 4;
		controlPanel.add(info, con);
		con.gridx = 2;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
