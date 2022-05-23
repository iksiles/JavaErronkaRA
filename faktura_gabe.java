package ERRONKA;

import java.awt.Dimension;
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

public class faktura_gabe extends JFrame{
	
	private JScrollPane scroll3;
    private DefaultListModel dlmlist3;
    private JList list3;
    private JButton btnIrten , btnKargatu , btnEditatu , btnEzabatu;
	
	public void faktura_gabe() {
		getContentPane().setLayout(null);
		faktura_gabe faktura_gabeframe = new faktura_gabe();
		faktura_gabeframe.setBounds(0,0,680,550);
		faktura_gabeframe.setVisible(true);
		faktura_gabeframe.setResizable(false);
		faktura_gabeframe.setLocationRelativeTo(null);
	}
	
	public faktura_gabe() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 550);
		getContentPane().setLayout(null);
		
		dlmlist3 = new DefaultListModel<>();
		list3 = new JList(dlmlist3);
		scroll3 = new JScrollPane(list3);
		
		list3.setPreferredSize(new Dimension(560, 2000)); //variable para lo largo
		scroll3.setBounds(50,90,580,300);
		
		getContentPane().add(scroll3);
		
		btnKargatu = new JButton("Kargatu");
		btnKargatu.setBackground(login.berdeArgia);
		btnKargatu.setBounds(462, 10, 85, 21);
		btnKargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.amaigabeFakturakKargatu();
				fakjarri();
			}
		});
		getContentPane().add(btnKargatu);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(571, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToMenu();
			}
		});
		getContentPane().add(btnIrten);
		
		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBackground(login.berdeArgia);
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_fak = (faktura) list3.getSelectedValue();
				DeleteRow();
				DeleteDB();
			}
		});
		btnEzabatu.setBounds(50, 431, 85, 21);
		getContentPane().add(btnEzabatu);
		
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);
	}
	
	public void DeleteRow() {
		int i = list3.getSelectedIndex();
		dlmlist3.remove(i);
	}
	
	public void DeleteDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.executeUpdate("DELETE FROM fakturak WHERE Faktura_id = '"+login.active_fak.fak_id+"'");
			
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
	
	public void fakjarri() {
		dlmlist3.removeAllElements();
		for (int i=0; i<login.amaigabFakAL.size(); i++) {
			dlmlist3.addElement(login.amaigabFakAL.get(i));
		}
	}

}
