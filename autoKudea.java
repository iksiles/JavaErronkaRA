package ERRONKA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class autoKudea extends JFrame {

	private JPanel contentPane;
	private JScrollPane scroll4;
    private JButton btnIrten , btnKargatu , btnEzabatu;
    private JList list4;
    private DefaultListModel dlmlist4;
    private JButton btnEditatu;

	public void autoKudea() {
		getContentPane().setLayout(null);
		autoKudea autoKudeaframe = new autoKudea();
		autoKudeaframe.setBounds(0,0,900,550);
		autoKudeaframe.setVisible(true);
		autoKudeaframe.setResizable(false);
		autoKudeaframe.setLocationRelativeTo(null);
	}
	
	public autoKudea() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		dlmlist4 = new DefaultListModel<>();
		list4 = new JList(dlmlist4);
		scroll4 = new JScrollPane(list4);
		
		list4.setPreferredSize(new Dimension(640, 2000)); //variable para lo largo
		
		scroll4.setBounds(120,90,660,300);
		
		getContentPane().add(scroll4);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(791, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToAut();
			}
		});
		getContentPane().add(btnIrten);
		
		btnKargatu = new JButton("Kargatu");
		btnKargatu.setBackground(login.berdeArgia);
		btnKargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.AutoakKargatu();
				autoakJarri();
			}
		});
		btnKargatu.setBounds(696, 10, 85, 21);
		getContentPane().add(btnKargatu);
		
		btnEditatu = new JButton("Editatu");
		btnEditatu.setBackground(login.berdeArgia);
		btnEditatu.setBounds(695, 426, 85, 21);
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_aut = (ibilgailuak) list4.getSelectedValue();
				autoeditatu iraautoeditatu = new autoeditatu();
				iraautoeditatu.autoeditatu();
				setVisible(false);
			}
		});
		getContentPane().add(btnEditatu);
		
		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBackground(login.berdeArgia);
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_aut = (ibilgailuak) list4.getSelectedValue();
				DeleteRow();
				DeleteDB();
			}
		});
		btnEzabatu.setBounds(120, 426, 85, 21);
		getContentPane().add(btnEzabatu);
	}
	
	public void GoToAut() {
		autoak iraautoak = new autoak();
		iraautoak.autoak();
		setVisible(false);
	}
	
	public void DeleteRow() {
		int i = list4.getSelectedIndex();
		dlmlist4.remove(i);
	}
	
	public void DeleteDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.executeUpdate("DELETE FROM ibilgailuak WHERE Bastidore_zenbakia = '"+login.active_aut.bast_znbk+"'");
			
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
	
	public void autoakJarri() {
		dlmlist4.removeAllElements();
		for (int i=0; i<login.autoakAL.size(); i++) {
			dlmlist4.addElement(login.autoakAL.get(i));
		}
	}	
}
