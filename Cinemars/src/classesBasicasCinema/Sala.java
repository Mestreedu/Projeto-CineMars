package classesBasicasCinema;


import gui.TelaSala;

public class Sala {
	 
    private int linha;
    private int coluna;
    private int numero;
    private TelaSala telaSala;
 
    public Sala(int numero, int linha, int coluna) {
 
        this.coluna = coluna;
        this.linha = linha;
        this.numero = numero;
 
        telaSala = new TelaSala(numero, linha, coluna);
        telaSala.setLocationRelativeTo(null);
        telaSala.setResizable(false);
        telaSala.setVisible(false);
    }
     
   public void turnSalaTrue(){
	   telaSala.setVisible(true);
	   
   }
 
 
    public int getNumero() {
        return numero;
    }
 
  
 
}
