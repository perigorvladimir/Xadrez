package test;

import main.model.*;
import main.Posicao;
import main.Tabuleiro;
import main.TipoPeca;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    private Tabuleiro tabuleiro;
    private static final Logger logger = LoggerFactory.getLogger(GameTest.class);
    @BeforeEach
    public void setUp(){
        tabuleiro = new Tabuleiro();
    }
    @Test
    public void testarTabuleiroInicial(){
        assertEquals(new Torre(TipoPeca.TORRE, false),tabuleiro.getPosicao(0, 0));
        assertEquals(new Cavalo(TipoPeca.CAVALO, false), tabuleiro.getPosicao(1, 0));
        assertEquals(new Bispo(TipoPeca.BISPO, false), tabuleiro.getPosicao(2, 0));
        assertEquals(new Rainha(TipoPeca.RAINHA, false), tabuleiro.getPosicao(3, 0));
        assertEquals(new Rei(TipoPeca.REI, false), tabuleiro.getPosicao(4, 0));
        assertEquals(new Bispo(TipoPeca.BISPO, false), tabuleiro.getPosicao(5, 0));
        assertEquals(new Cavalo(TipoPeca.CAVALO, false), tabuleiro.getPosicao(6, 0));
        assertEquals(new Torre(TipoPeca.TORRE, false), tabuleiro.getPosicao(7, 0));
        for(int i=0; i<8; i++){
            assertEquals(new Peao(TipoPeca.PEAO, false), tabuleiro.getPosicao(i,1));
        }

        for(int i=0;i<8; i++){
            assertNull(tabuleiro.getPosicao(i, 2));
            assertNull(tabuleiro.getPosicao(i, 3));
            assertNull(tabuleiro.getPosicao(i, 4));
            assertNull(tabuleiro.getPosicao(i, 5));
        }

        assertEquals(new Torre(TipoPeca.TORRE, true),tabuleiro.getPosicao(0, 7));
        assertEquals(new Cavalo(TipoPeca.CAVALO, true), tabuleiro.getPosicao(1, 7));
        assertEquals(new Bispo(TipoPeca.BISPO, true), tabuleiro.getPosicao(2, 7));
        assertEquals(new Rainha(TipoPeca.RAINHA, true), tabuleiro.getPosicao(3, 7));
        assertEquals(new Rei(TipoPeca.REI, true), tabuleiro.getPosicao(4, 7));
        assertEquals(new Bispo(TipoPeca.BISPO, true), tabuleiro.getPosicao(5, 7));
        assertEquals(new Cavalo(TipoPeca.CAVALO, true), tabuleiro.getPosicao(6, 7));
        assertEquals(new Torre(TipoPeca.TORRE, true), tabuleiro.getPosicao(7, 7));
        for(int i=0; i<7; i++){
            assertEquals(new Peao(TipoPeca.PEAO, true), tabuleiro.getPosicao(i,6));
        }
    }
    @Test
    public void testarPrimeiroMovimentoPeao(){
        Posicao posicaoInicial = new Posicao(4, 1);
        Posicao posicaoFinal = new Posicao(4, 3);
        tabuleiro.mover(posicaoInicial, posicaoFinal);
        assertEquals(new Peao(TipoPeca.PEAO, false), tabuleiro.getPosicao(4, 3));
        assertNull(tabuleiro.getPosicao(4, 1));
    }
    @Test
    public void testarPrimeiroMovimentoCavalo(){
        tabuleiro.mover("b1", "c3");
        assertEquals(new Cavalo(TipoPeca.CAVALO, false), tabuleiro.getPosicao("c3"));
        assertNull(tabuleiro.getPosicao(1,0));
    }
    @Test
    public void testarTentarMoverCasaVaziaParaCasaVazia(){
        Posicao posicaoInicial = new Posicao(1,2);
        Posicao posicaoFinal = new Posicao(2, 3);
        assertFalse(tabuleiro.mover(posicaoInicial, posicaoFinal));
        assertNull(tabuleiro.getPosicao(posicaoFinal));
        assertNull(tabuleiro.getPosicao(posicaoInicial));
    }
    @Test
    public void testarTentarmoverCasaVaziaParaCasaOcupada(){
        Posicao posicaoInicial = new Posicao(1,2);
        Posicao posicaoFinal = new Posicao(3,1);
        assertFalse(tabuleiro.mover(posicaoInicial, posicaoFinal));
        assertNull(tabuleiro.getPosicao(posicaoInicial));
        assertEquals(new Peao(TipoPeca.PEAO, false), tabuleiro.getPosicao(posicaoFinal));
    }
    @Test
    public void testarTentarMoverPecaPosicaoOcupada(){
        Posicao posicaoInicial = new Posicao(1,0);
        Posicao posicaoFinal = new Posicao(3,1);
        assertFalse(tabuleiro.mover(posicaoInicial, posicaoFinal));
        assertEquals(new Peao(TipoPeca.PEAO, false), tabuleiro.getPosicao(posicaoFinal));
        assertEquals(new Cavalo(TipoPeca.CAVALO, false), tabuleiro.getPosicao(posicaoInicial));
    }
    @Test
    public void testarCapturaBasicaBranca(){
        tabuleiro.mover(new Posicao(4,1),new Posicao(4,3));
        tabuleiro.mover(new Posicao(5,6),new Posicao(5,4));
        assertTrue(tabuleiro.mover(new Posicao(4,3), new Posicao(5,4)));
        assertNull(tabuleiro.getPosicao(4,3));
        assertEquals(new Peao(TipoPeca.PEAO, false), tabuleiro.getPosicao(new Posicao(5,4)));
    }
    @Test
    public void testarCapturaBasicaPreta(){
        tabuleiro.mover(new Posicao(4,1),new Posicao(4,3));
        tabuleiro.mover(new Posicao(5,6),new Posicao(5,4));
        tabuleiro.mover(new Posicao(1,0), new Posicao(2,3));
        assertTrue(tabuleiro.mover(new Posicao(5,4), new Posicao(4,3)));
        assertNull(tabuleiro.getPosicao(5,4));
        assertEquals(new Peao(TipoPeca.PEAO, true), tabuleiro.getPosicao(4,3));
    }
    @Test
    public void testarMoverForaDoTabuleiro(){
        assertFalse(tabuleiro.mover(new Posicao(6,0), new Posicao(8,1)));
    }
    @Test
    public void testarMovimentoBasicoBispo(){
        tabuleiro.mover("d2", "d4");
        tabuleiro.mover("e7","e5");
    }
}

