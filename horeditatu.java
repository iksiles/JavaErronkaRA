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

public class horeditatu extends JFrame {

	private JPanel contentPane;
	private JTextField textHKod , textHelb , textHizn;
	private JButton btnIrten , btnGorde;

	
	public void horeditatu() {
		getContentPane().setLayout(null);
		horeditatu horeditatuframe = new horeditatu();
		horeditatuframe.setBounds(0,0,700,400);
		horeditatuframe.setVisible(true);
		horeditatuframe.setResizable(false);
		horeditatuframe.setLocationRelativeTo(null);
	}
	
	public horeditatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 298);
		getContentPane().setLayout(null);
		
		textHKod = new JTextField();
		textHKod.setBounds(158, 68, 56, 37);
		getContentPane().add(textHKod);
		textHKod.setColumns(10);
		
		textHizn = new JTextField();
		textHizn.setBounds(327, 68, 251, 37);
		getContentPane().add(textHizn);
		textHizn.setColumns(10);
		
		textHelb = new JTextField();
		textHelb.setColumns(10);
		textHelb.setBounds(91, 140, 487, 37);
		getContentPane().add(textHelb);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(591, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToHor();
			}
		});
		getContentPane().add(btnIrten);
		
		btnGorde = new JButton("Datuak gorde");
		btnGorde.setBackground(login.berdeArgia);
		btnGorde.setBounds(485, 208, 93, 27);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatuakAldatu();
			}
		});
		getContentPane().add(btnGorde);
		
		horKargatu();
		
	}
	
	public void GoToHor() {
		horkudeatu horkudeatu = new horkudeatu();
		horkudeatu.horkudeatu();
		setVisible(false);
	}
	
	public void horKargatu() {
		textHKod.setText(String.valueOf(login.active_hor.hor_kod));
		textHizn.setText(login.active_hor.hor_izn);
		textHelb.setText(login.active_hor.hor_helb);
	}
	
	public void DatuakAldatu() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			if (!textHKod.getText().equals(login.active_hor.hor_kod)) {
				st.executeUpdate("UPDATE hornitzaileak SET hor_kod = '"+textHKod.getText()+"' WHERE pieza_kod = '"+login.active_hor.hor_kod+"'");
				login.active_hor.hor_kod = Integer.parseInt(textHKod.getText());}
			if (!textHizn.getText().equals(login.active_hor.hor_izn)) {
				st.executeUpdate("UPDATE hornitzaileak SET hor_izn = '"+textHizn.getText()+"' WHERE pieza_kod = '"+login.active_hor.hor_kod+"'");
				login.active_hor.hor_izn = textHizn.getText();}
			if (!textHelb.getText().equals(login.active_hor.hor_helb)) {
				st.executeUpdate("UPDATE hornitzaileak SET hor_helbide = '"+textHelb.getText()+"' WHERE pieza_kod = '"+login.active_hor.hor_kod+"'");
				login.active_hor.hor_helb = textHelb.getText();}
			login.horKargatu();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
