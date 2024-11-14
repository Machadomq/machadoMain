package access;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.MotoDAO;
import model.Moto;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaMoto extends JFrame {

	private JPanel contentPane;
	private JTextField txChassi;
	private JTextField txMarca;
	private JTextField txModeloMoto;
	private JTextField txAno;
	private JTextField txCilindrada;
	private JTextField txMarcaMotor;
	private JTextField txPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMoto frame = new TelaMoto();
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
	public TelaMoto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbChassi = new JLabel("Chassi:");
		lbChassi.setBounds(116, 60, 80, 14);
		contentPane.add(lbChassi);
		
		JLabel lbMarca = new JLabel("Marca:");
		lbMarca.setBounds(116, 85, 80, 14);
		contentPane.add(lbMarca);
		
		JLabel lbModeloMoto = new JLabel("Modelo:");
		lbModeloMoto.setBounds(116, 110, 80, 14);
		contentPane.add(lbModeloMoto);
		
		JLabel lbAno = new JLabel("Ano:");
		lbAno.setBounds(116, 135, 80, 14);
		contentPane.add(lbAno);
		
		JLabel lbMarcaMotor = new JLabel("Marca do Motor:");
		lbMarcaMotor.setBounds(116, 185, 80, 14);
		contentPane.add(lbMarcaMotor);
		
		JLabel lbCilindrada = new JLabel("Cilindrada:");
		lbCilindrada.setBounds(116, 160, 80, 14);
		contentPane.add(lbCilindrada);
		
		JLabel lbInformacao = new JLabel("Cadastro da Moto");
		lbInformacao.setBounds(181, 11, 93, 14);
		contentPane.add(lbInformacao);
		
		JLabel lbPreco = new JLabel("Preco:");
		lbPreco.setBounds(116, 210, 80, 14);
		contentPane.add(lbPreco);
		
		txChassi = new JTextField();
		txChassi.setBounds(245, 57, 86, 20);
		contentPane.add(txChassi);
		txChassi.setColumns(10);
		
		txMarca = new JTextField();
		txMarca.setColumns(10);
		txMarca.setBounds(245, 82, 86, 20);
		contentPane.add(txMarca);
		
		txModeloMoto = new JTextField();
		txModeloMoto.setColumns(10);
		txModeloMoto.setBounds(245, 107, 86, 20);
		contentPane.add(txModeloMoto);
		
		txAno = new JTextField();
		txAno.setColumns(10);
		txAno.setBounds(245, 132, 86, 20);
		contentPane.add(txAno);
		
		txCilindrada = new JTextField();
		txCilindrada.setColumns(10);
		txCilindrada.setBounds(245, 157, 86, 20);
		contentPane.add(txCilindrada);
		
		txMarcaMotor = new JTextField();
		txMarcaMotor.setColumns(10);
		txMarcaMotor.setBounds(245, 182, 86, 20);
		contentPane.add(txMarcaMotor);
		
		txPreco = new JTextField();
		txPreco.setColumns(10);
		txPreco.setBounds(245, 207, 86, 20);
		contentPane.add(txPreco);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moto m = new Moto(txChassi.getText(), txMarca.getText(), txModeloMoto.getText(), Integer.parseInt(txAno.getText()), Integer.parseInt(txCilindrada.getText()), txMarcaMotor.getText(), Float.parseFloat(txPreco.getText()));
				
					//Chamar a tela final
					TelaOpcaoFinal telaOF = new TelaOpcaoFinal();
						telaOF.setVisible(true);
				
				//Chamar a classe MotoDAO -> recebe o dados para salvar
				MotoDAO mDAO = new MotoDAO();
				
				try {
					mDAO.salvar(m);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btSalvar.setBackground(Color.GREEN);
		btSalvar.setBounds(168, 238, 89, 23);
		contentPane.add(btSalvar);
	}
}
