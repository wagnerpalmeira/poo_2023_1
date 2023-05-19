package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CadastrarUsuarioController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUsuarioView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private JLabel lblNome;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblSenha;
	
	private CadastrarUsuarioController cadastrarUsuarioController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuarioView frame = new CadastroUsuarioView();
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
	public CadastroUsuarioView() {
		this.cadastrarUsuarioController = new CadastrarUsuarioController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(164, 12, 114, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(164, 43, 114, 19);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(164, 74, 114, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(164, 105, 114, 19);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarUsuarioController.cadastrar();
			}
		});
		btnCadastrar.setBounds(164, 162, 117, 25);
		contentPane.add(btnCadastrar);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(76, 14, 70, 15);
		contentPane.add(lblNome);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(76, 45, 70, 15);
		contentPane.add(lblUsername);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(71, 76, 70, 15);
		contentPane.add(lblEmail);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(71, 107, 70, 15);
		contentPane.add(lblSenha);
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public void setTextFieldUsername(JTextField textFieldUsername) {
		this.textFieldUsername = textFieldUsername;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public void setTextFieldSenha(JTextField textFieldSenha) {
		this.textFieldSenha = textFieldSenha;
	}
	
}
