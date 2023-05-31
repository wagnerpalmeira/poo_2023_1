package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.ProdutoController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	private ProdutoController produtoController;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
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
	public HomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(35, 24, 114, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(175, 24, 114, 19);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		JLabel lblLogin = new JLabel("Nome");
		lblLogin.setBounds(35, -3, 70, 15);
		contentPane.add(lblLogin);
		
		JLabel lblTelefone = new JLabel("Preço");
		lblTelefone.setBounds(175, -3, 70, 15);
		contentPane.add(lblTelefone);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 55, 371, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtoController.inserirProduto();
			}
		});
		btnInserir.setBounds(321, 21, 117, 25);
		contentPane.add(btnInserir);
		this.produtoController = new ProdutoController(this);
		this.produtoController.listarProdutos();
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextFieldPreco() {
		return textFieldPreco;
	}

	public void setTextFieldPreco(JTextField textFieldPreco) {
		this.textFieldPreco = textFieldPreco;
	}
	
	
	
	
}
