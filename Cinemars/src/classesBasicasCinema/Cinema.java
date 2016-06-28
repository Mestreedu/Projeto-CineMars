package classesBasicasCinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Cinema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1661196384905790847L;
	private String nome;
	private int telefone;
	private List<Sala> salas;
	private List<Sessao> sessoes;

	public Cinema(String nome, int telefone, List<Sala> salas, List<Sessao> sessoes) {
		salas = new ArrayList<Sala>();
		sessoes = new ArrayList<Sessao>();
		this.salas = salas;
		this.sessoes = sessoes;
		this.setNome(nome);
		this.setTelefone(telefone);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null) {
			// mensagem de erro
		} else {
			this.nome = nome;
		}
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		if (telefone <= 9999999 || telefone > 99999999) {
			// mensagem de erro
		} else {
			this.telefone = telefone;
		}

	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		if (salas == null) {
			// mensagem de erro
		} else {
			this.salas = salas;
		}

	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public String[] getNomeSessoes() {
		String[] nomeSessoes = new String[50];

		for (int i = 0; i < sessoes.size(); i++) {
			nomeSessoes[i] = getSessoes().get(i).toString();
		}

		return nomeSessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		if (sessoes == null) {

		} else {
			this.sessoes = sessoes;
		}

	}

}
