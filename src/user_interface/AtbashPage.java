package user_interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ciphers.*;

/**
 * Class AtbashPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for the Atbash Cipher.
 */
public class AtbashPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private JPanel controlPanel;
	private CipherRunner runner;
	
	/**
	 * Constructor for objects of class AtbashPage
	 */
	public AtbashPage() {
		runner = new CipherRunner();
		prepareGUI();
		respond();
	}
	
	/**
	 * Returns the main frame of the class. Called in MonoAlphabeticPage to summon
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
		mainFrame = new JFrame("Atbash Cipher");
		mainFrame.setSize(450, 450);
		mainFrame.setLayout(new GridLayout(3, 1));
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
		headerLabel.setText("Atbash Cipher");
		JLabel enter = new JLabel("Text here: ", JLabel.LEFT);
		final JTextField text = new JTextField(16);
		JButton dencrypt = new JButton("Encrypt/Decrypt");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");
		
		//code the functions for the buttons
		dencrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					AtbashCipher at = new AtbashCipher();
					statusLabel.setText(runner.encrypt(at, text.getText()));
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
			               , "The Atbash Cipher maps each letter of the alphabet to\n"
			               		+ "its corresponding letter in the reversed alphabet.\n"
			               		+ "For example, A would map to Z, B would map to Y, and so on.\n"
			               		+ "Because reversing an alphabet twice would return the original\n"
			               		+ "alphabet, the steps for encrypting and decrypting an Atbash Cipher\n"
			               		+ "are identical.\n\n(Information courtesy of braingle.com)");
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
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = 2;
		con.gridx = 0;
		con.gridy = 3;
		controlPanel.add(dencrypt, con);
		con.gridwidth = 1;
		con.gridy = 4;
		con.gridx = 0;
		controlPanel.add(info, con);
		con.gridx = 1;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
