package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import classesBasicasCinema.Cinema;

public class RepositorioCinemasArray implements IRepositorioCinema, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2682841877114590106L;
	private static IRepositorioCinema instanceCine;
	private ArrayList<Cinema> cinemas;
	private int next;

	public RepositorioCinemasArray(int tamanho) {

		this.cinemas = new ArrayList<Cinema>(tamanho);
		this.next = 0;
	}

	
	public static synchronized IRepositorioCinema getInstance() {
		if (instanceCine == null) {
			if (ler() == null) {
				instanceCine = new RepositorioCinemasArray(100);
			} else {
				instanceCine = (RepositorioCinemasArray) ler();
			}
		}
		return instanceCine;
	}
	
	public void salvar() {
		try {
			File f = new File("Cinemas\\RepositorioCinemasArray.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceCine);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioCinema ler() {
		IRepositorioCinema repo = null;
		try {
			File f = new File("Cinemas\\RepositorioCinemasArray.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o != null) {
				repo = (RepositorioCinemasArray) o;
				System.out.println("agora ele foi des-serializado com sucesso");
			}
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}


	public void cadastrar(Cinema c) {
		c = this.cinemas.get(this.next);
		if (c != null && c.getNome().equals(this.cinemas.get(this.next).getNome())
				&& c.getTelefone() == this.cinemas.get(this.next).getTelefone()) {
			this.next = next + 1;
			if (this.next == this.cinemas.size()) {

			}
			System.out.println("Cinema Cadastrado!");
		}

	}

	private ArrayList<Integer> procurarIndice(String nome) {
		int aux = 0;
		ArrayList<Integer> indice = new ArrayList<Integer>(aux);

		for (int i = 0; i < cinemas.size(); i++) {
			if (nome.equals(this.cinemas.get(i).getNome())) {
				indice.add(aux, cinemas.indexOf(cinemas.get(i)));
				aux++;
			}
		}
		return indice;
	}


	public ArrayList<Cinema> procurar(String nome) {
		ArrayList<Integer> indices = this.procurarIndice(nome);
		ArrayList<Cinema> saida = new ArrayList<Cinema>();
		for (int i = 0; i < indices.size(); i++) {
			if (i != this.next) {
				saida.add(this.cinemas.get(indices.get(i)));
			} else {
				System.out.println("Cinema não encontrado!");
			}
		}
		return saida;
	}

	public void remover(String nome, int telefone) {
		ArrayList<Cinema> cines = this.procurar(nome);
		for (int i = 0; i < cines.size(); i++) {
			if (cines.get(i).getTelefone() == telefone) {
				this.cinemas.remove(this.cinemas.indexOf(cines.get(i)));
				System.out.println("Cinema foi removido!");
			} else {
				System.out.println("Houve um problema! Cinema não pode ser removido.");
			}
		}
	}

	
	public boolean existe(String nome, int telefone) {
		boolean existe = false;
		ArrayList<Cinema> cines = this.procurar(nome);
		for (int i = 0; i < cines.size(); i++) {
			if (cines.get(i).getTelefone() == telefone) {
				existe = true;
				System.out.println("O Cinema existe!");
			} else {
				System.out.println("Cinema não existe!");
			}
		}
		return existe;

	}
}
