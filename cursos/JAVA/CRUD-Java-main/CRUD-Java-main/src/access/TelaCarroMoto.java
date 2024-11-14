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

public class TelaCarroMoto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarroMoto frame = new TelaCarroMoto();
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
	public TelaCarroMoto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInformacao = new JLabel("O que deseja alterar?");
		lbInformacao.setBounds(158, 21, 119, 14);
		contentPane.add(lbInformacao);
		
		//Botão Cadastrar Carro
		JButton btCarro = new JButton("Carro");
		btCarro.setToolTipText("Bot\u00E3o para cadastrar carro");
		btCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcaoCarro telaC = new TelaOpcaoCarro();
					telaC.setVisible(true);
			}
		});
		btCarro.setBounds(147, 89, 143, 23);
		contentPane.add(btCarro);
		
		//Botão Cadastrar Moto
		JButton btMoto = new JButton("Moto");
		btMoto.setToolTipText("Bot\u00E3o para cadastrar moto");
		btMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcaoMoto telaM = new TelaOpcaoMoto();
					telaM.setVisible(true);
			}
		});
		btMoto.setBounds(147, 148, 143, 23);
		contentPane.add(btMoto);
	}

}
