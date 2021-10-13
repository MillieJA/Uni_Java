/*
Program: 	Assessment 2 - Individual Project to create a GUI based National Property Sales System
Filename: 	CSY2030.java
Author: 	Millie Allen (18417959)
Course: 	Computing (Software Engineering)
Module:		CSY2030 - Systems Design and Development
Tutor:		Apkar Salatian
Date:
*/

public class CSY2030 {

	public static void main(String[] args) {
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller, model);
	}

}