package ERRONKA;

import java.awt.BorderLayout;
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

public class piezakeditatu extends JFrame {

	private JPanel contentPane;
	private JTextField textPKod , textPIzn , textPPrz , textPKop , textHKod;
	private JButton btnIrten , btnGorde;

	public void piezakeditatu() {
		getContentPane().setLayout(null);
		piezakeditatu piezakeditatuframe = new piezakeditatu();
		piezakeditatuframe.setBounds(0,0,700,400);
		piezakeditatuframe.setVisible(true);
		piezakeditatuframe.setResizable(false);
		piezakeditatuframe.setLocationRelativeTo(null);
	}
	public piezakeditatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(null);
		
		textPKod = new JTextField();
		textPKod.setBounds(91, 68, 212, 37);
		getContentPane().add(textPKod);
		textPKod.setColumns(10);
		
		textPIzn = new JTextField();
		textPIzn.setColumns(10);
		textPIzn.setBounds(91, 150, 212, 37);
		getContentPane().add(textPIzn);
		
		textPPrz = new JTextField();
		textPPrz.setColumns(10);
		textPPrz.setBounds(366, 150, 212, 37);
		getContentPane().add(textPPrz);
		
		textPKop = new JTextField();
		textPKop.setColumns(10);
		textPKop.setBounds(366, 68, 212, 37);
		getContentPane().add(textPKop);
		
		textHKod = new JTextField();
		textHKod.setColumns(10);
		textHKod.setBounds(232, 232, 212, 37);
		getContentPane().add(textHKod);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(591, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToP();
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
		
		piezakKargatu();
		
	}
	
	public void GoToP() {
		piezakkudeatu piezakkudeatu = new piezakkudeatu();
		piezakkudeatu.piezakkudeatu();
		setVisible(false);
	}
	
	public void piezakKargatu() {
		textPKod.setText(String.valueOf(login.active_pieza.pieza_kod));
		textPIzn.setText(login.active_pieza.pieza_izn);
		textPPrz.setText(String.valueOf(login.active_pieza.pieza_prz));
		textPKop.setText(String.valueOf(login.active_pieza.pieza_kop));
		textHKod.setText(String.valueOf(login.active_pieza.hor_kod));
	}
	
	public void DatuakAldatu() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			if (!textPIzn.getText().equals(login.active_pieza.pieza_izn)) {
				st.executeUpdate("UPDATE stock SET pieza_izn = '"+textPIzn.getText()+"' WHERE pieza_kod = '"+login.active_pieza.pieza_kod+"'");
				login.active_pieza.pieza_izn = textPIzn.getText();}
			if (!textPPrz.getText().equals(login.active_pieza.pieza_prz)) {
				st.executeUpdate("UPDATE stock SET pieza_prz = '"+textPPrz.getText()+"' WHERE pieza_kod = '"+login.active_pieza.pieza_kod+"'");
				login.active_pieza.pieza_prz = Integer.parseInt(textPPrz.getText());}
			if (!textPKop.getText().equals(login.active_pieza.pieza_kop)) {
				st.executeUpdate("UPDATE stock SET pieza_kop = '"+textPKop.getText()+"' WHERE pieza_kod = '"+login.active_pieza.pieza_kod+"'");
				login.active_pieza.pieza_kop = Integer.parseInt(textPKop.getText());}
			if (!textHKod.getText().equals(login.active_pieza.hor_kod)) {
				st.executeUpdate("UPDATE stock SET hor_kod = '"+textHKod.getText()+"' WHERE pieza_kod = '"+login.active_pieza.pieza_kod+"'");
				login.active_pieza.hor_kod = Integer.parseInt(textHKod.getText());}
			login.PiezakKargatu();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
