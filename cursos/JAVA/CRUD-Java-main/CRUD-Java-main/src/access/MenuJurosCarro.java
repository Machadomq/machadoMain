package access;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MenuJurosCarro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJurosCarro frame = new MenuJurosCarro();
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
	public MenuJurosCarro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel btTitulo = new JLabel("Escolha entre juros simples ou compostos");
		btTitulo.setBounds(5, 5, 424, 14);
		contentPane.add(btTitulo);
		
		JButton btJurosSimples = new JButton("Juros simples");
		btJurosSimples.setBounds(10, 100, 140, 23);
		contentPane.add(btJurosSimples);
		
		JButton btJurosCompostos = new JButton("Juros compostos");
		btJurosCompostos.setBounds(284, 100, 140, 23);
		contentPane.add(btJurosCompostos);
	}

}
