package controllers;

import javax.swing.JOptionPane;

import services.LoginService;
import views.LoginView;

public class LoginController {
	private LoginView view;
	private LoginService loginService;
	
	public LoginController(LoginView view, LoginService loginService) {
		this.view = view;
		this.loginService = loginService;
	}
	
	public void autenticar() {
		String nome = view.getTextFieldUser().getText();
		String senha = view.getTextFieldPassword().getText();
		boolean autenticado = loginService.autenticar(nome, senha);
		if(autenticado) {
			JOptionPane.showMessageDialog(view, "Logado");
		} else {
			JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos");			
		}
	}
	
}
