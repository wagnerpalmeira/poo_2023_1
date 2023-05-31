package controllers;

public class ValidacaoLoginEmail implements ValidacaoLogin {

	@Override
	public void validar(String login, String senha) {
		if(!login.contains("@")) {
			throw new RuntimeException("Login tem que ser e-mail.");
		}
	}

}
