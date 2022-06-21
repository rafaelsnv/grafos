package Grafo;

public enum Cor {
    VERMELHO(0),
    AMARELO(0),
    VERDE(0),
    AZUL(0),
    ROXO(0);

    private int qtdUsos;

    Cor(int qtdUsos) {
        this.qtdUsos = qtdUsos;
    }

    public int getQtdUsos() {
        return qtdUsos;
    }

    public void setQtdUsos(int qtdUsos) {
        this.qtdUsos += qtdUsos;
    }

    public void resetQtdUso(){
        this.qtdUsos = 0;
    }

    @Override
    public String toString() {
        return "Cor{" +
                "qtdUsos=" + qtdUsos +
                '}';
    }
}
