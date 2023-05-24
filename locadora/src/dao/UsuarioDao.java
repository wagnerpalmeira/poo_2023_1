package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Usuario;

public class UsuarioDao {
	Connection connection;
	
	public UsuarioDao() {
		try {
			String DATABASE = "jdbc:sqlite:/home/ownard/Documentos/aula_db";
			this.connection = DriverManager.getConnection(DATABASE);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public boolean inserir(Usuario usuario) {
		String sql = "INSERT INTO usuarios(nome, username, email, senha) values (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getUsername());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
	public ResultSet autenticar(String username, String senha) {
		String sql = "SELECT * FROM usuarios WHERE username=? AND senha=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, senha);
			return stmt.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	
}
