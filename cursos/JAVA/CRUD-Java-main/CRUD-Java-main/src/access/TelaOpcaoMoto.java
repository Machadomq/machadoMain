package access;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOpcaoMoto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOpcaoCarro frame = new TelaOpcaoCarro();
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
	public TelaOpcaoMoto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInfoMoto = new JLabel("O que deseja fazer com a moto?");
		lbInfoMoto.setBounds(131, 23, 167, 14);
		contentPane.add(lbInfoMoto);
		
		JButton btCadasMoto = new JButton("Cadastrar Moto");
		btCadasMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMoto telaM = new TelaMoto();
					telaM.setVisible(true);
					
					//fechar a aba
					dispose();
					setVisible(false);
			}
		});
		btCadasMoto.setBounds(131, 72, 167, 23);
		contentPane.add(btCadasMoto);
		
		JButton btAlterMoto = new JButton("Alterar Moto");
		btAlterMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlterMoto telaAM = new TelaAlterMoto();
					telaAM.setVisible(true);
					
					//fechar a aba
					dispose();
					setVisible(false);
			}
		});
		btAlterMoto.setBounds(131, 122, 167, 23);
		contentPane.add(btAlterMoto);
		
		JButton btExMoto = new JButton("Excluir Moto");
		btExMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExMoto telaEM = new TelaExMoto();
					telaEM.setVisible(true);
					
					//fechar a aba
					dispose();
					setVisible(false);
			}
		});
		btExMoto.setBounds(131, 177, 167, 23);
		contentPane.add(btExMoto);
		
		JButton btConsultaMoto = new JButton("Motos em Estoque");
		btConsultaMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaConsultaMoto telaCM = new TelaConsultaMoto();
				
				telaCM.setVisible(true);
				
				//Fechar as aba
				dispose();
				setVisible(false);
			}
		});
		btConsultaMoto.setBounds(131, 227, 167, 23);
		contentPane.add(btConsultaMoto);
	}
}
