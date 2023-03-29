package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Pessoa> listaPessoas = new ArrayList<>();
		Pessoa cliente = new Cliente(null, null);
		cliente.setSalario(20D);
		listaPessoas.add(cliente);
		Pessoa cliente2= new Cliente(null, null);
		cliente2.setSalario(30D);
		listaPessoas.add(cliente2);
		Pessoa funcionario = new Funcionario(null, null, null);
		funcionario.setSalario(200D);
		listaPessoas.add(funcionario);
		Double totalSalarios = 0D;
		for(Pessoa p: listaPessoas) {
			totalSalarios += p.getSalario();
		}
		System.out.println(totalSalarios);
	
	}

}
