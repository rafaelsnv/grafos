package Grafo;

public class Aresta implements Comparable<Aresta> {
    private String id;
    private int peso;
    private Vertice v1, v2;
    private Cor cor;

    public Aresta(String id, int peso, Vertice v1, Vertice v2) {
        this.id = id;
        this.peso = peso;
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

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public boolean equals(String id) {
        return this.getId().equals(id);
    }

    @Override
    public int compareTo(Aresta outra) {
        return this.peso - outra.peso;
    }
}

