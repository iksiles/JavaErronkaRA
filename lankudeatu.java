package ERRONKA;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class lankudeatu extends JFrame {
	
	private JScrollPane scroll;
    private JButton btnIrten , btnKargatu;
    private JList list;
    private DefaultListModel dlmlist;
    private JButton btnEditatu;
    private JButton btnEzabatu;
	
	public void lankudeatu() {
		getContentPane().setLayout(null);
		lankudeatu lankudeatuframe = new lankudeatu();
		lankudeatuframe.setBounds(0,0,480,550);
		lankudeatuframe.setVisible(true);
		lankudeatuframe.setResizable(false);
		lankudeatuframe.setLocationRelativeTo(null);
	}
	
	public lankudeatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 550);
		getContentPane().setLayout(null);
		
		dlmlist = new DefaultListModel<>();
		list = new JList(dlmlist);
		scroll = new JScrollPane(list);
		
		list.setPreferredSize(new Dimension(260, 2000)); //variable para lo largo
		
		scroll.setBounds(100,90,280,300);
		
		getContentPane().add(scroll);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(371, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToMenu();
			}
		});
		getContentPane().add(btnIrten);
		
		btnKargatu = new JButton("Kargatu");
		btnKargatu.setBackground(login.berdeArgia);
		btnKargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.LangileakKargatu();
				langileakJarri();
			}
		});
		btnKargatu.setBounds(276, 10, 85, 21);
		getContentPane().add(btnKargatu);
		
		btnEditatu = new JButton("Editatu");
		btnEditatu.setBackground(login.berdeArgia);
		btnEditatu.setBounds(295, 433, 85, 21);
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_langile = (langileak) list.getSelectedValue();
				laneditatu iralaneditatu = new laneditatu();
				iralaneditatu.laneditatu();
				setVisible(false);
			}
		});
		getContentPane().add(btnEditatu);
		
		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBackground(login.berdeArgia);
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_langile = (langileak) list.getSelectedValue();
				DeleteRow();
				DeleteDB();
			}
		});
		btnEzabatu.setBounds(100, 433, 85, 21);
		getContentPane().add(btnEzabatu);
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);
	}
	
	public void DeleteRow() {
		int i = list.getSelectedIndex();
		dlmlist.remove(i);
	}
	
	public void DeleteDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.executeUpdate("DELETE FROM langileak WHERE Langile_nan = '"+login.active_langile.nan+"'");
			
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
	
	public void langileakJarri() {
		dlmlist.removeAllElements();
		for (int i=0; i<login.langileakAL.size(); i++) {
			dlmlist.addElement(login.langileakAL.get(i));
		}
	}	
}
