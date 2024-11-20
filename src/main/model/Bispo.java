package main.model;

import main.Posicao;
import main.Tabuleiro;
import main.TipoPeca;

public class Bispo extends Peca {
    public Bispo(TipoPeca tipoPeca, boolean isBlack){
        super(tipoPeca, isBlack);
        if(isBlack){
            this.icone="♝";
        } else{
            this.icone="♗";
        }
    }
    public boolean isMovimentoValido(Posicao posicaoInicial, Posicao posicaoFinal){
        return false;
    }
}
