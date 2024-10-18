package test;

import main.Peca;
import main.Posicao;
import main.Tabuleiro;
import main.TipoPeca;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {
    @Test
    public void testarTabuleiroInicial(){
        Tabuleiro tabuleiro = new Tabuleiro();
        assertEquals(new Peca(TipoPeca.TORRE, false),tabuleiro.getPosicao(0, 0));
        assertEquals(new Peca(TipoPeca.CAVALO, false), tabuleiro.getPosicao(1, 0));
        assertEquals(new Peca(TipoPeca.BISPO, false), tabuleiro.getPosicao(2, 0));
        assertEquals(new Peca(TipoPeca.RAINHA, false), tabuleiro.getPosicao(3, 0));
        assertEquals(new Peca(TipoPeca.REI, false), tabuleiro.getPosicao(4, 0));
        assertEquals(new Peca(TipoPeca.BISPO, false), tabuleiro.getPosicao(5, 0));
        assertEquals(new Peca(TipoPeca.CAVALO, false), tabuleiro.getPosicao(6, 0));
        assertEquals(new Peca(TipoPeca.TORRE, false), tabuleiro.getPosicao(7, 0));
        for(int i=0; i<7; i++){
            assertEquals(new Peca(TipoPeca.PEAO, false), tabuleiro.getPosicao(i,1));
        }

        for(int i=0;i<7; i++){
            assertNull(tabuleiro.getPosicao(i, 2));
            assertNull(tabuleiro.getPosicao(i, 3));
            assertNull(tabuleiro.getPosicao(i, 4));
            assertNull(tabuleiro.getPosicao(i, 5));
        }

        assertEquals(new Peca(TipoPeca.TORRE, true),tabuleiro.getPosicao(0, 7));
        assertEquals(new Peca(TipoPeca.CAVALO, true), tabuleiro.getPosicao(1, 7));
        assertEquals(new Peca(TipoPeca.BISPO, true), tabuleiro.getPosicao(2, 7));
        assertEquals(new Peca(TipoPeca.RAINHA, true), tabuleiro.getPosicao(3, 7));
        assertEquals(new Peca(TipoPeca.REI, true), tabuleiro.getPosicao(4, 7));
        assertEquals(new Peca(TipoPeca.BISPO, true), tabuleiro.getPosicao(5, 7));
        assertEquals(new Peca(TipoPeca.CAVALO, true), tabuleiro.getPosicao(6, 7));
        assertEquals(new Peca(TipoPeca.TORRE, true), tabuleiro.getPosicao(7, 7));
        for(int i=0; i<7; i++){
            assertEquals(new Peca(TipoPeca.PEAO, true), tabuleiro.getPosicao(i,6));
        }
    }
    @Test
    public void testarPrimeiroMovimentoPeao(){
        Tabuleiro tabuleiro = new Tabuleiro();
        Posicao posicaoInicial = new Posicao(4, 1);
        Posicao posicaoFinal = new Posicao(4, 3);
        tabuleiro.mover(posicaoInicial, posicaoFinal);
        assertEquals(new Peca(TipoPeca.PEAO, false), tabuleiro.getPosicao(4, 3));
        assertNull(tabuleiro.getPosicao(4, 1));
    }
}
