package classesBasicasCinema;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Sessao {
	
	private Sala sala;
	private Filme filme;
	private LocalDateTime hora;
	private LocalDate data;

	
	public Sessao(Sala sala, Filme filme, LocalDateTime hora, LocalDate data){
		
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


	public LocalDateTime getHora() {
		return hora;
	}


	public LocalDate getData() {
		return data;
	}
	
	
	
}
