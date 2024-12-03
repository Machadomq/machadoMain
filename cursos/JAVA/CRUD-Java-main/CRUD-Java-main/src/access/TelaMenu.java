package access;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInformar = new JLabel("Onde deseja fazer uma a\u00E7\u00E3o?");
		lbInformar.setBounds(130, 11, 198, 14);
		contentPane.add(lbInformar);
		
		JButton btVeiculo = new JButton("Ve\u00EDculo");
		btVeiculo.setBounds(147, 72, 139, 23);
		btVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarroMoto telaCM = new TelaCarroMoto();
					telaCM.setVisible(true);
					/*dispose();
					setVisible(false);*/
			}
		});
		contentPane.add(btVeiculo);
		
		JButton btSair = new JButton("Sair");
		btSair.setBounds(147, 207, 139, 23);
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		btSair.setBackground(Color.RED);
		contentPane.add(btSair);
		
		JButton btConta = new JButton("Conta");
		btConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuConta menuC = new MenuConta();
				menuC.setVisible(true);
			}
		});
		btConta.setBounds(147, 120, 139, 23);
		contentPane.add(btConta);
		
		JButton btFinanciamento = new JButton("Financiamento");
		btFinanciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFinanciamento menuF = new MenuFinanciamento();
				menuF.setVisible(true);
			}
		});
		btFinanciamento.setBounds(147, 161, 139, 23);
		contentPane.add(btFinanciamento);
	}
}
