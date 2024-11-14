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

public class MenuFinanciamento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFinanciamento frame = new MenuFinanciamento();
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
	public MenuFinanciamento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Escolha entre financiar um carro ou uma moto.");
		lblTitulo.setBounds(5, 5, 424, 14);
		contentPane.add(lblTitulo);
		
		JButton btFinanciarCarro = new JButton("Carro");
		btFinanciarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuJurosCarro jurosC = new MenuJurosCarro();
				jurosC.setVisible(true);
			}
		});
		btFinanciarCarro.setBounds(10, 72, 142, 115);
		contentPane.add(btFinanciarCarro);
		
		JButton btFinanciarMoto = new JButton("Moto");
		btFinanciarMoto.setBounds(282, 72, 142, 115);
		contentPane.add(btFinanciarMoto);
	}
}
