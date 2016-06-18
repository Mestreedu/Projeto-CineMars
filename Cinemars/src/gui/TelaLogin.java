package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import classesBasicasPessoa.Administrador;
import negocio.Fachada;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordField;

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
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		Fachada f = new Fachada();
		setTitle("CineMars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textLogin = new JTextField();
		textLogin.setBounds(436, 119, 218, 28);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		JLabel lbLogin = new JLabel("Login");
		lbLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbLogin.setForeground(Color.WHITE);
		lbLogin.setBounds(394, 119, 38, 24);
		contentPane.add(lbLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(390, 192, 46, 16);
		contentPane.add(lblSenha);
		
		
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Object o = f.checkType(textLogin.getText());
				if(o instanceof Administrador){
					
					TelaMenuAdmin telaMenuAdmin = new TelaMenuAdmin();
					telaMenuAdmin.setResizable(false);
					telaMenuAdmin.setLocationRelativeTo(null);
					telaMenuAdmin.setVisible(true);
				} 
			}
		});
		btnLogar.setBounds(506, 238, 89, 23);
		contentPane.add(btnLogar);
		

		passwordField = new JPasswordField();
		passwordField.setBounds(436, 188, 218, 28);
		contentPane.add(passwordField);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("Imagens//PipocaLogin.png"));
		label.setBounds(0, 0, 674, 393);
		contentPane.add(label);
	}
}
