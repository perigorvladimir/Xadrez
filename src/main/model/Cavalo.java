package main.model;

import main.Posicao;
import main.TipoPeca;

public class Cavalo extends Peca {
    public Cavalo(TipoPeca tipoPeca, boolean isBlack){
        super(tipoPeca, isBlack);
        if(isBlack){
            this.icone="♞";
        } else{
            this.icone="♘";
        }
    }

    @Override
    public boolean isMovimentoValido(Posicao posicaoInicial, Posicao posicaoFinal) {
        int deltaY = posicaoFinal.y - posicaoInicial.y;
        int deltaX = posicaoFinal.x - posicaoInicial.x;
        return deltaY == 2 && deltaX == 1 || deltaY == 1 && deltaX == 2;
    }
}
