package client.clientview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import client.clientcontroller.ClientController;
import client.clientcontroller.GUIController;

//This class handles events using lambda expressions.
//This approach should be used instead of using anonymous classes!
public class ClientView extends JFrame {

	String name;
	Frame4 f4;

	String id;

	JButton b1 = new JButton("Search course");
	JButton b2 = new JButton("Add course");
	JButton b3 = new JButton("Remove course");
	JButton b4 = new JButton("View all courses");
	JButton b5 = new JButton("View courses taken by student");
	JButton b6 = new JButton("Quit");
	private JTextArea textArea;

	public String getNameS() {
		return name;
	}

	public String getIDS() {
		return id;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public ClientView(String s) {
		super(s);
		f4 = new Frame4("Enter name and ID");
		f4.getB1().addActionListener((ActionEvent e1) -> {
			name = f4.NameT().getText();
			id = f4.IdT().getText();
			f4.setVisible(false);
			setSize(800, 400);
			setLayout(new BorderLayout());
			JPanel p = new JPanel();
			textArea = new JTextArea(100, 100);
			JScrollPane scroll = new JScrollPane(textArea);
			textArea.setEditable(false);
			JLabel j1 = new JLabel("Welcome " + name + " Your ID is " + id);
			add("North", j1);

			add("Center", scroll);
			add("South", p);
			p.add(b1);
			p.add(b2);
			p.add(b3);
			p.add(b4);
			p.add(b5);
			p.add(b6);
			setVisible(true);
		});
		f4.getB2().addActionListener((ActionEvent e1) -> {
			System.exit(1);
		});
//		b1.addActionListener((ActionEvent e) -> {
//			Frame1 f = new Frame1("Search catalogue course");
//		});
//		b2.addActionListener((ActionEvent e) -> {
//			Frame2 f = new Frame2("Add courses to student courses");
//		});
//		b3.addActionListener((ActionEvent e) -> {
//			Frame3 f = new Frame3("Remove course from student courses");
//		});
//		b4.addActionListener((ActionEvent e) -> {
//			
//		});
//		b5.addActionListener((ActionEvent e) -> {
//			
//		});
//		b6.addActionListener((ActionEvent e) -> {
//			System.exit(1);
//		});
	}

	/**
	 * listener for B1
	 * 
	 * @param listenForB1 listener
	 */
	public void addB1Listener(ActionListener listenForB1) {
		b1.addActionListener(listenForB1);
	}

	/**
	 * listener for B2
	 * 
	 * @param listenForB2 listener
	 */
	public void addB2Listener(ActionListener listenForB2) {
		b2.addActionListener(listenForB2);
	}

	/**
	 * listener for B3
	 * 
	 * @param listenForB3 listener
	 */
	public void addB3Listener(ActionListener listenForB3) {
		b3.addActionListener(listenForB3);
	}

	/**
	 * listener for B4 
	 * 
	 * @param listenForB4 listener
	 */
	public void addB4Listener(ActionListener listenForB4) {
		b4.addActionListener(listenForB4);
	}

	/**
	 * listener for B5
	 * 
	 * @param listenForB5 listener
	 */
	public void addB5Listener(ActionListener listenForB5) {
		b5.addActionListener(listenForB5);
	}

	/**
	 * listener for B6
	 * 
	 * @param listenForB6 listener
	 */
	public void addB6Listener(ActionListener listenForB6) {
		b6.addActionListener(listenForB6);
	}

	public JButton getB1() {
		return b1;
	}

	public void setB1(JButton b1) {
		this.b1 = b1;
	}

	public JButton getB2() {
		return b2;
	}

	public void setB2(JButton b2) {
		this.b2 = b2;
	}

	public JButton getB3() {
		return b3;
	}

	public void setB3(JButton b3) {
		this.b3 = b3;
	}

	public JButton getB4() {
		return b4;
	}

	public void setB4(JButton b4) {
		this.b4 = b4;
	}

	public JButton getB5() {
		return b5;
	}

	public void setB5(JButton b5) {
		this.b5 = b5;
	}

	public JButton getB6() {
		return b6;
	}

	public void setB6(JButton b6) {
		this.b6 = b6;
	}

	public static void main(String[] args) {

		ClientView myFrame = new ClientView("Course Registration System");
		ClientController control = new ClientController("localhost", 9091);
		GUIController gui = new GUIController(myFrame, control);
	}
}