package user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class DigraphPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @author Eduonix
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for ciphers that split plaintext into digraphs that are used along with a 2D array of letters
 * to encode the message
 */
public class DigraphPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	/**
	 * Constructor for objects of class DigraphPage
	 */
	public DigraphPage() {
		prepareGUI();
		setButtons();
	}

	/**
	 * Returns the main frame of the class. Called in GridPage to summon
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
		mainFrame = new JFrame("Grid Ciphers that use digraphs");
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
	void setButtons() {
		//initialize
		headerLabel.setText("Grid Ciphers that use digraphs");
		
		Button play = new Button("Playfair Cipher");
		Button two = new Button("Two Square Cipher");
		Button four = new Button("Four Square Cipher");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");
		
		
		//code buttons
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayfairPage playfair = new PlayfairPage();
				playfair.mainFrame().setVisible(true);
			}
		});
		
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwoSquarePage dos = new TwoSquarePage();
				dos.mainFrame().setVisible(true);
			}
		});
		
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FourSquarePage cuatro = new FourSquarePage();
				cuatro.mainFrame().setVisible(true);
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "These ciphers all split the plaintext into digraphs, pairs\n"
			               		+ "of letters. Each digraph maps to a rectange on a grid full\n"
			               		+ "of letters, where the two letters of the digraph form\n"
			               		+ "two opposite vertices. The ciphertext consists of the two\n"
			               		+ "opposite vertices of the rectangle.");
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
		controlPanel.add(four, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 1;
		controlPanel.add(play, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 2;
		controlPanel.add(two, con);
		con.gridy = 3;
		con.gridwidth = 1;
		con.gridx = 0;
		controlPanel.add(info, con);
		con.gridx = 1;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
