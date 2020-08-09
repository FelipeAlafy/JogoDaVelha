package game;

public class Jogador {
    private String nome = "";
    private String peca = "";
    private int vitorias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

    public void vitoria(){
        this.vitorias++;
    }
    public int getVitorias(){
        return this.vitorias;
    }
}
