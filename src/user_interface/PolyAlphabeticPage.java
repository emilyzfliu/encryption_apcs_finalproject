package user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class PolyAlphabeticPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @author Eduonix
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for polyalphabetic ciphers
 */
public class PolyAlphabeticPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	/**
	 * Constructor for objects of class PolyAlphabeticPage
	 */
	public PolyAlphabeticPage() {
		prepareGUI();
		setButtons();
	}

	/**
	 * Returns the main frame of the class. Called in HelloPage to summon
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
		mainFrame = new JFrame("Polyalphabetic Ciphers");
		mainFrame.setSize(450, 450);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);

		controlPanel = new Panel();
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
	private void setButtons() {
		//initialize
		headerLabel.setText("Polyalphabetic Ciphers");

		Button vig = new Button("Vigenere Cipher");
		Button auto = new Button("Autokey Cipher");
		Button beau = new Button("Beaufort Cipher");
		Button otp = new Button("One Time Pad");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");
		
		//code buttons
		vig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VigenerePage vigi = new VigenerePage();
				vigi.mainFrame().setVisible(true);
			}
		});
		
		auto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutokeyPage aut = new AutokeyPage();
				aut.mainFrame().setVisible(true);
			}
		});
		
		beau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BeaufortPage bea = new BeaufortPage();
				bea.mainFrame().setVisible(true);
			}
		});
		
		otp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OTPage one = new OTPage();
				one.mainFrame().setVisible(true);
				one.respond();
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "Polyalphabetic ciphers are ciphers that map each\n"
			               		+ "letter to another letter of the alphabet, but\n"
			               		+ "it is not a direct mapping. This makes polyalphabetic\n"
			               		+ "ciphers stronger than their monoalphabetic counterparts.");
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
			}
		});
		
		//place components
		GridBagConstraints con = new GridBagConstraints();
		con.gridwidth = 2;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 0;
		con.gridy = 0;
		controlPanel.add(auto, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 1;
		controlPanel.add(beau, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 2;
		controlPanel.add(otp, con);
		con.gridy = 3;
		controlPanel.add(vig, con);
		con.gridwidth = 1;
		con.gridy = 4;
		con.gridx = 0;
		controlPanel.add(info, con);
		con.gridx = 1;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
