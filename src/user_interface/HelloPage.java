package user_interface;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Class HelloPage
 * @author Emily Liu
 * @author TutorialsPoint
 * @author Eduonix
 * @version May 30 2017
 * 
 * Copyright	Emily Liu
 * 
 * The opening page to the GUI.
 * 
 * In this GUI, I had the choice of using java.awt or javax.swing. In this GUI, both are used.
 * 
 * I had several choices of layout to use. I eventually decided on GridBagLayout,
 * as it was the most versatile and allowed me to control the sizes of each individual component.
 * 
 * The code skeleton of all classes in package user_interface come from tutorialspoint.com
 */
public class HelloPage {
	private Frame mainFrame;
	private Label headerLabel;
	private JPanel controlPanel;

	/**
	 * Constructor for objects of class HelloPage
	 */
	public HelloPage() {
		prepareGUI();
		setButtons();
	}

	/**
	 * Initializes all the instance variables and places them in their respective locations.
	 */
	private void prepareGUI() {
		mainFrame = new Frame("Ciphers");
		mainFrame.setSize(450, 450);
		mainFrame.setLayout(new GridLayout(3, 3));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridBagLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);
	}

	/**
	 * Interacts with the user.
	 * Initializes the labels, text fields, and buttons and places them in the appropriate locations
	 */
	private void setButtons() {
		//initialize
		headerLabel.setText("Choose a Category");

		Button mono = new Button("Monoalphabetic Ciphers");
		Button poly = new Button("Polyalphabetic Ciphers");
		Button grid = new Button("Grid Ciphers");
		Button info = new Button("More Info");
		Button back = new Button("Exit Program");
		
		//code buttons
		mono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonoAlphabeticPage mon = new MonoAlphabeticPage();
				mon.mainFrame().setVisible(true);
			}
		});
		
		poly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PolyAlphabeticPage polly = new PolyAlphabeticPage();
				polly.mainFrame().setVisible(true);
			}
		});
		
		grid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GridPage gr = new GridPage();
				gr.mainFrame().setVisible(true);
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame
			               , "A cipher is classified as any set algorithm that "
			               		+ "encrypts plaintext into ciphertext.");
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//place components
		GridBagConstraints con = new GridBagConstraints();
		con.gridwidth = 2;
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = 0;
		con.gridy = 0;
		controlPanel.add(mono, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 1;
		controlPanel.add(poly, con);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 2;
		controlPanel.add(grid, con);
		con.gridwidth = 1;
		con.gridy = 3;
		controlPanel.add(info, con);
		con.gridx = 1;
		controlPanel.add(back, con);
		mainFrame.setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		HelloPage hi = new HelloPage();
	}
}
