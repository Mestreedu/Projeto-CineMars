package negocio;

import java.util.ArrayList;
import java.util.List;

import classesBasicasCinema.Cinema;

public interface ICadastroCinema {

	public abstract void cadastrar(Cinema c);

	public abstract boolean existe(String nome, int telefone);

	public abstract ArrayList<Cinema> procurar(String nome);

	public abstract void remover(String nome, int telefone);

	public abstract void salvar();

	public List<String> retornaTudo();

}