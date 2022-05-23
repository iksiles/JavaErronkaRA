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

public class horkudeatu extends JFrame {

	private JPanel contentPane;
	private JScrollPane scroll4;
    private DefaultListModel dlmlist4;
    private JList list4;
    private JButton btnIrten , btnKargatu , btnEditatu;
    private JButton btnEzabatu;

	public void horkudeatu() {
		getContentPane().setLayout(null);
		horkudeatu horkudeatuframe = new horkudeatu();
		horkudeatuframe.setBounds(0,0,900,550);
		horkudeatuframe.setVisible(true);
		horkudeatuframe.setResizable(false);
		horkudeatuframe.setLocationRelativeTo(null);
	}

	public horkudeatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		dlmlist4 = new DefaultListModel<>();
		list4 = new JList(dlmlist4);
		scroll4 = new JScrollPane(list4);
		
		list4.setPreferredSize(new Dimension(700, 2000)); //variable para lo largo
		scroll4.setBounds(85,90,720,300);
		
		getContentPane().add(scroll4);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(779, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToMenu();
			}
		});
		getContentPane().add(btnIrten);
		
		btnKargatu = new JButton("Kargatu");
		btnKargatu.setBackground(login.berdeArgia);
		btnKargatu.setBounds(684, 10, 85, 21);
		btnKargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.horKargatu();
				horjarri();
			}
		});
		getContentPane().add(btnKargatu);
		
		btnEditatu = new JButton("Editatu");
		btnEditatu.setBackground(login.berdeArgia);
		btnEditatu.setBounds(720, 431, 85, 21);
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_hor = (hornitzaileak) list4.getSelectedValue();
				horeditatu irahoreditatu = new horeditatu();
				irahoreditatu.horeditatu();
				setVisible(false);
			}
		});
		getContentPane().add(btnEditatu);
		
		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBackground(login.berdeArgia);
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_hor = (hornitzaileak) list4.getSelectedValue();
				DeleteRow();
				DeleteDB();
			}
		});
		btnEzabatu.setBounds(85, 431, 85, 21);
		getContentPane().add(btnEzabatu);
		
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
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
			
			st.executeUpdate("DELETE FROM hornitzaileak WHERE hor_kod = '"+login.active_hor.hor_kod+"'");
			
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
	
	public void horjarri() {
		dlmlist4.removeAllElements();
		for (int i=0; i<login.hornitzaileakAL.size(); i++) {
			dlmlist4.addElement(login.hornitzaileakAL.get(i));
		}
	}

}
