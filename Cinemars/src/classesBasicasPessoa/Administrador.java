package classesBasicasPessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classesBasicasCinema.Cinema;

public class Administrador extends Pessoa implements Serializable {
	
	private List<Cinema> cinemas;
	
	private static final long serialVersionUID = -8441289941209738977L;

	public Administrador(String nome, String email, String login, String senha, List<Cinema> cinemas) {
		super(nome, email, login, senha);
		cinemas = new ArrayList<Cinema>();
		this.cinemas = cinemas;
	}
	
	public void adicionarCinema(Cinema c){
		if(c != null){
			cinemas.add(c);
		}
	}
}
