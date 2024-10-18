package test;

import main.Peca;
import main.Tabuleiro;
import main.TipoPeca;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {
    @Test
    public void testarTabuleiroInicial(){
        Tabuleiro tabuleiro = new Tabuleiro();
        assertEquals(new Peca(TipoPeca.TORRE, false),tabuleiro.getPosicao(0, 0));
        assertEquals(new Peca(TipoPeca.TORRE, false), tabuleiro.getPosicao(0, 7));
        assertEquals(new Peca(TipoPeca.REI, false), tabuleiro.getPosicao(0, 4));
    }
}
