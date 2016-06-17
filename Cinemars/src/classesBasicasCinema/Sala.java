package classesBasicasCinema;

import java.util.Scanner;

public class Sala {
	 
    private int linha;
    private int coluna;
    private int numero;
    private String cadeiras[][] = new String[10][10];
 
    public Sala(int numero, int linha, int coluna) {
 
        cadeiras = new String[linha][coluna];
        this.coluna = coluna;
        this.linha = linha;
        this.numero = numero;
 
        int pos = 1;
 
        for (int l = 0; l < this.linha; l++) {
            for (int c = 0; c < this.coluna; c++) {
 
                cadeiras[l][c] = Integer.toString(pos);
 
                pos++;
            }
        }
 
    }
     
    Scanner sc = new Scanner(System.in);
     
 
    public String reservaCadeira(int num) {
        String msg = "LUGAR INDISPONÍVEL!\n";
        for (int l = 0; l < this.linha; l++) {
            for (int c = 0; c < this.coluna; c++) {
                if (cadeiras[l][c].equals(Integer.toString(num))) {
                    if (!cadeiras[l][c].equals("X")) {
                        msg = "LUGAR RESERVADO COM SUCESSO - CADEIRA: " + num;
                        cadeiras[l][c] = "X";
                        mostraCadeiras();
                        System.out.println(msg);
                         
                        return msg;
                    }
                }
 
            }
        }
        System.out.println(msg);
        return msg;
    }
 
    public String reservaEmGrupo(int num) {
        int w = 0;
         
        String msgGrupo = "LUGARES RESERVADOS: ";
 
        if (num > (linha * coluna) || num <= 0) {
             
            msgGrupo = "LUGARES INDISPONÍVEIS!";
            System.out.println(msgGrupo);
            return msgGrupo;
        }
 
        String cadeirasGrupo[] = new String[num];
        System.out.println("\nDigite os lugares que deseja reservar: ");
        while(w < num){
             
            int scaneado = sc.nextInt();
             
            if (!reservaCadeira(scaneado).equals("LUGAR INDISPONÍVEL!\n")){
                for (int l=0;l<this.linha;l++)
                   {
                       for(int c=0;c<this.coluna;c++)
                       {
                          if(!cadeiras[l][c].equals("X") && w < num)
                          {
                          cadeirasGrupo[w] = Integer.toString(scaneado);
                                 
                                 
                          }
                       }
                    }
                 
                w++;
            }
             
        }
         
        for (int i = 0; i < num; i++) {
             
                  msgGrupo = msgGrupo + "[" + cadeirasGrupo[i]+"]";
              }
         
        System.out.println("\n");
               
        return msgGrupo;
             
        }
 
 
    public int getNumero() {
        return numero;
    }
 
    public void mostraCadeiras() {
        for (int l = 0; l < linha; l++) {
            System.out.print(" " + (l + 1) + "   =>");
            for (int c = 0; c < coluna; c++) {
                System.out.print(" " + cadeiras[l][c] + " |");
            }
            System.out.print(" \n");
        }
        System.out.println(" \n");
    }
 
}
