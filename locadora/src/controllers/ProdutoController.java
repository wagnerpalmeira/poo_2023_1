package controllers;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ProdutoDAO;
import models.Produto;
import views.HomeView;

public class ProdutoController {
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private HomeView homeView;
	
	public ProdutoController(HomeView homeView) {
		this.homeView = homeView;
	}
	
	public void listarProdutos() {
		ArrayList<Produto> produtos = produtoDAO.listar();
		JTable table = homeView.getTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(Produto produto: produtos) {
			model.addRow(new Object[] { produto.getNome(), produto.getPreco() });
		}		
	}
	
	public void inserirProduto() {
		String nome = homeView.getTextFieldNome().getText();
		Double preco = Double.valueOf(homeView.getTextFieldPreco().getText());
		Produto produto = new Produto(nome, preco);
		produtoDAO.inserir(produto);
		this.listarProdutos();
	}
}
