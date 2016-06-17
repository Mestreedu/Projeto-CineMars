package dados;

import classesBasicasPessoa.Usuario;

public interface IRepositorioUsuario {

	void salvar();

	/* (non-Javadoc)
	 * @see dados.IRepositorioUsuario#cadastrar(classesBasicasPessoa.Usuario)
	 */
	void cadastrar(Usuario u);

	/* (non-Javadoc)
	 * @see dados.IRepositorioUsuario#procurar(java.lang.String)
	 */
	Usuario procurar(String login);

	/* (non-Javadoc)
	 * @see dados.IRepositorioUsuario#remover(java.lang.String)
	 */
	void remover(String login);

	/* (non-Javadoc)
	 * @see dados.IRepositorioUsuario#existe(java.lang.String)
	 */
	boolean existe(String login);
	
	void printar(Usuario u);

}