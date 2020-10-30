package com.Notepad;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Help {
	
	private Help() {}//uninstanciable
	
	public static void help() {
		JPanel panel;
		JPanel panel_1;
		JPanel panel_2;
		JPanel panel_3;
		JTextArea txtrFileMenuContains;
		JTextArea txtrEditMenuContains;
		JTextArea txtrFormatMenuContains;
		JTextArea txtrHelpMenuContains;
		JFrame helpFrame=new JFrame();
		helpFrame.setTitle("Help");
		helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		helpFrame.setSize(393, 513);
		helpFrame.setResizable(false);
		helpFrame.setLocationRelativeTo(null);
		helpFrame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "File", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 365, 94);
		helpFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtrFileMenuContains = new JTextArea();
		txtrFileMenuContains.setBounds(10, 20, 345, 64);
		txtrFileMenuContains.setLineWrap(true);
		txtrFileMenuContains.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrFileMenuContains.setEditable(false);
		txtrFileMenuContains.setWrapStyleWord(true);
		txtrFileMenuContains.setText("File menu contains functions for Creatig Files and Saving Files");
		panel.add(txtrFileMenuContains);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 126, 365, 94);
		helpFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtrEditMenuContains = new JTextArea();
		txtrEditMenuContains.setWrapStyleWord(true);
		txtrEditMenuContains.setLineWrap(true);
		txtrEditMenuContains.setEditable(false);
		txtrEditMenuContains.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrEditMenuContains.setText("Edit menu contains functions for modifying the contents of the file");
		txtrEditMenuContains.setBounds(10, 20, 345, 64);
		panel_1.add(txtrEditMenuContains);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 248, 365, 100);
		helpFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		txtrFormatMenuContains = new JTextArea();
		txtrFormatMenuContains.setWrapStyleWord(true);
		txtrFormatMenuContains.setLineWrap(true);
		txtrFormatMenuContains.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrFormatMenuContains.setEditable(false);
		txtrFormatMenuContains.setText("Format menu contains functions for formating the text of the file");
		txtrFormatMenuContains.setBounds(10, 21, 345, 69);
		panel_2.add(txtrFormatMenuContains);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Help", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 374, 365, 86);
		helpFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		txtrHelpMenuContains = new JTextArea();
		txtrHelpMenuContains.setWrapStyleWord(true);
		txtrHelpMenuContains.setLineWrap(true);
		txtrHelpMenuContains.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrHelpMenuContains.setEditable(false);
		txtrHelpMenuContains.setText("Help menu contains function for learnign the app and information about the authors");
		txtrHelpMenuContains.setBounds(10, 18, 345, 58);
		panel_3.add(txtrHelpMenuContains);
		
		helpFrame.setVisible(true);
	}
	public static void about() {
		JFrame aboutFrame=new JFrame();
		
		aboutFrame.setTitle("About");
		aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aboutFrame.setSize(300, 167);
		aboutFrame.setResizable(false);
		aboutFrame.setLocationRelativeTo(null);
		aboutFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 10, 241, 106);
		aboutFrame.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblRealwayneAGonzales = new JLabel("Realwayne A. Gonzales");
		lblRealwayneAGonzales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRealwayneAGonzales.setBounds(52, 10, 145, 23);
		panel.add(lblRealwayneAGonzales);
		JLabel lblSunshineA = new JLabel("Sunshine A . Dela Cruz");
		lblSunshineA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSunshineA.setBounds(52, 43, 145, 23);
		panel.add(lblSunshineA);
		JLabel lblJulietAlba = new JLabel("Juliet P. Alba");
		lblJulietAlba.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJulietAlba.setBounds(52, 73, 145, 23);
		panel.add(lblJulietAlba);
		
		Border b=BorderFactory.createTitledBorder("Authors");
		panel.setBorder(b);
		aboutFrame.setVisible(true);
	}
}
