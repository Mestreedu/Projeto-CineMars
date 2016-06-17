package classesBasicasCinema;

import java.io.Serializable;
import java.util.Random;

public class Filme implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1142780178123324259L;
	private String nome;
	private String genero;
	private String sinopse;
	private String diretor;
	private String atores;
	private String iD;
	private int horario;
	private int duracao;
	private int classificacaoIndicativa;
	private String[] comentarios;

	public Filme(String nome, String genero, String sinopse, String diretor, String atores, int horario, int duracao,
			int cI) {
		this.setAtores(atores);
		this.setClassificacaoIndicativa(cI);
		this.setDiretor(diretor);
		this.setDuracao(duracao);
		this.setGenero(genero);
		this.setHorario(horario);
		this.setNome(nome);
		this.setSinopse(sinopse);
		
		Random rand = new Random();
		for (int i = 0; i < 8; i++) {
			int x = 33 + rand.nextInt(93);
			if (i > 0) {
				iD += Character.toString((char) x);
			} else {
				iD = Character.toString((char) x);
			}
		}
		this.setID(iD);		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public String[] getComentarios() {
		return comentarios;
	}

	public void setComentarios(String[] comentarios) {
		this.comentarios = comentarios;
	}

	public String getNome() {
		return nome;
	}

	public String getGenero() {
		return genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public String getDiretor() {
		return diretor;
	}

	public String getAtores() {
		return atores;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public int getDuracao() {
		return duracao;
	}

	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}


	public String getID() {
		return iD;
	}

	public void setID(String iD) {
		this.iD = iD;
	}

}
