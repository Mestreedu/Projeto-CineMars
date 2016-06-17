package classesBasicasCinema;

import classesBasicasPessoa.Usuario;

public class Ingresso {

	private Usuario usuario;
	private Sessao sessao;
	private Cinema cinema;
	private int codigo;
	private int preco;
	
	public Ingresso(Usuario usuario, Sessao sessao, Cinema cinema, int codigo, int preco){
		
		this.cinema = cinema;
		this.codigo = codigo;
		this.sessao = sessao;
		this.usuario = usuario;
		this.preco = preco;
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Cinema getCinema() {
		return cinema;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public int getPreco() {
		return preco;
	}
	
	
	
}
