package services;

public class LoginService implements ILoginService {
	
	public boolean autenticar(String login, String senha) {
		if(login.equals("teste") && senha.equals("12345")) {
			return true;
		}
		
		return false;
	}
}
