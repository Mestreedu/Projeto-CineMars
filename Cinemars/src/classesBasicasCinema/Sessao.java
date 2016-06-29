package classesBasicasCinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class Sessao {

	private int nSala;
	private Filme filme;
	private LocalDate data;
	private LocalTime hora;
	private String codigo;

	public Sessao(int numeroDaSala, Filme filme, LocalDate data, LocalTime hora) {

		this.nSala = numeroDaSala;
		this.filme = filme;
		this.data = data;
		this.hora = hora;

		Random rand = new Random();
		for (int i = 0; i < 8; i++) {
			int x = 33 + rand.nextInt(93);
			if (i > 0) {
				codigo += Character.toString((char) x);
			} else {
				codigo = Character.toString((char) x);
			}
		}
		this.setCodigo(codigo);
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public int getnSala() {
		return nSala;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setnSala(int nSala) {
		this.nSala = nSala;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalTime getHora() {
		return hora;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String toString() {
		return "Filme: " + getFilme().getNome() + " | Sala: " + getnSala() + " | Data: " + getData().toString()
				+ " | Hora: " + getHora().toString();
	}
}
