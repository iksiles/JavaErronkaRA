package ERRONKA;

import java.awt.BorderLayout;
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
import java.awt.Color;

public class bezgehi extends JFrame {

	private JPanel contentPane;

	private JTextField textNanBez, textIzenaBez, textAbizenaBez, textEmailBez , textKaleBez, textPortalBez, textPisuBez, textKodPost, textTelfBez;
	private JLabel lblBezNan, lblBezIzn, lblLBezAbz, lblBezKale, lblBezEmail , lblBezPisu, lblBezPort, lblBezKodPost, lblBezTel;
	private JButton btnGorde, btnIrten;
	
	public void bezgehi() {
		getContentPane().setLayout(null);
		bezgehi bezgehiframe = new bezgehi();
		bezgehiframe.setBounds(0,0,480,590);
		bezgehiframe.setVisible(true);
		bezgehiframe.setResizable(false);
		bezgehiframe.setLocationRelativeTo(null);
	}
	public bezgehi() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 590);
		getContentPane().setLayout(null);
		
		textNanBez = new JTextField();
		TextPrompt textNanBezT = new TextPrompt("88888888Z...", textNanBez);
		textNanBez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNanBez.setBounds(190, 45, 200, 30);
		getContentPane().add(textNanBez);
		textNanBez.setColumns(10);
		
		textIzenaBez = new JTextField();
		TextPrompt textIzenaBezT = new TextPrompt("Paco...", textIzenaBez);
		textIzenaBez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIzenaBez.setColumns(10);
		textIzenaBez.setBounds(190, 95, 200, 30);
		getContentPane().add(textIzenaBez);
		
		textAbizenaBez = new JTextField();
		TextPrompt textAbizenaBezT = new TextPrompt("Cabello...", textAbizenaBez);
		textAbizenaBez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAbizenaBez.setColumns(10);
		textAbizenaBez.setBounds(190, 145, 200, 30);
		getContentPane().add(textAbizenaBez);
		
		textEmailBez = new JTextField();
		TextPrompt textEmailBezT = new TextPrompt("pacocabello@gmail.com...", textEmailBez);
		textEmailBez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEmailBez.setColumns(10);
		textEmailBez.setBounds(190, 195, 200, 30);
		getContentPane().add(textEmailBez);
		
		textKaleBez = new JTextField();
		TextPrompt textKaleBezT = new TextPrompt("Txibitxiaga kalea...", textKaleBez);
		textKaleBez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKaleBez.setColumns(10);
		textKaleBez.setBounds(190, 245, 200, 30);
		getContentPane().add(textKaleBez);
		
		textPortalBez = new JTextField();
		TextPrompt textPortalBezT = new TextPrompt("17...", textPortalBez);
		textPortalBez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPortalBez.setColumns(10);
		textPortalBez.setBounds(190, 295, 200, 30);
		getContentPane().add(textPortalBez);
		
		textPisuBez = new JTextField();
		TextPrompt textPisuBezT = new TextPrompt("7D...", textPisuBez);
		textPisuBez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPisuBez.setColumns(10);
		textPisuBez.setBounds(190, 345, 200, 30);
		getContentPane().add(textPisuBez);
		
		textKodPost = new JTextField();
		TextPrompt textKodPostT = new TextPrompt("48000...", textKodPost);
		textKodPost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKodPost.setColumns(10);
		textKodPost.setBounds(190, 395, 200, 30);
		getContentPane().add(textKodPost);
		
		textTelfBez = new JTextField();
		TextPrompt textTelfBezT = new TextPrompt("666666666...", textTelfBez);
		textTelfBez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTelfBez.setColumns(10);
		textTelfBez.setBounds(190, 445, 200, 30);
		getContentPane().add(textTelfBez);
		
		lblBezNan = new JLabel("Nan:");
		lblBezNan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezNan.setBounds(60, 53, 85, 13);
		getContentPane().add(lblBezNan);
		
		lblBezIzn = new JLabel("Izena:");
		lblBezIzn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezIzn.setBounds(60, 103, 85, 13);
		getContentPane().add(lblBezIzn);
		
		lblLBezAbz = new JLabel("Abizena:");
		lblLBezAbz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLBezAbz.setBounds(60, 153, 85, 13);
		getContentPane().add(lblLBezAbz);
		
		lblBezEmail = new JLabel("Email:");
		lblBezEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezEmail.setBounds(60, 205, 120, 13);
		getContentPane().add(lblBezEmail);
		
		lblBezKale = new JLabel("Kalea:");
		lblBezKale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezKale.setBounds(60, 253, 120, 13);
		getContentPane().add(lblBezKale);
		
		lblBezPort = new JLabel("Portala:");
		lblBezPort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezPort.setBounds(60, 303, 120, 13);
		getContentPane().add(lblBezPort);
		
		lblBezPisu = new JLabel("Pisu:");
		lblBezPisu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezPisu.setBounds(60, 353, 120, 13);
		getContentPane().add(lblBezPisu);
		
		lblBezKodPost = new JLabel("Posta kodea:");
		lblBezKodPost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezKodPost.setBounds(60, 403, 120, 13);
		getContentPane().add(lblBezKodPost);
		
		lblBezTel = new JLabel("Telf zenbakia:");
		lblBezTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezTel.setBounds(60, 453, 120, 13);
		getContentPane().add(lblBezTel);
		
		btnGorde = new JButton("Gorde");
		btnGorde.setBackground(login.berdeArgia);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textKonpro()) {
					bezeroGorde();
				}
				else {
					JOptionPane.showMessageDialog(null,(String)"Datuak falta dira","Error", JOptionPane.ERROR_MESSAGE,null);
				}
			}
		});
		btnGorde.setBounds(305, 502, 85, 21);
		getContentPane().add(btnGorde);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		getContentPane().add(btnIrten);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToMenu();
			}
		});
		btnIrten.setBounds(371, 10, 85, 21);
	
	}
	
	public boolean textKonpro() {
		if (!textNanBez.getText().equals("")) {
				if(!textIzenaBez.getText().equals("")) {
					if(!textAbizenaBez.getText().equals("")) {
						if(!textEmailBez.getText().equals("")) {
							if(!textKaleBez.getText().equals("")) {
								if(!textPortalBez.getText().equals("")) {
									if(!textPisuBez.getText().equals("")) {
										if(!textKodPost.getText().equals("")) {
											if(!textTelfBez.getText().equals("")) {
												return true;
											}
										}
									}	
								}	
							}
						}
					}
				}
			}
		return false;
	}
	
	public void bezeroGorde() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.executeUpdate("INSERT INTO pertsona VALUES ('"+textNanBez.getText()+"','"+textIzenaBez.getText()+"','"+textAbizenaBez.getText()+"','"+textTelfBez.getText()+"')");
			st.executeUpdate("INSERT INTO bezeroak VALUES ('"+textNanBez.getText()+"','"+textEmailBez.getText()+"','"+textKaleBez.getText()+"','"+textPortalBez.getText()+"','"+textPisuBez.getText()+"','"+textKodPost.getText()+"')");
				
			login.BezeroakKargatu();
			login.LangileakKargatu();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,(String)"Bezero hau existitzen da, Nan-a ezin da errepikatu","Error", JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);		
	}
}
