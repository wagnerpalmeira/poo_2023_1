package services;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;

public class LoginService implements ILoginService {
	
	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public boolean autenticar(String login, String senha) {
		try {
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
