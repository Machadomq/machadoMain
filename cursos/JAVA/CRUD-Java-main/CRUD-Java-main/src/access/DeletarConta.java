package access;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.ContaDAO;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeletarConta extends JFrame {

	private JPanel contentPane;
	private JTextField txNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarConta frame = new DeletarConta();
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
	public DeletarConta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 44, 46, 14);
		contentPane.add(lblNome);
		
		txNome = new JTextField();
		txNome.setBounds(20, 69, 86, 20);
		contentPane.add(txNome);
		txNome.setColumns(10);
		
		JButton btDeletar = new JButton("Deletar");
		btDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				ContaDAO cDAO = new ContaDAO();
				//tratamento de erro:
				try {
					cDAO.deletar(txNome.getText().toString());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btDeletar.setBounds(265, 70, 89, 23);
		contentPane.add(btDeletar);
		
		JLabel lbTitulo = new JLabel("Insira o nome do usu\u00E1rio que ter\u00E1 a conta deletada.");
		lbTitulo.setBounds(20, 11, 334, 14);
		contentPane.add(lbTitulo);
	}
}
