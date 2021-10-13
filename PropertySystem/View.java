import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Model model;
	private Controller controller;
	
	private Icon iLogo;
	JPanel jPBranchSecHomeBody, jPBranchSecViewSoldBody;
	private JPanel jPBanner, jPBannerLeft, jPBannerRight, jPMain, jPLogInPanel, jPLogInTop, jPLogInBottom, jPLogIn, jPUsername, jPPassword, jPLogInSubmit, jPAdminTop, jPAdminHome, jPAdminHomeOptions, jPAdminHomeBody, 
	jPBranchSecTop, jPBranchSecHome, jPBranchSecHomeOptions, jPBranch, jPProperty, jPAdminAdd, jPAdminAddOptions, jPAdminAddBody, jPBranchName, jPBranchAddress, jPBranchPhone, jPBranchEmail, jPBranchWeb, jPBranchSecUsername, jPBranchSecPassword, jPBranchSecAddHouse, 
	jPBranchSecAddHouseOptions, jPBranchSecAddHouseBody, jPHouseName, jPHouseAddress, jPHouseRooms, jPHouseSellingPrice, jPHouseFloors, jPHouseGarden, jPHouseGarage, jPBranchSecAddFlat, jPBranchSecAddFlatOptions, 
	jPBranchSecAddFlatBody, jPFlatName, jPFlatAddress, jPFlatRooms, jPFlatSellingPrice, jPFlatFloor, jPFlatMonthlyCost, jPBDName, jPBDAddress, jPPDName, jPPDAddress, jPAdminView, jPAdminViewOptions, jPAdminViewBody, 
	jPAdminEdit, jPAdminEditOptions, jPAdminEditBody, jPBranchSecViewHouse, jPBranchSecViewHouseOptions, jPBranchSecViewHouseBody, jPBranchSecViewFlat, jPBranchSecViewFlatOptions, jPBranchSecViewFlatBody, 
	jPBranchSecEditHouse, jPBranchSecEditHouseOptions, jPBranchSecEditHouseBody, jPBranchSecEditFlat, jPBranchSecEditFlatOptions, jPBranchSecEditFlatBody, jPBranchSecViewSold,jPBranchSecViewSoldOptions, jPPDType, jPPDSPrice, 
	jPPDSDate, jPBranchSecSoldDetails, jPBranchSecSoldDetailsOptions, jPBranchSecSoldDetailsBody,jPPropertyName, jPPropertyAddress, jPPropertySoldPrice, jPPropertySoldDate,jPBranchSecViewSoldHouse, 
	jPBranchSecViewSoldHouseOptions, jPBranchSecViewSoldHouseBody,jPHouseSoldPrice, jPHouseSoldDate, jPBranchSecViewSoldFlat, jPBranchSecViewSoldFlatOptions,jPBranchSecViewSoldFlatBody, jPFlatSoldPrice, jPFlatSoldDate, 
	jPBranchSecViewHouses, jPBranchSecViewHousesOptions, jPBranchSecViewHousesBody, jPBranchSecViewFlats, jPBranchSecViewFlatsOptions, jPBranchSecViewFlatsBody;
	private JLabel jLLogo, jLTitle, jLUsername, jLPassword, jLAdminWelcome, jLBranchSecWelcome, jLBranchName, jLBranchAddress, jLBranchPhone, jLBranchEmail, jLBranchWeb, jLBranchSecUsername, jLBranchSecPassword, 
	jLHouseName, jLHouseAddress, jLHouseRooms, jLHouseSellingPrice, jLHouseFloors, jLHouseGarden, jLHouseGarage, jLFlatName, jLFlatAddress, jLFlatRooms, jLFlatSellingPrice, jLFlatFloor, jLFlatMonthlyCost, jLBDName, 
	jLBDAddress, jLNoBranches, jLNoProperties, jLPDName, jLPDAddress, jLPDType, jLPDSPrice, jLPDSDate, jLPropertyName, jLPropertyAddress, jLPropertySoldPrice, jLPropertySoldDate, jLHouseSoldPrice, jLHouseSoldDate, 
	jLFlatSoldPrice, jLFlatSoldDate, jLNoHouses, jLNoFlats;
	private JMenuBar jMBMenu;
	private JMenu programmeMenu, helpMenu;
	private JTextField jTFUsername, jTFPassword, jTFBranchName, jTFBranchPhone, jTFBranchEmail, jTFBranchWeb, jTFBranchSecUsername, jTFBranchSecPassword, jTFHouseName, jTFHouseRooms, jTFHouseSellingPrice, jTFHouseFloors, 
	jTFFlatName, jTFFlatRooms, jTFFlatSellingPrice, jTFFlatFloor, jTFFlatMonthlyCost, jTFBDName, jTFPDName, jTFHouseGarden, jTFHouseGarage, jTFBranchSecSearchBar, jTFPDType, jTFPDSPrice, jTFPDSDate, jTFPropertyName, 
	jTFPropertySoldPrice, jTFPropertySoldDate, jTFHouseSoldPrice, jTFHouseSoldDate, jTFFlatSoldPrice, jTFFlatSoldDate;
	private JScrollPane jSPBranchList, jSPPropertyList, jSPSoldList, jSPHouseList, jSPFlatList;
	private JTextArea jTABranchAddress, jTAHouseAddress, jTAFlatAddress, jTABDAddress, jTAPDAddress, jTAPropertyAddress;
	JMenuItem logOutItem, exitItem, helpItem, aboutItem;
	JButton jBLogIn, jBAdminLogOut, jBBranchSecLogOut, jBAdminAdd, jBBranchSecAddHouse, jBBranchSecAddFlat, jBBranchSecSearch, jBAdminHome, jBBranchSubmit, jBBranchSecHome, jBHouseSubmit, jBFlatSubmit, jBProperty, jBBranch, 
	jBPView, jBPEdit, jBPDelete, jBBranchEditSubmit, jBHouseEditSubmit, jBFlatEditSubmit, jBBranchSecSold,jBBranchSecViewAll, jBBranchSecHouses, jBBranchSecFlats, jBSoldDetailsSubmit;
	
	JButton[] viewButton, editButton, deleteButton, soldButton;
	
	// Colours used
	Color paleBlue = new Color(134,210,249);
	Color paleGreen = new Color(184,250,184); 
	Color paleBG = new Color(234, 234, 232);
	Color paleRed = new Color(255,138,138);
	Color soldGreen = new Color(87,218,87);
	
	ArrayList<Property> notSoldProperties, soldProperties;
	
	// Create the main view and what is shown on log in
	public View (Controller controller, Model model) {
		this.controller = controller;
		this.model = model;
		controller.addView(this);
		
		// ********************************************************* MAIN *********************************************************
		// Create the main application window
		JPanel applicationPanel = new JPanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1400,1000);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/2)-(this.getSize().width)/2, (dim.height/2)-(this.getSize().height)/2);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png")); // Icon by Freepik on Flaticon.com
		this.setTitle("Millie's Moves");
		this.setLayout(new BorderLayout());
		this.add(applicationPanel);
		
		// Get logo for banner
		try {
			iLogo = new ImageIcon(Toolkit.getDefaultToolkit().createImage(CSY2030.class.getResource("images/logo.png"))); // Icon by Freepik on Flaticon.com
		}
		catch (Exception e) {
			System.err.println("Icon ImageIcon " + e);
		}
		
		// Create banner
		jPBanner = new JPanel();
		jPBanner.setPreferredSize(new Dimension(1400,120));
		jPBanner.setLayout(new BorderLayout());
		applicationPanel.add(jPBanner, BorderLayout.NORTH);
		
		// Create menu bar
		jMBMenu = new JMenuBar();
		jPBanner.add(jMBMenu, BorderLayout.NORTH);
		
		programmeMenu = new JMenu("Programme");
		logOutItem = new JMenuItem("Log Out");
		exitItem = new JMenuItem("Exit");
		programmeMenu.add(logOutItem);
		programmeMenu.add(exitItem);
		jMBMenu.add(programmeMenu);
		helpMenu = new JMenu("Help");
		helpItem = new JMenuItem("Help");
		helpMenu.add(helpItem);
		aboutItem = new JMenuItem("About");
		helpMenu.add(aboutItem);
		jMBMenu.add(helpMenu);
		logOutItem.addActionListener(controller);
		exitItem.addActionListener(controller);
		helpItem.addActionListener(controller);
		aboutItem.addActionListener(controller);
		
		// Create banner
		jPBannerLeft = new JPanel();
		jPBannerLeft.setBackground(paleBlue);
		jPBanner.add(jPBannerLeft, BorderLayout.WEST);
		
		jPBannerRight = new JPanel();
		jPBannerRight.setBackground(paleBlue);
		jPBannerRight.setPreferredSize(new Dimension(1300,120));
		jPBanner.add(jPBannerRight, BorderLayout.EAST);

		jLLogo = new JLabel(iLogo);
		jPBannerLeft.add(jLLogo);
		
		jLTitle = new JLabel("Millie's    Moves");
		jLTitle.setFont(new Font("Arial", Font.BOLD, 72));
		jPBannerRight.add(jLTitle);
		
		// Create main panel for content
		jPMain = new JPanel();
		jPMain.setPreferredSize(new Dimension(1400,842));
		jPMain.setBackground(paleGreen);
		jPMain.setLayout(new BorderLayout());
		applicationPanel.add(jPMain, BorderLayout.CENTER);
		
		logIn();
	}
	
	// Create panel for displayed branches
	public void displayBranch(JButton viewButton, JButton editButton, JButton deleteButton, String name, String address, int arrayPos) {
		jPBranch = new JPanel();
		jPBranch.setBackground(paleBG);
		jPBranch.setPreferredSize(new Dimension(1000,85));
		
		jPBDName = new JPanel();
		jLBDName = new JLabel("Branch Name: ");
		jLBDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFBDName = new JTextField(name);
		jTFBDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFBDName.setEditable(false);
		jPBDName.add(jLBDName);
		jPBDName.add(jTFBDName);
		jPBranch.add(jPBDName);
				
		jPBDAddress = new JPanel();
		jLBDAddress = new JLabel("Branch Address: ");
		jLBDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTABDAddress = new JTextArea(address);
		jTABDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTABDAddress.setEditable(false);
		jPBDAddress.add(jLBDAddress);
		jPBDAddress.add(jTABDAddress);
		jPBranch.add(jPBDAddress);

		viewButton = new JButton("View");
		viewButton.setPreferredSize(new Dimension(70,30));
		viewButton.setFont(new Font("Arial", Font.BOLD, 20));
		viewButton.setBackground(paleBlue);
		viewButton.setBorder(BorderFactory.createLineBorder(Color.black)); // (Oracle, no date)
		jPBranch.add(viewButton);
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.viewBranch(arrayPos);
			}
		}
		);
		
		editButton = new JButton("Edit");
		editButton.setPreferredSize(new Dimension(70,30));
		editButton.setFont(new Font("Arial", Font.BOLD, 20));
		editButton.setBackground(paleBlue);
		editButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranch.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.editBranch(arrayPos);
			}
		}
		);
		
		deleteButton = new JButton("Delete");
		deleteButton.setPreferredSize(new Dimension(70,30));
		deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
		deleteButton.setBackground(paleRed);
		deleteButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranch.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.removeBranch(arrayPos);
			}
		}
		);
		
		jPAdminHomeBody.add(jPBranch);
	}
	
	// Displays a branch
	void viewBranch(String name, String address, String phone, String email, String web, String username, String password) {
		// Admin top
		jPAdminTop = new JPanel();
		jPAdminTop.setLayout(new BorderLayout());
		jPAdminTop.setBackground(paleGreen);
		jPAdminTop.setPreferredSize(new Dimension(1400,30));
		
		jLAdminWelcome = new JLabel("  Hello Admin!");
		jLAdminWelcome.setOpaque(true);
		jLAdminWelcome.setBackground(paleGreen);
		jLAdminWelcome.setPreferredSize(new Dimension(150,30));
		jLAdminWelcome.setFont(new Font("Arial", Font.PLAIN, 18));
		jPAdminTop.add(jLAdminWelcome, BorderLayout.WEST);
		
		jBAdminLogOut = new JButton("Log Out");
		jBAdminLogOut.setPreferredSize(new Dimension(150,30));
		jBAdminLogOut.setFont(new Font("Arial", Font.BOLD, 18));
		jBAdminLogOut.setBackground(paleRed);
		jBAdminLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminTop.add(jBAdminLogOut, BorderLayout.EAST);
		jBAdminLogOut.addActionListener(controller);
		
		// Add a branch
		// Admin set up
		jPAdminView = new JPanel();
		jPAdminView.setPreferredSize(new Dimension(1200,820));
		jPAdminView.setBackground(paleGreen);
		jPAdminView.setLayout(new BorderLayout());	
		
		jPAdminViewOptions = new JPanel();
		jPAdminViewOptions.setLayout(new FlowLayout());
		jPAdminViewOptions.setBackground(paleGreen);
		jPAdminViewOptions.setPreferredSize(new Dimension(1200,30));
		jPAdminView.add(jPAdminViewOptions, BorderLayout.NORTH);
		
		jBAdminHome = new JButton("Home");
		jBAdminHome.setPreferredSize(new Dimension(150,30));
		jBAdminHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBAdminHome.setBackground(paleBlue);
		jBAdminHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminViewOptions.add(jBAdminHome);
		jBAdminHome.addActionListener(controller);
		
		jPAdminViewBody = new JPanel();
		jPAdminViewBody.setPreferredSize(new Dimension(1200,820));
		jPAdminViewBody.setBackground(paleGreen);
		jPAdminViewBody.setLayout(new BoxLayout(jPAdminViewBody, BoxLayout.Y_AXIS));
		jPAdminView.add(jPAdminViewBody);
		
		// Branch details		
		jPBranchName = new JPanel();
		jPAdminViewBody.add(jPBranchName);
		jLBranchName = new JLabel("Branch Name: ");
		jLBranchName.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchName = new JTextField(name);
		jTFBranchName.setPreferredSize(new Dimension(450,30));
		jTFBranchName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchName.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchName.setEditable(false);
		jPBranchName.add(jLBranchName);
		jPBranchName.add(jTFBranchName);
		
		jPBranchAddress = new JPanel();
		jPAdminViewBody.add(jPBranchAddress);
		jLBranchAddress = new JLabel("Branch Address: ");
		jLBranchAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTABranchAddress = new JTextArea(address);
		jTABranchAddress.setPreferredSize(new Dimension(450,90));
		jTABranchAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTABranchAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTABranchAddress.setLineWrap(true);
		jTABranchAddress.setEditable(false);
		jPBranchAddress.add(jLBranchAddress);
		jPBranchAddress.add(jTABranchAddress);
		
		jPBranchPhone = new JPanel();
		jPAdminViewBody.add(jPBranchPhone);
		jLBranchPhone = new JLabel("Branch Phone Number: ");
		jLBranchPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchPhone = new JTextField(phone);
		jTFBranchPhone.setPreferredSize(new Dimension(450,30));
		jTFBranchPhone.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchPhone.setEditable(false);
		jPBranchPhone.add(jLBranchPhone);
		jPBranchPhone.add(jTFBranchPhone);
		
		jPBranchEmail = new JPanel();
		jPAdminViewBody.add(jPBranchEmail);
		jLBranchEmail = new JLabel("Branch Email Address: ");
		jLBranchEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchEmail = new JTextField(email);
		jTFBranchEmail.setPreferredSize(new Dimension(450,30));
		jTFBranchEmail.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchEmail.setEditable(false);
		jPBranchEmail.add(jLBranchEmail);
		jPBranchEmail.add(jTFBranchEmail);
		
		jPBranchWeb = new JPanel();
		jPAdminViewBody.add(jPBranchWeb);
		jLBranchWeb = new JLabel("Branch Web Address: ");
		jLBranchWeb.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchWeb = new JTextField(web);
		jTFBranchWeb.setPreferredSize(new Dimension(450,30));
		jTFBranchWeb.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchWeb.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchWeb.setEditable(false);
		jPBranchWeb.add(jLBranchWeb);
		jPBranchWeb.add(jTFBranchWeb);
		
		jPBranchSecUsername = new JPanel();
		jPAdminViewBody.add(jPBranchSecUsername);
		jLBranchSecUsername = new JLabel("Branch Secretary Username: ");
		jLBranchSecUsername.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchSecUsername = new JTextField(username);
		jTFBranchSecUsername.setPreferredSize(new Dimension(450,30));
		jTFBranchSecUsername.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchSecUsername.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchSecUsername.setEditable(false);
		jPBranchSecUsername.add(jLBranchSecUsername);
		jPBranchSecUsername.add(jTFBranchSecUsername);
		
		jPBranchSecPassword = new JPanel();
		jPAdminViewBody.add(jPBranchSecPassword);
		jLBranchSecPassword = new JLabel("Branch Secretary Password: ");
		jLBranchSecPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchSecPassword = new JTextField(password);
		jTFBranchSecPassword.setPreferredSize(new Dimension(450,30));
		jTFBranchSecPassword.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchSecPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchSecPassword.setEditable(false);
		jPBranchSecPassword.add(jLBranchSecPassword);
		jPBranchSecPassword.add(jTFBranchSecPassword);
		
		jPMain.add(jPAdminTop, BorderLayout.NORTH);
		jPMain.add(jPAdminView, BorderLayout.CENTER);
	}
	
	// Editing a branch
	void editBranch(String name, String address, String phone, String email, String web, String username, String password) {
		// Admin top
		jPAdminTop = new JPanel();
		jPAdminTop.setLayout(new BorderLayout());
		jPAdminTop.setBackground(paleGreen);
		jPAdminTop.setPreferredSize(new Dimension(1400,30));
		
		jLAdminWelcome = new JLabel("  Hello Admin!");
		jLAdminWelcome.setOpaque(true);
		jLAdminWelcome.setBackground(paleGreen);
		jLAdminWelcome.setPreferredSize(new Dimension(150,30));
		jLAdminWelcome.setFont(new Font("Arial", Font.PLAIN, 18));
		jPAdminTop.add(jLAdminWelcome, BorderLayout.WEST);
		
		jBAdminLogOut = new JButton("Log Out");
		jBAdminLogOut.setPreferredSize(new Dimension(150,30));
		jBAdminLogOut.setFont(new Font("Arial", Font.BOLD, 18));
		jBAdminLogOut.setBackground(paleRed);
		jBAdminLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminTop.add(jBAdminLogOut, BorderLayout.EAST);
		jBAdminLogOut.addActionListener(controller);
		
		// Add a branch
		// Admin set up
		jPAdminEdit = new JPanel();
		jPAdminEdit.setPreferredSize(new Dimension(1200,820));
		jPAdminEdit.setBackground(paleGreen);
		jPAdminEdit.setLayout(new BorderLayout());	
		
		jPAdminEditOptions = new JPanel();
		jPAdminEditOptions.setLayout(new FlowLayout());
		jPAdminEditOptions.setBackground(paleGreen);
		jPAdminEditOptions.setPreferredSize(new Dimension(1200,30));
		jPAdminEdit.add(jPAdminEditOptions, BorderLayout.NORTH);
		
		jBAdminHome = new JButton("Home");
		jBAdminHome.setPreferredSize(new Dimension(150,30));
		jBAdminHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBAdminHome.setBackground(paleBlue);
		jBAdminHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminEditOptions.add(jBAdminHome);
		jBAdminHome.addActionListener(controller);
		
		jPAdminEditBody = new JPanel();
		jPAdminEditBody.setPreferredSize(new Dimension(1200,820));
		jPAdminEditBody.setBackground(paleGreen);
		jPAdminEditBody.setLayout(new BoxLayout(jPAdminEditBody, BoxLayout.Y_AXIS));
		jPAdminEdit.add(jPAdminEditBody);
		
		// Branch details		
		jPBranchName = new JPanel();
		jPAdminEditBody.add(jPBranchName);
		jLBranchName = new JLabel("Branch Name: ");
		jLBranchName.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchName = new JTextField(name);
		jTFBranchName.setEditable(false);
		jTFBranchName.setPreferredSize(new Dimension(450,30));
		jTFBranchName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchName.add(jLBranchName);
		jPBranchName.add(jTFBranchName);
		
		jPBranchAddress = new JPanel();
		jPAdminEditBody.add(jPBranchAddress);
		jLBranchAddress = new JLabel("Branch Address: ");
		jLBranchAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTABranchAddress = new JTextArea(address);
		jTABranchAddress.setPreferredSize(new Dimension(450,90));
		jTABranchAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTABranchAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTABranchAddress.setLineWrap(true);
		jPBranchAddress.add(jLBranchAddress);
		jPBranchAddress.add(jTABranchAddress);
		
		jPBranchPhone = new JPanel();
		jPAdminEditBody.add(jPBranchPhone);
		jLBranchPhone = new JLabel("Branch Phone Number: ");
		jLBranchPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchPhone = new JTextField(phone);
		jTFBranchPhone.setPreferredSize(new Dimension(450,30));
		jTFBranchPhone.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchPhone.add(jLBranchPhone);
		jPBranchPhone.add(jTFBranchPhone);
		
		jPBranchEmail = new JPanel();
		jPAdminEditBody.add(jPBranchEmail);
		jLBranchEmail = new JLabel("Branch Email Address: ");
		jLBranchEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchEmail = new JTextField(email);
		jTFBranchEmail.setPreferredSize(new Dimension(450,30));
		jTFBranchEmail.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchEmail.add(jLBranchEmail);
		jPBranchEmail.add(jTFBranchEmail);
		
		jPBranchWeb = new JPanel();
		jPAdminEditBody.add(jPBranchWeb);
		jLBranchWeb = new JLabel("Branch Web Address: ");
		jLBranchWeb.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchWeb = new JTextField(web);
		jTFBranchWeb.setPreferredSize(new Dimension(450,30));
		jTFBranchWeb.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchWeb.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchWeb.add(jLBranchWeb);
		jPBranchWeb.add(jTFBranchWeb);
		
		jPBranchSecUsername = new JPanel();
		jPAdminEditBody.add(jPBranchSecUsername);
		jLBranchSecUsername = new JLabel("Branch Secretary Username: ");
		jLBranchSecUsername.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchSecUsername = new JTextField(username);
		jTFBranchSecUsername.setPreferredSize(new Dimension(450,30));
		jTFBranchSecUsername.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchSecUsername.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchSecUsername.add(jLBranchSecUsername);
		jPBranchSecUsername.add(jTFBranchSecUsername);
		
		jPBranchSecPassword = new JPanel();
		jPAdminEditBody.add(jPBranchSecPassword);
		jLBranchSecPassword = new JLabel("Branch Secretary Password: ");
		jLBranchSecPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchSecPassword = new JTextField(password);
		jTFBranchSecPassword.setPreferredSize(new Dimension(450,30));
		jTFBranchSecPassword.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchSecPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchSecPassword.add(jLBranchSecPassword);
		jPBranchSecPassword.add(jTFBranchSecPassword);
		
		jBBranchEditSubmit = new JButton("Update");
		jBBranchEditSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		jBBranchEditSubmit.setBackground(paleBlue);
		jBBranchEditSubmit.setPreferredSize(new Dimension(300,50));
		jPAdminEditBody.add(jBBranchEditSubmit);
		jBBranchEditSubmit.addActionListener(controller);
		
		jPMain.add(jPAdminTop, BorderLayout.NORTH);
		jPMain.add(jPAdminEdit, BorderLayout.CENTER);
	}
	
	// Create panel for displayed properties
	public void displayProperty(String propertyType, JButton viewButton, JButton editButton, JButton deleteButton, JButton soldButton, String name, String address, int arrayPos) {
		jPProperty = new JPanel();
		jPProperty.setBackground(paleBG);
		jPProperty.setPreferredSize(new Dimension(1300,85));
		
		jPPDName = new JPanel();
		jLPDName = new JLabel("Property Name: ");
		jLPDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDName = new JTextField(name);
		jTFPDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDName.setEditable(false);
		jPPDName.add(jLPDName);
		jPPDName.add(jTFPDName);
		jPProperty.add(jPPDName);
				
		jPPDAddress = new JPanel();
		jLPDAddress = new JLabel("Property Address: ");
		jLPDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTAPDAddress = new JTextArea(address);
		jTAPDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTAPDAddress.setEditable(false);
		jPPDAddress.add(jLPDAddress);
		jPPDAddress.add(jTAPDAddress);
		jPProperty.add(jPPDAddress);
		
		jPPDType = new JPanel();
		jLPDType = new JLabel("Property Type: ");
		jLPDType.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDType = new JTextField(propertyType);
		jTFPDType.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDType.setEditable(false);
		jPPDType.add(jLPDType);
		jPPDType.add(jTFPDType);
		jPProperty.add(jPPDType);

		viewButton = new JButton("View");
		viewButton.setPreferredSize(new Dimension(70,30));
		viewButton.setFont(new Font("Arial", Font.BOLD, 20));
		viewButton.setBackground(paleBlue);
		viewButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(viewButton);
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.viewProperty(arrayPos);
			}
		}
		);
		
		editButton = new JButton("Edit");
		editButton.setPreferredSize(new Dimension(70,30));
		editButton.setFont(new Font("Arial", Font.BOLD, 20));
		editButton.setBackground(paleBlue);
		editButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.editProperty(arrayPos);
			}
		}
		);
		
		deleteButton = new JButton("Delete");
		deleteButton.setPreferredSize(new Dimension(70,30));
		deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
		deleteButton.setBackground(paleRed);
		deleteButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.removeProperty(arrayPos);
			}
		}
		);
		
		soldButton = new JButton("Mark as Sold");
		soldButton.setPreferredSize(new Dimension(140,30));
		soldButton.setFont(new Font("Arial", Font.BOLD, 20));
		soldButton.setBackground(soldGreen);
		soldButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(soldButton);
		soldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.markSold(arrayPos);
			}
		}
		);
		
		jPBranchSecHomeBody.add(jPProperty);
	}
	
	// Create panel for displayed sold properties
	public void displaySoldProperty(String propertyType, JButton viewButton, JButton deleteButton, String name, String address, int arrayPos, String soldPrice, String soldDate) {
		jPProperty = new JPanel();
		jPProperty.setBackground(paleBG);
		jPProperty.setPreferredSize(new Dimension(1300,85));
		
		jPPDName = new JPanel();
		jLPDName = new JLabel("Property Name: ");
		jLPDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDName = new JTextField(name);
		jTFPDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDName.setEditable(false);
		jPPDName.add(jLPDName);
		jPPDName.add(jTFPDName);
		jPProperty.add(jPPDName);
				
		jPPDAddress = new JPanel();
		jLPDAddress = new JLabel("Property Address: ");
		jLPDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTAPDAddress = new JTextArea(address);
		jTAPDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTAPDAddress.setEditable(false);
		jPPDAddress.add(jLPDAddress);
		jPPDAddress.add(jTAPDAddress);
		jPProperty.add(jPPDAddress);
		
		jPPDType = new JPanel();
		jLPDType = new JLabel("Property Type: ");
		jLPDType.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDType = new JTextField(propertyType);
		jTFPDType.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDType.setEditable(false);
		jPPDType.add(jLPDType);
		jPPDType.add(jTFPDType);
		jPProperty.add(jPPDType);
		
		jPPDSPrice = new JPanel();
		jLPDSPrice = new JLabel("Sold for: £");
		jLPDSPrice.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDSPrice = new JTextField(soldPrice);
		jTFPDSPrice.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDSPrice.setEditable(false);
		jPPDSPrice.add(jLPDSPrice);
		jPPDSPrice.add(jTFPDSPrice);
		jPProperty.add(jPPDSPrice);
		
		jPPDSDate = new JPanel();
		jLPDSDate = new JLabel("Sold on: ");
		jLPDSDate.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDSDate = new JTextField(soldDate);
		jTFPDSDate.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDSDate.setEditable(false);
		jPPDSDate.add(jLPDSDate);
		jPPDSDate.add(jTFPDSDate);
		jPProperty.add(jPPDSDate);
		
		viewButton = new JButton("View");
		viewButton.setPreferredSize(new Dimension(70,30));
		viewButton.setFont(new Font("Arial", Font.BOLD, 20));
		viewButton.setBackground(paleBlue);
		viewButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(viewButton);
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.viewSoldProperty(arrayPos);
			}
		}
		);
		
		deleteButton = new JButton("Delete");
		deleteButton.setPreferredSize(new Dimension(70,30));
		deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
		deleteButton.setBackground(paleRed);
		deleteButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.removeSoldProperty(arrayPos);
			}
		}
		);
		
		jPBranchSecViewSoldBody.add(jPProperty);
	}
	
	// Create panel for displayed houses
	public void displayHouse(String propertyType, JButton viewButton, JButton editButton, JButton deleteButton, JButton soldButton, String name, String address, int arrayPos) {
		jPProperty = new JPanel();
		jPProperty.setBackground(paleBG);
		jPProperty.setPreferredSize(new Dimension(1300,85));
		
		jPPDName = new JPanel();
		jLPDName = new JLabel("Property Name: ");
		jLPDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDName = new JTextField(name);
		jTFPDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDName.setEditable(false);
		jPPDName.add(jLPDName);
		jPPDName.add(jTFPDName);
		jPProperty.add(jPPDName);
				
		jPPDAddress = new JPanel();
		jLPDAddress = new JLabel("Property Address: ");
		jLPDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTAPDAddress = new JTextArea(address);
		jTAPDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTAPDAddress.setEditable(false);
		jPPDAddress.add(jLPDAddress);
		jPPDAddress.add(jTAPDAddress);
		jPProperty.add(jPPDAddress);
		
		jPPDType = new JPanel();
		jLPDType = new JLabel("Property Type: ");
		jLPDType.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDType = new JTextField(propertyType);
		jTFPDType.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDType.setEditable(false);
		jPPDType.add(jLPDType);
		jPPDType.add(jTFPDType);
		jPProperty.add(jPPDType);

		viewButton = new JButton("View");
		viewButton.setPreferredSize(new Dimension(70,30));
		viewButton.setFont(new Font("Arial", Font.BOLD, 20));
		viewButton.setBackground(paleBlue);
		viewButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(viewButton);
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.viewHouse(arrayPos);
			}
		}
		);
		
		editButton = new JButton("Edit");
		editButton.setPreferredSize(new Dimension(70,30));
		editButton.setFont(new Font("Arial", Font.BOLD, 20));
		editButton.setBackground(paleBlue);
		editButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.editProperty(arrayPos);
			}
		}
		);
		
		deleteButton = new JButton("Delete");
		deleteButton.setPreferredSize(new Dimension(70,30));
		deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
		deleteButton.setBackground(paleRed);
		deleteButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.removeHouse(arrayPos);
			}
		}
		);
		
		soldButton = new JButton("Mark as Sold");
		soldButton.setPreferredSize(new Dimension(140,30));
		soldButton.setFont(new Font("Arial", Font.BOLD, 20));
		soldButton.setBackground(soldGreen);
		soldButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(soldButton);
		soldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.markSold(arrayPos);
			}
		}
		);
		
		jPBranchSecViewHousesBody.add(jPProperty);
	}
	
	// Create panel for displayed flats
	public void displayFlat(String propertyType, JButton viewButton, JButton editButton, JButton deleteButton, JButton soldButton, String name, String address, int arrayPos) {
		jPProperty = new JPanel();
		jPProperty.setBackground(paleBG);
		jPProperty.setPreferredSize(new Dimension(1300,85));
		
		jPPDName = new JPanel();
		jLPDName = new JLabel("Property Name: ");
		jLPDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDName = new JTextField(name);
		jTFPDName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDName.setEditable(false);
		jPPDName.add(jLPDName);
		jPPDName.add(jTFPDName);
		jPProperty.add(jPPDName);
				
		jPPDAddress = new JPanel();
		jLPDAddress = new JLabel("Property Address: ");
		jLPDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTAPDAddress = new JTextArea(address);
		jTAPDAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		jTAPDAddress.setEditable(false);
		jPPDAddress.add(jLPDAddress);
		jPPDAddress.add(jTAPDAddress);
		jPProperty.add(jPPDAddress);
		
		jPPDType = new JPanel();
		jLPDType = new JLabel("Property Type: ");
		jLPDType.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDType = new JTextField(propertyType);
		jTFPDType.setFont(new Font("Arial", Font.PLAIN, 18));
		jTFPDType.setEditable(false);
		jPPDType.add(jLPDType);
		jPPDType.add(jTFPDType);
		jPProperty.add(jPPDType);

		viewButton = new JButton("View");
		viewButton.setPreferredSize(new Dimension(70,30));
		viewButton.setFont(new Font("Arial", Font.BOLD, 20));
		viewButton.setBackground(paleBlue);
		viewButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(viewButton);
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.viewFlat(arrayPos);
			}
		}
		);
		
		editButton = new JButton("Edit");
		editButton.setPreferredSize(new Dimension(70,30));
		editButton.setFont(new Font("Arial", Font.BOLD, 20));
		editButton.setBackground(paleBlue);
		editButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.editProperty(arrayPos);
			}
		}
		);
		
		deleteButton = new JButton("Delete");
		deleteButton.setPreferredSize(new Dimension(70,30));
		deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
		deleteButton.setBackground(paleRed);
		deleteButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.removeFlat(arrayPos);
			}
		}
		);
		
		soldButton = new JButton("Mark as Sold");
		soldButton.setPreferredSize(new Dimension(140,30));
		soldButton.setFont(new Font("Arial", Font.BOLD, 20));
		soldButton.setBackground(soldGreen);
		soldButton.setBorder(BorderFactory.createLineBorder(Color.black));
		jPProperty.add(soldButton);
		soldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.markSold(arrayPos);
			}
		}
		);
		
		jPBranchSecViewFlatsBody.add(jPProperty);
	}
	
	// Displays a house
	public void viewHouse(String user, String name, String address, int rooms, String sellPrice, int floors, String garden, String garage) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBackground(paleRed);
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);

		// View a house
		jPBranchSecViewHouse = new JPanel();
		jPBranchSecViewHouse.setPreferredSize(new Dimension(1200,850));
		jPBranchSecViewHouse.setBackground(paleGreen);
		jPBranchSecViewHouse.setLayout(new BorderLayout());	
		
		jPBranchSecViewHouseOptions = new JPanel();
		jPBranchSecViewHouseOptions.setLayout(new FlowLayout());
		jPBranchSecViewHouseOptions.setBackground(paleGreen);
		jPBranchSecViewHouseOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecViewHouse.add(jPBranchSecViewHouseOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewHouseOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecViewHouseBody = new JPanel();
		jPBranchSecViewHouseBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecViewHouseBody.setBackground(paleGreen);
		jPBranchSecViewHouseBody.setLayout(new BoxLayout(jPBranchSecViewHouseBody, BoxLayout.Y_AXIS));
		jPBranchSecViewHouse.add(jPBranchSecViewHouseBody, BorderLayout.CENTER);
		
		// House details
		jPHouseName = new JPanel();
		jPBranchSecViewHouseBody.add(jPHouseName);
		jLHouseName = new JLabel("House Name: ");
		jLHouseName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseName = new JTextField(name);
		jTFHouseName.setEditable(false);
		jTFHouseName.setPreferredSize(new Dimension(450,30));
		jTFHouseName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseName.add(jLHouseName);
		jPHouseName.add(jTFHouseName);
		
		jPHouseAddress = new JPanel();
		jPBranchSecViewHouseBody.add(jPHouseAddress);
		jLHouseAddress = new JLabel("House Address: ");
		jLHouseAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAHouseAddress = new JTextArea(address);
		jTAHouseAddress.setPreferredSize(new Dimension(450,90));
		jTAHouseAddress.setEditable(false);
		jTAHouseAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAHouseAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAHouseAddress.setLineWrap(true);
		jPHouseAddress.add(jLHouseAddress);
		jPHouseAddress.add(jTAHouseAddress);
		
		jPHouseRooms = new JPanel();
		jPBranchSecViewHouseBody.add(jPHouseRooms);
		jLHouseRooms = new JLabel("Number of Rooms: ");
		jLHouseRooms.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseRooms = new JTextField(Integer.toString(rooms));
		jTFHouseRooms.setPreferredSize(new Dimension(450,30));
		jTFHouseRooms.setEditable(false);
		jTFHouseRooms.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseRooms.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseRooms.add(jLHouseRooms);
		jPHouseRooms.add(jTFHouseRooms);
		
		jPHouseSellingPrice = new JPanel();
		jPBranchSecViewHouseBody.add(jPHouseSellingPrice);
		jLHouseSellingPrice = new JLabel("House Selling Price: £");
		jLHouseSellingPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseSellingPrice = new JTextField(sellPrice);
		jTFHouseSellingPrice.setPreferredSize(new Dimension(450,30));
		jTFHouseSellingPrice.setEditable(false);
		jTFHouseSellingPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseSellingPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseSellingPrice.add(jLHouseSellingPrice);
		jPHouseSellingPrice.add(jTFHouseSellingPrice);
		
		jPHouseFloors = new JPanel();
		jPBranchSecViewHouseBody.add(jPHouseFloors);
		jLHouseFloors = new JLabel("Number of Floors: ");
		jLHouseFloors.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseFloors = new JTextField(Integer.toString(floors));
		jTFHouseFloors.setPreferredSize(new Dimension(450,30));
		jTFHouseFloors.setEditable(false);
		jTFHouseFloors.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseFloors.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseFloors.add(jLHouseFloors);
		jPHouseFloors.add(jTFHouseFloors);
		
		jPHouseGarden = new JPanel();
		jPBranchSecViewHouseBody.add(jPHouseGarden);
		jLHouseGarden = new JLabel("Does this house have a garden?");
		jLHouseGarden.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseGarden = new JTextField(garden);
		jTFHouseGarden.setPreferredSize(new Dimension(450,30));
		jTFHouseGarden.setEditable(false);
		jTFHouseGarden.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseGarden.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseGarden.add(jLHouseGarden);
		jPHouseGarden.add(jTFHouseGarden);
		
		jPHouseGarage = new JPanel();
		jPBranchSecViewHouseBody.add(jPHouseGarage);
		jLHouseGarage = new JLabel("Does this house have a garage?");
		jLHouseGarage.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseGarage = new JTextField(garage);
		jTFHouseGarage.setPreferredSize(new Dimension(450,30));
		jTFHouseGarage.setEditable(false);
		jTFHouseGarage.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseGarage.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseGarage.add(jLHouseGarage);
		jPHouseGarage.add(jTFHouseGarage);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecViewHouse, BorderLayout.CENTER);
	}
	
	// Editing a house
	public void editHouse(String user, String name, String address, int rooms, String sellPrice, int floors, String garden, String garage) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);

		// View a house
		jPBranchSecEditHouse = new JPanel();
		jPBranchSecEditHouse.setPreferredSize(new Dimension(1200,850));
		jPBranchSecEditHouse.setBackground(paleGreen);
		jPBranchSecEditHouse.setLayout(new BorderLayout());	
		
		jPBranchSecEditHouseOptions = new JPanel();
		jPBranchSecEditHouseOptions.setLayout(new FlowLayout());
		jPBranchSecEditHouseOptions.setBackground(paleGreen);
		jPBranchSecEditHouseOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecEditHouse.add(jPBranchSecEditHouseOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecEditHouseOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecEditHouseBody = new JPanel();
		jPBranchSecEditHouseBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecEditHouseBody.setBackground(paleGreen);
		jPBranchSecEditHouseBody.setLayout(new BoxLayout(jPBranchSecEditHouseBody, BoxLayout.Y_AXIS));	
		jPBranchSecEditHouse.add(jPBranchSecEditHouseBody, BorderLayout.CENTER);
		
		// House details
		jPHouseName = new JPanel();
		jPBranchSecEditHouseBody.add(jPHouseName);
		jLHouseName = new JLabel("House Name: ");
		jLHouseName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseName = new JTextField(name);
		jTFHouseName.setPreferredSize(new Dimension(450,30));
		jTFHouseName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseName.add(jLHouseName);
		jPHouseName.add(jTFHouseName);
		
		jPHouseAddress = new JPanel();
		jPBranchSecEditHouseBody.add(jPHouseAddress);
		jLHouseAddress = new JLabel("House Address: ");
		jLHouseAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAHouseAddress = new JTextArea(address);
		jTAHouseAddress.setPreferredSize(new Dimension(450,90));
		jTAHouseAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAHouseAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAHouseAddress.setLineWrap(true);
		jPHouseAddress.add(jLHouseAddress);
		jPHouseAddress.add(jTAHouseAddress);
		
		jPHouseRooms = new JPanel();
		jPBranchSecEditHouseBody.add(jPHouseRooms);
		jLHouseRooms = new JLabel("Number of Rooms: ");
		jLHouseRooms.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseRooms = new JTextField(Integer.toString(rooms));
		jTFHouseRooms.setPreferredSize(new Dimension(450,30));
		jTFHouseRooms.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseRooms.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseRooms.add(jLHouseRooms);
		jPHouseRooms.add(jTFHouseRooms);
		
		jPHouseSellingPrice = new JPanel();
		jPBranchSecEditHouseBody.add(jPHouseSellingPrice);
		jLHouseSellingPrice = new JLabel("House Selling Price: £");
		jLHouseSellingPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseSellingPrice = new JTextField(sellPrice);
		jTFHouseSellingPrice.setPreferredSize(new Dimension(450,30));
		jTFHouseSellingPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseSellingPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseSellingPrice.add(jLHouseSellingPrice);
		jPHouseSellingPrice.add(jTFHouseSellingPrice);
		
		jPHouseFloors = new JPanel();
		jPBranchSecEditHouseBody.add(jPHouseFloors);
		jLHouseFloors = new JLabel("Number of Floors: ");
		jLHouseFloors.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseFloors = new JTextField(Integer.toString(floors));
		jTFHouseFloors.setPreferredSize(new Dimension(450,30));
		jTFHouseFloors.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseFloors.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseFloors.add(jLHouseFloors);
		jPHouseFloors.add(jTFHouseFloors);
		
		jPHouseGarden = new JPanel();
		jPBranchSecEditHouseBody.add(jPHouseGarden);
		jLHouseGarden = new JLabel("Does this house have a garden?");
		jLHouseGarden.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseGarden = new JTextField(garden);
		jTFHouseGarden.setPreferredSize(new Dimension(450,30));
		jTFHouseGarden.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseGarden.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseGarden.add(jLHouseGarden);
		jPHouseGarden.add(jTFHouseGarden);
		
		jPHouseGarage = new JPanel();
		jPBranchSecEditHouseBody.add(jPHouseGarage);
		jLHouseGarage = new JLabel("Does this house have a garage?");
		jLHouseGarage.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseGarage = new JTextField(garage);
		jTFHouseGarage.setPreferredSize(new Dimension(450,30));
		jTFHouseGarage.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseGarage.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseGarage.add(jLHouseGarage);
		jPHouseGarage.add(jTFHouseGarage);
		
		jBHouseEditSubmit = new JButton("Update");
		jBHouseEditSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		jBHouseEditSubmit.setBackground(paleBlue);
		jBHouseEditSubmit.setPreferredSize(new Dimension(300,50));
		jPBranchSecEditHouseBody.add(jBHouseEditSubmit);
		jBHouseEditSubmit.addActionListener(controller);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecEditHouse, BorderLayout.CENTER);
	}
	
	// Displays a flat
	public void viewFlat(String user, String name, String address, int rooms, String sellPrice, int floorNo, String monthlyCost) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);

		// View a house
		jPBranchSecViewFlat = new JPanel();
		jPBranchSecViewFlat.setPreferredSize(new Dimension(1200,850));
		jPBranchSecViewFlat.setBackground(paleGreen);
		jPBranchSecViewFlat.setLayout(new BorderLayout());	
		
		jPBranchSecViewFlatOptions = new JPanel();
		jPBranchSecViewFlatOptions.setLayout(new FlowLayout());
		jPBranchSecViewFlatOptions.setBackground(paleGreen);
		jPBranchSecViewFlatOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecViewFlat.add(jPBranchSecViewFlatOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewFlatOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecViewFlatBody = new JPanel();
		jPBranchSecViewFlatBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecViewFlatBody.setBackground(paleGreen);
		jPBranchSecViewFlatBody.setLayout(new BoxLayout(jPBranchSecViewFlatBody, BoxLayout.Y_AXIS));	
		jPBranchSecViewFlat.add(jPBranchSecViewFlatBody, BorderLayout.CENTER);
		
		// House details
		jPFlatName = new JPanel();
		jPBranchSecViewFlatBody.add(jPFlatName);
		jLFlatName = new JLabel("Flat Name: ");
		jLFlatName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatName = new JTextField(name);
		jTFFlatName.setPreferredSize(new Dimension(450,30));
		jTFFlatName.setEditable(false);
		jTFFlatName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatName.add(jLFlatName);
		jPFlatName.add(jTFFlatName);
		
		jPFlatAddress = new JPanel();
		jPBranchSecViewFlatBody.add(jPFlatAddress);
		jLFlatAddress = new JLabel("Flat Address: ");
		jLFlatAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAFlatAddress = new JTextArea(address);
		jTAFlatAddress.setPreferredSize(new Dimension(450,90));
		jTAFlatAddress.setEditable(false);
		jTAFlatAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAFlatAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAFlatAddress.setLineWrap(true);
		jPFlatAddress.add(jLFlatAddress);
		jPFlatAddress.add(jTAFlatAddress);
		
		jPFlatRooms = new JPanel();
		jPBranchSecViewFlatBody.add(jPFlatRooms);
		jLFlatRooms = new JLabel("Number of Rooms: ");
		jLFlatRooms.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatRooms = new JTextField(Integer.toString(rooms));
		jTFFlatRooms.setPreferredSize(new Dimension(450,30));
		jTFFlatRooms.setEditable(false);
		jTFFlatRooms.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatRooms.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatRooms.add(jLFlatRooms);
		jPFlatRooms.add(jTFFlatRooms);
		
		jPFlatSellingPrice = new JPanel();
		jPBranchSecViewFlatBody.add(jPFlatSellingPrice);
		jLFlatSellingPrice = new JLabel("Flat Selling Price: £");
		jLFlatSellingPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatSellingPrice = new JTextField(sellPrice);
		jTFFlatSellingPrice.setPreferredSize(new Dimension(450,30));
		jTFFlatSellingPrice.setEditable(false);
		jTFFlatSellingPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatSellingPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatSellingPrice.add(jLFlatSellingPrice);
		jPFlatSellingPrice.add(jTFFlatSellingPrice);
		
		jPFlatFloor = new JPanel();
		jPBranchSecViewFlatBody.add(jPFlatFloor);
		jLFlatFloor = new JLabel("This Flat is on floor: ");
		jLFlatFloor.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatFloor = new JTextField(Integer.toString(floorNo));
		jTFFlatFloor.setPreferredSize(new Dimension(450,30));
		jTFFlatFloor.setEditable(false);
		jTFFlatFloor.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatFloor.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatFloor.add(jLFlatFloor);
		jPFlatFloor.add(jTFFlatFloor);
		
		jPFlatMonthlyCost = new JPanel();
		jPBranchSecViewFlatBody.add(jPFlatMonthlyCost);
		jLFlatMonthlyCost = new JLabel("Monthly Cost: £");
		jLFlatMonthlyCost.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatMonthlyCost = new JTextField(monthlyCost);
		jTFFlatMonthlyCost.setPreferredSize(new Dimension(450,30));
		jTFFlatMonthlyCost.setEditable(false);
		jTFFlatMonthlyCost.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatMonthlyCost.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatMonthlyCost.add(jLFlatMonthlyCost);
		jPFlatMonthlyCost.add(jTFFlatMonthlyCost);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecViewFlat, BorderLayout.CENTER);
	}
	
	// Editing a flat
	public void editFlat(String user, String name, String address, int rooms, String sellPrice, int floorNo, String monthlyCost) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);

		// View a house
		jPBranchSecEditFlat = new JPanel();
		jPBranchSecEditFlat.setPreferredSize(new Dimension(1200,850));
		jPBranchSecEditFlat.setBackground(paleGreen);
		jPBranchSecEditFlat.setLayout(new BorderLayout());	
		
		jPBranchSecEditFlatOptions = new JPanel();
		jPBranchSecEditFlatOptions.setLayout(new FlowLayout());
		jPBranchSecEditFlatOptions.setBackground(paleGreen);
		jPBranchSecEditFlatOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecEditFlat.add(jPBranchSecEditFlatOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecEditFlatOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecEditFlatBody = new JPanel();
		jPBranchSecEditFlatBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecEditFlatBody.setBackground(paleGreen);
		jPBranchSecEditFlatBody.setLayout(new BoxLayout(jPBranchSecEditFlatBody, BoxLayout.Y_AXIS));
		jPBranchSecEditFlat.add(jPBranchSecEditFlatBody, BorderLayout.CENTER);
		
		// House details
		jPFlatName = new JPanel();
		jPBranchSecEditFlatBody.add(jPHouseName);
		jLFlatName = new JLabel("Flat Name: ");
		jLFlatName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatName = new JTextField(name);
		jTFFlatName.setPreferredSize(new Dimension(450,30));
		jTFFlatName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatName.add(jLFlatName);
		jPFlatName.add(jTFFlatName);
		
		jPFlatAddress = new JPanel();
		jPBranchSecEditFlatBody.add(jPFlatAddress);
		jLFlatAddress = new JLabel("Flat Address: ");
		jLFlatAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAFlatAddress = new JTextArea(address);
		jTAFlatAddress.setPreferredSize(new Dimension(450,90));
		jTAFlatAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAFlatAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAFlatAddress.setLineWrap(true);
		jPFlatAddress.add(jLFlatAddress);
		jPFlatAddress.add(jTAFlatAddress);
		
		jPFlatRooms = new JPanel();
		jPBranchSecEditFlatBody.add(jPFlatRooms);
		jLFlatRooms = new JLabel("Number of Rooms: ");
		jLFlatRooms.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatRooms = new JTextField(Integer.toString(rooms));
		jTFFlatRooms.setPreferredSize(new Dimension(450,30));
		jTFFlatRooms.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatRooms.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatRooms.add(jLFlatRooms);
		jPFlatRooms.add(jTFFlatRooms);
		
		jPFlatSellingPrice = new JPanel();
		jPBranchSecEditFlatBody.add(jPFlatSellingPrice);
		jLFlatSellingPrice = new JLabel("Flat Selling Price: £");
		jLFlatSellingPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatSellingPrice = new JTextField(sellPrice);
		jTFFlatSellingPrice.setPreferredSize(new Dimension(450,30));
		jTFFlatSellingPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatSellingPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatSellingPrice.add(jLFlatSellingPrice);
		jPFlatSellingPrice.add(jTFFlatSellingPrice);
		
		jPFlatFloor = new JPanel();
		jPBranchSecEditFlatBody.add(jPFlatFloor);
		jLFlatFloor = new JLabel("This Flat is on floor : ");
		jLFlatFloor.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatFloor = new JTextField(Integer.toString(floorNo));
		jTFFlatFloor.setPreferredSize(new Dimension(450,30));
		jTFFlatFloor.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatFloor.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatFloor.add(jLFlatFloor);
		jPFlatFloor.add(jTFFlatFloor);
		
		jPFlatMonthlyCost = new JPanel();
		jPBranchSecEditFlatBody.add(jPFlatMonthlyCost);
		jLFlatMonthlyCost = new JLabel("Monthly Cost: £");
		jLFlatMonthlyCost.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatMonthlyCost = new JTextField(monthlyCost);
		jTFFlatMonthlyCost.setPreferredSize(new Dimension(450,30));
		jTFFlatMonthlyCost.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatMonthlyCost.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatMonthlyCost.add(jLFlatMonthlyCost);
		jPFlatMonthlyCost.add(jTFFlatMonthlyCost);
		
		jBFlatEditSubmit = new JButton("Update");
		jBFlatEditSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		jBFlatEditSubmit.setBackground(paleBlue);
		jBFlatEditSubmit.setPreferredSize(new Dimension(300,50));
		jPBranchSecEditFlatBody.add(jBFlatEditSubmit);
		jBFlatEditSubmit.addActionListener(controller);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecEditFlat, BorderLayout.CENTER);
	}
	
	// Gets details of a sold property
	public void soldDetails(String user, String name, String address) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);

		// View a house
		jPBranchSecSoldDetails = new JPanel();
		jPBranchSecSoldDetails.setPreferredSize(new Dimension(1200,850));
		jPBranchSecSoldDetails.setBackground(paleGreen);
		jPBranchSecSoldDetails.setLayout(new BorderLayout());	
		
		jPBranchSecSoldDetailsOptions = new JPanel();
		jPBranchSecSoldDetailsOptions.setLayout(new FlowLayout());
		jPBranchSecSoldDetailsOptions.setBackground(paleGreen);
		jPBranchSecSoldDetailsOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecSoldDetails.add(jPBranchSecSoldDetailsOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecSoldDetailsOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecSoldDetailsBody = new JPanel();
		jPBranchSecSoldDetailsBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecSoldDetailsBody.setBackground(paleGreen);
		jPBranchSecSoldDetailsBody.setLayout(new BoxLayout(jPBranchSecSoldDetailsBody, BoxLayout.Y_AXIS));
		jPBranchSecSoldDetails.add(jPBranchSecSoldDetailsBody, BorderLayout.CENTER);
		
		// House details
		jPPropertyName = new JPanel();
		jPBranchSecSoldDetailsBody.add(jPPropertyName);
		jLPropertyName = new JLabel("Property Name: ");
		jLPropertyName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFPropertyName = new JTextField(name);
		jTFPropertyName.setPreferredSize(new Dimension(450,30));
		jTFPropertyName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFPropertyName.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFPropertyName.setEditable(false);
		jPPropertyName.add(jLPropertyName);
		jPPropertyName.add(jTFPropertyName);
		
		jPPropertyAddress = new JPanel();
		jPBranchSecSoldDetailsBody.add(jPPropertyAddress);
		jLPropertyAddress = new JLabel("Property Address: ");
		jLPropertyAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAPropertyAddress = new JTextArea(address);
		jTAPropertyAddress.setPreferredSize(new Dimension(450,90));
		jTAPropertyAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAPropertyAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAPropertyAddress.setEditable(false);
		jTAPropertyAddress.setLineWrap(true);
		jPPropertyAddress.add(jLPropertyAddress);
		jPPropertyAddress.add(jTAPropertyAddress);
		
		jPPropertySoldPrice = new JPanel();
		jPBranchSecSoldDetailsBody.add(jPPropertySoldPrice);
		jLPropertySoldPrice = new JLabel("Property Sold Price: £");
		jLPropertySoldPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFPropertySoldPrice = new JTextField(35);
		jTFPropertySoldPrice.setPreferredSize(new Dimension(450,30));
		jTFPropertySoldPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFPropertySoldPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPPropertySoldPrice.add(jLPropertySoldPrice);
		jPPropertySoldPrice.add(jTFPropertySoldPrice);
		
		jPPropertySoldDate = new JPanel();
		jPBranchSecSoldDetailsBody.add(jPPropertySoldDate);
		jLPropertySoldDate = new JLabel("Property Sold Date: ");
		jLPropertySoldDate.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFPropertySoldDate = new JTextField(35);
		jTFPropertySoldDate.setPreferredSize(new Dimension(450,30));
		jTFPropertySoldDate.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFPropertySoldDate.setFont(new Font("Arial", Font.PLAIN, 25));
		jPPropertySoldDate.add(jLPropertySoldDate);
		jPPropertySoldDate.add(jTFPropertySoldDate);
		
		jBSoldDetailsSubmit = new JButton("Update");
		jBSoldDetailsSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		jBSoldDetailsSubmit.setBackground(paleBlue);
		jBSoldDetailsSubmit.setPreferredSize(new Dimension(300,50));
		jPBranchSecSoldDetailsBody.add(jBSoldDetailsSubmit);
		jBSoldDetailsSubmit.addActionListener(controller);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecSoldDetails, BorderLayout.CENTER);
	}
	
	// Log in screen
  	public void logIn() {
		// ********************************************************* LOG IN *********************************************************
		// Create log in screen
		jPLogInPanel = new JPanel();
		jPLogInPanel.setPreferredSize(new Dimension(1200,840));
		jPLogInPanel.setBackground(paleGreen);
		jPLogInPanel.setLayout(new BorderLayout());
		
		jPLogInTop = new JPanel();
		jPLogInTop.setLayout(new BorderLayout());
		jPLogInTop.setBackground(paleGreen);
		jPLogInTop.setPreferredSize(new Dimension(1200,180));
		jPLogInPanel.add(jPLogInTop, BorderLayout.NORTH);
		
		jPLogInBottom = new JPanel();
		jPLogInBottom.setLayout(new BorderLayout());
		jPLogInBottom.setBackground(paleGreen);
		jPLogInBottom.setPreferredSize(new Dimension(1200,180));
		jPLogInPanel.add(jPLogInBottom, BorderLayout.SOUTH);
		
		jPLogIn = new JPanel();
		jPLogIn.setLayout(new BoxLayout(jPLogIn, BoxLayout.PAGE_AXIS));
		jPLogIn.setBackground(paleBG);
		jPLogInPanel.add(jPLogIn, BorderLayout.CENTER);
		
		jPUsername = new JPanel();
		jPUsername.setLayout(new FlowLayout());
		jPLogIn.add(jPUsername);
		
		jPPassword = new JPanel();
		jPPassword.setLayout(new FlowLayout());
		jPLogIn.add(jPPassword);
		
		jPLogInSubmit = new JPanel();
		jPLogInSubmit.setLayout(new FlowLayout());
		jPLogIn.add(jPLogInSubmit);
		
		jLUsername = new JLabel("Username    ");
		jLUsername.setFont(new Font("Arial", Font.BOLD, 58));
		jPUsername.add(jLUsername);
		
		jTFUsername = new JTextField();
		jTFUsername.setPreferredSize(new Dimension(300, 40));
		jTFUsername.setFont(new Font("Arial", Font.PLAIN, 28));
		jPUsername.add(jTFUsername);
		
		jLPassword = new JLabel("Password    ");
		jLPassword.setFont(new Font("Arial", Font.BOLD, 58));
		jPPassword.add(jLPassword);
		
		jTFPassword = new JTextField();
		jTFPassword.setPreferredSize(new Dimension(300, 40));
		jTFPassword.setFont(new Font("Arial", Font.PLAIN, 28));
		jPPassword.add(jTFPassword);
		
		jBLogIn = new JButton("Log In");
		jBLogIn.setPreferredSize(new Dimension(150,60));
		jBLogIn.setBackground(paleBlue);
		jBLogIn.setFont(new Font("Arial", Font.BOLD, 28));
		jBLogIn.setBorder(BorderFactory.createLineBorder(Color.black));
		jPLogInSubmit.add(jBLogIn);
		jBLogIn.addActionListener(controller);
		
		jPMain.add(jPLogInPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
  	// Admin home screen
	public void adminHome(int height) {
		// Admin top
		jPAdminTop = new JPanel();
		jPAdminTop.setLayout(new BorderLayout());
		jPAdminTop.setBackground(paleGreen);
		jPAdminTop.setPreferredSize(new Dimension(1400,30));
		
		jLAdminWelcome = new JLabel("  Hello Admin!");
		jLAdminWelcome.setOpaque(true);
		jLAdminWelcome.setBackground(paleGreen);
		jLAdminWelcome.setPreferredSize(new Dimension(150,30));
		jLAdminWelcome.setFont(new Font("Arial", Font.PLAIN, 18));
		jPAdminTop.add(jLAdminWelcome, BorderLayout.WEST);
		
		jBAdminLogOut = new JButton("Log Out");
		jBAdminLogOut.setPreferredSize(new Dimension(150,30));
		jBAdminLogOut.setFont(new Font("Arial", Font.BOLD, 18));
		jBAdminLogOut.setBackground(paleRed);
		jBAdminLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminTop.add(jBAdminLogOut, BorderLayout.EAST);
		jBAdminLogOut.addActionListener(controller);
		
		// Admin set up
		jPAdminHome = new JPanel();
		jPAdminHome.setBackground(paleGreen);
		jPAdminHome.setLayout(new BorderLayout());	
		
		jPAdminHomeOptions = new JPanel();
		jPAdminHomeOptions.setLayout(new FlowLayout());
		jPAdminHomeOptions.setBackground(paleGreen);
		jPAdminHomeOptions.setPreferredSize(new Dimension(1400,30));
		jPAdminHome.add(jPAdminHomeOptions, BorderLayout.NORTH);
		
		jBAdminAdd = new JButton("Add Branch");
		jBAdminAdd.setPreferredSize(new Dimension(150,30));
		jBAdminAdd.setFont(new Font("Arial", Font.BOLD, 18));
		jBAdminAdd.setBackground(paleBlue);
		jBAdminAdd.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminHomeOptions.add(jBAdminAdd);
		jBAdminAdd.addActionListener(controller);
		
		jPAdminHomeBody = new JPanel();
		jPAdminHomeBody.setPreferredSize(new Dimension(1200,height));
		jPAdminHomeBody.setBackground(paleGreen);	
		
		jSPBranchList = new JScrollPane(jPAdminHomeBody);
	    jSPBranchList.setPreferredSize(new Dimension(1200,820));
		jSPBranchList.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminHome.add(jSPBranchList, BorderLayout.CENTER);
		
		jPMain.add(jPAdminTop, BorderLayout.NORTH);
		jPMain.add(jPAdminHome, BorderLayout.CENTER);
	}
	
	// Adding a branch screen
	public void adminAddBranch() {
		// Admin top
		jPAdminTop = new JPanel();
		jPAdminTop.setLayout(new BorderLayout());
		jPAdminTop.setBackground(paleGreen);
		jPAdminTop.setPreferredSize(new Dimension(1400,30));
		
		jLAdminWelcome = new JLabel("  Hello Admin!");
		jLAdminWelcome.setOpaque(true);
		jLAdminWelcome.setBackground(paleGreen);
		jLAdminWelcome.setPreferredSize(new Dimension(150,30));
		jLAdminWelcome.setFont(new Font("Arial", Font.PLAIN, 18));
		jPAdminTop.add(jLAdminWelcome, BorderLayout.WEST);
		
		jBAdminLogOut = new JButton("Log Out");
		jBAdminLogOut.setPreferredSize(new Dimension(150,30));
		jBAdminLogOut.setFont(new Font("Arial", Font.BOLD, 18));
		jBAdminLogOut.setBackground(paleRed);
		jBAdminLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminTop.add(jBAdminLogOut, BorderLayout.EAST);
		jBAdminLogOut.addActionListener(controller);
		
		// Add a branch
		// Admin set up
		jPAdminAdd = new JPanel();
		jPAdminAdd.setBackground(paleGreen);
		jPAdminAdd.setLayout(new BorderLayout());	
		
		jPAdminAddOptions = new JPanel();
		jPAdminAddOptions.setLayout(new FlowLayout());
		jPAdminAddOptions.setBackground(paleGreen);
		jPAdminAddOptions.setPreferredSize(new Dimension(1200,30));
		jPAdminAdd.add(jPAdminAddOptions, BorderLayout.NORTH);
		
		jBAdminHome = new JButton("Home");
		jBAdminHome.setPreferredSize(new Dimension(150,30));
		jBAdminHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBAdminHome.setBackground(paleBlue);
		jBAdminHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPAdminAddOptions.add(jBAdminHome);
		jBAdminHome.addActionListener(controller);
		
		jPAdminAddBody = new JPanel();
		jPAdminAddBody.setBackground(paleBG);
		jPAdminAddBody.setLayout(new BoxLayout(jPAdminAddBody, BoxLayout.Y_AXIS));
		jPAdminAdd.add(jPAdminAddBody);
		
		// Branch details
		jPBranchName = new JPanel();
		jPAdminAddBody.add(jPBranchName);
		jLBranchName = new JLabel("Branch Name: ");
		jLBranchName.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchName = new JTextField(25);
		jTFBranchName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchName.add(jLBranchName);
		jPBranchName.add(jTFBranchName);
		
		jPBranchAddress = new JPanel();
		jPAdminAddBody.add(jPBranchAddress);
		jLBranchAddress = new JLabel("Branch Address: ");
		jLBranchAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTABranchAddress = new JTextArea(3,25);
		jTABranchAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTABranchAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTABranchAddress.setLineWrap(true);
		jPBranchAddress.add(jLBranchAddress);
		jPBranchAddress.add(jTABranchAddress);
		
		jPBranchPhone = new JPanel();
		jPAdminAddBody.add(jPBranchPhone);
		jLBranchPhone = new JLabel("Branch Phone Number: ");
		jLBranchPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchPhone = new JTextField(25);
		jTFBranchPhone.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchPhone.add(jLBranchPhone);
		jPBranchPhone.add(jTFBranchPhone);
		
		jPBranchEmail = new JPanel();
		jPAdminAddBody.add(jPBranchEmail);
		jLBranchEmail = new JLabel("Branch Email Address: ");
		jLBranchEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchEmail = new JTextField(25);
		jTFBranchEmail.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchEmail.add(jLBranchEmail);
		jPBranchEmail.add(jTFBranchEmail);
		
		jPBranchWeb = new JPanel();
		jPAdminAddBody.add(jPBranchWeb);
		jLBranchWeb = new JLabel("Branch Web Address: ");
		jLBranchWeb.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchWeb = new JTextField(25);
		jTFBranchWeb.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchWeb.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchWeb.add(jLBranchWeb);
		jPBranchWeb.add(jTFBranchWeb);
		
		jPBranchSecUsername = new JPanel();
		jPAdminAddBody.add(jPBranchSecUsername);
		jLBranchSecUsername = new JLabel("Branch Secretary Username: ");
		jLBranchSecUsername.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchSecUsername = new JTextField(25);
		jTFBranchSecUsername.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchSecUsername.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchSecUsername.add(jLBranchSecUsername);
		jPBranchSecUsername.add(jTFBranchSecUsername);
		
		jPBranchSecPassword = new JPanel();
		jPAdminAddBody.add(jPBranchSecPassword);
		jLBranchSecPassword = new JLabel("Branch Secretary Password: ");
		jLBranchSecPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		jTFBranchSecPassword = new JTextField(25);
		jTFBranchSecPassword.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchSecPassword.setFont(new Font("Arial", Font.PLAIN, 25));
		jPBranchSecPassword.add(jLBranchSecPassword);
		jPBranchSecPassword.add(jTFBranchSecPassword);
		
		jBBranchSubmit = new JButton("Submit Branch");
		jBBranchSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		jBBranchSubmit.setBackground(paleBlue);
		jBBranchSubmit.setPreferredSize(new Dimension(300,50));
		jPAdminAddBody.add(jBBranchSubmit);
		jBBranchSubmit.addActionListener(controller);
		
		jPMain.add(jPAdminTop, BorderLayout.NORTH);
		jPMain.add(jPAdminAdd, BorderLayout.CENTER);
	}
	
	// Branch sec home screen
	public void branchSecHome(String user, int height) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1300,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);
		
		// Branch Sec set up
		jPBranchSecHome = new JPanel();
		jPBranchSecHome.setPreferredSize(new Dimension(1300,height));
		jPBranchSecHome.setBackground(paleGreen);
		jPBranchSecHome.setLayout(new BorderLayout());	
		
		jPBranchSecHomeOptions = new JPanel();
		jPBranchSecHomeOptions.setLayout(new FlowLayout());
		jPBranchSecHomeOptions.setBackground(paleGreen);
		jPBranchSecHomeOptions.setPreferredSize(new Dimension(1300,30));
		jPBranchSecHome.add(jPBranchSecHomeOptions, BorderLayout.NORTH);
		
		jBBranchSecAddHouse = new JButton("Add House");
		jBBranchSecAddHouse.setPreferredSize(new Dimension(130,30));
		jBBranchSecAddHouse.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecAddHouse.setBackground(paleBlue);
		jBBranchSecAddHouse.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecHomeOptions.add(jBBranchSecAddHouse);
		jBBranchSecAddHouse.addActionListener(controller);
		
		jBBranchSecAddFlat = new JButton("Add Flat");
		jBBranchSecAddFlat.setPreferredSize(new Dimension(130,30));
		jBBranchSecAddFlat.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecAddFlat.setBackground(paleBlue);
		jBBranchSecAddFlat.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecHomeOptions.add(jBBranchSecAddFlat);
		jBBranchSecAddFlat.addActionListener(controller);
		
		jBBranchSecSold = new JButton("Sold Properties");
		jBBranchSecSold.setPreferredSize(new Dimension(150,30));
		jBBranchSecSold.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecSold.setBackground(paleBlue);
		jBBranchSecSold.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecHomeOptions.add(jBBranchSecSold);
		jBBranchSecSold.addActionListener(controller);
		
		jBBranchSecHouses = new JButton("View Houses");
		jBBranchSecHouses.setPreferredSize(new Dimension(150,30));
		jBBranchSecHouses.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHouses.setBackground(paleBlue);
		jBBranchSecHouses.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecHomeOptions.add(jBBranchSecHouses);
		jBBranchSecHouses.addActionListener(controller);
		
		jBBranchSecFlats = new JButton("View Flats");
		jBBranchSecFlats.setPreferredSize(new Dimension(150,30));
		jBBranchSecFlats.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecFlats.setBackground(paleBlue);
		jBBranchSecFlats.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecHomeOptions.add(jBBranchSecFlats);
		jBBranchSecFlats.addActionListener(controller);
		
		jTFBranchSecSearchBar = new JTextField(20);
		jTFBranchSecSearchBar.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFBranchSecSearchBar.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecHomeOptions.add(jTFBranchSecSearchBar);
		jBBranchSecSearch = new JButton("Search");
		jBBranchSecSearch.setPreferredSize(new Dimension(90,30));
		jBBranchSecSearch.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecSearch.setBackground(paleBlue);
		jBBranchSecSearch.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecHomeOptions.add(jBBranchSecSearch);
		jBBranchSecSearch.addActionListener(controller);
		
		jBBranchSecViewAll = new JButton("View All");
		jBBranchSecViewAll.setPreferredSize(new Dimension(100,30));
		jBBranchSecViewAll.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecViewAll.setBackground(soldGreen);
		jBBranchSecViewAll.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecHomeOptions.add(jBBranchSecViewAll);
		jBBranchSecViewAll.addActionListener(controller);
		
		jPBranchSecHomeBody = new JPanel();
		jPBranchSecHomeBody.setPreferredSize(new Dimension(1300,height));
		jPBranchSecHomeBody.setBackground(paleGreen);
		
		jSPPropertyList = new JScrollPane(jPBranchSecHomeBody);
		jSPPropertyList.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecHome.add(jSPPropertyList, BorderLayout.CENTER);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecHome, BorderLayout.CENTER);
	}
	
	// Adding a house screen
	public void branchSecAddHouse(String user) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);

		// Add a house
		jPBranchSecAddHouse = new JPanel();
		jPBranchSecAddHouse.setPreferredSize(new Dimension(1200,850));
		jPBranchSecAddHouse.setBackground(paleGreen);
		jPBranchSecAddHouse.setLayout(new BorderLayout());	
		
		jPBranchSecAddHouseOptions = new JPanel();
		jPBranchSecAddHouseOptions.setLayout(new FlowLayout());
		jPBranchSecAddHouseOptions.setBackground(paleGreen);
		jPBranchSecAddHouseOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecAddHouse.add(jPBranchSecAddHouseOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecAddHouseOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecAddHouseBody = new JPanel();
		jPBranchSecAddHouseBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecAddHouseBody.setBackground(paleGreen);
		jPBranchSecAddHouseBody.setLayout(new BoxLayout(jPBranchSecAddHouseBody, BoxLayout.Y_AXIS));
		jPBranchSecAddHouse.add(jPBranchSecAddHouseBody, BorderLayout.CENTER);
		
		// House details
		jPHouseName = new JPanel();
		jPBranchSecAddHouseBody.add(jPHouseName);
		jLHouseName = new JLabel("House Name: ");
		jLHouseName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseName = new JTextField(35);
		jTFHouseName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseName.add(jLHouseName);
		jPHouseName.add(jTFHouseName);
		
		jPHouseAddress = new JPanel();
		jPBranchSecAddHouseBody.add(jPHouseAddress);
		jLHouseAddress = new JLabel("House Address: ");
		jLHouseAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAHouseAddress = new JTextArea(3,35);
		jTAHouseAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAHouseAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAHouseAddress.setLineWrap(true);
		jPHouseAddress.add(jLHouseAddress);
		jPHouseAddress.add(jTAHouseAddress);
		
		jPHouseRooms = new JPanel();
		jPBranchSecAddHouseBody.add(jPHouseRooms);
		jLHouseRooms = new JLabel("Number of Rooms: ");
		jLHouseRooms.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseRooms = new JTextField(35);
		jTFHouseRooms.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseRooms.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseRooms.add(jLHouseRooms);
		jPHouseRooms.add(jTFHouseRooms);
		
		jPHouseSellingPrice = new JPanel();
		jPBranchSecAddHouseBody.add(jPHouseSellingPrice);
		jLHouseSellingPrice = new JLabel("House Selling Price: £");
		jLHouseSellingPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseSellingPrice = new JTextField(35);
		jTFHouseSellingPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseSellingPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseSellingPrice.add(jLHouseSellingPrice);
		jPHouseSellingPrice.add(jTFHouseSellingPrice);
		
		jPHouseFloors = new JPanel();
		jPBranchSecAddHouseBody.add(jPHouseFloors);
		jLHouseFloors = new JLabel("Number of Floors: ");
		jLHouseFloors.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseFloors = new JTextField(35);
		jTFHouseFloors.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseFloors.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseFloors.add(jLHouseFloors);
		jPHouseFloors.add(jTFHouseFloors);
		
		jPHouseGarden = new JPanel();
		jPBranchSecAddHouseBody.add(jPHouseGarden);
		jLHouseGarden = new JLabel("Does this house have a garden?");
		jLHouseGarden.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseGarden = new JTextField(35);
		jTFHouseGarden.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseGarden.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseGarden.add(jLHouseGarden);
		jPHouseGarden.add(jTFHouseGarden);
		
		jPHouseGarage = new JPanel();
		jPBranchSecAddHouseBody.add(jPHouseGarage);
		jLHouseGarage = new JLabel("Does this house have a garage?");
		jLHouseGarage.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseGarage = new JTextField(35);
		jTFHouseGarage.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseGarage.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseGarage.add(jLHouseGarage);
		jPHouseGarage.add(jTFHouseGarage);
		
		jBHouseSubmit = new JButton("Submit");
		jBHouseSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		jBHouseSubmit.setBackground(paleBlue);
		jPBranchSecAddHouseBody.add(jBHouseSubmit);
		jBHouseSubmit.addActionListener(controller);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecAddHouse, BorderLayout.CENTER);
	}
	
	// Adding a flat screen
	public void branchSecAddFlat(String user) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);
		
		// Add a flat
		jPBranchSecAddFlat = new JPanel();
		jPBranchSecAddFlat.setPreferredSize(new Dimension(1200,850));
		jPBranchSecAddFlat.setBackground(paleGreen);
		jPBranchSecAddFlat.setLayout(new BorderLayout());
		
		jPBranchSecAddFlatOptions = new JPanel();
		jPBranchSecAddFlatOptions.setLayout(new FlowLayout());
		jPBranchSecAddFlatOptions.setBackground(paleGreen);
		jPBranchSecAddFlatOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecAddFlat.add(jPBranchSecAddFlatOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecAddFlatOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecAddFlatBody = new JPanel();
		jPBranchSecAddFlatBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecAddFlatBody.setBackground(paleGreen);
		jPBranchSecAddFlatBody.setLayout(new BoxLayout(jPBranchSecAddFlatBody, BoxLayout.Y_AXIS));
		jPBranchSecAddFlat.add(jPBranchSecAddFlatBody, BorderLayout.CENTER);
		
		// Flat details
		jPFlatName = new JPanel();
		jPBranchSecAddFlatBody.add(jPFlatName);
		jLFlatName = new JLabel("Flat Name: ");
		jLFlatName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatName = new JTextField(35);
		jTFFlatName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatName.add(jLFlatName);
		jPFlatName.add(jTFFlatName);
		
		jPFlatAddress = new JPanel();
		jPBranchSecAddFlatBody.add(jPFlatAddress);
		jLFlatAddress = new JLabel("Flat Address: ");
		jLFlatAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAFlatAddress = new JTextArea(3,35);
		jTAFlatAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAFlatAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAFlatAddress.setLineWrap(true);
		jPFlatAddress.add(jLFlatAddress);
		jPFlatAddress.add(jTAFlatAddress);
		
		jPFlatRooms = new JPanel();
		jPBranchSecAddFlatBody.add(jPFlatRooms);
		jLFlatRooms = new JLabel("Number of Rooms: ");
		jLFlatRooms.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatRooms = new JTextField(35);
		jTFFlatRooms.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatRooms.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatRooms.add(jLFlatRooms);
		jPFlatRooms.add(jTFFlatRooms);
		
		jPFlatSellingPrice = new JPanel();
		jPBranchSecAddFlatBody.add(jPFlatSellingPrice);
		jLFlatSellingPrice = new JLabel("Flat Selling Price: ");
		jLFlatSellingPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatSellingPrice = new JTextField(35);
		jTFFlatSellingPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatSellingPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatSellingPrice.add(jLFlatSellingPrice);
		jPFlatSellingPrice.add(jTFFlatSellingPrice);
		
		jPFlatFloor = new JPanel();
		jPBranchSecAddFlatBody.add(jPFlatFloor);
		jLFlatFloor = new JLabel("Floor Number: ");
		jLFlatFloor.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatFloor = new JTextField(35);
		jTFFlatFloor.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatFloor.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatFloor.add(jLFlatFloor);
		jPFlatFloor.add(jTFFlatFloor);
		
		jPFlatMonthlyCost = new JPanel();
		jPBranchSecAddFlatBody.add(jPFlatMonthlyCost);
		jLFlatMonthlyCost = new JLabel("Monthly Cost: £");
		jLFlatMonthlyCost.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatMonthlyCost = new JTextField(35);
		jTFFlatMonthlyCost.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatMonthlyCost.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatMonthlyCost.add(jLFlatMonthlyCost);
		jPFlatMonthlyCost.add(jTFFlatMonthlyCost);
		
		jBFlatSubmit = new JButton("Submit");
		jBFlatSubmit.setFont(new Font("Arial", Font.BOLD, 25));
		jBFlatSubmit.setBackground(paleBlue);
		jPBranchSecAddFlatBody.add(jBFlatSubmit);
		jBFlatSubmit.addActionListener(controller);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecAddFlat, BorderLayout.CENTER);
	}

	// Viewing all sold properties
	public void branchSecViewSold(String user, int height) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);
		
		// Branch Sec set up
		jPBranchSecViewSold = new JPanel();
		jPBranchSecViewSold.setPreferredSize(new Dimension(1200,850));
		jPBranchSecViewSold.setBackground(paleGreen);
		jPBranchSecViewSold.setLayout(new BorderLayout());	
		
		jPBranchSecViewSoldOptions = new JPanel();
		jPBranchSecViewSoldOptions.setLayout(new FlowLayout());
		jPBranchSecViewSoldOptions.setBackground(paleGreen);
		jPBranchSecViewSoldOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecViewSold.add(jPBranchSecViewSoldOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewSoldOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecViewSoldBody = new JPanel();
		jPBranchSecViewSoldBody.setPreferredSize(new Dimension(1200,height));
		jPBranchSecViewSoldBody.setBackground(paleGreen);
		jPBranchSecViewSold.add(jPBranchSecViewSoldBody, BorderLayout.CENTER);
		
		jSPSoldList = new JScrollPane(jPBranchSecViewSoldBody);
		jSPSoldList.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewSold.add(jSPSoldList, BorderLayout.CENTER);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecViewSold, BorderLayout.CENTER);
	}
	
	// Re-generate the display
	public void reset() { // (rdonuk, 2016)
		jPMain.removeAll();
		jPMain.revalidate();
		jPMain.repaint();
	}

	// Get the username the user has entered
	public String getUsername() {
		String username = jTFUsername.getText();
		return username;
	}
	
	// Get the password the user has entered
	public String getPassword() {
		String password = jTFPassword.getText();
		return password;
	}

	// Display a help pop up
	public void help() {
		JTextArea helpText = new JTextArea("Use this software to control branches and properties at National Property Sales.\n\nIf you have forgotten your password or need any other help"
				+ " please contact: millie@npssupport.co.uk");
	    JScrollPane helpScrollPane = new JScrollPane(helpText);  
	    helpText.setLineWrap(true);  
	    helpText.setWrapStyleWord(true); 
	    helpScrollPane.setPreferredSize( new Dimension( 400, 60 ) );
	    JOptionPane.showMessageDialog(null, helpScrollPane, "Help", JOptionPane.YES_NO_OPTION);
	}
	
	// Display an about pop up
	public void about() {
		JTextArea aboutText = new JTextArea("Version 1.92.0\nThis software application was created by Millie Allen at the University of Northampton");
		JScrollPane aboutScrollPane = new JScrollPane(aboutText);  
		aboutText.setLineWrap(true);  
		aboutText.setWrapStyleWord(true); 
		aboutScrollPane.setPreferredSize( new Dimension( 300, 60 ) );
		JOptionPane.showMessageDialog(null, aboutScrollPane, "About", JOptionPane.YES_NO_OPTION);
	}
	
	// Display a message if the log in is incorrect
	public void logInIncorrect() {
		JOptionPane.showMessageDialog(this, "Login incorrect."); 
		jTFUsername.setText(null);
		jTFPassword.setText(null);
	}

	// Display a message if there are no branches
	public void noBranches() {
		jLNoBranches = new JLabel("No branches found.");
		jPAdminHomeBody.add(jLNoBranches);
	}
	
	// Display a message if there are no properties
	public void noProperties() {
		jLNoProperties = new JLabel("No properties found.");
		jPBranchSecHomeBody.add(jLNoProperties);
	}
	
	// Display a message if there are no sold properties
	public void noSoldProperties() {
		jLNoProperties = new JLabel("No properties found.");
		jPBranchSecViewSoldBody.add(jLNoProperties);
	}
	
	// Get branch details that have been entered
	public Branch getBranch() {
		String bName = jTFBranchName.getText();
		String bAddress = jTABranchAddress.getText();
		String bPhone = jTFBranchPhone.getText();
		String bEmail = jTFBranchEmail.getText();
		String bWeb = jTFBranchWeb.getText();
		String bSecUsername = jTFBranchSecUsername.getText();
		String bSecPassword = jTFBranchSecPassword.getText();
		
		Branch branch = new Branch(bName, bAddress, bPhone, bEmail, bWeb, bSecUsername, bSecPassword);
		return branch;
	}

	// Get house details that have been entered
	public House getHouse(String branch) {	
		String bName = branch;
		String hName = jTFHouseName.getText();
		String hAddress = jTAHouseAddress.getText();
		int hRooms = Integer.parseInt(jTFHouseRooms.getText());
		String hSellPrice = jTFHouseSellingPrice.getText();
		String hSoldPrice = "";
		String hSoldDate = "";
		int hNoFloors = Integer.parseInt(jTFHouseFloors.getText());
		String hGarden = jTFHouseGarden.getText();
		String hGarage = jTFHouseGarage.getText();
		
		Property property = new House(bName, hName, hAddress, hRooms, hSellPrice, hSoldPrice, hSoldDate, hNoFloors, hGarden, hGarage);
		return (House) property;
	}
	
	// Get flat details that have been entered
	public Flat getFlat(String branch) {
		String bName = branch;
		String fName = jTFFlatName.getText();
		String fAddress = jTAFlatAddress.getText();
		int fRooms = Integer.parseInt(jTFFlatRooms.getText());
		String fSellPrice = jTFFlatSellingPrice.getText();
		String fSoldPrice = "";
		String fSoldDate = "";
		int fFloorNo = Integer.parseInt(jTFFlatFloor.getText());
		String fMonthlyCost = jTFFlatMonthlyCost.getText();
		
		Property property = new Flat(bName, fName, fAddress, fRooms, fSellPrice, fSoldPrice, fSoldDate, fFloorNo, fMonthlyCost);
		return (Flat) property;
	}

	// Get the search term that has been entered
	public String getSearchTerm() {
		String searchTerm = jTFBranchSecSearchBar.getText();
		return searchTerm;
	}

	// Display a sold house
	public void viewSoldHouse(String user, String name, String address, int rooms, int floors, String garden, String garage, String soldPrice, String soldDate) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBackground(paleRed);
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);

		// View a house
		jPBranchSecViewSoldHouse = new JPanel();
		jPBranchSecViewSoldHouse.setPreferredSize(new Dimension(1200,850));
		jPBranchSecViewSoldHouse.setBackground(paleGreen);
		jPBranchSecViewSoldHouse.setLayout(new BorderLayout());	
		
		jPBranchSecViewSoldHouseOptions = new JPanel();
		jPBranchSecViewSoldHouseOptions.setLayout(new FlowLayout());
		jPBranchSecViewSoldHouseOptions.setBackground(paleGreen);
		jPBranchSecViewSoldHouseOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecViewSoldHouse.add(jPBranchSecViewSoldHouseOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewSoldHouseOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecViewSoldHouseBody = new JPanel();
		jPBranchSecViewSoldHouseBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecViewSoldHouseBody.setBackground(paleGreen);
		jPBranchSecViewSoldHouseBody.setLayout(new BoxLayout(jPBranchSecViewSoldHouseBody, BoxLayout.Y_AXIS));
		jPBranchSecViewSoldHouse.add(jPBranchSecViewSoldHouseBody, BorderLayout.CENTER);
		
		// House details
		jPHouseName = new JPanel();
		jPBranchSecViewSoldHouseBody.add(jPHouseName);
		jLHouseName = new JLabel("House Name: ");
		jLHouseName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseName = new JTextField(name);
		jTFHouseName.setEditable(false);
		jTFHouseName.setPreferredSize(new Dimension(450,30));
		jTFHouseName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseName.add(jLHouseName);
		jPHouseName.add(jTFHouseName);
		
		jPHouseAddress = new JPanel();
		jPBranchSecViewSoldHouseBody.add(jPHouseAddress);
		jLHouseAddress = new JLabel("House Address: ");
		jLHouseAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAHouseAddress = new JTextArea(address);
		jTAHouseAddress.setPreferredSize(new Dimension(450,90));
		jTAHouseAddress.setEditable(false);
		jTAHouseAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAHouseAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAHouseAddress.setLineWrap(true);
		jPHouseAddress.add(jLHouseAddress);
		jPHouseAddress.add(jTAHouseAddress);
		
		jPHouseRooms = new JPanel();
		jPBranchSecViewSoldHouseBody.add(jPHouseRooms);
		jLHouseRooms = new JLabel("Number of Rooms: ");
		jLHouseRooms.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseRooms = new JTextField(Integer.toString(rooms));
		jTFHouseRooms.setPreferredSize(new Dimension(450,30));
		jTFHouseRooms.setEditable(false);
		jTFHouseRooms.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseRooms.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseRooms.add(jLHouseRooms);
		jPHouseRooms.add(jTFHouseRooms);
		
		jPHouseFloors = new JPanel();
		jPBranchSecViewSoldHouseBody.add(jPHouseFloors);
		jLHouseFloors = new JLabel("Number of Floors: ");
		jLHouseFloors.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseFloors = new JTextField(Integer.toString(floors));
		jTFHouseFloors.setPreferredSize(new Dimension(450,30));
		jTFHouseFloors.setEditable(false);
		jTFHouseFloors.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseFloors.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseFloors.add(jLHouseFloors);
		jPHouseFloors.add(jTFHouseFloors);
		
		jPHouseGarden = new JPanel();
		jPBranchSecViewSoldHouseBody.add(jPHouseGarden);
		jLHouseGarden = new JLabel("Does this house have a garden?");
		jLHouseGarden.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseGarden = new JTextField(garden);
		jTFHouseGarden.setPreferredSize(new Dimension(450,30));
		jTFHouseGarden.setEditable(false);
		jTFHouseGarden.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseGarden.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseGarden.add(jLHouseGarden);
		jPHouseGarden.add(jTFHouseGarden);
		
		jPHouseGarage = new JPanel();
		jPBranchSecViewSoldHouseBody.add(jPHouseGarage);
		jLHouseGarage = new JLabel("Does this house have a garage?");
		jLHouseGarage.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseGarage = new JTextField(garage);
		jTFHouseGarage.setPreferredSize(new Dimension(450,30));
		jTFHouseGarage.setEditable(false);
		jTFHouseGarage.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseGarage.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseGarage.add(jLHouseGarage);
		jPHouseGarage.add(jTFHouseGarage);
		
		jPHouseSoldPrice = new JPanel();
		jPBranchSecViewSoldHouseBody.add(jPHouseSoldPrice);
		jLHouseSoldPrice = new JLabel("House sold price: £");
		jLHouseSoldPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseSoldPrice = new JTextField(soldPrice);
		jTFHouseSoldPrice.setPreferredSize(new Dimension(450,30));
		jTFHouseSoldPrice.setEditable(false);
		jTFHouseSoldPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseSoldPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseSoldPrice.add(jLHouseSoldPrice);
		jPHouseSoldPrice.add(jTFHouseSoldPrice);
		
		jPHouseSoldDate = new JPanel();
		jPBranchSecViewSoldHouseBody.add(jPHouseSoldDate);
		jLHouseSoldDate = new JLabel("House sold date: ");
		jLHouseSoldDate.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFHouseSoldDate = new JTextField(soldPrice);
		jTFHouseSoldDate.setPreferredSize(new Dimension(450,30));
		jTFHouseSoldDate.setEditable(false);
		jTFHouseSoldDate.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFHouseSoldDate.setFont(new Font("Arial", Font.PLAIN, 25));
		jPHouseSoldDate.add(jLHouseSoldDate);
		jPHouseSoldDate.add(jTFHouseSoldDate);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecViewSoldHouse, BorderLayout.CENTER);
	}

	// Display a sold flat
	public void viewSoldFlat(String user, String name, String address, int rooms, int floorNo, String soldPrice, String soldDate) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);

		// View a house
		jPBranchSecViewSoldFlat = new JPanel();
		jPBranchSecViewSoldFlat.setPreferredSize(new Dimension(1200,850));
		jPBranchSecViewSoldFlat.setBackground(paleGreen);
		jPBranchSecViewSoldFlat.setLayout(new BorderLayout());	
		
		jPBranchSecViewSoldFlatOptions = new JPanel();
		jPBranchSecViewSoldFlatOptions.setLayout(new FlowLayout());
		jPBranchSecViewSoldFlatOptions.setBackground(paleGreen);
		jPBranchSecViewSoldFlatOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecViewSoldFlat.add(jPBranchSecViewSoldFlatOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewSoldFlatOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecViewSoldFlatBody = new JPanel();
		jPBranchSecViewSoldFlatBody.setPreferredSize(new Dimension(1200,820));
		jPBranchSecViewSoldFlatBody.setBackground(paleGreen);
		jPBranchSecViewSoldFlatBody.setLayout(new BoxLayout(jPBranchSecViewSoldFlatBody, BoxLayout.Y_AXIS));	
		jPBranchSecViewSoldFlat.add(jPBranchSecViewSoldFlatBody, BorderLayout.CENTER);
		
		// House details
		jPFlatName = new JPanel();
		jPBranchSecViewSoldFlatBody.add(jPFlatName);
		jLFlatName = new JLabel("Flat Name: ");
		jLFlatName.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatName = new JTextField(name);
		jTFFlatName.setPreferredSize(new Dimension(450,30));
		jTFFlatName.setEditable(false);
		jTFFlatName.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatName.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatName.add(jLFlatName);
		jPFlatName.add(jTFFlatName);
		
		jPFlatAddress = new JPanel();
		jPBranchSecViewSoldFlatBody.add(jPFlatAddress);
		jLFlatAddress = new JLabel("Flat Address: ");
		jLFlatAddress.setFont(new Font("Arial", Font.PLAIN, 30));
		jTAFlatAddress = new JTextArea(address);
		jTAFlatAddress.setPreferredSize(new Dimension(450,90));
		jTAFlatAddress.setEditable(false);
		jTAFlatAddress.setBorder(BorderFactory.createLineBorder(Color.black));
		jTAFlatAddress.setFont(new Font("Arial", Font.PLAIN, 25));
		jTAFlatAddress.setLineWrap(true);
		jPFlatAddress.add(jLFlatAddress);
		jPFlatAddress.add(jTAFlatAddress);
		
		jPFlatRooms = new JPanel();
		jPBranchSecViewSoldFlatBody.add(jPFlatRooms);
		jLFlatRooms = new JLabel("Number of Rooms: ");
		jLFlatRooms.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatRooms = new JTextField(Integer.toString(rooms));
		jTFFlatRooms.setPreferredSize(new Dimension(450,30));
		jTFFlatRooms.setEditable(false);
		jTFFlatRooms.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatRooms.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatRooms.add(jLFlatRooms);
		jPFlatRooms.add(jTFFlatRooms);
		
		jPFlatFloor = new JPanel();
		jPBranchSecViewSoldFlatBody.add(jPFlatFloor);
		jLFlatFloor = new JLabel("This Flat is on floor: ");
		jLFlatFloor.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatFloor = new JTextField(Integer.toString(floorNo));
		jTFFlatFloor.setPreferredSize(new Dimension(450,30));
		jTFFlatFloor.setEditable(false);
		jTFFlatFloor.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatFloor.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatFloor.add(jLFlatFloor);
		jPFlatFloor.add(jTFFlatFloor);
		
		jPFlatSoldPrice = new JPanel();
		jPBranchSecViewSoldFlatBody.add(jPFlatSoldPrice);
		jLFlatSoldPrice = new JLabel("Flat sold price: £");
		jLFlatSoldPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatSoldPrice = new JTextField(Integer.toString(floorNo));
		jTFFlatSoldPrice.setPreferredSize(new Dimension(450,30));
		jTFFlatSoldPrice.setEditable(false);
		jTFFlatSoldPrice.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatSoldPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatSoldPrice.add(jLFlatSoldPrice);
		jPFlatSoldPrice.add(jTFFlatSoldPrice);
		
		jPFlatSoldDate = new JPanel();
		jPBranchSecViewSoldFlatBody.add(jPFlatSoldDate);
		jLFlatSoldDate = new JLabel("Flat sold date: ");
		jLFlatSoldDate.setFont(new Font("Arial", Font.PLAIN, 30));
		jTFFlatSoldDate = new JTextField(Integer.toString(floorNo));
		jTFFlatSoldDate.setPreferredSize(new Dimension(450,30));
		jTFFlatSoldDate.setEditable(false);
		jTFFlatSoldDate.setBorder(BorderFactory.createLineBorder(Color.black));
		jTFFlatSoldDate.setFont(new Font("Arial", Font.PLAIN, 25));
		jPFlatSoldDate.add(jLFlatSoldDate);
		jPFlatSoldDate.add(jTFFlatSoldDate);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecViewSoldFlat, BorderLayout.CENTER);
	}
	
	// Get the sold price
	public String getSoldPrice() {
		return jTFPropertySoldPrice.getText();
	}
	
	// Get the sold date
	public String getSoldDate() {
		return jTFPropertySoldDate.getText();
	}

	// Display all houses
	public void branchSecViewHouses(String user, int height) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);
		
		// Branch Sec set up
		jPBranchSecViewHouses = new JPanel();
		jPBranchSecViewHouses.setPreferredSize(new Dimension(1200,850));
		jPBranchSecViewHouses.setBackground(paleGreen);
		jPBranchSecViewHouses.setLayout(new BorderLayout());	
		
		jPBranchSecViewHousesOptions = new JPanel();
		jPBranchSecViewHousesOptions.setLayout(new FlowLayout());
		jPBranchSecViewHousesOptions.setBackground(paleGreen);
		jPBranchSecViewHousesOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecViewHouses.add(jPBranchSecViewHousesOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewHousesOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecViewHousesBody = new JPanel();
		jPBranchSecViewHousesBody.setPreferredSize(new Dimension(1200,height));
		jPBranchSecViewHousesBody.setBackground(paleGreen);
		jPBranchSecViewHouses.add(jPBranchSecViewHousesBody, BorderLayout.CENTER);
		
		jSPHouseList = new JScrollPane(jPBranchSecViewHousesBody);
		jSPHouseList.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewHouses.add(jSPHouseList, BorderLayout.CENTER);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecViewHouses, BorderLayout.CENTER);
	}

	// Display all flats
	public void branchSecViewFlats(String user, int height) {
		// Branch Sec top
		jPBranchSecTop = new JPanel();
		jPBranchSecTop.setLayout(new BorderLayout());
		jPBranchSecTop.setBackground(paleGreen);
		jPBranchSecTop.setPreferredSize(new Dimension(1200,30));
		
		jLBranchSecWelcome = new JLabel("  Hello " + user + "!");
		jLBranchSecWelcome.setOpaque(true);
		jLBranchSecWelcome.setBackground(paleGreen);
		jLBranchSecWelcome.setPreferredSize(new Dimension(300,30));
		jLBranchSecWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		jPBranchSecTop.add(jLBranchSecWelcome, BorderLayout.WEST);
		
		jBBranchSecLogOut = new JButton("Log Out");
		jBBranchSecLogOut.setPreferredSize(new Dimension(150,30));
		jBBranchSecLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecLogOut.setBorder(BorderFactory.createLineBorder(Color.black));
		jBBranchSecLogOut.setBackground(paleRed);
		jPBranchSecTop.add(jBBranchSecLogOut, BorderLayout.EAST);
		jBBranchSecLogOut.addActionListener(controller);
		
		// Branch Sec set up
		jPBranchSecViewFlats = new JPanel();
		jPBranchSecViewFlats.setPreferredSize(new Dimension(1200,850));
		jPBranchSecViewFlats.setBackground(paleGreen);
		jPBranchSecViewFlats.setLayout(new BorderLayout());	
		
		jPBranchSecViewFlatsOptions = new JPanel();
		jPBranchSecViewFlatsOptions.setLayout(new FlowLayout());
		jPBranchSecViewFlatsOptions.setBackground(paleGreen);
		jPBranchSecViewFlatsOptions.setPreferredSize(new Dimension(1200,30));
		jPBranchSecViewFlats.add(jPBranchSecViewFlatsOptions, BorderLayout.NORTH);
		
		jBBranchSecHome = new JButton("Home");
		jBBranchSecHome.setPreferredSize(new Dimension(150,30));
		jBBranchSecHome.setFont(new Font("Arial", Font.BOLD, 20));
		jBBranchSecHome.setBackground(paleBlue);
		jBBranchSecHome.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewFlatsOptions.add(jBBranchSecHome);
		jBBranchSecHome.addActionListener(controller);
		
		jPBranchSecViewFlatsBody = new JPanel();
		jPBranchSecViewFlatsBody.setPreferredSize(new Dimension(1200,height));
		jPBranchSecViewFlatsBody.setBackground(paleGreen);
		jPBranchSecViewFlats.add(jPBranchSecViewFlatsBody, BorderLayout.CENTER);
		
		jSPFlatList = new JScrollPane(jPBranchSecViewFlatsBody);
		jSPFlatList.setBorder(BorderFactory.createLineBorder(Color.black));
		jPBranchSecViewFlats.add(jSPFlatList, BorderLayout.CENTER);
		
		jPMain.add(jPBranchSecTop, BorderLayout.NORTH);
		jPMain.add(jPBranchSecViewFlats, BorderLayout.CENTER);
	}
	
	// Display a message if there are no houses
	public void noHouses() {
		jLNoHouses = new JLabel("No houses found.");
		jPBranchSecViewHousesBody.add(jLNoHouses);
	}
	
	// Display a message if there are no flats
	public void noFlats() {
		jLNoFlats = new JLabel("No flats found.");
		jPBranchSecViewFlatsBody.add(jLNoFlats);
	}
}