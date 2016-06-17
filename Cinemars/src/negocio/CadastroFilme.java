package negocio;

import java.io.Serializable;

import classesBasicasCinema.Filme;
import dados.IRepositorioFilme;
import dados.RepositorioFilmesArray;

public class CadastroFilme implements ICadastroFilme, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3249574711866813942L;
	private IRepositorioFilme repositorio;

	public CadastroFilme() {
		this.repositorio = RepositorioFilmesArray.getInstance();
	}

	/* (non-Javadoc)
	 * @see negocio.ICadastroFilme#cadastrar(classesBasicasCinema.Filme)
	 */
	@Override
	public void cadastrar(Filme f) {
		if (f == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (!this.existe(f.getID())) {
				this.repositorio.cadastrar(f);
			} else {
				System.out.println("ERRO! FILME J� CADASTRADO!");
			}
		}
	}

	/* (non-Javadoc)
	 * @see negocio.ICadastroFilme#existe(java.lang.String)
	 */
	@Override
	public boolean existe(String iD){
		return this.repositorio.existe(iD);
	}
	
	/* (non-Javadoc)
	 * @see negocio.ICadastroFilme#procurar(java.lang.String)
	 */
	@Override
	public Filme procurar(String iD) {
		return this.repositorio.procurar(iD);
	}

	
	public void salvar() {
		repositorio.salvar();
	}

	/* (non-Javadoc)
	 * @see negocio.ICadastroFilme#remover(java.lang.String)
	 */
	@Override
	public void remover(String iD) {
		this.repositorio.remover(iD);
	}

}
