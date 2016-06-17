package classesBasicasCinema;



public class Sessao {
	
	private Sala sala;
	private Filme filme;
	private int hora;
	private int data;

	
	public Sessao(Sala sala, Filme filme, int hora, int data){
		
		this.sala = sala;
		this.filme = filme;
		this.hora = hora;
		this.data = data;
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}


	public Sala getSala() {
		return sala;
	}


	public int getHora() {
		return hora;
	}


	public int getData() {
		return data;
	}
	
	
	
}
