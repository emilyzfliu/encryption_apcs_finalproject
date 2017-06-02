package user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class CoordinatePage
 * @author Emily Liu
 * @author TutorialsPoint
 * @author Eduonix
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for ciphers that use coordinates and a 2D array
 */
public class CoordinatePage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	/**
	 * Constructor for objects of class CoordinatePage
	 */
	public CoordinatePage() {
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
		mainFrame = new JFrame("Grid Ciphers that use coordinates");
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
		headerLabel.setText("Grid Ciphers that use grid coordinates");
		
		Button polyb = new Button("Polybius Cipher");
		Button bif = new Button("Bifid Cipher");
		Button trif = new Button("Trifid Cipher");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");
		
		
		//code buttons
		polyb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PolybiusPage poly = new PolybiusPage();
				poly.mainFrame().setVisible(true);
			}
		});
		
		bif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BifidPage bi = new BifidPage();
				bi.mainFrame().setVisible(true);
			}
		});
		
		trif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrifidPage tri = new TrifidPage();
				tri.mainFrame().setVisible(true);
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "These ciphers rely on the position of each plaintext letter\n"
			               		+ "in the grid key, which is determined by a set of coordinates.\n"
			               		+ "these coordinates are either used as the cipher or permutated\n"
			               		+ "in some manner.");
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
			}
		});
		
		
		//Place components
		GridBagConstraints con = new GridBagConstraints();
		con.gridwidth = 2;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 0;
		con.gridy = 0;
		controlPanel.add(bif, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 1;
		controlPanel.add(polyb, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 2;
		controlPanel.add(trif, con);
		con.gridy = 3;
		con.gridwidth = 1;
		con.gridx = 0;
		controlPanel.add(info, con);
		con.gridx = 1;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
