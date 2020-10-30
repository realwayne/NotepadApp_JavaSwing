package com.Notepad;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Notepad {

	private JFrame frame;
	static JTextArea textArea;
	//static String textAreaContent = "";
	static File file;

	static Notepad NOTE;

	static void Start() {
		NOTE = new Notepad();
	}

	public static void main(String[] args) {
		Notepad.Start();
	}

	public Notepad() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 559, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Notepad.file!=null) {
					new Save();
				}else{
					if (!(Notepad.textArea.getText().equalsIgnoreCase(""))) new Save();
					//else Notepad.textArea.setText("");
				}
			}
		});
		mnFile.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open...");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File fileDir; // user-specified file or directory
				File[] files; // array of files in specified directory
				String path = ""; // path of selected file
				JFileChooser chooser = new JFileChooser(".");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(null);

				Notepad.file = chooser.getSelectedFile();
				if (Notepad.file.isFile()) {
					path += String.format("%s", Notepad.file.getPath());
				}

				/////////////////////////////////////////////////////////////////////
				textArea.setText("");
				Notepad.file = new File(path);
				String message = "";
				Scanner s;
				try {
					s = new Scanner(new FileReader(path));
					while (s.hasNextLine()) {
						message += s.nextLine();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				textArea.setText(message);
			}
		});
		mnFile.add(mntmNewMenuItem_1);

		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Notepad.file!=null) {
					PrintWriter fileOut;
					try {
						fileOut = new PrintWriter(new FileWriter(Notepad.file.getPath(), true));
						fileOut.println(Notepad.textArea.getText());
						fileOut.close();
					} catch (IOException ee) {
						System.out.println("IO: " + ee.getMessage());
					}
				}
				// PrintWriter pw=new PrintWriter();
				// then append to the file
				
			}
		});
		mnFile.add(mntmSave);

		JMenuItem mntmSaveUs = new JMenuItem("Save As...");
		mntmSaveUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaveUs();
			}
		});
		mnFile.add(mntmSaveUs);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);

		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);

		JSeparator separator_2 = new JSeparator();
		mnEdit.add(separator_2);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);

		JSeparator separator_3 = new JSeparator();
		mnEdit.add(separator_3);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnEdit.add(mntmDelete);

		JMenu mnFormat = new JMenu("Format");
		menuBar.add(mnFormat);

		JCheckBox chckbxWordWrapp = new JCheckBox("Word Wrapp");
		chckbxWordWrapp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxWordWrapp.isSelected()) {
					textArea.setWrapStyleWord(true);
					textArea.setLineWrap(true);
				} else {
					textArea.setWrapStyleWord(false);
					textArea.setLineWrap(false);
				}
			}
		});
		mnFormat.add(chckbxWordWrapp);

		JSeparator separator_7 = new JSeparator();
		mnFormat.add(separator_7);

		JSeparator separator_6 = new JSeparator();
		mnFormat.add(separator_6);

		JMenuItem mntmFont = new JMenuItem("Font");
		mntmFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fonts f = new Fonts();
				// textArea.setFont(f.content());
			}
		});
		mnFormat.add(mntmFont);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmViewHelp = new JMenuItem("View Help");
		mntmViewHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help.help();
			}
		});
		mnHelp.add(mntmViewHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help.about();
			}
		});

		JSeparator separator_4 = new JSeparator();
		mnHelp.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		mnHelp.add(separator_5);

		mnHelp.add(mntmAbout);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setTabSize(4);
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(false);
		scrollPane.setViewportView(textArea);
	}

}
