package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classesBasicasCinema.Filme;
import negocio.Fachada;
import negocio.IFachada;

public class TelaFilme extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filme teste = new Filme("O Labirinto do Fauno","Fantasia/Drama","Espanha, 1944. Oficialmente a Guerra Civil já terminou, mas um grupo de rebeldes ainda luta nas montanhas ao norte de Navarra. Ofelia (Ivana Baquero), de 10 anos, muda-se para a região com sua mãe, Carmen (Ariadna Gil). Lá as espera seu novo padrasto, um oficial fascista que luta para exterminar os guerrilheiros da localidade. Solitária, a menina logo descobre a amizade de Mercedes (Maribel Verdú), jovem cozinheira da casa, que serve de contato secreto dos rebeldes. Além disso, em seus passeios pelo jardim da imensa mansão em que moram, Ofelia descobre um labirinto que faz com que todo um mundo de fantasias se abra, trazendo consequências para todos à sua volta.","Guilhermo del Toro"," Ivana Baquero, Sergi López, Doug Jones...", 112, 16, new File("Imagens\\O Labirinto do Fauno.jpg"));
					TelaFilme frame = new TelaFilme(teste);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaFilme(String nome){
		IFachada f = Fachada.getInstance();
		TelaFilme filme = new TelaFilme(f.procurarFilmeNome(nome));
	}
	/**
	 * Create the frame.
	 */
	public TelaFilme(Filme f) {
		setTitle("Cinemars");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(618, 63, 343, 490);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTituloDoFilme = new JLabel(f.getNome());
		lblTituloDoFilme.setBounds(6, 6, 331, 16);
		panel_1.add(lblTituloDoFilme);
		
		JLabel lblDiretor = new JLabel("Diretor: ");
		lblDiretor.setBounds(6, 34, 55, 16);
		panel_1.add(lblDiretor);
		
		JLabel lblNomeDoDiretor = new JLabel(f.getDiretor());
		lblNomeDoDiretor.setBounds(73, 34, 264, 16);
		panel_1.add(lblNomeDoDiretor);
		
		JLabel lblAtores = new JLabel("Atores:");
		lblAtores.setBounds(6, 62, 55, 16);
		panel_1.add(lblAtores);
		
		JLabel lblNomeDosAtores = new JLabel(f.getAtores());
		lblNomeDosAtores.setVerticalAlignment(SwingConstants.TOP);
		lblNomeDosAtores.setBounds(73, 62, 264, 48);
		panel_1.add(lblNomeDosAtores);
		
		JLabel lblGenero = new JLabel("Genero: ");
		lblGenero.setBounds(6, 122, 55, 16);
		panel_1.add(lblGenero);
		
		JLabel lblEstiloDoGenero = new JLabel(f.getGenero());
		lblEstiloDoGenero.setBounds(73, 122, 264, 16);
		panel_1.add(lblEstiloDoGenero);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textPane.setText(f.getSinopse());
		textPane.setEditable(false);
		textPane.setBounds(6, 173, 331, 311);
		panel_1.add(textPane);
		
		JLabel lblSinopse = new JLabel("Sinopse: ");
		lblSinopse.setBounds(6, 145, 55, 16);
		panel_1.add(lblSinopse);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.setVisible(true);
				menuInicial.setResizable(false);
				menuInicial.setLocationRelativeTo(null);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 58, 360, 501);
		contentPane.add(scrollPane);
		JLabel lblPoster = new JLabel("");
		lblPoster.setIcon(new ImageIcon(f.getPoster().getAbsolutePath()));
		scrollPane.setViewportView(lblPoster);
		
		
		btnVoltar.setIcon(new ImageIcon("Imagens//VoltarIcon.png"));
		btnVoltar.setBounds(0, 570, 69, 74);
		btnVoltar.setBorder(BorderFactory.createEmptyBorder());
		btnVoltar.setFocusPainted(false);
		btnVoltar.setContentAreaFilled(false);
		contentPane.add(btnVoltar);
		
		JLabel lblFundo = new JLabel("Fundo");
		lblFundo.setIcon(new ImageIcon("Imagens\\Poster cinema.jpg"));
		lblFundo.setBounds(0, 0, 999, 644);
		contentPane.add(lblFundo);
	}
}
