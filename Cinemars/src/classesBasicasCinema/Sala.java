package classesBasicasCinema;

public class Sala {

	private int linha;
	private int coluna;
	private int numero;

	public Sala(int numero, int linha, int coluna) {

		this.coluna = coluna;
		this.linha = linha;
		this.numero = numero;

	}

	public int getNumero() {
		return numero;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
