package pdf;

public class Administrador {

	private String login;
	private String senha;
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public String getSenha(){
		return senha;
	}
	
	public String getLogin(){
		return login;
	}
	
}
