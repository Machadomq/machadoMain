package access;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOpcaoFinal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOpcaoFinal frame = new TelaOpcaoFinal();
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
	public TelaOpcaoFinal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInfoFinal = new JLabel("Informe o que deseja fazer:");
		lbInfoFinal.setBounds(141, 32, 135, 14);
		contentPane.add(lbInfoFinal);
		
		JButton btVoltarMenu = new JButton("Voltar ao Menu");
		btVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telaM = new TelaMenu();
					telaM.setVisible(true);
			}
		});
		btVoltarMenu.setBackground(Color.GREEN);
		btVoltarMenu.setBounds(150, 79, 115, 42);
		contentPane.add(btVoltarMenu);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		btSair.setBackground(Color.RED);
		btSair.setBounds(150, 170, 115, 42);
		contentPane.add(btSair);
	}

}
