package user_interface;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import ciphers.*;

/**
 * Class OTPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for the one time pad
 */
public class OTPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private JPanel controlPanel;
	private CipherRunner runner;

	/**
	 * Constructor for objects of class OTPage
	 */
	public OTPage() {
		runner = new CipherRunner();
		prepareGUI();
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
		mainFrame = new JFrame("One Time Pad");
		mainFrame.setSize(450, 450);
		mainFrame.setLayout(new GridLayout(3,3));
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
	void respond() {
		//initialize
		headerLabel.setText("One Time Pad");

		JLabel enter = new JLabel("Text here: ", JLabel.LEFT);
		final JTextField text = new JTextField(8);

		JButton dencrypt = new JButton("Encrypt");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");

		//code buttons
		dencrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					OneTimePad otp = new OneTimePad();
					statusLabel.setText(runner.encrypt(otp, text.getText())+
						"\n\n\n\n\n\n\n\n\n\n(key: "+otp.getCurrentKey()+")");
				} catch (NullPointerException n) {
					statusLabel.setText("Make sure all fields are completed");
				}
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "The OneTimePad is a special type of Vigenere Cipher in which instead\n"
			               		+ "of a predetermined key, the pad is a random string of letters. One Time\n"
			               		+ "Pads are among the most secure type of ciphers, because a message of N\n"
			               		+ "characters has an equal probablility of mapping to any other message of N\n"
			               		+ "characters. The main weakness of the One Time Pad is that because the pad is\n"
			               		+ "random, it must be shared beforehand between the two parties.\n\n"
			               		+ "(Information courtesy of Khan Academy)");
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
		con.gridwidth = 2;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 1;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = 2;
		con.gridx = 1;
		con.gridy = 3;
		controlPanel.add(dencrypt, con);
		con.gridwidth = 1;
		con.gridx = 1;
		con.gridy = 4;
		controlPanel.add(info, con);
		con.gridx = 2;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
