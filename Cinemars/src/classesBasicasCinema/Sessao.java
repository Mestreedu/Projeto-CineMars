package classesBasicasCinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Sessao {

	private Sala sala;
	private Filme filme;
	private LocalTime hora;
	private LocalDate data;

	public Sessao(Sala sala, Filme filme, LocalTime hora, LocalDate data) {

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

	public LocalTime getHora() {
		return hora;
	}

	public LocalDate getData() {
		return data;
	}

}
