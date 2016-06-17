package negocio;

import java.io.Serializable;

import classesBasicasCinema.Ingresso;
import dados.IRepositorioIngresso;
import dados.RepositorioIngressosArray;

public class CadastroIngresso implements ICadastroIngresso, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3843330138258704304L;
	private IRepositorioIngresso repositorio;

	public CadastroIngresso() {
		this.repositorio = RepositorioIngressosArray.getInstance();
	}

	@Override
	public void cadastrar(Ingresso i) {
		if (i == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (!this.existe(i.getCodigo())) {
				this.repositorio.cadastrar(i);
			} else {
				System.out.println("ERRO! INGRESSO J� CADASTRADO!");
			}
		}
	}

	@Override
	public boolean existe(int codigo) {
		return this.repositorio.existe(codigo);
	}

	@Override
	public Ingresso procurar(int codigo) {
		return this.repositorio.procurar(codigo);
	}

	public void salvar() {
		repositorio.salvar();
	}

	@Override
	public void remover(int codigo) {
		this.repositorio.remover(codigo);
	}

}
