package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingManual {

	public static void main(String[] args) {
		JFrame jf = new JFrame("Mi ventanita");
		jf.setBounds(0, 0, 500, 400);
		
		Container cp = jf.getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JTextField tf = new JTextField(20);
		cp.add(tf);
		
		JButton b = new JButton("Saludar");
		cp.add(b);
		
		JLabel l = new JLabel("Introduce tu nombre");
		cp.add(l);
		
		// Se le pasa a addActionListener 
		// una clase anónima
		// que implementa el interface ActionListener
		// que necesita el método actionPerformed
//		b.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				l.setText("Hola " + tf.getText());
//			}
//		});
		
		b.addActionListener(e -> l.setText("Hola " + tf.getText()));
		
		jf.setVisible(true);
	}

}
