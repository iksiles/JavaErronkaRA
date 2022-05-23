package ERRONKA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class autoGehi extends JFrame {

	private JPanel contentPane;
	
	private JTextField textBastz, textMatrikula, textMarka, textModelo, textJabeNan;
	private JLabel lblLanNan, lblLanIzn, lblLanAbz, lblLanDpto, lblLanTel;
	private JButton btnGorde, btnIrten;

	public void autoGehi() {
		getContentPane().setLayout(null);
		autoGehi autoGehiframe = new autoGehi();
		autoGehiframe.setBounds(0,0,480,550);
		autoGehiframe.setVisible(true);
		autoGehiframe.setResizable(false);
		autoGehiframe.setLocationRelativeTo(null);
	}
	
	public autoGehi() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 550);
		getContentPane().setLayout(null);
		
		textBastz = new JTextField();
		TextPrompt textNanLanT = new TextPrompt("1a2b3c4d5e6f7g89...", textBastz);
		textBastz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textBastz.setBounds(190, 105, 200, 30);
		getContentPane().add(textBastz);
		textBastz.setColumns(10);
		
		textMatrikula = new JTextField();
		TextPrompt textIzenaLanT = new TextPrompt("8384LJM...", textMatrikula);
		textMatrikula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMatrikula.setColumns(10);
		textMatrikula.setBounds(190, 165, 200, 30);
		getContentPane().add(textMatrikula);
		
		textMarka = new JTextField();
		TextPrompt textAbizenaLanT = new TextPrompt("Ford...", textMarka);
		textMarka.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMarka.setColumns(10);
		textMarka.setBounds(190, 225, 200, 30);
		getContentPane().add(textMarka);
		
		textModelo = new JTextField();
		TextPrompt textDptoznbkT = new TextPrompt("Focus...", textModelo);
		textModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textModelo.setColumns(10);
		textModelo.setBounds(190, 285, 200, 30);
		getContentPane().add(textModelo);
		
		textJabeNan = new JTextField();
		TextPrompt textTelfLanT = new TextPrompt("12345678K...", textJabeNan);
		textJabeNan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textJabeNan.setColumns(10);
		textJabeNan.setBounds(190, 345, 200, 30);
		getContentPane().add(textJabeNan);
		
		lblLanNan = new JLabel("Bastidore zenbakia:");
		lblLanNan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanNan.setBounds(60, 115, 120, 13);
		getContentPane().add(lblLanNan);
		
		lblLanIzn = new JLabel("Matrikula:");
		lblLanIzn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanIzn.setBounds(60, 175, 85, 13);
		getContentPane().add(lblLanIzn);
		
		lblLanAbz = new JLabel("Marka:");
		lblLanAbz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanAbz.setBounds(60, 235, 85, 13);
		getContentPane().add(lblLanAbz);
		
		lblLanTel = new JLabel("Modeloa:");
		lblLanTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanTel.setBounds(60, 293, 120, 13);
		getContentPane().add(lblLanTel);
		
		lblLanDpto = new JLabel("Jabe Nan:");
		lblLanDpto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanDpto.setBounds(60, 353, 120, 13);
		getContentPane().add(lblLanDpto);
		
		btnGorde = new JButton("Gorde");
		btnGorde.setBackground(login.berdeArgia);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textKonpro()) {
					autoGorde();
				}
			}
		});
		btnGorde.setBounds(305, 423, 85, 21);
		getContentPane().add(btnGorde);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToAut();
			}
		});
		btnIrten.setBounds(305, 33, 85, 21);
		getContentPane().add(btnIrten);
	
	}
	
	public boolean textKonpro() {
		login.AutoakKargatu();
		login.BezeroakKargatu();
		if (!textBastz.getText().equals("")) {
			for(int i=0; i<login.autoakAL.size(); i++) {
				if(textBastz.getText().equals(login.autoakAL.get(i).bast_znbk)) {
					JOptionPane.showMessageDialog(null,(String)"Auto hau datu basean dago","Error", JOptionPane.ERROR_MESSAGE,null);
				}
			}
		}
		if(textMatrikula.getText().equals("")) {
			if(textMarka.getText().equals("")) {
				if(textModelo.getText().equals("")) {
					JOptionPane.showMessageDialog(null,(String)"Datuak falta dira","Error", JOptionPane.ERROR_MESSAGE,null);
					return false;
				}
			}
		}
		for(int i=0; i<=login.bezeroakAL.size(); i++) {
			if(textJabeNan.getText().equals(login.bezeroakAL.get(i).nan)) {	
				return true;
			}
		}
		JOptionPane.showMessageDialog(null,(String)"Bezero hau ez da existitzen, konprobatu nan-a ondo dagoen","Error", JOptionPane.ERROR_MESSAGE,null);
		return false;
	}
	
	public void autoGorde() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.executeUpdate("INSERT INTO ibilgailuak VALUES ('"+textBastz.getText()+"','"+textMatrikula.getText()+"','"+textMarka.getText()+"','"+textModelo.getText()+"','"+textJabeNan.getText()+"')");
			
			login.AutoakKargatu();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null,(String)"Auto hau existitzen da, Bastidore zenbakia ezin da errepikatu","Error", JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	public void GoToAut() {
		autoak iraautoak = new autoak();
		iraautoak.autoak();
		setVisible(false);
	}
}
