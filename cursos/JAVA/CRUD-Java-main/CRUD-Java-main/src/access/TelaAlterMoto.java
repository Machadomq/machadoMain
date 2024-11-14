package access;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.CarroDAO;
import dados.MotoDAO;
import model.Carro;
import model.Moto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaAlterMoto extends JFrame {

	private JPanel contentPane;
	private JTextField txChassiAntMoto;
	private JTextField txNewChassi;
	private JTextField txNewMarca;
	private JTextField txNewModelo;
	private JTextField txNewAno;
	private JTextField txNewPreco;
	private JTextField txCilindrada;
	private JTextField txMarcaMotor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterCarro frame = new TelaAlterCarro();
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
	public TelaAlterMoto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbDadosAnt = new JLabel("Dados Antigos");
		lbDadosAnt.setHorizontalAlignment(SwingConstants.CENTER);
		lbDadosAnt.setBounds(170, 11, 86, 14);
		contentPane.add(lbDadosAnt);
		
		JLabel lbDadosNovos = new JLabel("Novos Dados");
		lbDadosNovos.setHorizontalAlignment(SwingConstants.CENTER);
		lbDadosNovos.setBounds(170, 67, 86, 14);
		contentPane.add(lbDadosNovos);
		
		JLabel lbChassiAnt = new JLabel("Chassi");
		lbChassiAnt.setBounds(113, 39, 46, 14);
		contentPane.add(lbChassiAnt);
		
		//Chassi Anitgo
		txChassiAntMoto = new JTextField();
		txChassiAntMoto.setBounds(170, 36, 86, 20);
		contentPane.add(txChassiAntMoto);
		txChassiAntMoto.setColumns(10);
		
		JLabel lbNewChassi = new JLabel("Chassi");
		lbNewChassi.setBounds(49, 93, 46, 14);
		contentPane.add(lbNewChassi);
		
		JLabel lbNewMarca = new JLabel("Marca");
		lbNewMarca.setBounds(49, 123, 46, 14);
		contentPane.add(lbNewMarca);
		
		JLabel lbNewModelo = new JLabel("Modelo");
		lbNewModelo.setBounds(209, 92, 46, 14);
		contentPane.add(lbNewModelo);
		
		JLabel lbNewAno = new JLabel("Ano");
		lbNewAno.setBounds(209, 123, 46, 14);
		contentPane.add(lbNewAno);
		
		JLabel lnNewPreco = new JLabel("Pre\u00E7o");
		lnNewPreco.setBounds(133, 185, 46, 14);
		contentPane.add(lnNewPreco);
		
		//Novo Chassi
		txNewChassi = new JTextField();
		txNewChassi.setBounds(113, 90, 86, 20);
		contentPane.add(txNewChassi);
		txNewChassi.setColumns(10);
		
		//Nova Marca
		txNewMarca = new JTextField();
		txNewMarca.setColumns(10);
		txNewMarca.setBounds(113, 120, 86, 20);
		contentPane.add(txNewMarca);
		
		//Novo Modelo
		txNewModelo = new JTextField();
		txNewModelo.setColumns(10);
		txNewModelo.setBounds(306, 90, 86, 20);
		contentPane.add(txNewModelo);
		
		//Novo Ano
		txNewAno = new JTextField();
		txNewAno.setColumns(10);
		txNewAno.setBounds(306, 120, 86, 20);
		contentPane.add(txNewAno);
		
		//Novo Preco
		txNewPreco = new JTextField();
		txNewPreco.setColumns(10);
		txNewPreco.setBounds(183, 182, 86, 20);
		contentPane.add(txNewPreco);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moto m = new Moto(txNewChassi.getText(), txNewMarca.getText(), txNewModelo.getText(), Integer.parseInt(txNewAno.getText()), Integer.parseInt(txCilindrada.getText()), txMarcaMotor.getText(), Float.parseFloat(txNewPreco.getText()));
				
				
					//Chamar a tela final
					TelaOpcaoFinal telaOF = new TelaOpcaoFinal();
					telaOF.setVisible(true);
				
					//Classe para salvar os dados no BD, MotoDAO -> recebe os dados para salvar
					MotoDAO mDAO = new MotoDAO();
						try {
							mDAO.alterar(m, txChassiAntMoto.getText());
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
						
			}
		});
		btAlterar.setBackground(Color.GREEN);
		btAlterar.setBounds(143, 223, 139, 29);
		contentPane.add(btAlterar);
		
		JLabel lbCilindrada = new JLabel("Cilindrada");
		lbCilindrada.setBounds(49, 156, 59, 14);
		contentPane.add(lbCilindrada);
		
		//Cilindrada
		txCilindrada = new JTextField();
		txCilindrada.setColumns(10);
		txCilindrada.setBounds(113, 151, 86, 20);
		contentPane.add(txCilindrada);
		
		JLabel lblMarcaDoMotor = new JLabel("Marca do Motor");
		lblMarcaDoMotor.setBounds(210, 156, 86, 14);
		contentPane.add(lblMarcaDoMotor);
		
		//Marca do Motor
		txMarcaMotor = new JTextField();
		txMarcaMotor.setColumns(10);
		txMarcaMotor.setBounds(306, 151, 86, 20);
		contentPane.add(txMarcaMotor);
	}
}
