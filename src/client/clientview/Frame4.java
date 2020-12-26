package client.clientview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;

import client.clientcontroller.ClientController;

public class Frame4 extends JFrame {
	JButton b1, b2;
	JTextField nameTextField = new JTextField(5);
	public JTextField NameT() {
		return nameTextField;
	}
	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}
	public JTextField IdT() {
		return IDTextField;
	}
	public void setIDTextField(JTextField iDTextField) {
		IDTextField = iDTextField;
	}

	JTextField IDTextField = new JTextField(5);

	public Frame4(String s) {
		super(s);
		setSize(400, 400);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		setLayout(new BorderLayout());
		JLabel j1 = new JLabel("Enter your name");
		JLabel j2 = new JLabel("Enter your ID");
		b1 = new JButton("Confirm");
		b2 = new JButton("Exit");
		p1.add(b1);
		p1.add(b2);
		p2.add(j1);
		p2.add(nameTextField);
		p2.add(j2);
		p2.add(IDTextField);
		add("South",p1);
		add("Center",p2);
		setVisible(true);
		
	b1.addActionListener((ActionEvent e)->{
		String name = nameTextField.getText();
		String id = IDTextField.getText();
		setVisible(false);

	});
	
	b2.addActionListener((ActionEvent e)->{
		setVisible(false);
	});
	
	
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
}

