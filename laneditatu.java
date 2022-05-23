package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class laneditatu extends JFrame {

	private JPanel contentPane;
	private JTextField textNan , textIzn , textTlf , textDpto , textAbz;
	private JButton btnIrten , btnGorde;

	public void laneditatu() {
		getContentPane().setLayout(null);
		laneditatu laneditatuframe = new laneditatu();
		laneditatuframe.setBounds(0,0,700,400);
		laneditatuframe.setVisible(true);
		laneditatuframe.setResizable(false);
		laneditatuframe.setLocationRelativeTo(null);
	}
	
	public laneditatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(null);
		
		textNan = new JTextField();
		textNan.setBounds(91, 68, 212, 37);
		getContentPane().add(textNan);
		textNan.setColumns(10);
		
		textIzn = new JTextField();
		textIzn.setColumns(10);
		textIzn.setBounds(91, 150, 212, 37);
		getContentPane().add(textIzn);
		
		textAbz = new JTextField();
		textAbz.setColumns(10);
		textAbz.setBounds(366, 150, 212, 37);
		getContentPane().add(textAbz);
		
		textTlf = new JTextField();
		textTlf.setColumns(10);
		textTlf.setBounds(366, 68, 212, 37);
		getContentPane().add(textTlf);
		
		textDpto = new JTextField();
		textDpto.setColumns(10);
		textDpto.setBounds(232, 232, 212, 37);
		getContentPane().add(textDpto);
		
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
		
		LanKargatu();
	}
	
	public void GoToLan() {
		lankudeatu lankudeatu = new lankudeatu();
		lankudeatu.lankudeatu();
		setVisible(false);
	}
	
	public void LanKargatu() {
		textNan.setText(login.active_langile.nan);
		textIzn.setText(login.active_langile.izn);
		textAbz.setText(login.active_langile.abz);
		textTlf.setText(String.valueOf(login.active_langile.tlf));
		textDpto.setText(String.valueOf(login.active_langile.dpto_znbk));
	}
	
	public void DatuakAldatu() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			if (!textIzn.getText().equals(login.active_langile.izn)) {
				st.executeUpdate("UPDATE pertsona SET Izena = '"+textIzn.getText()+"' WHERE NAN = '"+login.active_langile.nan+"'");
				login.active_langile.izn = textIzn.getText();}
			if (!textAbz.getText().equals(login.active_langile.abz)) {
				st.executeUpdate("UPDATE pertsona SET Abizena = '"+textAbz.getText()+"' WHERE NAN = '"+login.active_langile.nan+"'");
				login.active_langile.abz = textAbz.getText();}
			if(!textTlf.getText().equals(login.active_langile.tlf)) {
				st.executeUpdate("UPDATE pertsona SET Telefono_zenbakia = '"+textTlf.getText()+"' WHERE NAN = '"+login.active_langile.nan+"'");
				login.active_langile.tlf = Integer.parseInt(textTlf.getText());}
			if(!textDpto.getText().equals(login.active_langile.dpto_znbk)) {
				st.executeUpdate("UPDATE langileak SET Departamentu_id = '"+textDpto.getText()+"' WHERE Langile_Nan = '"+login.active_langile.nan+"'");
				login.active_langile.dpto_znbk = Integer.parseInt(textDpto.getText());}
			login.PertsonaKargatu();
			login.LangileakKargatu();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
