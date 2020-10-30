package com.Notepad;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Fonts extends JFrame {
	private JFrame fr=new JFrame();
	
	static private String[] font = new String[] { "Arial", "Arial Black", "Arial Narrow", "Calibri", "Calibri Ligth",
			"Cambria" };
	static private int textSize, indexSelected, textStyle;
	static private String textFont;
	

	public static void main(String[] args) {
		new Fonts();
	}

	public Fonts() {
		
		fr.setTitle("Fonts");
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setSize(380, 470);
		fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		fr.getContentPane().setLayout(null);

		content();
		fr.setVisible(true);
		
	}
	void content() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Size: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(28, 271, 325, 95);
		fr.getContentPane().add(panel);
		panel.setLayout(null);

		JSlider slider = new JSlider();
		slider.setMinimum(5);
		slider.setMaximum(99);
		slider.setValue(15);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int textSize = slider.getValue();
			}
		});
		slider.setBounds(10, 32, 305, 53);
		panel.add(slider);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Font Style: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(28, 144, 325, 117);
		fr.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JRadioButton rdbtnPlain = new JRadioButton("Plain");
		rdbtnPlain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPlain.isSelected())
					textStyle = 0;
			}
		});
		rdbtnPlain.setBounds(47, 46, 78, 21);
		JRadioButton rdbtnBold = new JRadioButton("Bold");
		rdbtnBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBold.isSelected())
					textStyle = 1;
			}
		});
		rdbtnBold.setBounds(127, 46, 78, 21);
		JRadioButton rdbtnItalic = new JRadioButton("Italic");
		rdbtnItalic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPlain.isSelected())
					textStyle = 2;
			}
		});
		rdbtnItalic.setBounds(207, 46, 78, 21);

		ButtonGroup style = new ButtonGroup();
		style.add(rdbtnPlain);
		style.add(rdbtnBold);
		style.add(rdbtnItalic);
		rdbtnPlain.setSelected(true);

		panel_1.add(rdbtnPlain);
		panel_1.add(rdbtnItalic);
		panel_1.add(rdbtnBold);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Font: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(28, 17, 325, 117);
		fr.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JComboBox comboBox = new JComboBox(font);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexSelected = comboBox.getSelectedIndex();
			}
		});
		comboBox.setBounds(81, 37, 149, 21);
		comboBox.setEditable(false);
		panel_2.add(comboBox);

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notepad.textArea.setFont(new Font(font[indexSelected], textStyle, textSize));;
				fr.dispose();
			}
		});
		ok.setBounds(177, 403, 85, 21);
		fr.getContentPane().add(ok);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fr.dispose();
			}
		});
		cancel.setBounds(268, 403, 85, 21);
		fr.getContentPane().add(cancel);
		
	}
	
}
