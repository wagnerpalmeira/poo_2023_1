package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.LoginController;
import services.ILoginService;
import services.LoginService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;
	private LoginController loginController;

	public JTextField getTextFieldUser() {
		return textFieldUser;
	}

	public void setTextFieldUser(JTextField textFieldUser) {
		this.textFieldUser = textFieldUser;
	}

	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}

	public void setTextFieldPassword(JTextField textFieldPassword) {
		this.textFieldPassword = textFieldPassword;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					ILoginService loginService = new LoginService();
					frame.loginController = new LoginController(frame, loginService);
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(207, 47, 39, 15);
		contentPane.add(lblLogin);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(177, 74, 114, 19);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(177, 122, 114, 19);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginController.autenticar();
			}
		});
		btnEntrar.setBounds(177, 163, 117, 25);
		contentPane.add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginController.cadastrarAction();
			}
		});
		btnCadastrar.setBounds(177, 199, 117, 25);
		contentPane.add(btnCadastrar);
	}
}
