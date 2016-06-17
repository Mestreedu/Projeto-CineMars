package dados;

import classesBasicasCinema.Filme;

public interface IRepositorioFilme {

	void salvar();

	/* (non-Javadoc)
	 * @see dados.IRepositorioFilme#cadastrar(classesBasicasCinema.Filme)
	 */
	void cadastrar(Filme f);

	/* (non-Javadoc)
	 * @see dados.IRepositorioFilme#procurar(java.lang.String)
	 */
	Filme procurar(String ID);

	/* (non-Javadoc)
	 * @see dados.IRepositorioFilme#remover(java.lang.String)
	 */
	void remover(String ID);

	/* (non-Javadoc)
	 * @see dados.IRepositorioFilme#existe(java.lang.String)
	 */
	boolean existe(String ID);

}