package ERRONKA;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class login extends JFrame implements Runnable{
	
	public static Color urdin_argia = new Color(207, 226, 243);
	private JTextField textErab;
	private JPasswordField passField;
	private JLabel lblerab , lblpass;
	private JButton btnLogin;
	private JPanel panel;
	
	public static Color berdeArgia = new Color (147, 196 , 125);
	public static Color berdeIluna = new Color (182, 215 , 168);
	
	public static ArrayList<pertsona> pertsonakAL = new ArrayList<pertsona>();
	public static ArrayList<faktura> amaiFakAL = new ArrayList<faktura>();
	public static ArrayList<faktura> amaigabFakAL = new ArrayList<faktura>();
	public static ArrayList<bezeroak> bezeroakAL = new ArrayList<bezeroak>();
	public static ArrayList<langileak> langileakAL = new ArrayList<langileak>();
	public static ArrayList<piezak> piezakAL = new ArrayList<piezak>();
	public static ArrayList<ibilgailuak> autoakAL = new ArrayList<ibilgailuak>();
	public static ArrayList<hornitzaileak> hornitzaileakAL = new ArrayList<hornitzaileak>(); 
	public static erab active_erab;
	public static faktura active_fak;
	public static langileak active_langile;
	public static bezeroak active_bezeroa;
	public static piezak active_pieza;
	public static ibilgailuak active_aut;
	public static hornitzaileak active_hor;
	
	public void login() {
		login loginframe = new login();
		loginframe.setBounds(0,0,900,550);
		loginframe.setVisible(true);
		loginframe.setResizable(false);
		loginframe.setLocationRelativeTo(null);
	}
	
	public login() {

	setBounds(100, 100, 900, 550);
	getContentPane().setBackground(berdeIluna);
	setTitle("Login");
	getContentPane().setLayout(null);
	
	panel = new JPanel();
	panel.setBackground(berdeArgia);
	panel.setBounds(0, 0, 305, 513);
	getContentPane().add(panel);
	
	textErab = new JTextField();
	textErab.setFont(new Font("Tahoma", Font.PLAIN, 14));
	TextPrompt textErabT = new TextPrompt("Erabiltzailea...", textErab);
	textErab.setBounds(520, 164, 285, 35);
	getContentPane().add(textErab);
	textErab.setColumns(10);
	
	passField = new JPasswordField();
	passField.setFont(new Font("Tahoma", Font.PLAIN, 14));
	TextPrompt passFieldT = new TextPrompt("Pasahitza...", passField);
	passField.setBounds(520, 232, 285, 35);
	getContentPane().add(passField);
	
	btnLogin = new JButton("Login");
	btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnLogin.setBackground(berdeArgia);
	btnLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (Login()) {
				GoToMenu();
				if(konexioa()) {
					Konektatuta();
					PertsonaKargatu();
					BezeroakKargatu();
				}
				else {
					BerriroEgin();
				}
			}
			else {					
				JOptionPane.showMessageDialog(null,(String)"Erabiltzaile edo pasahitz okerra","Error", JOptionPane.ERROR_MESSAGE,null);
			}
		}
	}); 
	btnLogin.setBounds(691, 327, 96, 35);
	getContentPane().add(btnLogin);
	
	lblerab = new JLabel("Erabiltzaiela:");
	lblerab.setBackground(new Color(102, 204, 0));
	lblerab.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblerab.setBounds(425, 174, 85, 13);
	getContentPane().add(lblerab);
	
	lblpass = new JLabel("Pasahitza:");
	lblpass.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblpass.setBounds(425, 244, 85, 13);
	getContentPane().add(lblpass);
	
	}
	
	public boolean Login() {
		for (int i=0 ; i<index.erabAL.size() ; i++) {
			if (textErab.getText().equals(index.erabAL.get(i).erab)) {
				if (passField.getText().equals(index.erabAL.get(i).pass)) {
					active_erab = index.erabAL.get(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);
	}
	
	public static boolean konexioa() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.close();
			konekta.close();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
	}
	
	public static void Konektatuta() {
		menu.lblEstado.setText("Konektatuta");
	}
	
	public static void EzKonektatuta() {
		menu.lblEstado.setText("Konektatu gabe");
	}
	
	public static void BerriroEgin() {
		JOptionPane.showMessageDialog(null,(String)"Ez zaude konektatuta, biztu zerbitzaria eta berriro sahiatu","Error", JOptionPane.ERROR_MESSAGE,null);		
		EzKonektatuta();
	}
	
	public static void PertsonaKargatu() {
		pertsonakAL.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM pertsona");
			while (rs.next()) {
				pertsonakAL.add(new pertsona(String.valueOf(rs.getObject("NAN")) , String.valueOf(rs.getObject("Izena")) , String.valueOf(rs.getObject("Abizena")) , Integer.parseInt(String.valueOf(rs.getObject("Telefono_zenbakia")))));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void BezeroakKargatu() {
		bezeroakAL.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st2 = konekta.createStatement();
			ResultSet rs1 = st2.executeQuery("SELECT * FROM bezeroak");
			while (rs1.next()) {
				for(int i=0; i<pertsonakAL.size(); i++) {
					if(pertsonakAL.get(i).getNan().equals(String.valueOf(rs1.getObject("Bezero_nan")))) {
						bezeroakAL.add(new bezeroak(pertsonakAL.get(i), String.valueOf(rs1.getObject("Email")) , String.valueOf(rs1.getObject("Kalea")) , String.valueOf(rs1.getObject("Portala")) , String.valueOf(rs1.getObject("Pisua")) , Integer.parseInt(String.valueOf(rs1.getObject("Posta_kodea")))));	
						break;
					}
				}
			}			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void LangileakKargatu() {
		langileakAL.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st2 = konekta.createStatement();
			ResultSet rs1 = st2.executeQuery("SELECT * FROM langileak");
			while (rs1.next()) {
				for(int i=0; i<pertsonakAL.size(); i++) {
					if(pertsonakAL.get(i).getNan().equals(String.valueOf(rs1.getObject("Langile_nan")))) {
						langileakAL.add(new langileak(pertsonakAL.get(i) , Integer.parseInt(String.valueOf(rs1.getObject("Departamentu_id")))));	
						break;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void AutoakKargatu() {
		autoakAL.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ibilgailuak");
			while (rs.next()) {
				autoakAL.add(new ibilgailuak(String.valueOf(rs.getObject("Bastidore_zenbakia")) , String.valueOf(rs.getObject("Matrikula")) , String.valueOf(rs.getObject("Marka")) , String.valueOf(rs.getObject("Modeloa")) , String.valueOf(rs.getObject("Bezero_nan"))));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void PiezakKargatu() {
		piezakAL.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM stock");
			while (rs.next()) {
				piezakAL.add(new piezak(Integer.parseInt(String.valueOf(rs.getObject("pieza_kod"))) , String.valueOf(rs.getObject("pieza_izn")) , Double.parseDouble(String.valueOf(rs.getObject("pieza_prz"))) , Integer.parseInt(String.valueOf(rs.getObject("pieza_kop"))) , Integer.parseInt(String.valueOf(rs.getObject("hor_kod")))));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void horKargatu() {
		hornitzaileakAL.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM hornitzaileak");
			while (rs.next()) {
				hornitzaileakAL.add(new hornitzaileak(Integer.parseInt(String.valueOf(rs.getObject("hor_kod"))) , String.valueOf(rs.getObject("hor_izn")) , String.valueOf(rs.getObject("hor_helbide"))));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void amaiFakturakKargatu() {
		piezakAL.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM fakturak WHERE Amaituta = 'BAI'");
			while (rs.next()) {
				amaiFakAL.add(new faktura(Integer.parseInt(String.valueOf(rs.getObject("faktura_id"))) , Double.parseDouble(String.valueOf(rs.getObject("Prezioa"))) , String.valueOf(rs.getObject("Data")) , String.valueOf(rs.getObject("Fitxategi_izena")) , String.valueOf(rs.getObject("Bezero_NAN")) , String.valueOf(rs.getObject("Langile_NAN")) , String.valueOf(rs.getObject("Amaituta"))));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void amaigabeFakturakKargatu() {
		piezakAL.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM fakturak WHERE Amaituta = 'EZ'");
			while (rs.next()) {
				amaigabFakAL.add(new faktura(Integer.parseInt(String.valueOf(rs.getObject("faktura_id"))) , Double.parseDouble(String.valueOf(rs.getObject("Prezioa"))) , String.valueOf(rs.getObject("Data")) , String.valueOf(rs.getObject("Fitxategi_izena")) , String.valueOf(rs.getObject("Bezero_NAN")) , String.valueOf(rs.getObject("Langile_NAN")) , String.valueOf(rs.getObject("Amaituta"))));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
