package ERRONKA;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class autoak extends JFrame {
	
	private JButton btnAutoGehitu, btnAutoKudeatu, btnIrten;
	private JPanel panel;
	
	public void autoak() {
		getContentPane().setLayout(null);
		autoak autoakframe = new autoak();
		autoakframe.setBounds(0,0,900,550);
		autoakframe.setVisible(true);
		autoakframe.setResizable(false);
		autoakframe.setLocationRelativeTo(null);
	}
	
	public autoak() {
		getContentPane().setBackground(new Color(185, 215, 168));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		btnAutoGehitu = new JButton("Auto berria");
		btnAutoGehitu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAutoGehitu.setBounds(447, 124, 305, 109);
		btnAutoGehitu.setBackground(new Color(147, 196, 125));
		btnAutoGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autoGehi iraautoGehi = new autoGehi();
				iraautoGehi.autoGehi();
				setVisible(false);
			}
		});
		getContentPane().add(btnAutoGehitu);
		
		btnAutoKudeatu = new JButton("Autoak Kudeatu");
		btnAutoKudeatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAutoKudeatu.setBounds(447, 267, 305, 109);
		btnAutoKudeatu.setBackground(new Color(147, 196, 125));
		btnAutoKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autoKudea iraautoKudea = new autoKudea();
				iraautoKudea.autoKudea();
				setVisible(false);
			}
		});
		getContentPane().add(btnAutoKudeatu);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBounds(791, 10, 85, 21);
		btnIrten.setBackground(new Color(147, 196, 125));
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToMenu();
			}
		});
		getContentPane().add(btnIrten);
		
		panel = new JPanel();
		panel.setBackground(new Color(147, 196, 125));
		panel.setBounds(0, 0, 395, 513);
		getContentPane().add(panel);

	}
	
	public void GoToMenu() {
		menu iramenu = new menu();
		iramenu.menu();
		setVisible(false);
	}
}
