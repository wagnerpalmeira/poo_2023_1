package controllers;

import views.LoginView;

public class LoginController {
	private LoginView view;
	
	public LoginController(LoginView view) {
		this.view = view;
	}
	
	public void autenticar() {
		String nome = view.getTextFieldUser().getText();
		String senha = view.getTextFieldPassword().getText();
		if(nome.equals("teste") && senha.equals("12345")) {
			System.out.println("Logado");	
		} else {					
			System.out.println("Senha errada!");
		}
	}
	
}
