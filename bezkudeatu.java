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

public class bezkudeatu extends JFrame {


	private JScrollPane scroll2;
    private DefaultListModel dlmlist2;
    private JList list2;
    private JButton btnIrten , btnKargatu , btnEditatu;
    private JButton btnEzabatu;
	
	public void bezkudeatu() {
		getContentPane().setLayout(null);
		bezkudeatu bezkudeatuframe = new bezkudeatu();
		bezkudeatuframe.setBounds(0,0,480,550);
		bezkudeatuframe.setVisible(true);
		bezkudeatuframe.setResizable(false);
		bezkudeatuframe.setLocationRelativeTo(null);
	}
	
	public bezkudeatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 550);
		getContentPane().setLayout(null);
		
		dlmlist2 = new DefaultListModel<>();
		list2 = new JList(dlmlist2);
		scroll2 = new JScrollPane(list2);
		
		list2.setPreferredSize(new Dimension(320, 2000)); //variable para lo largo
		scroll2.setBounds(65,90,340,300);
		
		getContentPane().add(scroll2);
		
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
		btnKargatu.setBounds(276, 10, 85, 21);
		btnKargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.BezeroakKargatu();
				login.PertsonaKargatu();
				bezeroakJarri();
			}
		});
		getContentPane().add(btnKargatu);
		
		btnEditatu = new JButton("Editatu");
		btnEditatu.setBackground(login.berdeArgia);
		btnEditatu.setBounds(320, 435, 85, 21);
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_bezeroa = (bezeroak) list2.getSelectedValue();
				bezeditatu irabezeditatu = new bezeditatu();
				irabezeditatu.bezeditatu();
				setVisible(false);
			}
		});
		getContentPane().add(btnEditatu);
		
		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBackground(login.berdeArgia);
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_bezeroa = (bezeroak) list2.getSelectedValue();
				DeleteRow();
				DeleteDB();
				}
		});
		btnEzabatu.setBounds(65, 435, 85, 21);
		getContentPane().add(btnEzabatu);
		
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);
	}
	
	public void DeleteRow() {
		int i = list2.getSelectedIndex();
		dlmlist2.remove(i);
	}
	
	public void DeleteDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.executeUpdate("DELETE FROM bezeroak WHERE Bezero_nan = '"+login.active_bezeroa.nan+"'");
			
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
	
	public void bezeroakJarri() {
		dlmlist2.removeAllElements();
		for (int i=0; i<login.bezeroakAL.size(); i++) {
			dlmlist2.addElement(login.bezeroakAL.get(i));
		}
	}
}
