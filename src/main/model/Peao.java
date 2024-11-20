package main.model;

import main.Posicao;
import main.TipoPeca;

public class Peao extends Peca{
    private boolean isPrimeiroMovimento;
    public Peao(TipoPeca tipoPeca, boolean isBlack) {
        super(tipoPeca, isBlack);
        this.isPrimeiroMovimento=true;
        if(isBlack){
            this.icone="♟";
        } else {
            this.icone="♙";
        }
    }

    @Override
    public boolean isMovimentoValido(Posicao posicaoInicial, Posicao posicaoFinal) {
        return false;
    }
    @Override
    public boolean isMovimentoValido(Posicao posicaoInicial, Posicao posicaoFinal, boolean isCaptura){
        int direcao = isBlack ? -1:1;
        if(isCaptura){
            if(posicaoFinal.x==posicaoInicial.x+1 || posicaoFinal.x==posicaoInicial.x-1){//se tiver uma casa pra alguma diagonal
                return posicaoFinal.y == posicaoInicial.y + direcao; // se tiver uma casa à frente
            }
        }
        if(posicaoFinal.x == posicaoInicial.x) {
            if(isPrimeiroMovimento){
                return posicaoFinal.y == posicaoInicial.y + direcao || posicaoFinal.y == posicaoInicial.y + direcao + direcao;
            }
            return posicaoFinal.y == posicaoInicial.y+direcao;
        }
        return false;
    }
}
