package user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class GridPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @author Eduonix
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * Page for all the subcategories of ciphers that implement 2D arrays
 */
public class GridPage {
	private JFrame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	/**
	 * Constructor for objects of class GridPage
	 */
	public GridPage() {
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
		mainFrame = new JFrame("Grid Ciphers");
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
		headerLabel.setText("Grid Ciphers");
		Button di = new Button("Grid Ciphers that use digraphs");
		Button coo = new Button("Grid Ciphers that use coordinates");
		Button tr = new Button("Transposition grid ciphers");
		Button info = new Button("More Info");
		Button back = new Button("Go Back");
		
		//code buttons
		di.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DigraphPage dig = new DigraphPage();
				dig.mainFrame().setVisible(true);
			}
		});
		
		coo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoordinatePage coord = new CoordinatePage();
				coord.mainFrame().setVisible(true);
			}
		});
		
		tr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TranspositionPage tr = new TranspositionPage();
				tr.mainFrame().setVisible(true);
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "These ciphers all employ a grid or matrix in their algorithm. Because\n"
			               		+ "some letters are substituted for other letters in the encryption process\n"
			               		+ "due to limited space, it is not uncommon to see some modification of data.\n"
			               		+ "This is completely normal.");
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
		controlPanel.add(coo, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 1;
		controlPanel.add(di, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 2;
		controlPanel.add(tr, con);
		con.gridy = 3;
		con.gridwidth = 1;
		con.gridx = 0;
		controlPanel.add(info, con);
		con.gridx = 1;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}
}
