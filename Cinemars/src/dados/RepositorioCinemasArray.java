package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
		if (c != null) {
			cinemas.add(c);
			this.next = next + 1;
			System.out.println("Cinema Cadastrado!");
		}
		this.salvar();
	}

	private ArrayList<Integer> procurarIndice(String nome) {
		ArrayList<Integer> indice = new ArrayList<Integer>();

		for (int i = 0; i < cinemas.size(); i++) {
			if ((this.cinemas.get(i).getNome()).contains(nome)) {
				indice.add(cinemas.indexOf(cinemas.get(i)));
			}
		}
		return indice;
	}

	public ArrayList<Cinema> procurar(String nome) {
		ArrayList<Integer> indices = this.procurarIndice(nome);
		ArrayList<Cinema> saida = new ArrayList<Cinema>();
		if (indices != null) {
			for (int i = 0; i < indices.size(); i++) {
				saida.add(this.cinemas.get(indices.get(i)));
			}
		} else {
			System.out.println("Nenhum cinema com este nome foi encontrado.");
		}
		return saida;
	}

	public void remover(String nome, int telefone) {
		ArrayList<Cinema> cines = this.procurar(nome);
		if (this.existe(nome, telefone)) {
			for (int i = 0; i < cines.size(); i++) {
				if (cines.get(i).getTelefone() == telefone) {
					this.cinemas.remove(this.cinemas.indexOf(cines.get(i)));
					System.out.println("Cinema foi removido!");
				} else {
					System.out.println("Houve um problema! Cinema não pode ser removido.");
				}
			}
		} else {
			System.out.println("O parametro informado deve conter erros.");
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
	
	public List<String> retornaTudo(){
		List<String> lista = new ArrayList<String>();
		for(Cinema c : cinemas){
			lista.add(c.getNome());
		}
		return lista;
	}
}
