/*
Program:   Assignment 2: Application - CarNavigation of a Maze
Filename:  CCarCrash.java                              
@author:   © Millie Allen (18417959)                       
Course:    BSc Business Computing Year 1        
Module:    CSY1020 Problem Solving & Programming       
Tutor:     Gary Hill                                   
@version:  1.0 
Date:      25/04/19                                    
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CCarCrash extends JFrame implements ActionListener, ChangeListener { // Create all objects and global variables that will be used
	private Container window;
	private JPanel jPTop, jPMain, jPRight, jPBottom, jPPosition, jPControls, jPTimer, jPOptions, jPCompass, jPBotOptions, jPSlider;
	private JButton jBGrid[]=new JButton[208], jBOption1, jBOption2, jBOption3, jBExit, jBAct, jBRun, jBReset, jBCompass, jBBlank1, jBUp, jBBlank2, jBLeft, jBBlank3, jBRight, jBBlank4, jBDown, jBBlank5;
	private JLabel jLCompass, jLOption, jLSquare, jLDirection, jLTimer, jLColon, jLSpeed;
	private JTextField jTFOption, jTFSquare, jTFDirection, jTFHours, jTFMinutes, jTFSeconds;
	private JSlider jSSpeed;
	private JMenuBar topMenuBar;
	private JMenu scenarioMenu, editMenu, controlsMenu, helpMenu;
	private JMenuItem exitItem, option1Item, option2Item, option3Item, actItem, runItem, resetItem, helpItem, aboutItem;
	private Icon iHorizWall, iVertWall, iTopLCorner, iTopRCorner, iBottomLCorner, iBottomRCorner, iSpace, iCarNorth, iCarEast, iCarSouth,iCarWest, iNorth, iEast, iSouth, iWest, iAct, iRun, iReset, 
	iSandstone, iBrick, iPerson, iRed;
	private Timer timer;
	private Timer runTimer;
	private int ticks = 0;
	private int hours;
	private int minutes;
	private int seconds;
	private int nCarP = 17;
	private int clicks = 0;
	private int actClicks = 0;
	boolean option1 = true; // (Carney, 2016)
	boolean option2 = false;
	boolean option3 = false;

	public static void main (String[] args) {
		CCarCrash frame = new CCarCrash(); // Create the main application window
		frame.setSize(810, 650);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Jack, (2010)
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setResizable(false); // (Juvanis, 2012)
		frame.createGUI();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("images/greenfoot.png")));
		frame.setTitle("CCarCrash - Car Race Application"); // (Alexander, 2017)
		frame.show();
	}

	private void createGUI() {
		
		try { // Create all the images
			iHorizWall = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/wall-horiz.png")));
			iVertWall = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/wall-vert.png")));
			iTopLCorner = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/wall-NW.png")));
			iTopRCorner = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/wall-NE.png")));
			iBottomLCorner = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/wall-SW.png")));
			iBottomRCorner = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/wall-SE.png")));
			iSpace = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/space.png")));
			iCarNorth = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/car-n.png")));
			iCarEast = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/car-e.png")));
			iCarSouth = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/car-s.png")));
			iCarWest = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/car-w.png")));
			iNorth = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/north.jpg")));
			iEast = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/east.jpg")));
			iSouth = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/south.jpg")));
			iWest = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/west.jpg")));
			iAct = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/step.png")));
			iRun = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/run.png")));
			iReset = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/reset.png")));
			iSandstone = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/sandstone.jpg")));
			iBrick = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/brick.png")));
			iPerson = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/person.png")));
			iRed = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("images/red-draught.png")));
		}

		catch (Exception e) {
			System.err.println("Icon ImageIcon " + e);
		}
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		window = getContentPane();
		window.setLayout(new BorderLayout() );
		
		jPMain = new JPanel(); //creates the panel
		jPMain.setPreferredSize(new Dimension(650, 550));
		jPMain.setLayout(new GridLayout(13, 16));
		jPMain.setBackground(Color.black);
		window.add(jPMain, BorderLayout.CENTER);
		
		jPTop = new JPanel(); 
		jPTop.setPreferredSize(new Dimension(650, 30));
		jPTop.setBackground(Color.WHITE);
		window.add(jPTop, BorderLayout.NORTH);
		
		menuSetup();
		startLayout();

		jPRight = new JPanel(); 
		jPRight.setPreferredSize(new Dimension(160, 550));
		jPRight.setBackground(Color.lightGray);
		window.add(jPRight, BorderLayout.EAST);

		jPBottom = new JPanel(); 
		jPBottom.setPreferredSize(new Dimension(810, 50));
		jPBottom.setBackground(Color.lightGray);
		window.add(jPBottom, BorderLayout.SOUTH);

		jPPosition = new JPanel();
		jPPosition.setPreferredSize(new Dimension(160, 100));
		jPPosition.setLayout(new GridLayout(3, 2) );
		jPPosition.setBackground(Color.white);
		jPRight.add(jPPosition, BorderLayout.NORTH);

		jPControls = new JPanel();
		jPControls.setPreferredSize(new Dimension(160, 110));
		jPControls.setBackground(Color.white);
		jPRight.add(jPControls, BorderLayout.NORTH);

		jPTimer = new JPanel();
		jPTimer.setPreferredSize(new Dimension(160, 90));
		jPTimer.setBackground(Color.white);
		jPRight.add(jPTimer, BorderLayout.NORTH);

		jPOptions = new JPanel();
		jPOptions.setPreferredSize(new Dimension(160, 70));
		jPOptions.setBackground(Color.white);
		jPRight.add(jPOptions, BorderLayout.NORTH);

		jPCompass = new JPanel();
		jPCompass.setPreferredSize(new Dimension(160, 130));
		jPCompass.setBackground(Color.white);
		jPRight.add(jPCompass, BorderLayout.NORTH);

		jPBotOptions = new JPanel();
		jPBotOptions.setPreferredSize(new Dimension(480, 40));
		jPBotOptions.setBackground(Color.white);
		jPBottom.add(jPBotOptions, BorderLayout.WEST);

		jPSlider = new JPanel();
		jPSlider.setPreferredSize(new Dimension(300, 40));
		jPSlider.setBackground(Color.white);
		jPBottom.add(jPSlider, BorderLayout.EAST);

		jLOption = new JLabel("Option:");
		jLOption.setForeground(Color.black);
		jPPosition.add(jLOption);

		jTFOption = new JTextField("1");
		jPPosition.add(jTFOption);
		jTFOption.setPreferredSize(new Dimension (70,27));

		jLSquare = new JLabel("Square:");
		jLSquare.setForeground(Color.black);
		jPPosition.add(jLSquare);

		jTFSquare = new JTextField("17");
		jPPosition.add(jTFSquare);
		jTFSquare.setPreferredSize(new Dimension (70,27));

		jLDirection = new JLabel("Direction:");
		jLDirection.setForeground(Color.black);
		jPPosition.add(jLDirection);

		jTFDirection = new JTextField("E");
		jPPosition.add(jTFDirection);
		jTFDirection.setPreferredSize(new Dimension (70,27));

		jBBlank1 = new JButton(" ");
		jPControls.add(jBBlank1);
		jBBlank1.setEnabled(false);
		jBBlank1.setPreferredSize(new Dimension (45,30));

		jBUp = new JButton("^");
		jPControls.add(jBUp);
		jBUp.setToolTipText("North");
		jBUp.addActionListener(this); //means the button will perform the action stated
		jBUp.setPreferredSize(new Dimension (45,30));

		jBBlank2 = new JButton(" ");
		jPControls.add(jBBlank2);
		jBBlank2.setEnabled(false);
		jBBlank2.setPreferredSize(new Dimension (45,30));

		jBLeft = new JButton("<");
		jPControls.add(jBLeft);
		jBLeft.setToolTipText("West");
		jBLeft.addActionListener(this);
		jBLeft.setPreferredSize(new Dimension (45,30));

		jBBlank3 = new JButton(" ");
		jPControls.add(jBBlank3);
		jBBlank3.setEnabled(false);
		jBBlank3.setPreferredSize(new Dimension (45,30));

		jBRight = new JButton(">");
		jPControls.add(jBRight);
		jBRight.setToolTipText("East");
		jBRight.addActionListener(this);
		jBRight.setPreferredSize(new Dimension (45,30));

		jBBlank4 = new JButton(" ");
		jPControls.add(jBBlank4);
		jBBlank4.setEnabled(false);
		jBBlank4.setPreferredSize(new Dimension (45,30));

		jBDown = new JButton("v");
		jPControls.add(jBDown);
		jBDown.setToolTipText("South");
		jBDown.addActionListener(this);
		jBDown.setPreferredSize(new Dimension (45,30));

		jBBlank5 = new JButton(" ");
		jPControls.add(jBBlank5);
		jBBlank5.setEnabled(false);
		jBBlank5.setPreferredSize(new Dimension (45,30));

		jLTimer = new JLabel("          DIGITAL TIMER");
		jLTimer.setForeground(Color.black);
		jPTimer.add(jLTimer);
		jLTimer.setPreferredSize(new Dimension (150,25));

		jTFHours = new JTextField("00");
		jPTimer.add(jTFHours);
		jTFHours.setBackground(Color.black);
		jTFHours.setForeground(Color.white);
		jTFHours.setPreferredSize(new Dimension (25,20));

		jLColon = new JLabel(": ");
		jLColon.setForeground(Color.black);
		jPTimer.add(jLColon);

		jTFMinutes = new JTextField("00");
		jPTimer.add(jTFMinutes);
		jTFMinutes.setBackground(Color.black);
		jTFMinutes.setForeground(Color.white);
		jTFMinutes.setPreferredSize(new Dimension (25,20));

		jLColon = new JLabel(": ");
		jLColon.setForeground(Color.black);
		jPTimer.add(jLColon);

		jTFSeconds = new JTextField("00");
		jPTimer.add(jTFSeconds);
		jTFSeconds.setBackground(Color.black);
		jTFSeconds.setForeground(Color.white);
		jTFSeconds.setPreferredSize(new Dimension (25,20));

		jBOption1 = new JButton("Option 1");
		jPOptions.add(jBOption1);
		jBOption1.setMargin(new Insets(0, 0, 0, 0));
		jBOption1.setPreferredSize(new Dimension (70,28));
		jBOption1.setFont(new Font("Arial", Font.BOLD, 12));
		jBOption1.setToolTipText("Option 1");
		jBOption1.addActionListener(this);

		jBOption2 = new JButton("Option 2");
		jPOptions.add(jBOption2);
		jBOption2.setMargin(new Insets(0, 0, 0, 0));
		jBOption2.setPreferredSize(new Dimension (70,28));
		jBOption2.setFont(new Font("Arial", Font.BOLD, 12));
		jBOption2.setToolTipText("Option 2");
		jBOption2.addActionListener(this);

		jBOption3 = new JButton("Option 3");
		jPOptions.add(jBOption3);
		jBOption3.setMargin(new Insets(0, 0, 0, 0));
		jBOption3.setPreferredSize(new Dimension (70,28));
		jBOption3.setFont(new Font("Arial", Font.BOLD, 12));
		jBOption3.setToolTipText("Option 3");
		jBOption3.addActionListener(this);

		jBExit = new JButton("Exit");
		jPOptions.add(jBExit);
		jBExit.setMargin(new Insets(0, 0, 0, 0));
		jBExit.setPreferredSize(new Dimension (70,28));
		jBExit.setFont(new Font("Arial", Font.BOLD, 12));
		jBExit.setToolTipText("Exit");
		jBExit.addActionListener(this);

		jLCompass = new JLabel("Compass Image");
		jLCompass.setForeground(Color.black);
		jPCompass.add(jLCompass);

		jBCompass = new JButton("");
		jBCompass.setIcon(iEast);
		jBCompass.setPreferredSize(new Dimension (100,100));
		jBCompass.setContentAreaFilled(false); 
		jBCompass.setFocusPainted(false); 
        jBCompass.setOpaque(false);
		jPCompass.add(jBCompass);

		jBAct = new JButton("Act");
		jBAct.setIcon(iAct);
		jPBotOptions.add(jBAct);
		jBAct.addActionListener(this);
		jBAct.setPreferredSize(new Dimension (90,25));
		jBAct.setToolTipText("Act");

		jBRun = new JButton("Run");
		jBRun.setIcon(iRun);
		jPBotOptions.add(jBRun);
		jBRun.addActionListener(this);
		jBRun.setPreferredSize(new Dimension (90,25));
		jBRun.setToolTipText("Run");

		jBReset = new JButton("Reset");
		jBReset.setIcon(iReset);
		jPBotOptions.add(jBReset);
		jBReset.addActionListener(this);
		jBReset.setPreferredSize(new Dimension (90,25));
		jBReset.setToolTipText("Reset");

		jLSpeed = new JLabel("Speed: ");
		jLSpeed.setForeground(Color.black);
		jPSlider.add(jLSpeed);

		jSSpeed = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		jPSlider.add(jSSpeed);
		jSSpeed.addChangeListener(this);
		jSSpeed.setPaintTicks(true);
		jSSpeed.setSnapToTicks(true);
		jSSpeed.setMajorTickSpacing(25);
		
		timer = new Timer (1000, this);
		runTimer = new Timer (1000, this);
	}
	
	private void menuSetup() { // Creates the menu bar across the top of the window
		
		 topMenuBar = new JMenuBar(); // Hill, (2018)
		 topMenuBar.setPreferredSize(new Dimension(790 ,30));
		 jPTop.add(topMenuBar);
		 
		 scenarioMenu = new JMenu("Scenario");
	     exitItem = new JMenuItem("Exit");
	     scenarioMenu.add(exitItem);
	     exitItem.addActionListener(this);
	     topMenuBar.add(scenarioMenu);  
	     
	     editMenu = new JMenu("Edit");
	     option1Item = new JMenuItem("Option 1");
	     editMenu.add(option1Item);
	     option1Item.addActionListener(this);
	     option2Item = new JMenuItem("Option 2");
	     editMenu.add(option2Item);
	     option2Item.addActionListener(this);
	     option3Item = new JMenuItem("Option 3");
	     editMenu.add(option3Item);
	     option3Item.addActionListener(this);
	     topMenuBar.add(editMenu );
	     
	     controlsMenu = new JMenu("Controls");
	     actItem = new JMenuItem("Act");
	     controlsMenu.add(actItem);
	     actItem.addActionListener(this);
	     runItem = new JMenuItem("Run");
	     controlsMenu.add(runItem);
	     runItem.addActionListener(this);
	     resetItem = new JMenuItem("Reset");
	     controlsMenu.add(resetItem);
	     resetItem.addActionListener(this);
	     topMenuBar.add(controlsMenu);
	     
	     helpMenu = new JMenu("Help");
	     helpItem = new JMenuItem("Help");
	     helpMenu.add(helpItem);
	     helpItem.addActionListener(this);
	     aboutItem = new JMenuItem("About");
	     helpMenu.add(aboutItem);
	     aboutItem.addActionListener(this);
	     topMenuBar.add(helpMenu);
	}
	
	private void startLayout() { // Creates the initial grid layout of the game

		for(int nC = 0; nC<208; nC++) {
			jBGrid[nC] = new JButton();
			jBGrid[nC].setToolTipText(""+nC);
			jBGrid[nC].setBorder(null);
			jBGrid[nC].setContentAreaFilled(false); 
			jBGrid[nC].setFocusPainted(false); 
			jBGrid[nC].setOpaque(false); 
			jBGrid[nC].setIcon(iSpace);
			jPMain.add(jBGrid[nC]);
			jBGrid[nC].addActionListener(this);

			if (nC>=1 && nC<=15 || nC>=51 && nC<=60 || nC>=147 && nC<=156 || nC>=193 && nC<=206) {
				jBGrid[nC].setIcon(iHorizWall);
			}
			if (nC%16==0 || nC%16==15 || (nC%16==2 && nC>=66 && nC<=131) || (nC%16==13 && nC>=77 && nC<=141)) {
				jBGrid[nC].setIcon(iVertWall);
			}
			if (nC==0 || nC==50) {
				jBGrid[nC].setIcon(iTopLCorner);
			}
			if (nC==15 || nC==61) {
				jBGrid[nC].setIcon(iTopRCorner);
			}
			if (nC==146 || nC==192) {
				jBGrid[nC].setIcon(iBottomLCorner);
			}
			if (nC==157 || nC==207) {
				jBGrid[nC].setIcon(iBottomRCorner);
			}
			if (nC==17) {
				jBGrid[nC].setIcon(iCarEast);
			}
			if (nC==177) {
				jBGrid[nC].setIcon(iSandstone);
			}
		}
	}

	public void actionPerformed(ActionEvent event) { //creates the events that buttons will perform
		
		if (event.getSource() == helpItem) {
			help();
		}
		
		if (event.getSource() == aboutItem) {
			about();
		}

		if (event.getSource()==jBUp) {
			goNorth();
		}

		if (event.getSource()==jBRight) {
			goEast();
		}

		if (event.getSource()==jBDown) {
			goSouth();
		}

		if (event.getSource()==jBLeft) {
			goWest();
		}

		if (event.getSource()==jBOption1 || event.getSource() == option1Item) {
			option1();
		}

		if (event.getSource()==jBOption2 || event.getSource() == option2Item) {
			option2();
		}

		if (event.getSource()==jBOption3 || event.getSource() == option3Item) {
			option3();
		}

		if (event.getSource()==jBExit || event.getSource() == exitItem) {
			exit();
		}
		
		if (event.getSource() == jBAct || event.getSource() == actItem) {
	    	driveCar();
		}

		if (event.getSource()==jBRun || event.getSource() == runItem) {
			run();
		}

		if (event.getSource()==jBReset || event.getSource() == resetItem) {
			reset();
		}
		
		if (event.getSource()==timer) { // Converts the timer ticks into hours, minutes, and seconds for the timer display
			
			// Hours
			hours = (ticks / 3600);
			if(hours < 10) {
				jTFHours.setText("0" + hours);
			}
			else {
				jTFHours.setText(Integer.toString(ticks / 3600));
			}

			// Minutes
			minutes = ((ticks % 3600) / 60);
			if(minutes < 10) {
				jTFMinutes.setText("0" + minutes);
			}
			else {
				jTFMinutes.setText(Integer.toString((ticks % 3600) / 60));
			}
							
			// Seconds
			seconds = (ticks % 60);
			if(seconds < 10) {
				jTFSeconds.setText("0" + seconds);
			}
			else {
				jTFSeconds.setText(Integer.toString(ticks % 60));
			}
			ticks++;
		}
		
		if (event.getSource()==runTimer) {
			driveCar();
		}
		
	}

	public void stateChanged(ChangeEvent event) { // State changed method for the slider

		int sliderValue;
		sliderValue = jSSpeed.getValue();
	}
	
	private void goNorth() { // When the up arrow is pressed
		jTFDirection.setText("N");
		jBCompass.setIcon(iNorth);
		jBGrid[nCarP-16].setIcon(iCarNorth);
		jBGrid[nCarP].setIcon(iSpace);
		nCarP=nCarP-16;
		String position = Integer.toString(nCarP);
		jTFSquare.setText(position);
		clicks = clicks + 1;
		winBlock();
		hitObject();
		if ((nCarP > 0 && nCarP < 15) || (nCarP > 145 && nCarP < 158)) { // Game ends if the player hits a wall
			timer.stop();
			Object[] options = {"Play again", "Quit game"}; // (Oracle, 2017)
			int overOption = JOptionPane.showOptionDialog(null, "GAME OVER\nYou used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "GAME OVER",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
				reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
				exit();
			}
		}
	}

	private void goEast() { // When the right arrow is pressed
		jTFDirection.setText("E");
		jBCompass.setIcon(iEast);
		jBGrid[nCarP+1].setIcon(iCarEast);
		jBGrid[nCarP].setIcon(iSpace);
		nCarP++;
		String position = Integer.toString(nCarP);
		jTFSquare.setText(position);
		clicks = clicks + 1;
		winBlock();
		hitObject();
		if (nCarP%16 == 15 || (nCarP%16 == 2 && nCarP > 49 && nCarP < 147)) { // Game ends if the player hits a wall
			timer.stop();
			Object[] options = {"Play again", "Quit game"}; // (Oracle, 2017)
			int overOption = JOptionPane.showOptionDialog(null, "GAME OVER\nYou used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "GAME OVER",
					 JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
				reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
				exit();
			}
		}
	}

	private void goSouth() { // When the down arrow is pressed
		jTFDirection.setText("S");
		jBCompass.setIcon(iSouth);
		jBGrid[nCarP+16].setIcon(iCarSouth);
		jBGrid[nCarP].setIcon(iSpace);
		nCarP=nCarP+16;
		String position = Integer.toString(nCarP);
		jTFSquare.setText(position);
		clicks = clicks + 1;
		winBlock();
		hitObject();
		if ((nCarP > 192 && nCarP < 207) || (nCarP > 49 && nCarP < 62)) { // Game ends if the player hits a wall
			timer.stop();
			Object[] options = {"Play again", "Quit game"}; // (Oracle, 2017)
			int overOption = JOptionPane.showOptionDialog(null, "GAME OVER\nYou used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "GAME OVER",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
				reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
				exit();
			}
		}
	}

	private void goWest() { // When the left arrow is pressed
		jTFDirection.setText("W");
		jBCompass.setIcon(iWest);
		jBGrid[nCarP-1].setIcon(iCarWest);
		jBGrid[nCarP].setIcon(iSpace);
		nCarP--;
		String position = Integer.toString(nCarP);
		jTFSquare.setText(position);
		clicks = clicks + 1;
		winBlock();
		hitObject();
		if (nCarP%16 == 0 || (nCarP%16 == 13 && nCarP > 60 && nCarP < 158)) { // Game ends if the player hits a wall
			timer.stop();
			Object[] options = {"Play again", "Quit game"}; // (Oracle, 2017)
			int overOption = JOptionPane.showOptionDialog(null, "GAME OVER\nYou used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "GAME OVER",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
				reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
				exit();
			}
		}
	}
	
	private void winBlock() { // Player wins if the player lands on the white square
		if (option1 == true && option2 == false && option3 == false && nCarP == 177) {
			timer.stop();
			Object[] options = {"Play again", "Quit game"};
			int overOption = JOptionPane.showOptionDialog(null, "YOU WIN! You used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "WIN", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
					reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
					exit();
			}
		
		}
		if (option2 == true && option1 == false && option3 == false && nCarP == 49) {
			timer.stop();
			Object[] options = {"Play again", "Quit game"};
			int overOption = JOptionPane.showOptionDialog(null, "YOU WIN! You used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "WIN", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
					reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
					exit();
			}
		
		}
		
		if (option3 == true && option1 == false && option2 == false && nCarP == 30) {
			timer.stop();
			Object[] options = {"Play again", "Quit game"};
			int overOption = JOptionPane.showOptionDialog(null, "YOU WIN! You used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "WIN", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
					reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
					exit();
			}
		}
	}
	
	private void hitObject() { // Game ends if player hits any obstacles
		if (option2 == true && option1 == false && option3 == false && (nCarP == 17 || nCarP == 18 || nCarP == 25 || nCarP == 41 || nCarP == 162 || nCarP == 165 || nCarP == 167 || nCarP == 187)) {
			timer.stop();
			Object[] options = {"Play again", "Quit game"};
			int overOption = JOptionPane.showOptionDialog(null, "GAME OVER\nYou used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "GAME OVER",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
				reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
				exit();
			}
		}
		
		if (option3 == true && option1 == false && option2 == false && (nCarP == 17 || nCarP == 18 || nCarP == 23 || nCarP == 25 || nCarP == 29 || nCarP == 36 || nCarP == 37 || nCarP == 162 || nCarP == 165 || nCarP == 167 || nCarP == 171 || nCarP == 187 || nCarP == 188 || nCarP == 190)) {
			timer.stop();
			Object[] options = {"Play again", "Quit game"};
			int overOption = JOptionPane.showOptionDialog(null, "GAME OVER\nYou used " + clicks + " clicks and lasted " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.", "GAME OVER",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if (overOption == JOptionPane.YES_OPTION) {
				reset();
			}
			if (overOption == JOptionPane.NO_OPTION || overOption == JOptionPane.CLOSED_OPTION) {
				exit();
			}
		}
	}
	
	private void option1() { // If the option 1 button is selected
		jTFOption.setText("1");
		option1 = true;
		option2 = false;
		option3 = false;
		for(int nC = 0; nC<208; nC++) {
			jBGrid[nC].setIcon(iSpace);
			jBGrid[177].setIcon(iSandstone);
			if (nC>=1 && nC<=15 || nC>=51 && nC<=60 || nC>=147 && nC<=156 || nC>=193 && nC<=206) {
				jBGrid[nC].setIcon(iHorizWall);
			}
			if (nC%16==0 || nC%16==15 || (nC%16==2 && nC>=66 && nC<=131) || (nC%16==13 && nC>=77 && nC<=141)) {
				jBGrid[nC].setIcon(iVertWall);
			}
			if (nC==0 || nC==50) {
				jBGrid[nC].setIcon(iTopLCorner);
			}
			if (nC==15 || nC==61) {
				jBGrid[nC].setIcon(iTopRCorner);
			}
			if (nC==146 || nC==192) {
				jBGrid[nC].setIcon(iBottomLCorner);
			}
			if (nC==157 || nC==207) {
				jBGrid[nC].setIcon(iBottomRCorner);
			}
			if (nC==17) {
				jBGrid[nC].setIcon(iCarEast);
			}
			nCarP = 17;
		}
		runTimer.restart();
		runTimer.stop();
		ticks = 0;
		timer.restart();
		timer.start();
	}

	private void option2() { // If the option 2 button is selected
		jTFOption.setText("2");
		option1 = false;
		option2 = true;
		option3 = false;
		for(int nC = 0; nC<208; nC++) {
			jBGrid[nC].setIcon(iSpace);
			jBGrid[17].setIcon(iBrick);
			jBGrid[18].setIcon(iBrick);
			jBGrid[25].setIcon(iPerson);
			jBGrid[41].setIcon(iPerson);
			jBGrid[49].setIcon(iSandstone);
			jBGrid[162].setIcon(iPerson);
			jBGrid[165].setIcon(iRed);
			jBGrid[167].setIcon(iRed);
			jBGrid[187].setIcon(iPerson);
			if (nC>=1 && nC<=15 || nC>=51 && nC<=60 || nC>=147 && nC<=156 || nC>=193 && nC<=206) {
				jBGrid[nC].setIcon(iHorizWall);
			}
			if (nC%16==0 || nC%16==15 || (nC%16==2 && nC>=66 && nC<=131) || (nC%16==13 && nC>=77 && nC<=141)) {
				jBGrid[nC].setIcon(iVertWall);
			}
			if (nC==0 || nC==50) {
				jBGrid[nC].setIcon(iTopLCorner);
			}
			if (nC==15 || nC==61) {
				jBGrid[nC].setIcon(iTopRCorner);
			}
			if (nC==146 || nC==192) {
				jBGrid[nC].setIcon(iBottomLCorner);
			}
			if (nC==157 || nC==207) {
				jBGrid[nC].setIcon(iBottomRCorner);
			}
			if (nC==30) {
				jBGrid[nC].setIcon(iCarSouth);
			}
			nCarP = 30;
		}
		runTimer.restart();
		runTimer.stop();
		ticks = 0;
		timer.restart();
		timer.start();
	}

	private void option3() { // If the option 3 button is selected
		jTFOption.setText("3");
		option1 = false;
		option2 = false;
		option3 = true;
		for(int nC = 0; nC<208; nC++) {
			jBGrid[nC].setIcon(iSpace);
			jBGrid[17].setIcon(iBrick);
			jBGrid[18].setIcon(iBrick);
			jBGrid[23].setIcon(iBrick);
			jBGrid[25].setIcon(iPerson);
			jBGrid[29].setIcon(iRed);
			jBGrid[30].setIcon(iSandstone);
			jBGrid[36].setIcon(iBrick);
			jBGrid[37].setIcon(iBrick);
			jBGrid[162].setIcon(iPerson);
			jBGrid[165].setIcon(iRed);
			jBGrid[167].setIcon(iRed);
			jBGrid[171].setIcon(iPerson);
			jBGrid[187].setIcon(iPerson);
			jBGrid[188].setIcon(iPerson);
			jBGrid[190].setIcon(iPerson);
			if (nC>=1 && nC<=15 || nC>=51 && nC<=60 || nC>=147 && nC<=156 || nC>=193 && nC<=206) {
				jBGrid[nC].setIcon(iHorizWall);
			}
			if (nC%16==0 || nC%16==15 || (nC%16==2 && nC>=66 && nC<=131) || (nC%16==13 && nC>=77 && nC<=141)) {
				jBGrid[nC].setIcon(iVertWall);
			}
			if (nC==0 || nC==50) {
				jBGrid[nC].setIcon(iTopLCorner);
			}
			if (nC==15 || nC==61) {
				jBGrid[nC].setIcon(iTopRCorner);
			}
			if (nC==146 || nC==192) {
				jBGrid[nC].setIcon(iBottomLCorner);
			}
			if (nC==157 || nC==207) {
				jBGrid[nC].setIcon(iBottomRCorner);
			}
			if (nC==166) {
				jBGrid[nC].setIcon(iCarWest);
			}
			nCarP = 166;
		}
		runTimer.restart();
		runTimer.stop();
		ticks = 0;
		timer.restart();
		timer.start();
	}
	
	private void help() { // Help menu option, shows the controls and aim of the game
		JTextArea helpText = new JTextArea("Select a layout option and use the arrow buttons on the right-hand side to control the car. You must move it into the white sqaure while "
				+ "avoiding any obstacles in order to win! Or you can click the act button the see the solution at each step, or click the run button to watch the car complete the cir"
				+ "cuit."); // (GETah, 2011)
		JScrollPane helpScrollPane = new JScrollPane(helpText);  
		helpText.setLineWrap(true);  
		helpText.setWrapStyleWord(true); 
		helpScrollPane.setPreferredSize( new Dimension( 400, 100 ) );
		JOptionPane.showMessageDialog(null, helpScrollPane, "Help", JOptionPane.YES_NO_OPTION);
	}
	
	private void about() { // About menu option, briefly describes how the game was made
		JTextArea aboutText = new JTextArea("Version 1.92.0\nThis game application was created in Java by one student for a class project. I hope you "
				+ "enjoy playing it!"); // (GETah, 2011)
		JScrollPane aboutScrollPane = new JScrollPane(aboutText);  
		aboutText.setLineWrap(true);  
		aboutText.setWrapStyleWord(true); 
		aboutScrollPane.setPreferredSize( new Dimension( 300, 60 ) );
		JOptionPane.showMessageDialog(null, aboutScrollPane, "About", JOptionPane.YES_NO_OPTION);
	}

	private void exit() { // Exit button
		int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION); 
		if (selectedOption == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void driveCar() { // Controls what happens if the act button is clicked for each option
		if (option1 == true && option2 == false && option3 == false) {
			if (actClicks <= 12) {
				goEast();
			}
			if (actClicks > 12 && clicks <= 22) {
				goSouth();
			}
			if (actClicks > 22 && clicks <= 35) {
				goWest();
			}
		}
		if (option2 == true && option1 == false && option3 == false) {
			if (actClicks <= 8) {
				goSouth();
			}
			if (actClicks > 8 && actClicks <= 14) {
				goWest();
			}
			if (actClicks == 15) {
				goSouth();
			}
			if (actClicks > 15 && actClicks <= 22) {
				goWest();
			}
			if (actClicks > 22 && actClicks <= 30) {
				goNorth();
			}
		}
		if (option3 == true && option1 == false && option2 == false) {
			if (actClicks < 1) {
				goSouth();
			}
			if (actClicks >= 1 && actClicks <= 5) {
				goWest();
			}
			if (actClicks > 5 && actClicks <= 14) {
				goNorth();
			}
			if (actClicks > 14 && actClicks <= 16) {
				goEast();
			}
			if (actClicks > 16 && actClicks <= 17) {
				goNorth();
			}
			if (actClicks > 17 && actClicks <= 20) {
				goEast();
			}
			if (actClicks > 20 && actClicks <= 21) {
				goSouth();
			}
			if (actClicks > 21 && actClicks <= 29) {
				goEast();
			}
			if (actClicks > 29 && actClicks <= 30) {
				goNorth();
			}
		}
        actClicks++;
	}
	
	private void run() { // Controls what happens if the run button is clicked for each option and runs the act sequence
		actClicks = 0;
		timer.restart();
		runTimer.restart();
		int sliderValue;
		sliderValue = jSSpeed.getValue();
		double speed = sliderValue * 0.1;
		runTimer = new Timer ((int) (1000/speed), this);
		runTimer.start();
		timer.start();
	}

	private void reset() { // Reset button resets the entire window
		runTimer.stop();
		dispose();// (MattS, 2014)
		main(null);
		actClicks = 0;
		ticks = 0;
	}
}
