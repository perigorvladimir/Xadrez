package main;


import main.model.*;

public class Tabuleiro {
    private Peca[][] tabuleiro = new Peca[8][8]; //coluna,linha
    private boolean turnoDasBrancas = true;

    public Tabuleiro(){
        tabuleiro[0][0] = new Torre(TipoPeca.TORRE, false);
        tabuleiro[1][0] = new Cavalo(TipoPeca.CAVALO, false);
        tabuleiro[2][0] = new Bispo(TipoPeca.BISPO, false);
        tabuleiro[3][0] = new Rainha(TipoPeca.RAINHA, false);
        tabuleiro[4][0] = new Rei(TipoPeca.REI, false);
        tabuleiro[5][0] = new Bispo(TipoPeca.BISPO, false);
        tabuleiro[6][0] = new Cavalo(TipoPeca.CAVALO, false);
        tabuleiro[7][0] = new Torre(TipoPeca.TORRE, false);
        for(int i=0;i<8;i++){
            tabuleiro[i][1] = new Peao(TipoPeca.PEAO, false);
        }

        tabuleiro[0][7] = new Torre(TipoPeca.TORRE, true);
        tabuleiro[1][7] = new Cavalo(TipoPeca.CAVALO, true);
        tabuleiro[2][7] = new Bispo(TipoPeca.BISPO, true);
        tabuleiro[3][7] = new Rainha(TipoPeca.RAINHA, true);
        tabuleiro[4][7] = new Rei(TipoPeca.REI, true);
        tabuleiro[5][7] = new Bispo(TipoPeca.BISPO, true);
        tabuleiro[6][7] = new Cavalo(TipoPeca.CAVALO, true);
        tabuleiro[7][7] = new Torre(TipoPeca.TORRE, true);
        for(int i=0;i<8;i++){
            tabuleiro[i][6] = new Peao(TipoPeca.PEAO, true);
        }
    }

    public Peca getPosicao(int x, int y){
        return tabuleiro[x][y];
    }
    public Peca getPosicao(Posicao posicao){
        return getPosicao(posicao.x, posicao.y);
    }
    public Peca getPosicao(String posicao){
        return getPosicao(getPosicaoByString(posicao));
    }
    public boolean mover(Posicao posicaoInicial, Posicao posicaoFinal){
        Peca peca = getPosicao(posicaoInicial);
        if(peca==null){
            return false;
        }
        if(posicaoFinal.x>7 || posicaoFinal.y>7){
            return false;
        }
        if(!checkTurno(getPosicao(posicaoInicial).isBlack())){
            return false;
        }
        if(tabuleiro[posicaoFinal.x][posicaoFinal.y]!=null && getPosicao(posicaoFinal).isBlack()==peca.isBlack()){
            return false;
        }
        if(peca.isMovimentoValido(posicaoInicial, posicaoFinal, getPosicao(posicaoFinal)!=null)){
            tabuleiro[posicaoFinal.x][posicaoFinal.y] = peca;
            tabuleiro[posicaoInicial.x][posicaoInicial.y] = null;
            passarTurno();
            return true;
        }
        return false;
    }
    public boolean mover(String posicaoInicial, String posicaoFinal){
        return mover(getPosicaoByString(posicaoInicial), getPosicaoByString(posicaoFinal));
    }

    private int getColunaPorLetra(char coluna){
        return switch (coluna) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            default -> -1;
        };
    }

    private Posicao getPosicaoByString(String posicaoString){
        if(posicaoString.length()>2){
            throw new RuntimeException("a posicao passada por string nao pode ter mais de 2 caracteres");
        }
        return new Posicao(getColunaPorLetra(posicaoString.charAt(0)), Character.getNumericValue(posicaoString.charAt(1)-1));
    }

    private boolean checkTurno(boolean isBlack){
        return this.turnoDasBrancas==!isBlack;
    }

    private void passarTurno(){
        this.turnoDasBrancas=!this.turnoDasBrancas;
    }

    public void print(){
        for(int i=0;i<8;i++){
            System.out.print("\n");
            for(int j=0;j<8;j++){
                if(tabuleiro[j][i]!=null){
                    System.out.print(tabuleiro[j][i].getIcone());
                } else {
                    System.out.print("X");
                }
            }
        }
    }
}
