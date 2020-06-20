package game;

import java.util.Scanner;

public class Jogo {
    //Função de inicialização
    public static void main(String[] args) {
        String[][] tabuleiro = new String[3][3];
        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();
        boolean ret = false;
        //Preenchendo o tabuleiro;
        for(int c = 0; c < tabuleiro.length; c++){
            for(int i = 0; i < tabuleiro.length; i++){
                tabuleiro[c][i] = " ";
            }
        }
        Scanner sc = new Scanner(System.in);
        //Info sobre os players
        System.out.print("Jogador 1 insira seu nome: ");
        j1.setNome(sc.nextLine());
        System.out.print("Jogador 2 insira seu nome: ");
        j2.setNome(sc.nextLine());
        //Peça
        j1.setPeca("X");
        j2.setPeca("O");
        System.out.println("O(A) " + j1.getNome() + " está jogando como " + j1.getPeca() + "\nO(A) " + j2.getNome() + "está jogando como " + j2.getPeca());

        Draw(tabuleiro);
        while(true){
            //Jogador 1
            Entrada(tabuleiro, j1);
            ret = VerificarDiagonal(j1, tabuleiro);

            Draw(tabuleiro);
            if(ret) break;

            //jogador 2
            Entrada(tabuleiro, j2);
            ret = VerificarDiagonal(j2, tabuleiro);
            Draw(tabuleiro);
            if(ret) break;
        }

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

    //Função de entrada
    public static void Entrada(String[][] tabuleiro, Jogador j){
        Scanner sc = new Scanner(System.in);
        System.out.println("Jogador(a) " + j.getNome() + " Faça sua jogada");
        System.out.print("Coluna: ");
        int l = sc.nextInt();
        System.out.print("Linha: ");
        int c = sc.nextInt();
        if(tabuleiro[c][l].equals(" ")) Mark(j, c, l, tabuleiro);
        else {
            while (!tabuleiro[c][l].equals(" ")) {
                System.out.println("Não foi possível marcar nesse posição, pois está sendo marcada por Outro Jogador.\nTente Novamente");
                System.out.print("Coluna: ");
                l = sc.nextInt();
                System.out.print("Linha: ");
                c = sc.nextInt();
            }
            Mark(j, c, l, tabuleiro);
        }
    }

    //Função de marcar
    public static void Mark(Jogador j, int c, int l, String[][] tabuleiro){
        tabuleiro[c][l] = j.getPeca();
    }

    //Função para Verificar nas diagonais
    public static boolean VerificarDiagonal(Jogador j, String[][] tabuleiro){
        if((tabuleiro[0][0].equals(j.getPeca())) && (tabuleiro[1][1].equals(j.getPeca())) && (tabuleiro[2][2].equals(j.getPeca()))){
            FimJogo(j);
            return true;
        } else if ((tabuleiro[2][0].equals(j.getPeca())) && (tabuleiro[1][1].equals(j.getPeca())) && (tabuleiro[0][2].equals(j.getPeca()))){
            FimJogo(j);
            return true;
        } else {
            return false;
        }
    }



    //Função declararVitoria
    public static void FimJogo(Jogador j){
        System.out.println("O " + j.getNome() + " Venceu!");
        System.out.println("Fim do jogo.");
    }
}
