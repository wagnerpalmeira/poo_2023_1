package main;

public class Funcionario extends Pessoa {
	private String matricula;

	public String getMatricula() {
		return matricula;
	}
	
	public Funcionario(String nome, String cpf, String matricula) {
		super(cpf, nome);
		this.matricula = matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String getNome() {
		return "Funcionario: " + super.getNome();
	}
	
	@Override
	public String toString() {
		return "Nome" + this.getNome() + "Cpf...";
	}
	
}
