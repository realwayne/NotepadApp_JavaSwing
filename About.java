package com.Notepad;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class About extends JFrame {
	
	public About() {
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 167);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 10, 241, 106);
		getContentPane().add(panel);
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
		setVisible(true);
	}

	public static void main(String[] args) {
		new About();
	}

}
