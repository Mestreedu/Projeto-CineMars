package classesBasicasPessoa;

import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5049389043160337615L;
	private long cpf;
	private Object idade;
	private long numeroDoCartao;

	public Usuario(String nome, String email, String login, String senha, long cpf, Object idade, long nCartao) {
		super(nome, email, login, senha);
		this.setCpf(cpf);
		this.setIdade(idade);
		this.setNumeroDoCartao(nCartao);
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		if (cpf <= 10000000000l || cpf > 99999999999l) {
			System.out.println("Numero do CPF invalido.");
		} else {
			this.cpf = cpf;
		}

	}

	public Object getIdade() {
		return idade;
	}

	public void setIdade(Object idade) {
		if ((int) idade == 0 || (int) idade >= 100) {

		} else {
			this.idade = idade;
		}

	}

	public long getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(long numeroDoCartao) {
		if (numeroDoCartao <= 100000000000000l || numeroDoCartao > 9999999999999999l) {
			System.out.println("Numero do cartão invalido.");
		} else {
			this.numeroDoCartao = numeroDoCartao;
		}

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("\nCPF: ");
		sb.append(this.cpf);
		sb.append("\nIdade: ");
		sb.append(this.idade);
		sb.append("\nnCartao: ");
		sb.append(this.numeroDoCartao);

		return sb.toString() + "\n";
	}

}
