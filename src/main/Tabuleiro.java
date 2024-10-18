package main;

public class Tabuleiro {
    private Peca[][] tabuleiro = new Peca[8][8];

    public Tabuleiro(){
        tabuleiro[0][0] = new Peca(TipoPeca.TORRE, false);
        tabuleiro[1][0] = new Peca(TipoPeca.CAVALO, false);
        tabuleiro[2][0] = new Peca(TipoPeca.BISPO, false);
        tabuleiro[3][0] = new Peca(TipoPeca.RAINHA, false);
        tabuleiro[4][0] = new Peca(TipoPeca.REI, false);
        tabuleiro[5][0] = new Peca(TipoPeca.BISPO, false);
        tabuleiro[6][0] = new Peca(TipoPeca.CAVALO, false);
        tabuleiro[7][0] = new Peca(TipoPeca.TORRE, false);
        for(int i=0;i<7;i++){
            tabuleiro[i][1] = new Peca(TipoPeca.PEAO, false);
        }

        tabuleiro[0][7] = new Peca(TipoPeca.TORRE, true);
        tabuleiro[1][7] = new Peca(TipoPeca.CAVALO, true);
        tabuleiro[2][7] = new Peca(TipoPeca.BISPO, true);
        tabuleiro[3][7] = new Peca(TipoPeca.RAINHA, true);
        tabuleiro[4][7] = new Peca(TipoPeca.REI, true);
        tabuleiro[5][7] = new Peca(TipoPeca.BISPO, true);
        tabuleiro[6][7] = new Peca(TipoPeca.CAVALO, true);
        tabuleiro[7][7] = new Peca(TipoPeca.TORRE, true);
        for(int i=0;i<7;i++){
            tabuleiro[i][6] = new Peca(TipoPeca.PEAO, true);
        }
    }

    public Peca getPosicao(int x, int y){
        if(tabuleiro[x][y]!=null){
            return tabuleiro[x][y];
        }
        return null;
    }

    public boolean mover(Posicao posicaoInicial, Posicao posicaoFinal){
        Peca peca = getPosicao(posicaoInicial.x, posicaoInicial.y);
        tabuleiro[posicaoInicial.x][posicaoInicial.y] = null;
        if(peca.getTipoPeca() == TipoPeca.PEAO){
            tabuleiro[posicaoFinal.x][posicaoFinal.y] = peca;
        }
        return false;
    }
}
