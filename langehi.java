package ERRONKA;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class langehi extends JFrame {

	private JPanel contentPane;
	private JTextField textNanLan, textIzenaLan, textAbizenaLan, textDptoznbk, textTelfLan;
	private JLabel lblLanNan, lblLanIzn, lblLanAbz, lblLanDpto, lblLanTel;
	private JButton btnGorde, btnIrten;

	public void langehi() {
		getContentPane().setLayout(null);
		langehi langehiframe = new langehi();
		langehiframe.setBounds(0,0,480,550);
		langehiframe.setVisible(true);
		langehiframe.setResizable(false);
		langehiframe.setLocationRelativeTo(null);
	}
	
	public langehi() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 550);
		getContentPane().setLayout(null);
		
		textNanLan = new JTextField();
		TextPrompt textNanLanT = new TextPrompt("88888888Z...", textNanLan);
		textNanLan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNanLan.setBounds(190, 105, 200, 30);
		getContentPane().add(textNanLan);
		textNanLan.setColumns(10);
		
		textIzenaLan = new JTextField();
		TextPrompt textIzenaLanT = new TextPrompt("Paco...", textIzenaLan);
		textIzenaLan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIzenaLan.setColumns(10);
		textIzenaLan.setBounds(190, 165, 200, 30);
		getContentPane().add(textIzenaLan);
		
		textAbizenaLan = new JTextField();
		TextPrompt textAbizenaLanT = new TextPrompt("Cabello...", textAbizenaLan);
		textAbizenaLan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAbizenaLan.setColumns(10);
		textAbizenaLan.setBounds(190, 225, 200, 30);
		getContentPane().add(textAbizenaLan);
		
		textTelfLan = new JTextField();
		TextPrompt textTelfLanT = new TextPrompt("666666666...", textTelfLan);
		textTelfLan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTelfLan.setColumns(10);
		textTelfLan.setBounds(190, 285, 200, 30);
		getContentPane().add(textTelfLan);
		
		textDptoznbk = new JTextField();
		TextPrompt textDptoznbkT = new TextPrompt("1 / 2 / 3 / 4...", textDptoznbk);
		textDptoznbk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDptoznbk.setColumns(10);
		textDptoznbk.setBounds(190, 345, 200, 30);
		getContentPane().add(textDptoznbk);
		
		lblLanNan = new JLabel("Nan:");
		lblLanNan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanNan.setBounds(60, 115, 85, 13);
		getContentPane().add(lblLanNan);
		
		lblLanIzn = new JLabel("Izena:");
		lblLanIzn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanIzn.setBounds(60, 175, 85, 13);
		getContentPane().add(lblLanIzn);
		
		lblLanAbz = new JLabel("Abizena:");
		lblLanAbz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanAbz.setBounds(60, 235, 85, 13);
		getContentPane().add(lblLanAbz);
		
		lblLanTel = new JLabel("Telf zenbakia:");
		lblLanTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanTel.setBounds(60, 293, 120, 13);
		getContentPane().add(lblLanTel);
		
		lblLanDpto = new JLabel("Dpto zenbakia:");
		lblLanDpto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanDpto.setBounds(60, 353, 120, 13);
		getContentPane().add(lblLanDpto);
		
		btnGorde = new JButton("Gorde");
		btnGorde.setBackground(login.berdeArgia);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textKonpro()) {
					langileGorde();
				}
				else {
					JOptionPane.showMessageDialog(null,(String)"Datuak falta dira","Error", JOptionPane.ERROR_MESSAGE,null);
				}
			}
		});
		btnGorde.setBounds(305, 423, 85, 21);
		getContentPane().add(btnGorde);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToMenu();
			}
		});
		btnIrten.setBounds(305, 33, 85, 21);
		getContentPane().add(btnIrten);
	
	}
	
	public boolean textKonpro() {
		if (!textNanLan.getText().equals("")) {
				if(!textIzenaLan.getText().equals("")) {
					if(!textAbizenaLan.getText().equals("")) {
						if(!textTelfLan.getText().equals("")) {
							if(!textDptoznbk.getText().equals("")) {
								return true;
							}
						}
					}
				}
			}
		return false;
	}
	
	public void langileGorde() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.executeUpdate("INSERT INTO pertsona VALUES ('"+textNanLan.getText()+"','"+textIzenaLan.getText()+"','"+textAbizenaLan.getText()+"','"+textTelfLan.getText()+"')");
			st.executeUpdate("INSERT INTO langileak VALUES ('"+textNanLan.getText()+"','"+textDptoznbk.getText()+"')");
			
			login.PertsonaKargatu();
			login.LangileakKargatu();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,(String)"Langile hau existitzen da, Nan-a ezin da errepikatu","Error", JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);
	}
}
