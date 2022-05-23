package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ariketak.Ikasle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class menu extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnLangile , mnBezero , mnFaktura;
	private JMenuItem mntmLangehi , mntmLankud , mntmLaniku , mntmBezgehi , mntmBezkud , mntmFakamai , mntmFakamaigabe; 
	private JButton btnStock, btnAutoak, btnAurreBerri;
	public static JLabel lblEstado;
	private JButton btnRefresh;

	public void menu() {
		getContentPane().setLayout(null);
		menu menuframe = new menu();
		menuframe.setBounds(0,0,900,550);
		menuframe.setVisible(true);
		menuframe.setResizable(false);
		menuframe.setLocationRelativeTo(null);
	}
	
	public menu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		
		contentPane = new JPanel();
		contentPane.setBackground(login.berdeIluna);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(login.berdeArgia);
		setJMenuBar(menuBar);
				
		mnLangile = new JMenu("Langileak");
		mnLangile.setBackground(new Color(147, 196, 125));
		mnLangile.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnLangile);
		
		mntmLangehi = new JMenuItem("Gehitu");
		mntmLangehi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmLangehi.setBackground(login.berdeArgia);
		mnLangile.add(mntmLangehi);
		mntmLangehi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				langehi iralangehi = new langehi();
				iralangehi.langehi();
				setVisible(false);
			}
		});
		
		mntmLankud = new JMenuItem("Kudeatu");
		mntmLankud.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmLankud.setBackground(login.berdeArgia);
		mnLangile.add(mntmLankud);
		mntmLankud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lankudeatu lankudeatu = new lankudeatu();
				lankudeatu.lankudeatu();
				setVisible(false);
			}
		});
		
		/* ez-admin langileentzat
		mntmLaniku = new JMenuItem("Ikusi");
		mntmLaniku.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnLangile.add(mntmLaniku); */
		
		mnBezero = new JMenu("Bezeroak");
		mnBezero.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnBezero.setBackground(login.berdeArgia);
		menuBar.add(mnBezero);
		
		mntmBezgehi = new JMenuItem("Gehitu");
		mntmBezgehi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmBezgehi.setBackground(new Color(147, 196, 125));
		mntmBezgehi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bezgehi bezgehi = new bezgehi();
				bezgehi.bezgehi();
				setVisible(false);
			}
		});
		mnBezero.add(mntmBezgehi);
		
		mntmBezkud = new JMenuItem("Kudeatu");
		mntmBezkud.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmBezkud.setBackground(new Color(147, 196, 125));
		mntmBezkud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bezkudeatu bezkudeatu = new bezkudeatu();
				bezkudeatu.bezkudeatu();
				setVisible(false);
			}
		});
		mnBezero.add(mntmBezkud);
		
		mnFaktura = new JMenu("Fakturak");
		mnFaktura.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnFaktura.setBackground(login.berdeArgia);
		menuBar.add(mnFaktura);
		
		mntmFakamai = new JMenuItem("Faktura amaituak");
		mntmFakamai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmFakamai.setBackground(login.berdeArgia);
		mntmFakamai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faktura_amai irafaktura_amai = new faktura_amai();
				irafaktura_amai.faktura_amai();
				setVisible(false);
			}
		});
		mnFaktura.add(mntmFakamai);
		
		mntmFakamaigabe = new JMenuItem("Faktura amaitu gabeak");
		mntmFakamaigabe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmFakamaigabe.setBackground(login.berdeArgia);
		mntmFakamaigabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faktura_gabe irafaktura_gabe = new faktura_gabe();
				irafaktura_gabe.faktura_gabe();
				setVisible(false);
			}
		});
		mnFaktura.add(mntmFakamaigabe);
		
		btnStock = new JButton("Stock");
		btnStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStock.setBackground(login.berdeArgia);
		btnStock.setBounds(297, 267, 246, 129);
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stock irastock = new stock();
				irastock.stock();
				setVisible(false);
			}
		});
		contentPane.add(btnStock);
		
		btnAutoak = new JButton("Autoak");
		btnAutoak.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAutoak.setBackground(login.berdeArgia);
		btnAutoak.setBounds(593, 267, 246, 129);
		btnAutoak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autoak iraautoak = new autoak();
				iraautoak.autoak();
				setVisible(false);
			}
		});
		contentPane.add(btnAutoak);
		
		btnAurreBerri = new JButton("Aurre faktura berria");
		btnAurreBerri.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAurreBerri.setBackground(login.berdeArgia);
		btnAurreBerri.setBounds(593, 91, 246, 129);
		btnAurreBerri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aurrefak iraaurrefak = new aurrefak();
				iraaurrefak.aurrefak();
				setVisible(false);
			}
		});
		contentPane.add(btnAurreBerri);
		
		lblEstado = new JLabel("");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstado.setBounds(698, 10, 141, 26);
		contentPane.add(lblEstado);
		
		btnRefresh = new JButton("");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRefresh.setBackground(login.berdeArgia);
		btnRefresh.setBounds(651, 10, 33, 26);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(login.konexioa()) {
					login.Konektatuta();
				}
				else {
					login.EzKonektatuta();
				}
			}
		});
		contentPane.add(btnRefresh);
		
		if(login.konexioa()) {
			login.Konektatuta();
		}
		else {
			login.EzKonektatuta();
		}
	}
}
