package access;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class MenuConta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuConta frame = new MenuConta();
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
	boolean sair = false;
	public MenuConta() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 200);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lbCriarConta = new JLabel("Clique aqui para adicionar uma nova conta:");
			lbCriarConta.setBounds(20, 24, 305, 14);
			contentPane.add(lbCriarConta);
			
			JButton btCriarConta = new JButton("Criar");
			btCriarConta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AbrirConta abrirC = null;
					try {
						abrirC = new AbrirConta();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					abrirC.setVisible(true);
				}
			});
			btCriarConta.setBounds(335, 20, 89, 23);
			contentPane.add(btCriarConta);
			
			JLabel lbAlterarConta = new JLabel("Clique aqui para atualizar uma conta:");
			lbAlterarConta.setBounds(20, 63, 305, 14);
			contentPane.add(lbAlterarConta);
			
			JButton btAtualizarConta = new JButton("Atualizar");
			btAtualizarConta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AlterarConta alterarC = new AlterarConta();
					alterarC.setVisible(true);
				}
			});
			btAtualizarConta.setBounds(335, 54, 89, 23);
			contentPane.add(btAtualizarConta);
			
			JLabel lbDeletarConta = new JLabel("Clique aqui para deletar uma conta:");
			lbDeletarConta.setBounds(20, 100, 305, 14);
			contentPane.add(lbDeletarConta);
			
			JButton btDeletarConta = new JButton("Deletar");
			btDeletarConta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeletarConta deletarC = new DeletarConta();
					deletarC.setVisible(true);
				}
			});
			btDeletarConta.setBounds(335, 88, 89, 23);
			contentPane.add(btDeletarConta);
			
			JButton btSair = new JButton("Sair");
			btSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sair = true;
				}
			});
			btSair.setBounds(10, 125, 89, 23);
			contentPane.add(btSair);
			
		}
	}
