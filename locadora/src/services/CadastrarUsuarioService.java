package services;

import dao.UsuarioDao;
import models.Usuario;

public class CadastrarUsuarioService implements ICadastrarUsuarioService{
	UsuarioDao usuarioDao = new UsuarioDao();
	
	@Override
	public boolean cadastrar(String nome, String username, String email, String senha) {
//		Atividade 01: Criar regras de validação para nome e email
		Usuario usuario = new Usuario(nome, username, senha, email);
		return this.usuarioDao.inserir(usuario);
	}
}
