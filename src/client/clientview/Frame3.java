package client.clientview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;
/**
 * 
 * @author kameshwara sekar
 *the frame for remove course frame
 */
public class Frame3 extends JFrame {
	JButton b1, b2;
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


	JTextField nameTextField = new JTextField(5);
	JTextField IDTextField = new JTextField(5);
	
	public Frame3(String s) {
		super(s);
		
		setSize(400, 200);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		setLayout(new BorderLayout());
		JLabel j1 = new JLabel("Enter the name of the course");
		JLabel j2 = new JLabel("Enter the ID of the course");
		
		//j1.setBounds(400, 20, 100, 100);
		add("North", j1);
		b1 = new JButton("Remove");
		b2 = new JButton("Return to main window");
		
		p1.add(b1);
		p1.add(b2);
		//JTextField nameTextField = new JTextField(5);
		p2.add(j1);
		p2.add(nameTextField);
		//JTextField IDTextField = new JTextField(5);
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


	public String getName()
	{
		return nameTextField.getText();
	}
	

	public String getID()
	{
		return IDTextField.getText();
	}
	
	
	
	
}