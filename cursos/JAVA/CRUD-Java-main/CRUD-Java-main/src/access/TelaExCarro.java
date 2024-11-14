package access;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.CarroDAO;
import model.Carro;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaExCarro extends JFrame {

	private JPanel contentPane;
	private JTextField txExcluirChassi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExCarro frame = new TelaExCarro();
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
	public TelaExCarro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInfoExCarro = new JLabel("Excluir Carro");
		lbInfoExCarro.setHorizontalAlignment(SwingConstants.CENTER);
		lbInfoExCarro.setBounds(168, 30, 86, 14);
		contentPane.add(lbInfoExCarro);
		
		JLabel lbExcluirChassi = new JLabel("Chassi");
		lbExcluirChassi.setBounds(110, 67, 48, 14);
		contentPane.add(lbExcluirChassi);
		
		txExcluirChassi = new JTextField();
		txExcluirChassi.setBounds(168, 64, 86, 20);
		contentPane.add(txExcluirChassi);
		txExcluirChassi.setColumns(10);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carro c = new Carro(txExcluirChassi.getText());
				
				//Chamar a tela final
				TelaOpcaoFinal telaOF = new TelaOpcaoFinal();
					telaOF.setVisible(true);
				
				
				CarroDAO cDAO = new CarroDAO();
				try {
					cDAO.delete(c);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(168, 124, 89, 72);
		contentPane.add(btnNewButton);
	}

}
