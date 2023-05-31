package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controllers.ValidacaoLogin;
import controllers.ValidacaoLoginEmail;
import controllers.ValidacaoTamanhoLogin;
import dao.UsuarioDao;

public class LoginService implements ILoginService {
	private List<ValidacaoLogin> validacoes = new ArrayList<>();
	
	
	public LoginService() {
		this.validacoes.add(new ValidacaoTamanhoLogin());
		this.validacoes.add(new ValidacaoLoginEmail());
	}
	
	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public boolean autenticar(String login, String senha) {
		try {
			this.validacoes.forEach(validacao -> validacao.validar(login, senha));
			ResultSet resultado = usuarioDao.autenticar(login, senha);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage().toString());
		}
		
		return false;
	}
}
