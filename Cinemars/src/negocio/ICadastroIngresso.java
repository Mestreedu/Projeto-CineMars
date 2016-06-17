package negocio;

import classesBasicasCinema.Ingresso;

public interface ICadastroIngresso {
	
	public abstract void cadastrar(Ingresso i);

	public abstract boolean existe(int codigo);

	public abstract Ingresso procurar(int codigo);

	public abstract void remover(int codigo);
	
	public abstract void salvar();

}
