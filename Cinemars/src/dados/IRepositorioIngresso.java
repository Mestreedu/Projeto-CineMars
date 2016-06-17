package dados;

import classesBasicasCinema.Ingresso;

public interface IRepositorioIngresso {
	
	
	void salvar();
	
	void cadastrar(Ingresso i);
	
	Ingresso procurar(int codigo);
	
	void remover(int codigo);
	
	boolean existe(int codigo);
}
