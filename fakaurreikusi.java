package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class fakaurreikusi extends JFrame {

	private JPanel contentPane;
	private JTextField textBNan , textBIzn , textBTel , textHelb , textAutoa , textMatr , textSubtot , textIva , textTot;
	private JTable tDesk;
	private JButton btnIrten , btnInprimatu;
	private JLabel lblAutoa , lblPiezakZerbitzuak , lblBez , lblNan , lblIzAb , lblTelfN , lblHelbidea , lblModeloa , lblMatrikula , lblSubtotala , lblBez_1;
	private JComboBox comboLan;
	private JScrollPane scrollDesk;
	private double lanOrdKop = 1 , subtotal = 0 , bez = 0 , total = 0 , rowPrz = 0;
	private double bezZB = 0.21;
	private int fakid = 0;
	
	DefaultTableModel model;
	
	Object[] column = {"Zerbitzua", "Kopurua", "Prezioa"};
	final Object[] row1 = new Object[3];
	private JLabel lblLangile;
	
	ActionListener comboLan_AListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String s;
			for(int i=0; i<login.langileakAL.size(); i++) {
				s=login.langileakAL.get(i).nan+" "+login.langileakAL.get(i).izn;
				if(s.equals(comboLan.getSelectedItem())) {
					login.active_langile = login.langileakAL.get(i);
				}
			}
		}
	};
	private JLabel lblBez_2;
	
	public void fakaurreikusi() {
		getContentPane().setLayout(null);
		fakaurreikusi fakaurreikusiframe = new fakaurreikusi();
		fakaurreikusiframe.setBounds(0,0,566,713);
		fakaurreikusiframe.setVisible(true);
		fakaurreikusiframe.setResizable(false);
		fakaurreikusiframe.setLocationRelativeTo(null);
	}

	public fakaurreikusi() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 713);
		getContentPane().setLayout(null);
		
		lblBez = new JLabel("BEZEROA");
		lblBez.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBez.setBounds(22, 58, 85, 13);
		getContentPane().add(lblBez);
		
		textBNan = new JTextField();
		textBNan.setBounds(78, 91, 180, 19);
		textBNan.setText(login.active_bezeroa.nan);
		getContentPane().add(textBNan);
		textBNan.setColumns(10);
		
		textBIzn = new JTextField();
		textBIzn.setColumns(10);
		textBIzn.setBounds(78, 120, 180, 19);
		textBIzn.setText(""+login.active_bezeroa.izn+""+login.active_bezeroa.abz);
		getContentPane().add(textBIzn);
		
		textBTel = new JTextField();
		textBTel.setColumns(10);
		textBTel.setBounds(78, 149, 180, 19);
		textBTel.setText(String.valueOf(login.active_bezeroa.tlf));
		getContentPane().add(textBTel);
		
		textHelb = new JTextField();
		textHelb.setColumns(10);
		textHelb.setBounds(78, 178, 180, 37);
		textHelb.setText(""+login.active_bezeroa.kale+" nº"+login.active_bezeroa.prtl+" "+login.active_bezeroa.pisu+", "+login.active_bezeroa.kodpost);
		getContentPane().add(textHelb);
		
		lblAutoa = new JLabel("AUTOA");
		lblAutoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAutoa.setBounds(22, 240, 106, 13);
		getContentPane().add(lblAutoa);
		
		textAutoa = new JTextField();
		textAutoa.setColumns(10);
		textAutoa.setBounds(78, 268, 180, 19);
		textAutoa.setText(""+login.active_aut.marka+" "+login.active_aut.modeloa);
		getContentPane().add(textAutoa);
		
		textMatr = new JTextField();
		textMatr.setColumns(10);
		textMatr.setBounds(351, 268, 157, 19);
		textMatr.setText(""+login.active_aut.matrikula);
		getContentPane().add(textMatr);
		
		lblLangile = new JLabel("LANGILEA");
		lblLangile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLangile.setBounds(328, 171, 106, 13);
		getContentPane().add(lblLangile);
		
		lblPiezakZerbitzuak = new JLabel("PIEZAK & ZERBITZUAK");
		lblPiezakZerbitzuak.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPiezakZerbitzuak.setBounds(22, 325, 200, 13);
		getContentPane().add(lblPiezakZerbitzuak);
		
		tDesk = new JTable();
		tDesk.setPreferredScrollableViewportSize(new Dimension(500,200));
		tDesk.setFillsViewportHeight(true);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		tDesk.setModel(model);
		scrollDesk = new JScrollPane(tDesk);
		scrollDesk.setBounds(22, 360, 486, 146);
		getContentPane().add(scrollDesk);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToFak();
			}
		});
		btnIrten.setBounds(423, 10, 85, 21);
		getContentPane().add(btnIrten);
		
		textSubtot = new JTextField();
		textSubtot.setColumns(10);
		textSubtot.setBounds(168, 561, 75, 19);
		getContentPane().add(textSubtot);
		
		textIva = new JTextField();
		textIva.setColumns(10);
		textIva.setBounds(359, 561, 75, 19);
		getContentPane().add(textIva);
		
		textTot = new JTextField();
		textTot.setColumns(10);
		textTot.setBounds(268, 601, 75, 19);
		getContentPane().add(textTot);
		
		btnInprimatu = new JButton("Inprimatu");
		btnInprimatu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInprimatu.setBackground(login.berdeArgia);
		btnInprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FakGorde();
				try {
					Inprimatu();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInprimatu.setBounds(394, 615, 99, 37);
		getContentPane().add(btnInprimatu);
		
		comboLan = new JComboBox();
		comboLan.setBounds(328, 194, 180, 21);
		comboLan.addActionListener(comboLan_AListener);
		getContentPane().add(comboLan);
		
		lblNan = new JLabel("Nan:");
		lblNan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNan.setBounds(23, 94, 55, 13);
		getContentPane().add(lblNan);
		
		lblIzAb = new JLabel("Izena:");
		lblIzAb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIzAb.setBounds(22, 123, 55, 13);
		getContentPane().add(lblIzAb);
		
		lblTelfN = new JLabel("Telf n:");
		lblTelfN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelfN.setBounds(22, 152, 55, 13);
		getContentPane().add(lblTelfN);
		
		lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHelbidea.setBounds(22, 190, 55, 13);
		getContentPane().add(lblHelbidea);
		
		lblModeloa = new JLabel("Modeloa:");
		lblModeloa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModeloa.setBounds(22, 271, 85, 13);
		getContentPane().add(lblModeloa);
		
		lblMatrikula = new JLabel("Matrikula:");
		lblMatrikula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatrikula.setBounds(285, 271, 73, 13);
		getContentPane().add(lblMatrikula);
		
		lblSubtotala = new JLabel("Subtotala:");
		lblSubtotala.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubtotala.setBounds(78, 564, 80, 13);
		getContentPane().add(lblSubtotala);
		
		lblBez_1 = new JLabel("Bez (%21):");
		lblBez_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBez_1.setBounds(283, 564, 75, 13);
		getContentPane().add(lblBez_1);
		
		lblBez_2 = new JLabel("Totala:");
		lblBez_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBez_2.setBounds(192, 604, 66, 13);
		getContentPane().add(lblBez_2);
		
		langileakJarri();
		TaulaKargatu();
		kalkuloak();
	}
	
	public void GoToFak() {
		
	}
	
	public void langileakJarri () {
		login.LangileakKargatu();
		comboLan.removeActionListener(comboLan_AListener);
		comboLan.removeAllItems();
		for (int i=0; i<login.langileakAL.size(); i++) {
				comboLan.addItem(""+login.langileakAL.get(i).nan+" "+login.langileakAL.get(i).izn);
		}
		comboLan.addActionListener(comboLan_AListener);
	}
	
	public void TaulaKargatu() {
		row1[0] = "Eskulan orduak";
		row1[1] = aurrefak.textLanOrd.getText();
		row1[2] = aurrefak.lanPrz;
		model.addRow(row1);
		
		for(int i = 0 ; i<aurrefak.piezakTBL.getRowCount() ; i++) {
			row1[0] = aurrefak.piezakTBL.getValueAt(i, 1);
			row1[1] = aurrefak.piezakTBL.getValueAt(i, 3);
			row1[2] = aurrefak.piezakTBL.getValueAt(i, 2);
			model.addRow(row1);
		}
	}
	
	public void kalkuloak() {
		for (int i = 0; i<tDesk.getRowCount() ; i++) {
			rowPrz = Double.parseDouble(String.valueOf(tDesk.getValueAt(i, 2))) * Integer.parseInt(String.valueOf(tDesk.getValueAt(i, 1)));
			subtotal = subtotal + rowPrz;
		}
		
		subtotal= (double)Math.round(subtotal * 100d) / 100d;
		
		bez = subtotal * bezZB;
		
		bez = (double)Math.round(bez * 100d) / 100d;
		
		total = subtotal + bez;
		
		total = (double)Math.round(total * 100d) / 100d;

		
		textSubtot.setText(String.valueOf(subtotal)+"€");
		textIva.setText(String.valueOf(bez)+"€");
		textTot.setText(String.valueOf(total)+"€");
	}
	
	public void FakGorde() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection konekta = DriverManager.getConnection("jdbc:mysql://ns31182333.ip-51-91-153.eu:8140/erronkafinal", "cabello", "1234");
			java.sql.Statement st = konekta.createStatement();
			login.amaiFakturakKargatu();
			login.amaigabeFakturakKargatu();
			fakid = (login.amaiFakAL.size() + login.amaigabFakAL.size()) + 1;
			st.executeUpdate("INSERT INTO fakturak VALUES ("+fakid+",'"+total+"','"+LocalDate.now()+"','fak"+login.active_bezeroa.izn+""+login.active_bezeroa.abz+""+login.active_aut.matrikula+"','"+login.active_bezeroa.nan+"','"+login.active_langile.nan+"','EZ')");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Inprimatu() throws DocumentException {
		Document doc = new Document();
		FileOutputStream pdf = null;
		
		try {
			pdf = new FileOutputStream("Fakturak\\fak"+login.active_bezeroa.izn+""+login.active_bezeroa.abz+""+login.active_aut.matrikula+".pdf");
			PdfWriter.getInstance(doc,pdf).setInitialLeading(20);
			doc.open();
			doc.add(new Paragraph("FAKTURA\n",
								FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK)));
			doc.add(new Paragraph("  RekordAuto S.A.\n  Dr. Ornilla Kalea, 2, 48004\n  645 332 912\n",
								FontFactory.getFont("arial", 12, Font.PLAIN, BaseColor.BLACK)));
			doc.add(new Paragraph("___________________________________________________________________\n"
								+ "BEZEROA\n",
								FontFactory.getFont("arial", 14, Font.BOLD, BaseColor.BLACK)));
			doc.add(new Paragraph(" Izena:  "+login.active_bezeroa.izn+" "+login.active_bezeroa.abz+"\n"
								+ " NAN:  "+login.active_bezeroa.nan+"\n"
								+ " Telfn.:  "+login.active_bezeroa.tlf+"\n"
								+ " Helbidea:  "+login.active_bezeroa.kodpost+", "+login.active_bezeroa.kale+", "+login.active_bezeroa.prtl+", "+login.active_bezeroa.pisu,
								FontFactory.getFont("arial", 12, Font.PLAIN, BaseColor.BLACK)));
			doc.add(new Paragraph("___________________________________________________________________\n"
								+ "AUTOA\n",
								FontFactory.getFont("arial", 14, Font.BOLD, BaseColor.BLACK)));
			doc.add(new Paragraph(" Matrikula:  "+login.active_aut.matrikula+"\n"
								+ " Modeloa:  "+login.active_aut.marka+" "+login.active_aut.modeloa+"\n",
								FontFactory.getFont("arial", 12, Font.PLAIN, BaseColor.BLACK)));
			doc.add(new Paragraph("___________________________________________________________________\n"
								+ "ZERBITZUAK\n",
								FontFactory.getFont("arial", 14, Font.BOLD, BaseColor.BLACK)));
								for(int i=0; i<tDesk.getRowCount(); i++) {
			doc.add(new Paragraph("  "+tDesk.getValueAt(i, 0)+"    "+tDesk.getValueAt(i, 1)+"     "+tDesk.getValueAt(i, 2)+ "€\n",
								FontFactory.getFont("arial", 12, Font.PLAIN, BaseColor.BLACK)));
			}
			doc.add(new Paragraph("___________________________________________________________________\n",
					FontFactory.getFont("arial", 14, Font.BOLD, BaseColor.BLACK)));
			doc.add(new Paragraph(" Subtotala:  "+textSubtot.getText()+"\n"
								+ " Bez(%21):  "+textIva.getText()+"\n"
								+ " Totala:  "+textTot.getText()+"",
								FontFactory.getFont("arial", 12, Font.PLAIN, BaseColor.BLACK)));
			doc.close();
		}catch(FileNotFoundException e) {		e.printStackTrace();		}
		try {
		     File path = new File ("Fakturak\\fak"+login.active_bezeroa.izn+""+login.active_bezeroa.abz+""+login.active_aut.matrikula+".pdf");
		     Desktop.getDesktop().open(path);
		}catch (IOException ex) {
		     ex.printStackTrace();
		}
	}
}
