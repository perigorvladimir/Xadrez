package main;

public class Tabuleiro {
    private Peca[][] tabuleiro = new Peca[8][8];

    public Tabuleiro(){
        tabuleiro[0][0] = new Peca(TipoPeca.TORRE, false);
        tabuleiro[0][7] = new Peca(TipoPeca.TORRE, false);

        tabuleiro[0][4] = new Peca(TipoPeca.REI, false);
    }

    public Peca getPosicao(int x, int y){
        if(tabuleiro[x][y]!=null){
            return tabuleiro[x][y];
        }
        return null;
    }
}
