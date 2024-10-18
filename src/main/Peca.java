package main;

import java.util.Objects;

public class Peca {
    TipoPeca tipoPeca;
    boolean cor; //false brancas, true negras

    public Peca(TipoPeca tipoPeca, boolean cor){
        this.tipoPeca = tipoPeca;
        this.cor = cor;
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
        return cor == peca.cor && tipoPeca == peca.tipoPeca; // Compara tipo e isPreta
    }

    // Sobrescrevendo hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(tipoPeca, cor);
    }
}
