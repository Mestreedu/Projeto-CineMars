package dados;

import classesBasicasCinema.Filme;

public interface IRepositorioFilme {

	void salvar();

	void cadastrar(Filme f);

	Filme procurar(String ID);

	void remover(String ID);

	boolean existe(String ID);

}