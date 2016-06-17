package negocio;

import java.io.Serializable;
import java.util.Scanner;

import classesBasicasPessoa.Administrador;
import classesBasicasPessoa.Pessoa;
import dados.IRepositorioAdmin;
import dados.RepositorioAdminArray;

public class CadastroAdmin implements ICadastroAdmin, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4738714696075798068L;
	private IRepositorioAdmin repositorio;

	public CadastroAdmin() {
		this.repositorio = RepositorioAdminArray.getInstance();
	}

	public boolean cadastrar(Administrador a) {
		boolean resposta = false;
		if (a == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (!this.existe(a.getLogin())) {
				this.repositorio.cadastrar(a);

				resposta = true;
			} else {
				System.out.println("ERRO! LOGIN JÁ CADASTRADO!");
			}
		}
		return resposta;
	}

	@Override
	public Administrador procurar(String login) {
		return this.repositorio.procurar(login);
	}

	@Override
	public boolean existe(String login) {
		return this.repositorio.existe(login);
	}

	@Override
	public void remover(String login) {
		Scanner cs = new Scanner(System.in);
		boolean x = false;
		while (x == false) {
			System.out.println("DIGITE A SENHA DO USUARIO: ");
			String senha = cs.nextLine();
			Pessoa aux = (Pessoa) procurar(login);
			if (senha == aux.getSenha()) {
				this.repositorio.remover(login);
				x = true;
			} else {
				System.out.println("SENHA ERRADA, DIGITE NOVAMENTE");
			}
		}

	}

	public void salvar() {
		repositorio.salvar();
	}

	public boolean login(String login, String senha) {
		boolean logado = false;
		if (repositorio.existe(login)) {
			logado = true;
			System.out.println("LOGIN REALIZADO COM SUCESSO");
			repositorio.procurar(login).toString();
		} else {
			System.out.println("LOGIN NÃO REALIZADO");
		}
		return logado;
	}

}
