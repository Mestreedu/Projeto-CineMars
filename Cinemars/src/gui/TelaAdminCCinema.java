package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import classesBasicasCinema.Cinema;
import classesBasicasCinema.Sala;
import classesBasicasCinema.Sessao;
import classesBasicasPessoa.Administrador;
import negocio.Fachada;

public class TelaAdminCCinema extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeCinema;
	private JTextField txtTel;
	private JLabel lblQuantidadeDeSalas;
	private JLabel lblescolhaDentreOs;
	private JLabel lblColunaXFileira;
	private JLabel lblPadres;
	private JButton btnNewButton;
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
				
					TelaAdminCCinema frame = new TelaAdminCCinema();
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
	public TelaAdminCCinema() {
		fachada = new Fachada();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeCinema = new JLabel("Nome:");
		lblNomeCinema.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblNomeCinema.setForeground(Color.YELLOW);
		lblNomeCinema.setBounds(63, 124, 50, 14);
		contentPane.add(lblNomeCinema);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBackground(Color.WHITE);
		lblTelefone.setForeground(Color.YELLOW);
		lblTelefone.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblTelefone.setBounds(23, 162, 90, 14);
		contentPane.add(lblTelefone);
		
		textNomeCinema = new JTextField();
		textNomeCinema.setText("Ex: Jorge Sampaoli");
		textNomeCinema.setToolTipText("");
		textNomeCinema.setBackground(Color.LIGHT_GRAY);
		textNomeCinema.setBounds(115, 117, 242, 28);
		contentPane.add(textNomeCinema);
		textNomeCinema.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setText("Ex: 985122134");
		txtTel.setColumns(10);
		txtTel.setBackground(Color.LIGHT_GRAY);
		txtTel.setBounds(115, 155, 242, 28);
		contentPane.add(txtTel);
		
		lblQuantidadeDeSalas = new JLabel("Quantidade de Salas:");
		lblQuantidadeDeSalas.setForeground(Color.YELLOW);
		lblQuantidadeDeSalas.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblQuantidadeDeSalas.setBackground(Color.WHITE);
		lblQuantidadeDeSalas.setBounds(23, 242, 200, 14);
		contentPane.add(lblQuantidadeDeSalas);
		
		lblescolhaDentreOs = new JLabel("(Escolha dentre os padr\u00F5es abaixo)");
		lblescolhaDentreOs.setForeground(Color.YELLOW);
		lblescolhaDentreOs.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblescolhaDentreOs.setBackground(Color.WHITE);
		lblescolhaDentreOs.setBounds(10, 279, 347, 14);
		contentPane.add(lblescolhaDentreOs);
		
		JComboBox<String> comboSala = new JComboBox<String>();
		comboSala.setModel(new DefaultComboBoxModel<String>(new String[] {"M8 ( 8 X 8 )", "M10 ( 10 X 10 )", "MARS ( 15 X 15 )"}));
		comboSala.setMaximumRowCount(3);
		comboSala.setBounds(157, 318, 200, 28);
		contentPane.add(comboSala);
		
		JSpinner spinnerQtdSalas = new JSpinner();
		spinnerQtdSalas.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerQtdSalas.setBounds(233, 235, 50, 28);
		contentPane.add(spinnerQtdSalas);
		
		lblColunaXFileira = new JLabel("(Coluna\r\ns x Fileiras)");
		lblColunaXFileira.setForeground(Color.YELLOW);
		lblColunaXFileira.setFont(new Font("OCR A Extended", Font.BOLD, 13));
		lblColunaXFileira.setBounds(167, 351, 180, 14);
		contentPane.add(lblColunaXFileira);
		
		lblPadres = new JLabel("Padr\u00F5es:");
		lblPadres.setForeground(Color.YELLOW);
		lblPadres.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblPadres.setBackground(Color.WHITE);
		lblPadres.setBounds(67, 325, 80, 14);
		contentPane.add(lblPadres);
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				int c = 5;
				int f = 5;
				
				switch(comboSala.getSelectedIndex()){
				case 0: 
				c = 8;
				f = 8;
				break;
				case 1:
				c = 10;
				f = 10;
				break;
				case 2:
				c = 15;
				f = 15;
				break;
				default:
				break;
				}
				int telefone = Integer.parseInt(txtTel.getText());
				List<Sala> salasC;
				List<Sessao> sessoesC;
				int qtdSalas = (int) spinnerQtdSalas.getValue();
				Cinema cine = new Cinema(textNomeCinema.getText(), telefone, salasC = new ArrayList<Sala>(qtdSalas), sessoesC = new ArrayList<Sessao>() );
				JPasswordField password = new JPasswordField(10);
				password.setEchoChar('*'); 
				JLabel rotulo = new JLabel("Digite sua senha:");
				JPanel entUsuario = new JPanel();
				entUsuario.add(rotulo);
				entUsuario.add(password);
				JOptionPane.showMessageDialog(null, entUsuario, "Acesso restrito", JOptionPane.PLAIN_MESSAGE);
				String senha = new String(password.getPassword());
				fachada.procurarAdminSenha(senha).adicionarCinema(cine);;
				TelaSala telaSala = new TelaSala(10, c, f);
				telaSala.setLocationRelativeTo(null);
				telaSala.setResizable(false);
				telaSala.setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("Imagens\\ConfirmarIconAdmin.png"));
		btnNewButton.setBounds(188, 428, 123, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblFundoCCinema = new JLabel("");
		lblFundoCCinema.setIcon(new ImageIcon("Imagens\\TelaAdminCCinema.png"));
		lblFundoCCinema.setBounds(0, 0, 1019, 660);
		contentPane.add(lblFundoCCinema);
	}
}
