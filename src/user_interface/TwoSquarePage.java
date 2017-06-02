package user_interface;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import ciphers.*;

/**
 * Class TwoSquarePage
 * @author Emily Liu
 * @author TutorialsPoint
 * @version May 16 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for the two square cipher
 */
public class TwoSquarePage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private JPanel controlPanel;
	private CipherRunner runner;

	/**
	 * Constructor for objects of class TwoSquarePage
	 */
	public TwoSquarePage() {
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
		mainFrame = new JFrame("Two Square Cipher");
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
		headerLabel.setText("Two Square Cipher");

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
					TwoSquareCipher two = new TwoSquareCipher(keyText1.getText().toUpperCase(),
							keyText2.getText().toUpperCase());
					statusLabel.setText(runner.encrypt(two, text.getText()));
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
					TwoSquareCipher two = new TwoSquareCipher(keyText1.getText().toUpperCase(),
							keyText2.getText().toUpperCase());
					statusLabel.setText(runner.decrypt(two, text.getText()));
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
			               , " A TwoSquareCipher is similar to a Playfair Cipher in that it employs\n"
			               		+ "digraphs and GridKeys. In the TwoSquareCipher, there are two keys that\n"
			               		+ "are used to form grids. For each digraph, each letter is located in one of\n"
			               		+ "the two GridKeys, and is encrypted in the same manner as a Playfair Cipher.\n"
			               		+ "Decryption is the reverse.\n\n(Information courtesy of learncryptography.com)");
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
