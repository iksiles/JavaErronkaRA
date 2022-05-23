package ERRONKA;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class aurrefak extends JFrame {
	private JTextField textBeznan , textPKod , textPKop , textIzenaAbz , textAutoa;
	private JLabel lblBezero, lblAutoa , lblZerb , lblPiezak , lblLanOrd , lblKodea , lblKantitatea;
	public static JTextField textLanOrd;
	private JComboBox comboAuto;
	public static JTable piezakTBL;
	public static JScrollPane piezakSP;
	private JButton btnAdd , btnDelete , btnAurreIkusi , btnIrten;
	
	public static double lanPrz = 25;
	
	public static DefaultTableModel model;
	Object[] column = {"Kodea", "Pieza", "Prezioa", "Kopurua"};
	public static final Object[] row = new Object[4];
	
	//matrikula comboboxaren actionlistener matrikula activoa aukeratzen du
		ActionListener comboAuto_AListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<login.autoakAL.size(); i++) {
					if(login.autoakAL.get(i).matrikula.equals(comboAuto.getSelectedItem())) {
						login.active_aut = login.autoakAL.get(i);
						String autoa = (""+login.active_aut.marka+" "+login.active_aut.modeloa);
						textAutoa.setText(autoa);
					}
				}
			}
		};
	
	public void aurrefak() {
		getContentPane().setLayout(null);
		aurrefak aurrefakframe = new aurrefak();
		aurrefakframe.setBounds(0,0,507,528);
		aurrefakframe.setVisible(true);
		aurrefakframe.setResizable(false);
		aurrefakframe.setLocationRelativeTo(null);
	}
	
	public aurrefak() {
		getContentPane().setBackground(new Color(185, 215, 168));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 528);
		getContentPane().setLayout(null);
		
		piezakTBL = new JTable();
		piezakTBL.setPreferredScrollableViewportSize(new Dimension(500,200));
		piezakTBL.setFillsViewportHeight(true);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		piezakTBL.setModel(model);
		piezakSP = new JScrollPane(piezakTBL);
		piezakSP.setBounds(30, 310, 377, 100);
		getContentPane().add(piezakSP);
		
		lblBezero = new JLabel("Bezeroa");
		lblBezero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBezero.setBounds(34, 44, 74, 13);
		getContentPane().add(lblBezero);
		
		lblAutoa = new JLabel("Autoa");
		lblAutoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAutoa.setBounds(243, 44, 74, 13);
		getContentPane().add(lblAutoa);
		
		lblZerb = new JLabel("Zerbitzuak");
		lblZerb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblZerb.setBounds(30, 148, 93, 13);
		getContentPane().add(lblZerb);
		
		lblPiezak = new JLabel("Piezak");
		lblPiezak.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPiezak.setBounds(30, 230, 74, 13);
		getContentPane().add(lblPiezak);
		
		lblLanOrd = new JLabel("Lan orduak:");
		lblLanOrd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLanOrd.setBounds(30, 189, 89, 13);
		getContentPane().add(lblLanOrd);
		
		lblKodea = new JLabel("Kodea:");
		lblKodea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKodea.setBounds(30, 273, 89, 13);
		getContentPane().add(lblKodea);
		
		lblKantitatea = new JLabel("Kantitatea:");
		lblKantitatea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKantitatea.setBounds(243, 273, 89, 13);
		getContentPane().add(lblKantitatea);
		
		textBeznan = new JTextField();
		textBeznan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BezeroBilatu()) {
					FDatuJarri(login.active_bezeroa);
					matrikulakJarri(login.active_bezeroa);
				}
			}
		});
		textBeznan.setBounds(34, 77, 166, 19);
		getContentPane().add(textBeznan);
		textBeznan.setColumns(10);
		
		textIzenaAbz = new JTextField();
		textIzenaAbz.setColumns(10);
		textIzenaAbz.setBounds(34, 114, 166, 19);
		getContentPane().add(textIzenaAbz);
		
		textAutoa = new JTextField();
		textAutoa.setColumns(10);
		textAutoa.setBounds(243, 114, 166, 19);
		getContentPane().add(textAutoa);
		
		comboAuto = new JComboBox();
		comboAuto.setBounds(243, 76, 166, 21);
		getContentPane().add(comboAuto);
		comboAuto.addActionListener(comboAuto_AListener);
		
		textLanOrd = new JTextField();
		textLanOrd.setColumns(10);
		textLanOrd.setBounds(118, 188, 82, 19);
		getContentPane().add(textLanOrd);
		
		textPKod = new JTextField();
		textPKod.setBounds(104, 270, 96, 19);
		getContentPane().add(textPKod);
		textPKod.setColumns(10);
		
		textPKop = new JTextField();
		textPKop.setColumns(10);
		textPKop.setBounds(311, 270, 96, 19);
		getContentPane().add(textPKop);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBackground(login.berdeArgia);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(konproPieza()) {
					StockKendu(login.active_pieza);
					RowBerri(login.active_pieza);
				}
				else{
					JOptionPane.showMessageDialog(null,(String)"Pieza hau ez da existitzen","Error", JOptionPane.ERROR_MESSAGE,null);
				}
			}
		});
		btnAdd.setBounds(417, 310, 65, 21);
		getContentPane().add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(login.berdeArgia);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockGehi(login.active_pieza);
				DeleteRow();
			}
		});
		btnDelete.setBounds(417, 350, 65, 21);
		getContentPane().add(btnDelete);
		
		btnAurreIkusi = new JButton("Aurreikusi");
		btnAurreIkusi.setBackground(login.berdeArgia);
		btnAurreIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fakaurreikusi irafakaurreikusi = new fakaurreikusi();
				irafakaurreikusi.fakaurreikusi();
				setVisible(false);
			}
		});
		btnAurreIkusi.setBounds(327, 431, 121, 38);
		getContentPane().add(btnAurreIkusi);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToMenu();
			}
		});
		btnIrten.setBounds(417, 10, 65, 21);
		getContentPane().add(btnIrten);

	}
	
	public boolean konproPieza() {
		login.PiezakKargatu();
		boolean b = false;
		for (int i=0; i<login.piezakAL.size(); i++) {
			if (textPKod.getText().equals(String.valueOf(login.piezakAL.get(i).pieza_kod))) {
				login.active_pieza = login.piezakAL.get(i);
				b = true;
			}
		}
		return b;
	}
	
	public void RowBerri(piezak p) {
		row[0] = p.pieza_kod;
		row[1] = p.pieza_izn;
		row[2] = p.pieza_prz;
		row[3] = textPKop.getText();
		model.addRow(row);
		textPKod.setText("");
		textPKop.setText("0");
	}
	
	public void StockKendu(piezak p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			st.executeUpdate("UPDATE stock SET pieza_kop = pieza_kop -'"+textPKop.getText()+"' WHERE pieza_kod = '"+p.pieza_kod+"'");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void DeleteRow() {
		int i = piezakTBL.getSelectedRow();
		model.removeRow(i);
	}
	
	public void StockGehi(piezak p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			int i = piezakTBL.getSelectedRow();			
			st.executeUpdate("UPDATE stock SET pieza_kop = pieza_kop +'"+piezakTBL.getValueAt(i, 3)+"' WHERE pieza_kod = '"+piezakTBL.getValueAt(i, 0)+"'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean BezeroBilatu() {
		for (int i=0; i<login.bezeroakAL.size(); i++) {
				if(textBeznan.getText().equals(login.bezeroakAL.get(i).nan)) {
						login.active_bezeroa = login.bezeroakAL.get(i);
						return true;
			}
		}
		return false;
	}
	
	public void FDatuJarri(bezeroak b) {
		String IzenaAbz = (""+b.izn+" "+b.abz);
		textIzenaAbz.setText(IzenaAbz);;
	}
	
	public void matrikulakJarri (bezeroak b) {
		login.AutoakKargatu();
		comboAuto.removeActionListener(comboAuto_AListener);
		comboAuto.removeAllItems();
		for (int i=0; i<login.autoakAL.size(); i++) {
			if (b.nan.equals(login.autoakAL.get(i).bez_nan) ) {
				comboAuto.addItem(login.autoakAL.get(i).matrikula);
			}
		}
		comboAuto.addActionListener(comboAuto_AListener);
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);
	}
}
