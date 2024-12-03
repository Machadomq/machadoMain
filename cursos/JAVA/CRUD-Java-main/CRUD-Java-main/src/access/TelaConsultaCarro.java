package access;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;


import model.Carro;
import dados.CarroDAO;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultaCarro extends JFrame {

	private JPanel contentPane;
	private JTable tabelaCarro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaCarro frame = new TelaConsultaCarro();
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
	public TelaConsultaCarro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabelaCarro = new JTable();
		tabelaCarro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaCarro.setBounds(26, 30, 378, 200);
		
		//Navega��o no JTable -> JScrollPane		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(26, 30, 378, 200); //medidas e posi��o iguais ao JTable
		//Visualiza��o do ScrollPane
		scroll.setViewportView(tabelaCarro);
		//Adiciona o scroll no JFrame(janela)
		contentPane.add(scroll);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//1� Dados da tabela Produto -> listar() -> ArrayList
				
				//Criar um modelo de tabela -> JTable
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Chassi"); 
				modelo.addColumn("Marca");
				modelo.addColumn("Modelo");
				modelo.addColumn("Ano");
				modelo.addColumn("Preco");
				
				
				//Objeto para receber os filtros (WHERE)
				Carro c = new Carro();
				
				CarroDAO cDAO = new CarroDAO();
				ArrayList<Carro> listaProdutos = new ArrayList<Carro>();
				try {
					listaProdutos = cDAO.listar(c);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Mostrar isso Tabela (JTable)
				//for(int i=0; i < listaProdutos.size(); i++) {
				for(Carro cCarro: listaProdutos) {
					//Cada linha:
					
					modelo.addRow(new Object[] {
							cCarro.getChassi(),
							cCarro.getMarca(),
							cCarro.getModelo(),
							cCarro.getModelo(),
							cCarro.getAno(),
							cCarro.getPreco()
							
							
					});
				} 
				//Aplicar o modelo dentro do JTable:
				tabelaCarro.setModel(modelo);
			}
		});
		btPesquisar.setBounds(297, 241, 107, 23);
		contentPane.add(btPesquisar);
	}
}