package main;

public enum TipoPeca {
    PEAO("Peao", 1),
    BISPO("Bispo", 3),
    CAVALO("Cavalo", 3),
    RAINHA("Rainha", 9),
    REI("Rei", Integer.MAX_VALUE),
    TORRE("Torre", 5);
    private final String nome;
    private final int valor;

    TipoPeca(String nome, int valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome(){
        return nome;
    }

    public int getValor(){
        return valor;
    }
}
