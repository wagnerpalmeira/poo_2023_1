package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Produto;

public class ProdutoDAO {
	private Connection connection;
	
	public ProdutoDAO() {
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<Produto> listar() {
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		
		String sql = "select * from produto";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery();
			while(resultados.next()) {
				listaProdutos.add(new Produto(resultados.getString("nome"), resultados.getDouble("preco")));
			}
		} catch (Exception e) {}
		return listaProdutos;
	}
	
	public boolean inserir(Produto produto) {
		String sql = "insert into produto (nome, preco, id_categoria) values (?, ?, 1)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
