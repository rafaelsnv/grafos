package Grafo;

public class Aresta{
    private String id;
    private int peso, direcao;
    private Vertice v1, v2;

    public Aresta(String id, int peso, int direcao, Vertice v1, Vertice v2) {
        this.id = id;
        this.peso = peso;
        this.direcao = direcao;
        this.v1 = v1;
        this.v2 = v2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getDirecao() {
        return this.direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public Vertice getV1() {
        return this.v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return this.v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }
}

