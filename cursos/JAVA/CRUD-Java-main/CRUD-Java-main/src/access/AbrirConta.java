package access;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import model.Conta;
import dados.ContaDAO;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class AbrirConta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txNome;
	private JTextField txCpf;
	private JTextField txDataNasc;
	private JTextField txFone;
	private JTextField txLogradouro;
	private JTextField txNumero;
	private JTextField txComplemento;
	private JTextField txBairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirConta frame = new AbrirConta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws   
	 */
	public AbrirConta() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbNome = new JLabel("Nome");
		
		txNome = new JTextField();
		txNome.setColumns(10);
		
		JLabel lbCpf = new JLabel("Cpf");
		
		txCpf = new JTextField();
		txCpf.setColumns(10);
		
		JLabel lbDataNasc = new JLabel("Data de Nascimento");
		
		txDataNasc = new JTextField();
		txDataNasc.setColumns(10);
		
		JLabel lbFone = new JLabel("Telefone");
		
		txFone = new JTextField();
		txFone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel txTituloEndereco = new JLabel("Endere\u00E7o:");
		txTituloEndereco.setForeground(new Color(0, 0, 0));
		
		JLabel lbLogradouro = new JLabel("Rua");
		
		txLogradouro = new JTextField();
		txLogradouro.setColumns(10);
		
		JLabel lbNumero = new JLabel("N\u00FAmero");
		
		txNumero = new JTextField();
		txNumero.setColumns(10);
		
		JLabel lbComplemento = new JLabel("Complemento");
		
		txComplemento = new JTextField();
		txComplemento.setColumns(10);
		
		JLabel lbBairro = new JLabel("Bairro");
		
		txBairro = new JTextField();
		txBairro.setColumns(10);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//salvar no banco de dados:
				//guardar os dados 
				Conta conta = new Conta();
				conta.setNome(txNome.getText().toString());
				conta.setCpf(txCpf.getText().toString());
				conta.setFone(Integer.parseInt(txFone.getText().toString()));
				SimpleDateFormat f = new SimpleDateFormat ("dd/MM/yyyy");
				try {
					conta.setDataNasc(f.parse(txDataNasc.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//DAO:
				ContaDAO c = new ContaDAO();
				try {
					c.salvar(conta);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0, 10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lbNome, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbCpf)
										.addComponent(lbDataNasc)
										.addComponent(lbFone)
										.addComponent(lbLogradouro))
									.addGap(48)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txLogradouro)
										.addComponent(txFone)
										.addComponent(txDataNasc)
										.addComponent(txCpf)
										.addComponent(txNome, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
										.addComponent(txNumero)
										.addComponent(txComplemento)
										.addComponent(txBairro)
										.addComponent(txTituloEndereco, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(lbNumero))
					.addGap(111))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbComplemento)
					.addContainerGap(368, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbBairro)
					.addContainerGap(386, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btSalvar)
					.addContainerGap(335, Short.MAX_VALUE))
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNome, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbCpf)
						.addComponent(txCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbDataNasc)
						.addComponent(txDataNasc, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbFone)
						.addComponent(txFone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txTituloEndereco, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbLogradouro)
						.addComponent(txLogradouro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbNumero)
						.addComponent(txNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbComplemento)
						.addComponent(txComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbBairro)
						.addComponent(txBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(btSalvar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
