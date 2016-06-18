package negocio;

import java.util.ArrayList;

import classesBasicasCinema.Cinema;
import classesBasicasCinema.Filme;
import classesBasicasCinema.Ingresso;
import classesBasicasPessoa.Administrador;
import classesBasicasPessoa.Usuario;

public interface IFachada {

	public abstract void cadastrarCinema(Cinema c);

	public abstract void salvarCinema();


	public abstract boolean existeCinema(String nome, int telefone);

	public abstract ArrayList<Cinema> procurarCinema(String nome);

	public abstract void removerCinema(String nome, int telefone);

	public abstract void cadastrarFilme(Filme f);

	public abstract void salvarFilme();
	public abstract boolean existeFilme(String iD);

	public abstract Filme procurarFilme(String iD);

	public abstract void removerFilme(String iD);

	public abstract boolean cadastrarUsuario(Usuario u);
	
	public abstract Object checkType(String Login);

	public abstract void salvarUsuario();

	public abstract Usuario procurarUsuario(String login);

	public abstract boolean existeUsuario(String login);

	public abstract void removerUsuario(String login);

	public abstract boolean loginUsuario(String login, String senha);

	public abstract boolean verificarLogin(String login);

	public abstract void printarUsuario(Usuario u);

	public boolean cadastrarAdmin(Administrador a);

	public Administrador procurarAdmin(String login);

	public boolean existeAdmin(String login);

	public void removerAdmin(String login);

	public boolean loginAdmin(String login, String senha);

	public void salvarAdmin();

	public void cadastrarIngresso(Ingresso i);

	public boolean existeIngresso(int codigo);

	public Ingresso procurarIngresso(int codigo);

	public void removerIngresso(int codigo);

	public void salvarIngresso();
}
