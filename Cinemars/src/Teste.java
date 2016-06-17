import java.util.Scanner;

import classesBasicasCinema.Sala;
import classesBasicasPessoa.Administrador;
import classesBasicasPessoa.Usuario;
import negocio.Fachada;
import java.io.Serializable;

import java.util.Scanner;

import classesBasicasCinema.Sala;
import classesBasicasPessoa.Administrador;
import classesBasicasPessoa.Usuario;
import negocio.Fachada;

public class Teste implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1071904876221951895L;

	public static void main(String[] args) {
		Sala sala = new Sala(1, 20, 20);
		boolean logado = false;

		Fachada f = new Fachada();

		while (!logado) {
			System.out.println(
					"Bem-Vindo ao CineMars!\n1 - Entrar\n2 - Criar Conta Usuario\n3 - Criar Conta Administrador");
			Scanner sc = new Scanner(System.in);
			int s = sc.nextInt();
			switch (s) {
			case 1:
				int w = 0;
				while (w == 0) {
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Login: ");
					String login = sc1.nextLine();
					System.out.println("Senha: ");
					String senha = sc1.nextLine();

					if (f.loginUsuario(login, senha)) {
						if (f.verificarLogin(login)) {
							int log = 0;
							while (log == 0) {
								System.out.println(
										"1 - Reservar Cadeira em Grupo\n2 - Reservar Cadeira Individual\n3 - Editar Usuario\n4 - Mostrar Informações\n5 - Deslogar");
								int controle = sc1.nextInt();
								switch (controle) {
								case 1:
									System.out.println("Digite o número de cadeiras que deseja reservar: ");
									int num = sc.nextInt();
									sala.reservaEmGrupo(num);
									break;
								case 2:
									System.out.println("Digite o lugar que deseja reservar");
									int numero = sc1.nextInt();
									sala.reservaCadeira(numero);
									break;
								case 3:
									int e = 0;
									while (e == 0) {
										
										System.out.println(
												"Você deseja alterar: 1 - Nome\n2 - Email\n3 - Senha\n4 - Número do Cartão\n5 - Voltar ao Menu Principal");
										int edit = sc1.nextInt();
										switch (edit) {
										case 1:
											String space = sc.nextLine();
											f.procurarUsuario(login).setNome(sc.nextLine());
											break;
										case 2:
											f.procurarUsuario(login).setEmail(sc.next());
											break;
										case 3:
											f.procurarUsuario(login).setSenha(sc.nextLine());
											break;
										case 4:
											f.procurarUsuario(login).setNumeroDoCartao(sc.nextLong());
											break;
										case 5:
											e++;
										}
									}
								case 4:
							
									break;
								case 5:
									log++;
									w++;
									break;
								}
							}
						}
					}
				}
				break;
			case 2:
				int x = 0;
				while (x == 0) {
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Digite seu nome: ");
					String nome = sc1.nextLine();
					System.out.println("Digite seu email: ");
					String email = sc1.nextLine();
					System.out.println("Digite seu login: ");
					String login = sc1.nextLine();
					System.out.println("Digite sua senha: ");
					String senha = sc1.nextLine();
					System.out.println("Digite seu CPF: ");
					long cpf = Long.parseLong(sc1.nextLine());
					System.out.println("Digite sua idade: ");
					int idade = Integer.parseInt(sc1.nextLine());
					System.out.println("Digite o numero do cartão: ");
					long nCartao = Long.parseLong(sc1.nextLine());

					Usuario u = new Usuario(nome, email, login, senha, cpf, idade, nCartao);

					if (f.cadastrarUsuario(u)){
						x = x + 1;
						f.salvarUsuario();
					}
						
				}
				break;
			case 3:
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Digite seu nome: ");
				String nome = sc1.nextLine();
				System.out.println("Digite seu email: ");
				String email = sc1.nextLine();
				System.out.println("Digite seu login");
				String login = sc1.nextLine();
				System.out.println("Digite sua senha: ");
				String senha = sc1.nextLine();

				Administrador adm = new Administrador(nome, email, login, senha);

			}
		}

	}

}
