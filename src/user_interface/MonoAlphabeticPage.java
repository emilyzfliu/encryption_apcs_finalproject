package user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class MonoAlphabeticPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @author Eduonix
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for monoalphabetic ciphers
 */
public class MonoAlphabeticPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	/**
	 * Constructor for objects of class MonoAlphabeticPage
	 */
	public MonoAlphabeticPage() {
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
		mainFrame = new JFrame("Monoalphabetic Ciphers");
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
		headerLabel.setText("Monoalphabetic Ciphers");

		Button caesar = new Button("Caesar Cipher");
		Button at = new Button("Atbash Cipher");
		Button keyword = new Button("Keyword Cipher");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");
		
		//code buttons
		caesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaesarPage julius = new CaesarPage();
				julius.mainFrame().setVisible(true);
			}
		});
		
		at.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtbashPage at = new AtbashPage();
				at.mainFrame().setVisible(true);
			}
		});
		
		keyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeywordPage keyw = new KeywordPage();
				keyw.mainFrame().setVisible(true);
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "Monoalphabetic ciphers are ciphers that map each\n"
			               		+ "letter of the alphabet to a corresponding letter.\n"
			               		+ "This makes monoalphabetic ciphers especially weak\n"
			               		+ "to cryptoanalysis techniques such as frequency analysis.");
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
		controlPanel.add(at, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 1;
		controlPanel.add(caesar, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 2;
		controlPanel.add(keyword, con);
		con.gridwidth = 1;
		con.gridy = 3;
		controlPanel.add(info, con);
		con.gridx = 1;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
