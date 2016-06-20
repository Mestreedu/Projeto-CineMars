package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import classesBasicasPessoa.Usuario;
import negocio.Fachada;

public class TelaCUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5172160195587822169L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textLogin;
	private JLabel senhaCUsuario;
	private JLabel cpfCUsuario;
	private JTextField textCpf;
	private JLabel idadeCUsuario;
	private JPasswordField passwordField;
	private JLabel nCartaoCUsuario;
	private JTextField textCartao;
	private Fachada f;
	private long nCartao;
	private String senha;
	private long cpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					TelaCUsuario frame = new TelaCUsuario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCUsuario() {
		f = new Fachada();
		setTitle("CineMars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel nomeCUsuario = new JLabel("Nome");
		nomeCUsuario.setFont(nomeCUsuario.getFont().deriveFont(nomeCUsuario.getFont().getStyle() | Font.BOLD));
		nomeCUsuario.setBounds(566, 155, 33, 16);
		contentPane.add(nomeCUsuario);

		JLabel emailCUsuario = new JLabel("Email");
		emailCUsuario.setFont(emailCUsuario.getFont().deriveFont(emailCUsuario.getFont().getStyle() | Font.BOLD));
		emailCUsuario.setBounds(566, 195, 33, 16);
		contentPane.add(emailCUsuario);

		JLabel loginCUsuario = new JLabel("Login");
		loginCUsuario.setFont(loginCUsuario.getFont().deriveFont(loginCUsuario.getFont().getStyle() | Font.BOLD));
		loginCUsuario.setBounds(567, 235, 33, 16);
		contentPane.add(loginCUsuario);

		senhaCUsuario = new JLabel("Senha");
		senhaCUsuario.setFont(senhaCUsuario.getFont().deriveFont(senhaCUsuario.getFont().getStyle() | Font.BOLD));
		senhaCUsuario.setBounds(563, 275, 36, 16);
		contentPane.add(senhaCUsuario);

		cpfCUsuario = new JLabel("CPF");
		cpfCUsuario.setFont(cpfCUsuario.getFont().deriveFont(cpfCUsuario.getFont().getStyle() | Font.BOLD));
		cpfCUsuario.setBounds(566, 309, 22, 16);
		contentPane.add(cpfCUsuario);

		idadeCUsuario = new JLabel("Idade");
		idadeCUsuario.setFont(idadeCUsuario.getFont().deriveFont(idadeCUsuario.getFont().getStyle() | Font.BOLD));
		idadeCUsuario.setBounds(566, 355, 36, 16);
		contentPane.add(idadeCUsuario);

		nCartaoCUsuario = new JLabel("N\u00FAmero do Cart\u00E3o");
		nCartaoCUsuario.setFont(nCartaoCUsuario.getFont().deriveFont(nCartaoCUsuario.getFont().getStyle() | Font.BOLD));
		nCartaoCUsuario.setBounds(494, 394, 103, 16);
		contentPane.add(nCartaoCUsuario);

		JSpinner spinIdade = new JSpinner();
		spinIdade.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(100), new Integer(1)));
		spinIdade.setBounds(603, 349, 54, 28);
		contentPane.add(spinIdade);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("Imagens\\Sign.png"));
		btnCadastrar.setBounds(727, 447, 109, 28);
		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textNome.getText().length() > 0) {
					if (textEmail.getText().length() > 0) {
						if (textLogin.getText().length() > 0) {
							if (passwordField.getPassword().length > 0) {
								char [] codigo = passwordField.getPassword();
								for (int i = 0; i < codigo.length; i++) {
									if (i > 0) {
										senha += Character.toString(codigo[i]);
									} else {
										senha = Character.toString(codigo[i]);
									}
								}

								if (textCpf.getText().length() == 11) {

									if (textCartao.getText().length() > 0) {

										if (senha != null) {
											cpf = Long.parseLong(textCpf.getText());
											char[] cartaoNum = textCartao.getText().toCharArray();
											for (int j = 0; j < textCartao.getText().length(); j++) {
												if (cartaoNum[j] == '0' || cartaoNum[j] == '1' || cartaoNum[j] == '2'
														|| cartaoNum[j] == '3' || cartaoNum[j] == '4'
														|| cartaoNum[j] == '5' || cartaoNum[j] == '6'
														|| cartaoNum[j] == '7' || cartaoNum[j] == '8'
														|| cartaoNum[j] == '9') {

													//nCartao += cartaoNum[j];
												} else {
													
												}
											
											nCartao = Long.valueOf(textCartao.getText()).longValue();
											}

											Usuario u = new Usuario(textNome.getText(), textEmail.getText(),
													textLogin.getText(), senha, cpf, spinIdade.getValue(), nCartao);
											f.cadastrarUsuario(u);
											f.printarUsuario(u);
											dispose();

										}

									} else {
										JOptionPane.showMessageDialog(null, "ERRO, NUMERO DE CARTAO INVALIDO");
									}
								} else {
									JOptionPane.showMessageDialog(null, "ERRO, CPF INVALIDO");
								}
							} else {
								JOptionPane.showMessageDialog(null, "ERRO, SENHA INVALIDA");
							}
						} else {
							JOptionPane.showMessageDialog(null, "ERRO, LOGIN INVALIDO");
						}
					} else {
						JOptionPane.showMessageDialog(null, "ERRO, EMAIL INVALIDO");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERRO, NOME INVALIDO");
				}

			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(603, 269, 380, 28);
		contentPane.add(passwordField);

		textCartao = new JTextField();
		textCartao.setColumns(10);
		textCartao.setBounds(603, 388, 380, 28);
		contentPane.add(textCartao);

		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(603, 303, 380, 28);
		contentPane.add(textCpf);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(603, 189, 380, 28);
		contentPane.add(textEmail);

		textNome = new JTextField();
		textNome.setBounds(603, 149, 380, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(604, 229, 380, 28);
		contentPane.add(textLogin);

		JLabel lblLabelUsuario = new JLabel("New label");
		lblLabelUsuario.setIcon(new ImageIcon("Imagens\\TelaCUsuario1.jpg"));
		lblLabelUsuario.setBounds(0, -10, 1009, 654);
		contentPane.add(lblLabelUsuario);
	}
}
