package com.Notepad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Save extends JFrame {

	private JPanel contentPane;
	private PrintWriter fileOut;
	public static void main(String[] args) {
		new Save();
	}

	public Save() {
		setTitle("Save Changes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 151);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDoYouWant = new JLabel("Do you want to save changes?");
		lblDoYouWant.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDoYouWant.setBounds(25, 21, 249, 21);
		contentPane.add(lblDoYouWant);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Notepad.file != null) {
					String text = "Hello, world!";
					try {
						
						fileOut = new PrintWriter(new FileWriter(Notepad.file, true));
						fileOut.println(Notepad.textArea.getText());
						fileOut.close();
					} catch (IOException ee) {
						System.out.println("IO: " + ee.getMessage());
					}
					// get the content of textArea then append to file
				} else {
					new SaveUs();
				}

				dispose();
			}
		});
		btnSave.setBounds(148, 74, 85, 21);
		contentPane.add(btnSave);

		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notepad.textArea.setText("");
				//Notepad.textAreaContent = "";
				Notepad.file = null;
				dispose();
				// set the File refference to null and the [textArea, message] to empty
			}
		});
		btnDiscard.setBounds(243, 74, 85, 21);
		contentPane.add(btnDiscard);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(341, 74, 85, 21);
		contentPane.add(btnCancel);
		setVisible(true);
	}
}
