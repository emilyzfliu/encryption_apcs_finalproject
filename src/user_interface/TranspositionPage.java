package user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class TranspositionPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @author Eduonix
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for ciphers that scramble the letters of the plaintext
 */
public class TranspositionPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	/**
	 * Constructor for objects of class TranspositionPage
	 */
	public TranspositionPage() {
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
		mainFrame = new JFrame("Grid Ciphers that use transposition");
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
		headerLabel.setText("Grid Ciphers that use transposition");

		Button rail = new Button("Rail Fence Cipher");
		Button col = new Button("Columnar Transposition Cipher");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");
		
		//code buttons
		rail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RailFencePage rails = new RailFencePage();
				rails.mainFrame().setVisible(true);
			}
		});
		
		col.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColumnarTranspositionPage c = new ColumnarTranspositionPage();
				c.mainFrame().setVisible(true);
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "These ciphers all employ a grid in order to \"transpose\" the message,\n"
			               		+ "scrambling it according to a certain algorithm.");
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
		controlPanel.add(col, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 1;
		controlPanel.add(rail, con);
		con.gridy = 2;
		con.gridwidth = 1;
		con.gridx = 0;
		controlPanel.add(info, con);
		con.gridx = 1;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
