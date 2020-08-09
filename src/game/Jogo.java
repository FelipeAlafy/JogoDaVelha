package game;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Jogo {
    //Função de inicialização
    public static void main(String[] args) {
        //Variáveis
        String[][] tab = new String[3][3];
        int c, l, d, f;
        boolean valid1 = false;
        boolean valid2 = false;
        boolean check = false;
        boolean checkVelha = false;
        boolean trocarDeJogador = false;
        String jogar = "s";
        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();
        Scanner tec = new Scanner(System.in);

        //Lendo as credências dos jogadores
        System.out.print("Jogador(a) 1 insira seu nome: ");
        j1.setNome(tec.next());
        System.out.print("Jogador(a) 2 insira seu nome: ");
        j2.setNome(tec.next());

        System.out.print("\033[0;32mJogador(a) " + j1.getNome() + " insira sua peça: \033[0;31m");
        j1.setPeca(tec.next());
        System.out.print("\033[0;32mJogador(a) " + j2.getNome() + " insira sua peça: \033[0;31m");
        j2.setPeca(tec.next());
        System.out.println("\033[m");

        //Loop-inicial
        while(jogar.equals("s")) {
            limparTela();
            limparTab(tab);
            while(true) {
                draw(tab);
                //Verificando o input do jogador
                while(!valid1) {
                    System.out.print(j1.getNome() + " insira a Linha: ");
                    c = tec.nextInt();
                    System.out.print(j1.getNome() + " insira a Coluna: ");
                    l = tec.nextInt();
                    if ((c >= 0 && c < 3) && (l >= 0 && l < 3)) {
                        if (tab[c][l].equals(" ")) {
                            tab[c][l] = j1.getPeca();
                            valid1 = true;
                        }
                    }
                }

                valid1 = false;
                c = 0;
                l = 0;

                check = verificarHorizontal(tab, j1);
                if(check){
                    System.out.println("\033[34m" + j1.getNome() + " VENCEUUUU!!!!\n E agora tem " + j1.getVitorias() + " vitórias.\033[m");
                    break;
                }
                check = verificarVertical(tab, j1);
                if(check){
                    System.out.println("\033[34m" + j1.getNome() + " VENCEUUUU!!!!\n E agora tem " + j1.getVitorias() + " vitórias.\033[m");
                    break;
                }
                verificarDiagonais(tab, j1);
                if(check) {
                    System.out.println("\033[34m" + j1.getNome() + " VENCEUUUU!!!!\n E agora tem " + j1.getVitorias() + " vitórias.\033[m");
                    break;
                }
                draw(tab);
                while(!valid2) {
                    System.out.print(j2.getNome() + " insira a Linha: ");
                    c = tec.nextInt();
                    System.out.print(j2.getNome() + " insira a Coluna: ");
                    l = tec.nextInt();
                    if ((c >= 0 && c < 3) && (l >= 0 && l < 3)) {
                        if (tab[c][l].equals(" ")) {
                            tab[c][l] = j2.getPeca();
                            valid2 = true;
                        }
                    }
                }

                valid2 = false;
                c = 0;
                l = 0;

                check = verificarHorizontal(tab, j2);
                if(check){
                    System.out.println("\033[34m" + j2.getNome() + " VENCEUUUU!!!!\n E agora tem " + j2.getVitorias() + " vitórias.\033[m");
                    break;
                }
                check = verificarVertical(tab, j2);
                if(check){
                    System.out.println("\033[34m" + j2.getNome() + " VENCEUUUU!!!!\n E agora tem " + j2.getVitorias() + " vitórias.\033[m");
                    break;
                }
                verificarDiagonais(tab, j2);
                if(check) {
                    System.out.println("\033[34m" + j2.getNome() + " VENCEUUUU!!!!\n E agora tem " + j2.getVitorias() + " vitórias.\033[m");
                    break;
                }
                checkVelha = velha(tab);
                if(checkVelha){
                    System.out.println("\033[31mCOMO É POSSÍVEL A VELHA VENCEU DE NOVO!!!\033[m");
                    break;
                }
            }
            do {
                draw(tab);
                System.out.print("Vocês querem jogar de novo? [N/s] ");
                jogar = tec.next();
            } while (!((jogar.toUpperCase().equals("N")) || (jogar.toUpperCase().equals("S"))));
        }
    }

    //Funções
    //Desenho
    public static void draw(String[][] tab){
        System.out.println("   0 1 2");
        for(int c = 0; c < 3; c++){
            System.out.print(c + " |");
            for(int l = 0; l < 3; l++){
                System.out.print(tab[c][l] + "|");
            }
            System.out.println();
        }
    }

    //Verificar horizontal
    public static boolean verificarHorizontal(String[][] tab, Jogador j){
        if (tab[0][0].equals(j.getPeca()) && tab[0][1].equals(j.getPeca()) && tab[0][2].equals(j.getPeca())) {
            j.vitoria();
            return true;
        } else if (tab[1][0].equals(j.getPeca()) && tab[1][1].equals(j.getPeca()) && tab[1][2].equals(j.getPeca())) {
            j.vitoria();
            return true;
        } else if (tab[2][0].equals(j.getPeca()) && tab[2][1].equals(j.getPeca()) && tab[2][2].equals(j.getPeca())) {
            j.vitoria();
            return true;
        } else return false;
    }

    //Verificar Vertical
    public static boolean verificarVertical(String[][] tab, Jogador j){
        if(tab[0][0].equals(j.getPeca()) && tab[1][0].equals(j.getPeca()) && tab[2][0].equals(j.getPeca())){
            j.vitoria();
            return true;
        } else if(tab[1][0].equals(j.getPeca()) && tab[1][1].equals(j.getPeca()) && tab[1][2].equals(j.getPeca())) {
            j.vitoria();
            return true;
        } else if(tab[2][0].equals(j.getPeca()) && tab[2][1].equals(j.getPeca()) && tab[2][2].equals(j.getPeca())) {
            j.vitoria();
            return true;
        } else return false;
    }

    //verificar diagonais
    public static boolean verificarDiagonais(String[][] tab, Jogador j){
        if(tab[0][0].equals(j.getPeca()) && tab[1][1].equals(j.getPeca()) && tab[2][2].equals(j.getPeca())){
            j.vitoria();
            return true;
        } else if(tab[0][2].equals(j.getPeca()) && tab[1][1].equals(j.getPeca()) && tab[2][0].equals(j.getPeca())){
            j.vitoria();
            return true;
        } else {
            return false;
        }
    }

    //Verificando a Velha
    public static boolean velha(String[][] tab){
        boolean c0 = false;
        boolean c10 = false;
        boolean c11 = false;
        if(tab[0][0].equals(" ") || tab[0][1].equals(" ") || tab[0][2].equals(" ")) {
            return false;
        }
        if(tab[1][0].equals(" ") || tab[1][1].equals(" ") || tab[1][2].equals(" ")){
            return false;
        }
        if(tab[2][0].equals(" ") || tab[2][1].equals(" ") || tab[2][2].equals(" ")){
            return false;
        } else return true;
    }

    //Limpeza de Tela
    public static void limparTela(){
        for(int c = 0; c < 120; c++){
            System.out.println();
        }
    }

    //Limpar Tabuleiro
    public static void limparTab(String[][] tab){
        for(int c = 0; c < tab.length; c++){
            for(int l = 0; l < tab.length; l++){
                tab[c][l] = " ";
            }
        }
    }
}
