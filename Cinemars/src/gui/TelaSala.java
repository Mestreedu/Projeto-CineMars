package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
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

import classesBasicasCinema.Sala;

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
	char letra;
	private JLabel lblFundoSala;
	private String cadeiras[][];

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

					TelaSala frame = new TelaSala();
					frame.setTitle("CineMars");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 1015, 682);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaSala(int numeroSala, int col, int fil) {
		this.telaSalaC(numeroSala, col, fil);
	}

	public TelaSala(Sala s){
		this.telaSalaC(s.getNumero(), s.getColuna(), s.getLinha());
		this.sala = s;
	}
	
	public TelaSala() {
		this.telaSalaC(10, 10, 10);
	}

	private void telaSalaC(int numeroSala, int col, int fil) {
		cadeiras = new String[col][fil];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 682);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
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
				mostraCadeiras();
				JOptionPane.showMessageDialog(null, print);
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

	public void reservar() {
		for (int i = 0; i < this.getColunas(); i++) {
			for (int j = 0; j < this.getFileiras(); j++) {
				AbstractButton tecla = (AbstractButton) poltronasArrayButton[i][j];
				if (tecla.isSelected()) {
					tecla.setEnabled(false);
					tecla.setBackground(Color.RED);;
					this.reservaCadeira(i, j);
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
