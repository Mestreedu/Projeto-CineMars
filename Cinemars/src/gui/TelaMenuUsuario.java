package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import classesBasicasCinema.Cinema;
import classesBasicasCinema.Filme;
import classesBasicasCinema.Sala;
import classesBasicasCinema.Sessao;
import negocio.Fachada;
import negocio.IFachada;

public class TelaMenuUsuario extends JFrame {

	private JPanel contentPane;

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
					TelaMenuUsuario frame = new TelaMenuUsuario();
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
	public TelaMenuUsuario() {
		IFachada f = Fachada.getInstance();

		setTitle("CineMars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		btnVoltar.setIcon(new ImageIcon("Imagens//VoltarIcon.png"));
		btnVoltar.setBounds(0, 570, 69, 74);
		btnVoltar.setBorder(BorderFactory.createEmptyBorder());
		btnVoltar.setFocusPainted(false);
		btnVoltar.setContentAreaFilled(false);
		contentPane.add(btnVoltar);

		Filme fauno = new Filme("O Labirinto do Fauno", "Fantasia/Drama",
				"Espanha, 1944. Oficialmente a Guerra Civil já terminou, mas um grupo de rebeldes ainda luta nas montanhas ao norte de Navarra. Ofelia (Ivana Baquero), de 10 anos, muda-se para a região com sua mãe, Carmen (Ariadna Gil). Lá as espera seu novo padrasto, um oficial fascista que luta para exterminar os guerrilheiros da localidade. Solitária, a menina logo descobre a amizade de Mercedes (Maribel Verdú), jovem cozinheira da casa, que serve de contato secreto dos rebeldes. Além disso, em seus passeios pelo jardim da imensa mansão em que moram, Ofelia descobre um labirinto que faz com que todo um mundo de fantasias se abra, trazendo consequências para todos à sua volta.",
				"Guilhermo del Toro", " Ivana Baquero, Sergi López, Doug Jones...", 112, 16,
				new File("Imagens\\O Labirinto do Fauno.jpg"));
		Filme cadaver = new Filme("A Noiva Cadaver", "Animação/Drama", "Sinopse fake", "Diretor desconhecido",
				"Atores desconhecidos", 115, 16, new File("Imagens\\SalaFundo.jpg"));

		f.cadastrarFilme(fauno);
		f.cadastrarFilme(cadaver);

		JList listFilme = new JList();
		listFilme.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2) {

					TelaFilme telaF = new TelaFilme(f.procurarFilmeNome(
							(String) listFilme.getModel().getElementAt(listFilme.getSelectedIndex())));
					dispose();
					telaF.setVisible(true);
					telaF.setLocationRelativeTo(null);
					telaF.setResizable(false);
				}
			}
		});

		JLabel lblSesses = new JLabel("Sess\u00F5es");
		lblSesses.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesses.setForeground(Color.BLACK);
		lblSesses.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		lblSesses.setBounds(394, 235, 220, 45);
		contentPane.add(lblSesses);

		JLabel lblCinemas = new JLabel("Cinemas");
		lblCinemas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinemas.setForeground(Color.BLACK);
		lblCinemas.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		lblCinemas.setBounds(87, 235, 220, 45);
		contentPane.add(lblCinemas);

		JLabel lblListaFilmes = new JLabel("Filmes");
		lblListaFilmes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaFilmes.setIcon(new ImageIcon("Imagens//Movie-Studio-icon.png"));
		lblListaFilmes.setForeground(Color.BLACK);
		lblListaFilmes.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		lblListaFilmes.setBounds(701, 235, 220, 45);
		contentPane.add(lblListaFilmes);
		listFilme.setModel(new AbstractListModel() {
			String[] values = new String[] { fauno.getNome(), cadaver.getNome() };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listFilme.setBounds(686, 291, 280, 279);
		contentPane.add(listFilme);
		List sessoes = new ArrayList<Sessao>();
		Sessao dasTreze = new Sessao(new Sala(2, 8, 8), fauno, LocalDate.of(2016, 06, 27), LocalTime.of(13, 5, 30));
		sessoes.add(dasTreze);
		Cinema UCI = new Cinema("UCI Recife", 35626654, new ArrayList<Sala>(), sessoes);

		JList listCinema = new JList();
		listCinema.setModel(new AbstractListModel() {

			List<String> values = f.retornaTudo();

			public Object getElementAt(int index) {
				return values.get(index);
			}

			public int getSize() {
				return values.size();
			}

		});
		listCinema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2) {
				}
			}
		});
		listCinema.setBounds(42, 291, 280, 282);
		contentPane.add(listCinema);

		JList listSessao = new JList();
		listSessao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

			}
		});
		listSessao.setBounds(364, 289, 280, 282);
		contentPane.add(listSessao);

		JButton ferramentasIconButton = new JButton("");
		ferramentasIconButton.setIcon(new ImageIcon("Imagens//FerramentasIcon.png"));
		ferramentasIconButton.setBounds(963, 593, 52, 65);
		ferramentasIconButton.setBorder(BorderFactory.createEmptyBorder());
		ferramentasIconButton.setFocusPainted(false);
		ferramentasIconButton.setContentAreaFilled(false);
		contentPane.add(ferramentasIconButton);

		JLabel lblBemvindo = new JLabel("");
		lblBemvindo.setForeground(SystemColor.textHighlight);
		lblBemvindo.setFont(new Font("Twentieth Century Medium", Font.BOLD, 26));
		lblBemvindo.setBounds(269, 50, 438, 45);
		contentPane.add(lblBemvindo);

		JLabel lblMenuAdmin = new JLabel("");
		lblMenuAdmin.setIcon(new ImageIcon("Imagens//TelaCAdmin.jpg"));
		lblMenuAdmin.setBounds(0, 0, 1020, 655);
		contentPane.add(lblMenuAdmin);
	}
}