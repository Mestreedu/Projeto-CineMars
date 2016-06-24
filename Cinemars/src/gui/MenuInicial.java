package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import classesBasicasCinema.Filme;
import negocio.Fachada;

public class MenuInicial extends JFrame {

	private JPanel contentPane;
	private Fachada fachada;

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
					
					MenuInicial frame = new MenuInicial();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuInicial() {
		fachada = new Fachada();
		fachada.cadastrarFilme(new Filme("Vida e Obra de Dilma Rousseff", "Terror", "Luiz Inacio Lula da Silva", 169, 18));
		fachada.salvarCinema();
		fachada.salvarFilme();
		fachada.salvarUsuario();
		fachada.salvarAdmin();
		fachada.salvarIngresso();
		setTitle("CineMars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenutelainicial = new JMenu("Menu");
		menuBar.add(mnMenutelainicial);
		
		JMenuItem mntmCriarUsuario = new JMenuItem("Criar Usuario");
		mnMenutelainicial.add(mntmCriarUsuario);
		
		JMenuItem mntmCriarAdministrador = new JMenuItem("Criar Administrador");
		mnMenutelainicial.add(mntmCriarAdministrador);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton adminRegistrarButton = new JButton("");
		adminRegistrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
				TelaCAdmin telaCAdmin = new TelaCAdmin();
				telaCAdmin.setResizable(false);
				telaCAdmin.setLocationRelativeTo(null);
				telaCAdmin.setVisible(true);
			}
		});
		
		adminRegistrarButton.setIcon(new ImageIcon("Imagens\\AdminButton.png"));
		adminRegistrarButton.setFont(new Font("Lucida Console", adminRegistrarButton.getFont().getStyle(), 22));
		adminRegistrarButton.setBorder(BorderFactory.createEmptyBorder());
		adminRegistrarButton.setFocusPainted(false);
		adminRegistrarButton.setContentAreaFilled(false);
		adminRegistrarButton.setBounds(281, 177, 144, 145);
		contentPane.add(adminRegistrarButton);
		
		
		JButton usuarioRegistrarButton = new JButton("");
		usuarioRegistrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				TelaCUsuario telaCUsuario = new TelaCUsuario();
				telaCUsuario.setVisible(true);
				telaCUsuario.setResizable(false);
				telaCUsuario.setLocationRelativeTo(null);
			}
		});
		
		usuarioRegistrarButton.setIcon(new ImageIcon("Imagens\\Novo Usuario Button.png"));
		usuarioRegistrarButton.setBounds(660, 162, 155, 160);
		usuarioRegistrarButton.setBorder(BorderFactory.createEmptyBorder());
		usuarioRegistrarButton.setFocusPainted(false);
		usuarioRegistrarButton.setContentAreaFilled(false);
		contentPane.add(usuarioRegistrarButton);
		usuarioRegistrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setIcon(new ImageIcon("Imagens\\film.png"));
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setResizable(false);
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
			}
		});
		btnEntrar.setBounds(494, 399, 102, 31);
		contentPane.add(btnEntrar);
		
		JLabel usuarioImage = new JLabel("Usuario");
		usuarioImage.setIcon(new ImageIcon("Imagens\\UserLogin1.png"));
		usuarioImage.setBounds(505, 291, 118, 123);
		contentPane.add(usuarioImage);
		
		
		JLabel lblFundo = new JLabel("New label");
		lblFundo.setIcon(new ImageIcon("Imagens\\TelaInicial.png"));
		lblFundo.setBounds(0, 0, 1025, 682);
		contentPane.add(lblFundo);
	}
	}
