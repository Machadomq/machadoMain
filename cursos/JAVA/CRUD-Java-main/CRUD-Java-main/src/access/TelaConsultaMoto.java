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


import model.Moto;
import dados.CarroDAO;
import dados.MotoDAO;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultaMoto extends JFrame {

	private JPanel contentPane;
	private JTable tabelaMoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaMoto frame = new TelaConsultaMoto();
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
	public TelaConsultaMoto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabelaMoto = new JTable();
		tabelaMoto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaMoto.setBounds(26, 30, 378, 200);
		
		//Navegação no JTable -> JScrollPane		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(26, 30, 378, 200); //medidas e posição iguais ao JTable
		//Visualização do ScrollPane
		scroll.setViewportView(tabelaMoto);
		//Adiciona o scroll no JFrame(janela)
		contentPane.add(scroll);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//1º Dados da tabela Produto -> listar() -> ArrayList
				
				//Criar um modelo de tabela -> JTable
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Chassi"); //visualização
				modelo.addColumn("Marca");
				modelo.addColumn("Modelo");
				modelo.addColumn("Ano");
				modelo.addColumn("Cilindrada");
				modelo.addColumn("Marca do Motor");
				modelo.addColumn("Preço");
				
				
				//Objeto para receber os filtros (WHERE)
				Moto m = new Moto();
				
				MotoDAO mDAO = new MotoDAO();
				ArrayList<Moto> listaMotos = new ArrayList<Moto>();
				try {
					listaMotos = mDAO.listar(m);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Mostrar isso Tabela (JTable)
				//for(int i=0; i < listaProdutos.size(); i++) {
				for(Moto mMoto: listaMotos) {
					//Cada linha:
					
					modelo.addRow(new Object[] {
							mMoto.getChassi(),
							mMoto.getMarca(),
							mMoto.getModeloMoto(),
							mMoto.getAno(),
							mMoto.getCilindrada(),
							mMoto.getMarcaMotor(),
							mMoto.getPreco()
							
							
					});
				} //fim for
				//Aplicar o modelo dentro do JTable:
				tabelaMoto.setModel(modelo);
			}
		});
		btPesquisar.setBounds(297, 241, 107, 23);
		contentPane.add(btPesquisar);
	}
}