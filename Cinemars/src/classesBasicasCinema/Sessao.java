package classesBasicasCinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Sessao {

	private Sala sala;
	private Filme filme;
	private LocalDate data;
	private LocalTime hora;

	public Sessao(Sala sala, Filme filme, LocalDate data, LocalTime hora) {

		this.sala = sala;
		this.filme = filme;
		this.data = data;
		this.hora = hora;
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

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

}
