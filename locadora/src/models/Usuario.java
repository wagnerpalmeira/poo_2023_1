package models;

public class Usuario {
	private String nome;
	private String username;
	private String senha;
	private String email;
	
	public Usuario(String nome, String username, String senha, String email) {
		this.nome = nome;
		this.username = username;
		this.senha = senha;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
