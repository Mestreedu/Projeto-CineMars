package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

public class TelaMenuAdmin extends JFrame {

	/**
	 * 
	 */
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
					TelaMenuAdmin frame = new TelaMenuAdmin();
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
	public TelaMenuAdmin() {
		setTitle("CineMars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrarCinema = new JButton("");
		btnCadastrarCinema.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

			}
		});
		btnCadastrarCinema.setIcon(new ImageIcon("Imagens\\addCinema.png"));
		btnCadastrarCinema.setBounds(648, 170, 131, 140);
		btnCadastrarCinema.setBorder(BorderFactory.createEmptyBorder());
		btnCadastrarCinema.setFocusPainted(false);
		btnCadastrarCinema.setContentAreaFilled(false);
		contentPane.add(btnCadastrarCinema);

		JLabel lblCadastrarCinemaAdmin = new JLabel("Cadastrar Cinema");
		lblCadastrarCinemaAdmin.setForeground(Color.LIGHT_GRAY);
		lblCadastrarCinemaAdmin.setFont(new Font("OCR A Extended", Font.ITALIC, 15));
		lblCadastrarCinemaAdmin.setBounds(639, 291, 156, 65);
		contentPane.add(lblCadastrarCinemaAdmin);

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
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\Eduardo\\Downloads\\VoltarIcon.png"));
		btnVoltar.setBounds(0, 570, 69, 74);
		btnVoltar.setBorder(BorderFactory.createEmptyBorder());
		btnVoltar.setFocusPainted(false);
		btnVoltar.setContentAreaFilled(false);
		contentPane.add(btnVoltar);

		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(96, 291, 280, 279);
		contentPane.add(list);

		JButton updateCineButton = new JButton("");
		updateCineButton.setIcon(new ImageIcon("C:\\Users\\Eduardo\\Downloads\\UpdateFinalIcon.png"));
		updateCineButton.setBounds(648, 384, 131, 116);
		updateCineButton.setBorder(BorderFactory.createEmptyBorder());
		updateCineButton.setContentAreaFilled(false);
		updateCineButton.setFocusPainted(false);
		contentPane.add(updateCineButton);

		JLabel lblAtualizarCinemas = new JLabel("Atualizar Cinemas");
		lblAtualizarCinemas.setForeground(new Color(211, 211, 211));
		lblAtualizarCinemas.setFont(new Font("OCR A Extended", Font.ITALIC, 15));
		lblAtualizarCinemas.setBounds(639, 486, 156, 65);
		contentPane.add(lblAtualizarCinemas);

		JLabel lblListadeCinemasSeus = new JLabel("Seus Cinemas");
		lblListadeCinemasSeus.setIcon(new ImageIcon("C:\\Users\\Eduardo\\Downloads\\Movie-Studio-icon.png"));
		lblListadeCinemasSeus.setForeground(new Color(255, 255, 0));
		lblListadeCinemasSeus.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		lblListadeCinemasSeus.setBounds(135, 244, 220, 45);
		contentPane.add(lblListadeCinemasSeus);

		JButton ferramentasIconButton = new JButton("");
		ferramentasIconButton.setIcon(new ImageIcon("C:\\Users\\Eduardo\\Downloads\\FerramentasIcon.png"));
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
		lblMenuAdmin.setIcon(new ImageIcon("C:\\Users\\Eduardo\\Downloads\\TelaCAdmin.jpg"));
		lblMenuAdmin.setBounds(0, 0, 1020, 655);
		contentPane.add(lblMenuAdmin);
	}

}