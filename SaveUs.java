package com.Notepad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.awt.event.ActionEvent;

public class SaveUs extends JFrame {

	private JPanel contentPane;
	private JTextField tfFileName;
	private JTextField tfDirectory;
	private String location="";
	public static void main(String[] args) {
		new SaveUs();

	}

	public SaveUs() {
		setTitle("Save Us");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 445, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("File Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 74, 28);
		contentPane.add(lblNewLabel);

		JLabel lblBrowse = new JLabel("Location");
		lblBrowse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBrowse.setBounds(10, 36, 74, 26);
		contentPane.add(lblBrowse);

		tfFileName = new JTextField();
		tfFileName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfFileName.setBounds(94, 16, 293, 21);
		contentPane.add(tfFileName);
		tfFileName.setColumns(10);

		tfDirectory = new JTextField();
		tfDirectory.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfDirectory.setBounds(94, 41, 293, 21);
		contentPane.add(tfDirectory);
		tfDirectory.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String fileName = tfFileName.getText();
//				String directory = tfDirectory.getText();
//				if (tfFileName.getText().equalsIgnoreCase(""))fileName="Untitled";
//				if (tfDirectory.getText().equalsIgnoreCase(""))directory=""
				try {

					Notepad.file = new File(tfDirectory.getText()+"//"+(tfFileName.getText()+".txt"));
					Writer w = new FileWriter(Notepad.file);
					w.write(Notepad.textArea.getText());
					w.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnSave.setBounds(184, 71, 85, 21);
		contentPane.add(btnSave);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File fileDir; // user-specified file or directory
				File[] files; // array of files in specified directory
				String path = ""; // path of selected file
				JFileChooser chooser = new JFileChooser(".");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showOpenDialog(null);

				fileDir = chooser.getSelectedFile();
				if (fileDir.isDirectory()) {
					location += String.format("%s", fileDir.getPath());
				}
				tfDirectory.setText(location);

			}
		});
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBrowse.setBounds(397, 40, 24, 20);
		contentPane.add(btnBrowse);
		
		JLabel lbltxt = new JLabel(".txt");
		lbltxt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbltxt.setBounds(397, 20, 24, 13);
		contentPane.add(lbltxt);
		setVisible(true);
	}
}
