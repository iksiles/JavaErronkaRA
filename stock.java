package ERRONKA;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class stock extends JFrame{
	
	private JButton btnPiezaKudeatu, btnHornitzaile , btnIrten;
	private JPanel panel;
	
	public void stock() {
		getContentPane().setLayout(null);
		stock stockframe = new stock();
		stockframe.setBounds(0,0,900,550);
		stockframe.setVisible(true);
		stockframe.setResizable(false);
		stockframe.setLocationRelativeTo(null);
	}
	
	public stock() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		btnPiezaKudeatu = new JButton("Piezak");
		btnPiezaKudeatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPiezaKudeatu.setBackground(new Color(147, 196, 125));
		btnPiezaKudeatu.setBounds(447, 124, 305, 109);
		btnPiezaKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				piezakkudeatu irapiezakkudeatu = new piezakkudeatu();
				irapiezakkudeatu.piezakkudeatu();
				setVisible(false);
			}
		});
		getContentPane().add(btnPiezaKudeatu);
		
		btnHornitzaile = new JButton("Hornitzaileak");
		btnHornitzaile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHornitzaile.setBackground(new Color(147, 196, 125));
		btnHornitzaile.setBounds(447, 267, 305, 109);
		btnHornitzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				horkudeatu irahorkudeatu = new horkudeatu();
				irahorkudeatu.horkudeatu();
				setVisible(false);
			}
		});
		getContentPane().add(btnHornitzaile);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBackground(login.berdeArgia);
		btnIrten.setBounds(791, 10, 85, 21);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToMenu();
			}
		});
		getContentPane().add(btnIrten);
		
		panel = new JPanel();
		panel.setBackground(login.berdeArgia);
		panel.setBounds(0, 0, 395, 513);
		getContentPane().add(panel);
	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);
	}
}
