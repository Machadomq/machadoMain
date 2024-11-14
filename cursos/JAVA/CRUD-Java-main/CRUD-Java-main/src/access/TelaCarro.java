package access;


import dados.CarroDAO;

import dados.ConexaoMySQL;
import model.Carro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaCarro extends JFrame {

	private JPanel contentPane;
	private JTextField txChassi;
	private JTextField txMarca;
	private JTextField txModelo;
	private JTextField txAno;
	private JTextField txPrecoCarro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarro frame = new TelaCarro();
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
	public TelaCarro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//texto Chassi
		txChassi = new JTextField();
		txChassi.setBackground(Color.WHITE);
		txChassi.setToolTipText("Digite o Chassi do Carro");
		txChassi.setBounds(338, 61, 86, 20);
		contentPane.add(txChassi);
		txChassi.setColumns(10);
		
		//texto Marca
		txMarca = new JTextField();
		txMarca.setToolTipText("Digite a Marca do Carro");
		txMarca.setBounds(338, 108, 86, 20);
		contentPane.add(txMarca);
		txMarca.setColumns(10);
		
		//texto Modelo
		txModelo = new JTextField();
		txModelo.setToolTipText("Digite o Modelo do Carro");
		txModelo.setBounds(338, 156, 86, 20);
		contentPane.add(txModelo);
		txModelo.setColumns(10);
		
		//texto Ano
		txAno = new JTextField();
		txAno.setToolTipText("Digite o Ano do Carro");
		txAno.setBounds(338, 200, 86, 20);
		contentPane.add(txAno);
		txAno.setColumns(10);
		
		//escrita Chassi
		JLabel lbChassi = new JLabel("Chassi");
		lbChassi.setBounds(221, 64, 48, 14);
		contentPane.add(lbChassi);
		
		//escrita Marca
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(221, 111, 48, 14);
		contentPane.add(lblMarca);
		
		//escrita Modelo
		JLabel lbModelo = new JLabel("Modelo");
		lbModelo.setBounds(221, 159, 48, 14);
		contentPane.add(lbModelo);
		
		//escrita Ano
		JLabel lbAno = new JLabel("Ano");
		lbAno.setBounds(221, 203, 48, 14);
		contentPane.add(lbAno);
		
		//escrita Preco Carro
		JLabel lbPrecoCarro = new JLabel("Pre\u00E7o do Carro");
		lbPrecoCarro.setBounds(221, 251, 107, 14);
		contentPane.add(lbPrecoCarro);
		
		//texto Preco do Carro
		txPrecoCarro = new JTextField();
		txPrecoCarro.setToolTipText("Digite o Valor do Carro");
		txPrecoCarro.setColumns(10);
		txPrecoCarro.setBounds(338, 248, 86, 20);
		contentPane.add(txPrecoCarro);
		
		JLabel lbInfoCadasCarro = new JLabel("Cadastrar Carro");
		lbInfoCadasCarro.setHorizontalAlignment(SwingConstants.CENTER);
		lbInfoCadasCarro.setBounds(221, 21, 203, 14);
		contentPane.add(lbInfoCadasCarro);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carro c = new Carro(txChassi.getText(), txMarca.getText(), txModelo.getText(), Integer.parseInt(txAno.getText()), Float.parseFloat(txPrecoCarro.getText()));
				
					
					//Chamar a tela final
						TelaOpcaoFinal telaOF = new TelaOpcaoFinal();
						telaOF.setVisible(true);
				
				//Classe DAO do Carro -> recebe os dados do cadastrar veículo
				CarroDAO cDAO = new CarroDAO();
				
				try {
					cDAO.salvar(c);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btSalvar.setBackground(Color.GREEN);
		btSalvar.setBounds(270, 300, 89, 75);
		contentPane.add(btSalvar);
	}
}
