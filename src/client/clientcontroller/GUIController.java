package client.clientcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.clientview.ClientView;
import client.clientview.Frame1;
import client.clientview.Frame2;
import client.clientview.Frame3;

public class GUIController {

	ClientView theView;
	// ClientModel theModel;
	Frame1 f1;
	Frame2 f2;
	Frame3 f3;
	int pos = 0;
	ClientController client;

	public GUIController(ClientView theView, ClientController theController) {
		// this.theModel=theModel;
		this.theView = theView;

		// client=new ClientController("locol port",9898);
		client = theController;
		theView.addB1Listener(new AddB1Listener());
		theView.addB2Listener(new AddB2Listener());
		theView.addB3Listener(new AddB3Listener());
		theView.addB4Listener(new AddB4Listener());
		theView.addB5Listener(new AddB5Listener());
		theView.addB6Listener(new AddB6Listener());

	}

	class AddB1Listener implements ActionListener {
		/**
		 * action performer for B1
		 */
		public void actionPerformed(ActionEvent e) {
			// String name, id;
			f1 = new Frame1("Search catelogue courses");
			f1.getB1().addActionListener((ActionEvent e1) -> {
				String name = f1.nameT().getText();
				String id = f1.idT().getText();
				String line = "1 " + name + " " + id;
				String ret = client.communicate(line);
				theView.getTextArea().insert(ret, pos);
				f1.setVisible(false);
				// pos++;

			});
			f1.getB2().addActionListener((ActionEvent e1) -> {
				f1.setVisible(false);
			});

		}

	}

	class AddB2Listener implements ActionListener {
		/**
		 * action performer for B2
		 */
		public void actionPerformed(ActionEvent e) {
			// String name, id;
			f2 = new Frame2("Add course to student course");
			f2.getB1().addActionListener((ActionEvent e1) -> {
				String name = f2.NameT().getText();
				String id = f2.IdT().getText();
				String line = "2 " + name + " " + id + " " + theView.getNameS() + " " + theView.getIDS();
				// System.out.println(theView.getNameS()+theView.getIDS());
				String ret = client.communicate(line) + "\n";
				theView.getTextArea().insert(ret, pos);
				f2.setVisible(false);
				// pos++;

			});
			f2.getB2().addActionListener((ActionEvent e1) -> {
				f2.setVisible(false);
			});

		}

	}

	class AddB3Listener implements ActionListener {
		/**
		 * action performer for B3
		 */
		public void actionPerformed(ActionEvent e) {
			// String name, id;
			f3 = new Frame3("remove course to student course");
			f3.getB1().addActionListener((ActionEvent e1) -> {
				String name = f3.NameT().getText();
				String id = f3.IdT().getText();
				String line = "3 " + name + " " + id;
				String ret = client.communicate(line) + "\n";
				theView.getTextArea().insert(ret, pos);
				f3.setVisible(false);

			});
			f3.getB2().addActionListener((ActionEvent e1) -> {
				f3.setVisible(false);
			});

		}

	}

	class AddB4Listener implements ActionListener {
		/**
		 * action performer for B4
		 */
		public void actionPerformed(ActionEvent e) {
			String line = "4 " + "allCourses" + " 0 ";

			String ret = client.communicate(line);
			ret = ret.trim().replaceAll("[&]{1,}", "\n");
			ret += "\n";
			ret += "-------------------------------------------------------";
			ret += "\n";
			theView.getTextArea().insert(ret, pos);
			// pos++;

		}

	}

	class AddB5Listener implements ActionListener {
		/**
		 * action performer for B5
		 */
		public void actionPerformed(ActionEvent e) {
			String line = "5 studentCourses 0";
			String ret = client.communicate(line);
			ret = ret.trim().replaceAll("[&]{1,}", "\n");
			ret += "\n";
			ret += "-------------------------------------------------------";
			ret += "\n";
			theView.getTextArea().insert(ret, pos);
			// pos++;

		}

	}

	class AddB6Listener implements ActionListener {
		/**
		 * action performer for B6
		 */
		public void actionPerformed(ActionEvent e) {
			String line = "6";
			String ret = client.communicate(line);
			theView.getTextArea().insert(ret, 0);
			// pos++;
			System.exit(1);

		}

	}

}