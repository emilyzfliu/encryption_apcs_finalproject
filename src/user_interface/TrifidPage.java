package user_interface;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import ciphers.*;

/**
 * Class TrifidPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for the Trifid Cipher
 */
public class TrifidPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private JPanel controlPanel;
	private CipherRunner runner;

	/**
	 * Constructor for objects of class TrifidPage
	 */
	public TrifidPage() {
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
		mainFrame = new JFrame("Trifid Cipher");
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

	private void respond() {
		//initialize
		headerLabel.setText("Trifid Cipher");

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
					TrifidCipher tri = new TrifidCipher(keyText.getText().toUpperCase());
					statusLabel.setText(runner.encrypt(tri, text.getText()));
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
					TrifidCipher tri = new TrifidCipher(keyText.getText().toUpperCase());
					statusLabel.setText(runner.decrypt(tri, text.getText()));
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
			               , "Similar to how a Bifid Cipher extends a Polybius Cipher to two GridKeys,\n"
			               		+ "a Trifid Cipher extends the Bifid Cipher to three GridKeys. Each\n"
			               		+ "3 by 3 grid contains some portion of the alphabet, with the last grid\n"
			               		+ "having one null value. Encrypting and decrypting a Trifid cipher is nearly\n"
			               		+ "identical to a Bifid Cipher, except each letter will have three coordinates\n"
			               		+ "instead of two. Thus, to decrypt, you would need to split the ciphertext\n"
			               		+ "into three substrings.\n"
			               		+ "Because there is a null value in the 2D array for a trifid cipher,\n"
			               		+ "some corruption of data is to be expected. However, the original\n"
			               		+ "message should still be intelligible."
			               		+ "\n\n(Information courtesy of braingle.com)");
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
