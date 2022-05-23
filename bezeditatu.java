package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

public class bezeditatu extends JFrame {

	private JPanel contentPane;
	private JTextField textNan , textIzn , textTlf , textDpto , textAbz , textKale , textPortal , textPisu , textKodPost , textEmail;
	private JButton btnIrten, btnGorde;

	public void bezeditatu() {
		getContentPane().setLayout(null);
		bezeditatu bezeditatuframe = new bezeditatu();
		bezeditatuframe.setBounds(0,0,700,490);
		bezeditatuframe.setVisible(true);
		bezeditatuframe.setResizable(false);
		bezeditatuframe.setLocationRelativeTo(null);
	}
	
	public bezeditatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 490);
		getContentPane().setLayout(null);
		
		textNan = new JTextField();
		textNan.setBounds(91, 46, 212, 37);
		getContentPane().add(textNan);
		textNan.setColumns(10);
		
		textIzn = new JTextField();
		textIzn.setColumns(10);
		textIzn.setBounds(91, 120, 212, 37);
		getContentPane().add(textIzn);
		
		textAbz = new JTextField();
		textAbz.setColumns(10);
		textAbz.setBounds(366, 120, 212, 37);
		getContentPane().add(textAbz);
		
		textTlf = new JTextField();
		textTlf.setColumns(10);
		textTlf.setBounds(366, 46, 212, 37);
		getContentPane().add(textTlf);
		
		textKale = new JTextField();
		textKale.setColumns(10);
		textKale.setBounds(91, 198, 212, 37);
		getContentPane().add(textKale);
		
		textPortal = new JTextField();
		textPortal.setColumns(10);
		textPortal.setBounds(366, 198, 212, 37);
		getContentPane().add(textPortal);
		
		textPisu = new JTextField();
		textPisu.setColumns(10);
		textPisu.setBounds(91, 276, 212, 37);
		getContentPane().add(textPisu);
		
		textKodPost = new JTextField();
		textKodPost.setColumns(10);
		textKodPost.setBounds(366, 276, 212, 37);
		getContentPane().add(textKodPost);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(229, 351, 212, 37);
		getContentPane().add(textEmail);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(591, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToBez();
			}
		});
		getContentPane().add(btnIrten);
		
		btnGorde = new JButton("Datuak gorde");
		btnGorde.setBackground(login.berdeArgia);
		btnGorde.setBounds(485, 395, 93, 27);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatuakAldatu();
			}
		});
		getContentPane().add(btnGorde);
		
		BezKargatu();
	}
	
	public void GoToBez() {
		bezkudeatu bezkudeatu = new bezkudeatu();
		bezkudeatu.bezkudeatu();
		setVisible(false);
	}
	
	public void BezKargatu() {
		textNan.setText(login.active_bezeroa.nan);
		textIzn.setText(login.active_bezeroa.izn);
		textAbz.setText(login.active_bezeroa.abz);
		textTlf.setText(String.valueOf(login.active_bezeroa.tlf));
		textKale.setText(login.active_bezeroa.kale);
		textPortal.setText(login.active_bezeroa.prtl);
		textPisu.setText(login.active_bezeroa.pisu);
		textKodPost.setText(String.valueOf(login.active_bezeroa.kodpost));
		textEmail.setText(login.active_bezeroa.mail);
		}

	
	public void DatuakAldatu() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			if (!textIzn.getText().equals(login.active_bezeroa.izn)) {
				st.executeUpdate("UPDATE pertsona SET Izena = '"+textIzn.getText()+"' WHERE NAN = '"+login.active_bezeroa.nan+"'");
				login.active_bezeroa.izn = textIzn.getText();}
			if (!textAbz.getText().equals(login.active_bezeroa.abz)) {
				st.executeUpdate("UPDATE pertsona SET Abizena = '"+textAbz.getText()+"' WHERE NAN = '"+login.active_bezeroa.nan+"'");
				login.active_bezeroa.abz = textAbz.getText();}
			if (!textTlf.getText().equals(login.active_bezeroa.tlf)) {
				st.executeUpdate("UPDATE pertsona SET Telefono_zenbakia = '"+textTlf.getText()+"' WHERE NAN = '"+login.active_bezeroa.nan+"'");
				login.active_bezeroa.tlf = Integer.parseInt(textTlf.getText());}
			if (!textKale.getText().equals(login.active_bezeroa.kale)) {
				st.executeUpdate("UPDATE bezeroak SET Kalea = '"+textKale.getText()+"' WHERE NAN = '"+login.active_bezeroa.nan+"'");
				login.active_bezeroa.kale = textKale.getText();}
			if (!textPortal.getText().equals(login.active_bezeroa.prtl)) {
				st.executeUpdate("UPDATE bezeroak SET Portala = '"+textPortal.getText()+"' WHERE NAN = '"+login.active_bezeroa.nan+"'");
				login.active_bezeroa.prtl = textPortal.getText();}
			if (!textPisu.getText().equals(login.active_bezeroa.pisu)) {
				st.executeUpdate("UPDATE pertsona SET Pisua = '"+textPisu.getText()+"' WHERE NAN = '"+login.active_bezeroa.nan+"'");
				login.active_bezeroa.pisu = textPisu.getText();}
			if (!textKodPost.getText().equals(login.active_bezeroa.kodpost)) {
				st.executeUpdate("UPDATE pertsona SET Telefono_zenbakia = '"+textKodPost.getText()+"' WHERE NAN = '"+login.active_bezeroa.nan+"'");
				login.active_bezeroa.kodpost = Integer.parseInt(textKodPost.getText());}
			if (!textEmail.getText().equals(login.active_bezeroa.mail)) {
				st.executeUpdate("UPDATE pertsona SET Email = '"+textEmail.getText()+"' WHERE NAN = '"+login.active_bezeroa.nan+"'");
				login.active_bezeroa.mail = textEmail.getText();}
			login.PertsonaKargatu();
			login.BezeroakKargatu();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
