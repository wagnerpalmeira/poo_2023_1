package controllers;

import services.CadastrarUsuarioService;
import views.CadastroUsuarioView;

public class CadastrarUsuarioController {
	CadastroUsuarioView cadastroUsuarioView;
	
	public CadastrarUsuarioController(CadastroUsuarioView view) {
		this.cadastroUsuarioView = view;
	}
	
	public void cadastrar() {
		CadastrarUsuarioService service = new CadastrarUsuarioService();
		service.cadastrar(
				this.cadastroUsuarioView.getTextFieldNome().getText(),
				this.cadastroUsuarioView.getTextFieldUsername().getText(),
				this.cadastroUsuarioView.getTextFieldEmail().getText(),
				this.cadastroUsuarioView.getTextFieldSenha().getText());
	}
}
