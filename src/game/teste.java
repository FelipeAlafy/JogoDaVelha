package game;

public class teste {
    public static void main(String[] args) {
        String[][] tabuleiro = new String[3][3];
        tabuleiro[1][0] = "X";
        tabuleiro[1][1] = "X";
        tabuleiro[1][2] = "X";
        Draw(tabuleiro);
        int vezes = 0;
        for(int l =0; l < tabuleiro.length; l++) {
            for (int c = 0; c < tabuleiro.length; c++) {
                if (tabuleiro[l][c].equals("X")) {
                    vezes++;
                    if(vezes == 3){
                        break;
                    }
                }
            }
            if(vezes == 3){
                break;
            }
        }
        if(vezes == 3) System.out.println("Vitoria do X");
    }

    //Função de desenho
    public static void Draw(String[][] tabuleiro){
        System.out.println("I  0 1 2");
        for(int c = 0; c < tabuleiro.length; c++){
            System.out.print(c + " ");
            for(int l = 0; l < tabuleiro.length; l++){
                System.out.print("|" + tabuleiro[c][l]);
            }
            System.out.println("|");
        }
    }
}
