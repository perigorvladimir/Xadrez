package main.model;

import main.Posicao;
import main.TipoPeca;

public class Torre extends Peca{
    public Torre(TipoPeca tipoPeca, boolean isBlack){
        super(tipoPeca, isBlack);
        if(isBlack){
            this.icone="♜";
        } else{
            this.icone="♖";
        }
    }

    @Override
    public boolean isMovimentoValido(Posicao posicaoInicial, Posicao posicaoFinal) {
        return false;
    }
}
