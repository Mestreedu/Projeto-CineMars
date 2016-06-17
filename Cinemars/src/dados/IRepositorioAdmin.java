package dados;

import java.util.ArrayList;

import classesBasicasCinema.Cinema;
import classesBasicasPessoa.Administrador;

public interface IRepositorioAdmin {

	void salvar();

	void cadastrar(Administrador a);

	Administrador procurar(String login);

	void remover(String login);

	boolean existe(String login);
	
}
