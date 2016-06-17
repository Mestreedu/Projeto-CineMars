package classesBasicasPessoa;

import java.io.Serializable;

public class Administrador extends Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8441289941209738977L;

	public Administrador(String nome, String email, String login, String senha) {
		super(nome, email, login, senha);

	}
}
