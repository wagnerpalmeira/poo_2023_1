package controllers;

public class ValidacaoTamanhoLogin implements ValidacaoLogin {

	@Override
	public void validar(String login, String senha) {
		if(login.length() < 3) {
			throw new RuntimeException("Login tem que ter mais que 3 digitos.");
		}	
	}

}
