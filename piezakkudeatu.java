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

public class piezakkudeatu extends JFrame {

	private JPanel contentPane;
	private JScrollPane scroll3;
    private DefaultListModel dlmlist3;
    private JList list3;
    private JButton btnIrten , btnKargatu , btnEditatu;	
    private JButton btnEzabatu;
	
	public void piezakkudeatu() {
		getContentPane().setLayout(null);
		piezakkudeatu piezakkudeatuframe = new piezakkudeatu();
		piezakkudeatuframe.setBounds(0,0,900,550);
		piezakkudeatuframe.setVisible(true);
		piezakkudeatuframe.setResizable(false);
		piezakkudeatuframe.setLocationRelativeTo(null);
	}

	public piezakkudeatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		dlmlist3 = new DefaultListModel<>();
		list3 = new JList(dlmlist3);
		scroll3 = new JScrollPane(list3);
		
		list3.setPreferredSize(new Dimension(700, 2000)); //variable para lo largo
		scroll3.setBounds(85,90,720,300);
		
		getContentPane().add(scroll3);
		
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
				login.PiezakKargatu();
				piezakjarri();
			}
		});
		getContentPane().add(btnKargatu);
		
		btnEditatu = new JButton("Editatu");
		btnEditatu.setBackground(login.berdeArgia);
		btnEditatu.setBounds(720, 431, 85, 21);
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_pieza = (piezak) list3.getSelectedValue();
				piezakeditatu irapiezaeditatu = new piezakeditatu();
				irapiezaeditatu.piezakeditatu();
				setVisible(false);
			}
		});
		getContentPane().add(btnEditatu);
		
		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBackground(login.berdeArgia);
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.active_pieza = (piezak) list3.getSelectedValue();
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
		int i = list3.getSelectedIndex();
		dlmlist3.remove(i);
	}
	
	public void DeleteDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			
			st.executeUpdate("DELETE FROM stock WHERE pieza_kod = '"+login.active_pieza.pieza_kod+"'");
			
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
	
	public void piezakjarri() {
		dlmlist3.removeAllElements();
		for (int i=0; i<login.piezakAL.size(); i++) {
			dlmlist3.addElement(login.piezakAL.get(i));
		}
	}

}
