package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import classesBasicasCinema.Cinema;
import classesBasicasCinema.Sala;
import classesBasicasCinema.Sessao;
import classesBasicasPessoa.Usuario;
import negocio.Fachada;
import negocio.IFachada;
import java.awt.Toolkit;

public class TelaSala extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel title;
	JToggleButton poltronasArrayButton[][];
	JPanel panelCadeiras;
	int colunas;
	int fileiras;
	int numeroDaSala;
	private Sala sala;
	private Cinema c;
	private Usuario u;
	private Sessao sa;
	char letra;
	private JLabel lblFundoSala;
	private String cadeiras[][];

	public TelaSala(int numeroSala, int col, int fil) {
		this.telaSalaC(numeroSala, col, fil);
	}

	public TelaSala(Sala s, Cinema c, Usuario u, Sessao sa) {
		this.telaSalaC(s.getNumero(), s.getColuna(), s.getLinha());
		this.sala = s;
		this.c = c;
		this.u = u;
		this.sa = sa;
	}

	public TelaSala() {
		setTitle("Cinemars");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		this.telaSalaC(10, 10, 10);
	}

	private void telaSalaC(int numeroSala, int col, int fil) {
		IFachada f = Fachada.getInstance();
		cadeiras = new String[col][fil];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.colunas = col;
		this.fileiras = fil;
		this.numeroDaSala = numeroSala;
		this.letra = 'a';
		title = new JLabel("Sala " + numeroSala);
		title.setForeground(Color.YELLOW);
		title.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		title.setLocation(455, 11);
		title.setSize(155, 60);

		poltronasArrayButton = new JToggleButton[col][fil];
		panelCadeiras = new JPanel(new GridLayout(col, fil));
		panelCadeiras.setBackground(Color.black);
		panelCadeiras.setBounds(103, 82, 808, 515);
		for (int y = 0; y < col; y++) {
			for (int x = 0; x < fil; x++) {
				String a = String.valueOf(letra).toUpperCase();
				poltronasArrayButton[x][y] = new JToggleButton(a + x);
				panelCadeiras.add(poltronasArrayButton[x][y]);
			}
			letra++;
		}

		ActionListener listener = new MyListener();

		contentPane.add(title);
		contentPane.add(panelCadeiras);

		JButton btnVoltar = new JButton("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				TelaMenuUsuario menuInicial = new TelaMenuUsuario(u);
				menuInicial.setVisible(true);
				menuInicial.setResizable(false);
				menuInicial.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setIcon(new ImageIcon("Imagens//VoltarIcon.png"));
		btnVoltar.setBounds(0, 570, 69, 74);
		btnVoltar.setBorder(BorderFactory.createEmptyBorder());
		btnVoltar.setFocusPainted(false);
		btnVoltar.setContentAreaFilled(false);
		contentPane.add(btnVoltar);

		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String print = "Cadeiras Reservadas:";
				for (int i = 0; i < col; i++) {
					for (int j = 0; j < fil; j++) {
						if (poltronasArrayButton[i][j].isSelected()) {
							print += " " + poltronasArrayButton[i][j].getText();

						}
					}
				}
				reservar();
				c.getSalas().get(sala.getNumero());
				f.salvarCinema();
				mostraCadeiras();
				JOptionPane.showMessageDialog(null, print);
				dispose();
				TelaBilhete tela = new TelaBilhete(u, sa, c);
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnNewButton.setBounds(473, 620, 89, 23);
		contentPane.add(btnNewButton);

		lblFundoSala = new JLabel("");
		lblFundoSala.setIcon(new ImageIcon("Imagens\\SalaFundo.jpg"));
		lblFundoSala.setBounds(0, -15, 1264, 722);
		contentPane.add(lblFundoSala);

	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public int getFileiras() {
		return fileiras;
	}

	public void setFileiras(int fileiras) {
		this.fileiras = fileiras;
	}

	public int getNumeroDaSala() {
		return numeroDaSala;
	}

	public void setNumeroDaSala(int numeroDaSala) {
		this.numeroDaSala = numeroDaSala;
	}

	public String[][] getCadeiras() {
		return cadeiras;
	}

	public void setCadeiras(String[][] cadeiras) {
		this.cadeiras = cadeiras;
	}

	public String reservaCadeira(int x, int y) {
		String msg = "LUGAR INDISPONÍVEL!\n";
		AbstractButton tecla = (AbstractButton) poltronasArrayButton[x][y];
		msg = "LUGAR RESERVADO COM SUCESSO - CADEIRA: " + tecla.getText();
		tecla.setText("X");
		System.out.println(msg);

		return msg;
	}

	public void reservaCadeiras(String s) {
		for (int i = 0; i < getFileiras(); i++) {
			for (int j = 0; j < getColunas(); j++) {
				if (poltronasArrayButton[i][j].getText().equals(s)) {
					AbstractButton tecla = (AbstractButton) poltronasArrayButton[i][j];
					tecla.setText("X");
				}
			}
		}
	}

	public void reservar() {
		for (int i = 0; i < this.getColunas(); i++) {
			for (int j = 0; j < this.getFileiras(); j++) {
				AbstractButton tecla = (AbstractButton) poltronasArrayButton[i][j];
				if (tecla.isSelected()) {
					tecla.setEnabled(false);
					tecla.setBackground(Color.RED);
					;
					String s = poltronasArrayButton[i][j].getText();
					this.reservaCadeiras(s);
				}
			}
		}

	}

	public void mostraCadeiras() {
		for (int l = 0; l < this.getColunas(); l++) {
			System.out.print(" " + (l + 1) + "  =>");
			for (int c = 0; c < this.getFileiras(); c++) {
				AbstractButton tecla = (AbstractButton) poltronasArrayButton[c][l];
				System.out.print(" " + tecla.getText() + " |");
			}
			System.out.print(" \n");
		}
		System.out.println(" \n");
	}

	public JToggleButton[][] getPoltronasArrayButton() {
		return poltronasArrayButton;
	}

	public void setPoltronasArrayButton(JToggleButton[][] poltronasArrayButton) {
		this.poltronasArrayButton = poltronasArrayButton;
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Button pressed: " + e.getActionCommand());
			JToggleButton tb = (JToggleButton) e.getSource();
			tb.setSelected(true);
			;

		}
	}
}
