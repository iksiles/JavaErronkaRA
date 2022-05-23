package ERRONKA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class autoeditatu extends JFrame {

	private JPanel contentPane;
	private JTextField textBast , textMatr , textModelo , textJabeNan , textMarka;
	private JButton btnIrten , btnGorde , btnSupr;

	/**
	 * Launch the application.
	 */
	public void autoeditatu() {
		getContentPane().setLayout(null);
		autoeditatu autoeditatuframe = new autoeditatu();
		autoeditatuframe.setBounds(0,0,700,490);
		autoeditatuframe.setVisible(true);
		autoeditatuframe.setResizable(false);
		autoeditatuframe.setLocationRelativeTo(null);
	}

	public autoeditatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 490);
		getContentPane().setLayout(null);
		
		textBast = new JTextField();
		textBast.setBounds(91, 68, 212, 37);
		getContentPane().add(textBast);
		textBast.setColumns(10);
		
		textMatr = new JTextField();
		textMatr.setColumns(10);
		textMatr.setBounds(91, 150, 212, 37);
		getContentPane().add(textMatr);
		
		textMarka = new JTextField();
		textMarka.setColumns(10);
		textMarka.setBounds(366, 150, 212, 37);
		getContentPane().add(textMarka);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(366, 68, 212, 37);
		getContentPane().add(textModelo);
		
		textJabeNan = new JTextField();
		textJabeNan.setColumns(10);
		textJabeNan.setBounds(232, 232, 212, 37);
		getContentPane().add(textJabeNan);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(591, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToLan();
			}
		});
		getContentPane().add(btnIrten);
		
		btnGorde = new JButton("Datuak gorde");
		btnGorde.setBackground(login.berdeArgia);
		btnGorde.setBounds(485, 298, 93, 27);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatuakAldatu();
			}
		});
		getContentPane().add(btnGorde);
		
		autoKargatu();
	}
	
	public void GoToLan() {
		lankudeatu lankudeatu = new lankudeatu();
		lankudeatu.lankudeatu();
		setVisible(false);
	}
	
	public void autoKargatu() {
		textBast.setText(login.active_aut.bast_znbk);
		textMatr.setText(login.active_aut.matrikula);
		textMarka.setText(login.active_aut.marka);
		textModelo.setText(String.valueOf(login.active_aut.modeloa));
		textJabeNan.setText(String.valueOf(login.active_aut.bez_nan));
	}
	
	public void DatuakAldatu() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			if (!textMatr.getText().equals(login.active_aut.matrikula)) {
				st.executeUpdate("UPDATE ibilgailuak SET Matrikula = '"+textMatr.getText()+"' WHERE Bastidore_zenbakia = '"+login.active_aut.bast_znbk+"'");
				login.active_aut.matrikula = textMatr.getText();}
			if (!textMarka.getText().equals(login.active_aut.marka)) {
				st.executeUpdate("UPDATE ibilgailuak SET Marka = '"+textMarka.getText()+"' WHERE Bastidore_zenbakia = '"+login.active_aut.bast_znbk+"'");
				login.active_aut.marka = textMarka.getText();}
			if(!textModelo.getText().equals(login.active_aut.modeloa)) {
				st.executeUpdate("UPDATE ibilgailuak SET Modeloa = '"+textModelo.getText()+"' WHERE Bastidore_zenbakia = '"+login.active_aut.bast_znbk+"'");
				login.active_aut.modeloa = textModelo.getText();}
			if(!textJabeNan.getText().equals(login.active_aut.bez_nan)) {
				st.executeUpdate("UPDATE ibilgailuak SET Bezero_NAN = '"+textJabeNan.getText()+"' WHERE Bastidore_zenbakia = '"+login.active_aut.bast_znbk+"'");
				login.active_aut.bez_nan = textJabeNan.getText();}
			login.AutoakKargatu();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
