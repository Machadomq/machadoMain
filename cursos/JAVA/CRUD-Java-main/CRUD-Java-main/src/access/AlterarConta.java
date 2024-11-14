package access;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Conta;
import dados.ContaDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class AlterarConta extends JFrame {

	private JPanel contentPane;
	private JTextField txNomeAntigo;
	private JTextField txNovoNome;
	private JTextField txNovoCpf;
	private JTextField txNovoDataNasc;
	private JTextField txNovoFone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarConta frame = new AlterarConta();
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
	public AlterarConta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbTitulo = new JLabel("Alterar conta:");
		
		JLabel lbNome = new JLabel("Nome do cliente:");
		
		txNomeAntigo = new JTextField();
		txNomeAntigo.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JLabel lbNovoNome = new JLabel("Novo nome:");
		
		txNovoNome = new JTextField();
		txNovoNome.setColumns(10);
		
		JLabel lbNovoCpf = new JLabel("Novo cpf:");
		
		txNovoCpf = new JTextField();
		txNovoCpf.setColumns(10);
		
		JLabel lbNovoDataNasc = new JLabel("Data nascimento:");
		
		txNovoDataNasc = new JTextField();
		txNovoDataNasc.setColumns(10);
		
		JLabel lbNovoFone = new JLabel("Novo Telefone");
		
		txNovoFone = new JTextField();
		txNovoFone.setColumns(10);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//update no banco de dados:
				Conta c = new Conta();
				c.setNome(txNovoNome.getText().toString());
				c.setNome(txNovoCpf.getText().toString());
				c.setFone(Integer.parseInt(txNovoFone.getText().toString()));
				SimpleDateFormat f = new SimpleDateFormat ("dd/MM/yyyy");
				try {
					c.setDataNasc(f.parse(txNovoDataNasc.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//DAO (update no bd):
				ContaDAO cDAO = new ContaDAO();
				try {
					cDAO.alterar(c, txNomeAntigo.getText());
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(163)
							.addComponent(lbTitulo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txNomeAntigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(99)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbNome))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lbNovoCpf)
								.addComponent(lbNovoDataNasc)
								.addComponent(lbNovoNome)
								.addComponent(lbNovoFone))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txNovoCpf, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
								.addComponent(txNovoNome, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
								.addComponent(txNovoDataNasc, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
								.addComponent(txNovoFone, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(336, Short.MAX_VALUE)
					.addComponent(btAlterar)
					.addGap(25))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lbTitulo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNome)
						.addComponent(txNovoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbNovoNome))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txNomeAntigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbNovoCpf)
								.addComponent(txNovoCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbNovoDataNasc)
								.addComponent(txNovoDataNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbNovoFone)
								.addComponent(txNovoFone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btAlterar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
