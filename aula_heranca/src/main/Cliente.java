package main;

public class Cliente extends Pessoa {
	
	public Cliente(String cpf, String nome) {
		super(cpf, nome);
	}

	@Override
	public String getNome() {
		return "Cliente: " + super.getNome();
	}

}
