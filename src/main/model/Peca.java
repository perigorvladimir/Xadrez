package main.model;

import main.Posicao;
import main.Tabuleiro;
import main.TipoPeca;

import java.util.Objects;

public abstract class Peca {
    protected TipoPeca tipoPeca;
    protected boolean isBlack; //false brancas, true negras
    protected String icone;

    public Peca(TipoPeca tipoPeca, boolean isBlack){
        this.tipoPeca = tipoPeca;
        this.isBlack = isBlack;
    }

    public TipoPeca getTipoPeca(){
        return tipoPeca;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Se forem o mesmo objeto
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Se não forem da mesma classe
        }
        Peca peca = (Peca) obj;
        return isBlack == peca.isBlack && tipoPeca == peca.tipoPeca; // Compara tipo e isPreta
    }

    // Sobrescrevendo hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(tipoPeca, isBlack);
    }

    @Override
    public String toString() {
        return tipoPeca.toString();
    }

    public boolean isBlack(){
        return isBlack;
    }

    public String getIcone(){
        return icone;
    }

    public abstract boolean isMovimentoValido(Posicao posicaoInicial, Posicao posicaoFinal);

    public boolean isMovimentoValido(Posicao posicaoInicial, Posicao posicaoFinal, boolean isCaptura){
        return isMovimentoValido(posicaoInicial, posicaoFinal);
    }
}
