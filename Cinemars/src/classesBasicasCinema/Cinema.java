package classesBasicasCinema;

import java.io.Serializable;

public class Cinema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1661196384905790847L;
	private String nome;
	private int telefone;
	private Sala[] salas;
	private Sessao[] sessoes;
	
	public Cinema(String nome, int telefone, Sala[] salas, Sessao[] sessoes){
		this.setSessoes(sessoes);
		this.setNome(nome);
		this.setSalas(salas);
		this.setTelefone(telefone);
	}

	public String getNome() {
		return nome;
	}
 
	
	public void setNome(String nome) {
		if(nome == null){
			// mensagem de erro
		}else{
			this.nome = nome;	
		}
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		if(telefone <= 9999999 || telefone > 99999999){
			// mensagem de erro
		}else{
			this.telefone = telefone;	
		}
		
	}

	public Sala[] getSalas() {
		return salas;
	}

	public void setSalas(Sala[] salas) {
		if(salas == null){
			// mensagem de erro
		}else{
			this.salas = salas;	
		}
		
	}

	public Sessao[] getSessoes() {
		return sessoes;
	}

	public void setSessoes(Sessao[] sessoes) {
		if(sessoes == null){
			// mensagem de erro
		}else{
			this.sessoes = sessoes;	
		}
		
	}
	
	
	
	
}
