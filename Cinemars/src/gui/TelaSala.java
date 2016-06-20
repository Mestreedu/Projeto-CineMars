package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

public class TelaSala extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel title;
    JToggleButton l[][], m[][], r[][]; 
    JPanel panelCadeiras, panel2, panel3;
    int colunas;
    int fileiras;
    int numeroDaSala;
    char letra;
    private JLabel lblFundoSala;


	
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

	public TelaSala(int numeroSala, int col, int fil){
		this.telaSalaC(numeroSala, col, fil);
}
	
	public TelaSala(){
		this.telaSalaC(10, 10, 10);
	}
	
	private void telaSalaC(int numeroSala, int col, int fil) {
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
        title.setLocation(455,11);
        title.setSize(155, 60);
        
        l = new JToggleButton[col][fil];
        panelCadeiras = new JPanel(new GridLayout(col,fil));
        panelCadeiras.setBackground(Color.black);
        panelCadeiras.setBounds(103, 82, 808, 548);
        for(int y = 0; y < col ; y++){
                for(int x = 0; x < fil ; x++){
                	String a = String.valueOf(letra).toUpperCase();
                    l[x][y] = new JToggleButton(a + x); 
                    panelCadeiras.add(l[x][y]);
                }
                letra++;
        }

        ActionListener listener = new MyListener();

        contentPane.add(title);
        contentPane.add(panelCadeiras);
        
        lblFundoSala = new JLabel("");
        lblFundoSala.setIcon(new ImageIcon("Imagens\\SalaFundo.jpg"));
        lblFundoSala.setBounds(0, -15, 1264, 722);
        contentPane.add(lblFundoSala);
        
       
	}

private class MyListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	     System.out.println("Button pressed: " + e.getActionCommand());
	     ((JToggleButton)e.getSource()).setEnabled(false);
	  }
	}

}
