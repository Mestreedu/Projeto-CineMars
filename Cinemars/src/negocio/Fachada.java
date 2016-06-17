package negocio;

import java.io.Serializable;

import java.util.ArrayList;

import classesBasicasCinema.Cinema;
import classesBasicasCinema.Filme;

import classesBasicasCinema.Ingresso;
import classesBasicasPessoa.Administrador;
import classesBasicasPessoa.Usuario;

public class Fachada implements IFachada, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7208831605966568731L;
	private ICadastroUsuario cadastroUsuario;
	private ICadastroFilme cadastroFilme;
	private ICadastroCinema cadastroCinema;
	private ICadastroAdmin cadastroAdmin;
	private ICadastroIngresso cadastroIngresso;

	private static IFachada instance;

	public Fachada() {
		this.cadastroCinema = new CadastroCinema();
		this.cadastroFilme = new CadastroFilme();
		this.cadastroUsuario = new CadastroUsuario();
		this.cadastroAdmin = new CadastroAdmin();
		this.cadastroIngresso = new CadastroIngresso();
	}

	public static IFachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#cadastrarCinema(classesBasicasCinema.Cinema)
	 */
	@Override
	public void cadastrarCinema(Cinema c) {
		cadastroCinema.cadastrar(c);
	}

	public void salvarCinema() {
		cadastroCinema.salvar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#existeCinema(java.lang.String, int)
	 */
	@Override
	public boolean existeCinema(String nome, int telefone) {
		return cadastroCinema.existe(nome, telefone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#procurarCinema(java.lang.String)
	 */
	@Override
	public ArrayList<Cinema> procurarCinema(String nome) {
		return cadastroCinema.procurar(nome);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#removerCinema(java.lang.String, int)
	 */
	@Override
	public void removerCinema(String nome, int telefone) {
		cadastroCinema.remover(nome, telefone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#cadastrarFilme(classesBasicasCinema.Filme)
	 */
	@Override
	public void cadastrarFilme(Filme f) {
		cadastroFilme.cadastrar(f);
	}

	public void salvarFilme() {
		cadastroFilme.salvar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#existeFilme(java.lang.String)
	 */
	@Override
	public boolean existeFilme(String iD) {
		return cadastroFilme.existe(iD);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#procurarFilme(java.lang.String)
	 */
	@Override
	public Filme procurarFilme(String iD) {
		return cadastroFilme.procurar(iD);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#removerFilme(java.lang.String)
	 */
	@Override
	public void removerFilme(String iD) {
		cadastroFilme.remover(iD);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#cadastrarUsuario(classesBasicasPessoa.Usuario)
	 */
	@Override
	public boolean cadastrarUsuario(Usuario u) {
		return cadastroUsuario.cadastrar(u);
	}

	public void salvarUsuario() {
		cadastroUsuario.salvar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * =======
	 * 
	 * 
	 * @see negocio.IFachada#procurarUsuario(java.lang.String)
	 */
	@Override
	public Usuario procurarUsuario(String login) {
		return cadastroUsuario.procurar(login);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#existeUsuario(java.lang.String)
	 */
	@Override
	public boolean existeUsuario(String login) {
		return cadastroUsuario.existe(login);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * =======
	 * 
	 * 
	 * 
	 * /* (non-Javadoc) >>>>>>> branch 'master' of
	 * https://github.com/Brunosimoesorlandelli/CineMars.git
	 * 
	 * @see negocio.IFachada#removerUsuario(java.lang.String)
	 */
	@Override
	public void removerUsuario(String login) {
		cadastroUsuario.remover(login);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#loginUsuario(java.lang.String, int)
	 */
	@Override
	public boolean loginUsuario(String login, String senha) {
		return cadastroUsuario.login(login, senha);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#verificarLogin(java.lang.String)
	 */
	@Override
	public boolean verificarLogin(String login) {
		boolean verificar = false;
		if (existeUsuario(login))
			verificar = true;

		return verificar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#printarUsuario(java.lang.String)
	 */
	@Override

	public void printarUsuario(Usuario u) {

		cadastroUsuario.printar(u);
	}

	public boolean cadastrarAdmin(Administrador a) {
		return cadastroAdmin.cadastrar(a);
	}

	public Administrador procurarAdmin(String login) {
		return cadastroAdmin.procurar(login);
	}

	public boolean existeAdmin(String login) {
		return cadastroAdmin.existe(login);
	}

	public void removerAdmin(String login) {
		cadastroAdmin.remover(login);
	}

	public boolean loginAdmin(String login, String senha) {
		return cadastroAdmin.login(login, senha);
	}

	public void salvarAdmin() {
		cadastroAdmin.salvar();
	}

	public void cadastrarIngresso(Ingresso i) {
		cadastroIngresso.cadastrar(i);
	}

	public boolean existeIngresso(int codigo) {
		return cadastroIngresso.existe(codigo);
	}

	public Ingresso procurarIngresso(int codigo) {
		return cadastroIngresso.procurar(codigo);
	}

	public void removerIngresso(int codigo) {
		cadastroIngresso.remover(codigo);
	}

	public void salvarIngresso() {
		cadastroIngresso.salvar();
	}
}
