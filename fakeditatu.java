package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class fakeditatu extends JFrame {

	private JPanel contentPane;
	private JLabel lblAmaituta;
	private JRadioButton rdbtnBai , rdbtnEz;

	/**
	 * Launch the application.
	 */
	public void fakeditatu() {
		getContentPane().setLayout(null);
		fakeditatu fakeditatuframe = new fakeditatu();
		fakeditatuframe.setBounds(0,0,450,330);
		fakeditatuframe.setVisible(true);
		fakeditatuframe.setResizable(false);
		fakeditatuframe.setLocationRelativeTo(null);
	}

	public fakeditatu() {
		getContentPane().setBackground(login.berdeIluna);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		getContentPane().setLayout(null);
		
		lblAmaituta = new JLabel("Amaituta");
		lblAmaituta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmaituta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAmaituta.setBounds(175, 94, 80, 13);
		getContentPane().add(lblAmaituta);
		
		rdbtnBai = new JRadioButton("BAI");
		rdbtnBai.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBai.setBounds(131, 144, 55, 21);
		getContentPane().add(rdbtnBai);
		
		rdbtnEz = new JRadioButton("EZ");
		rdbtnEz.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEz.setBounds(244, 144, 55, 21);
		getContentPane().add(rdbtnEz);
		
		
		
	}
}
