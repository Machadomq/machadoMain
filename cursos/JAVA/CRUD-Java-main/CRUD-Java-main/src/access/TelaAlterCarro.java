package access;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.CarroDAO;
import model.Carro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaAlterCarro extends JFrame {

	private JPanel contentPane;
	private JTextField txChassiAnt;
	private JTextField txNewChassi;
	private JTextField txNewMarca;
	private JTextField txNewModelo;
	private JTextField txNewAno;
	private JTextField txNewPreco;

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
	public TelaAlterCarro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbDadosAnt = new JLabel("Dados Antigos");
		lbDadosAnt.setHorizontalAlignment(SwingConstants.CENTER);
		lbDadosAnt.setBounds(170, 24, 86, 14);
		contentPane.add(lbDadosAnt);
		
		JLabel lbDadosNovos = new JLabel("Novos Dados");
		lbDadosNovos.setHorizontalAlignment(SwingConstants.CENTER);
		lbDadosNovos.setBounds(170, 87, 86, 14);
		contentPane.add(lbDadosNovos);
		
		JLabel lbChassiAnt = new JLabel("Chassi");
		lbChassiAnt.setBounds(113, 52, 46, 14);
		contentPane.add(lbChassiAnt);
		
		//Chassi Anitgo
		txChassiAnt = new JTextField();
		txChassiAnt.setBounds(170, 49, 86, 20);
		contentPane.add(txChassiAnt);
		txChassiAnt.setColumns(10);
		
		JLabel lbNewChassi = new JLabel("Chassi");
		lbNewChassi.setBounds(113, 112, 46, 14);
		contentPane.add(lbNewChassi);
		
		JLabel lbNewMarca = new JLabel("Marca");
		lbNewMarca.setBounds(113, 142, 46, 14);
		contentPane.add(lbNewMarca);
		
		JLabel lbNewModelo = new JLabel("Modelo");
		lbNewModelo.setBounds(113, 172, 46, 14);
		contentPane.add(lbNewModelo);
		
		JLabel lbNewAno = new JLabel("Ano");
		lbNewAno.setBounds(113, 202, 46, 14);
		contentPane.add(lbNewAno);
		
		JLabel lnNewPreco = new JLabel("Pre\u00E7o");
		lnNewPreco.setBounds(113, 232, 46, 14);
		contentPane.add(lnNewPreco);
		
		//Novo Chassi
		txNewChassi = new JTextField();
		txNewChassi.setBounds(170, 109, 86, 20);
		contentPane.add(txNewChassi);
		txNewChassi.setColumns(10);
		
		//Nova Marca
		txNewMarca = new JTextField();
		txNewMarca.setColumns(10);
		txNewMarca.setBounds(170, 139, 86, 20);
		contentPane.add(txNewMarca);
		
		//Novo Modelo
		txNewModelo = new JTextField();
		txNewModelo.setColumns(10);
		txNewModelo.setBounds(170, 169, 86, 20);
		contentPane.add(txNewModelo);
		
		//Novo Ano
		txNewAno = new JTextField();
		txNewAno.setColumns(10);
		txNewAno.setBounds(170, 199, 86, 20);
		contentPane.add(txNewAno);
		
		//Novo Preco
		txNewPreco = new JTextField();
		txNewPreco.setColumns(10);
		txNewPreco.setBounds(170, 229, 86, 20);
		contentPane.add(txNewPreco);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carro c = new Carro(txNewChassi.getText(), txNewMarca.getText(), txNewModelo.getText(), Integer.parseInt(txNewAno.getText()), Float.parseFloat(txNewPreco.getText()));
				
				//Chamar a tela final
				TelaOpcaoFinal telaOF = new TelaOpcaoFinal();
				telaOF.setVisible(true);
				
				CarroDAO cDAO = new CarroDAO();
					try {
						cDAO.alterar(c, txChassiAnt.getText());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					dispose();
					setVisible(false);
			}
		});
		btAlterar.setBackground(Color.GREEN);
		btAlterar.setBounds(319, 93, 89, 78);
		contentPane.add(btAlterar);
	}
}
