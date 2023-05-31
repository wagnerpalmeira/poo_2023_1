package controllers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import services.ILoginService;
import views.CadastroUsuarioView;
import views.HomeView;
import views.LoginView;

public class LoginController {
	private LoginView view;
	private ILoginService loginService;
	private HomeView proximaTela = new HomeView();
	
	public LoginController(LoginView view, ILoginService loginService) {
		this.view = view;
		this.loginService = loginService;
	}
	
	public void autenticar() {
		String nome = view.getTextFieldUser().getText();
		String senha = view.getTextFieldPassword().getText();
		try {			
			boolean autenticado = loginService.autenticar(nome, senha);
			if(autenticado) {
				JOptionPane.showMessageDialog(view, "Logado");
				proximaTela.setVisible(true);
				view.setVisible(false);
				
			} else {
				JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos");			
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, e.getMessage());
		}
	}
	
	public void cadastrarAction() {
		CadastroUsuarioView cadastroUsuarioView = new CadastroUsuarioView();
		cadastroUsuarioView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadastroUsuarioView.setVisible(true);
	}

	
}
