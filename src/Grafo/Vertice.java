package Grafo;

import java.util.ArrayList;

public class Vertice {
    private int id;
    private int grau;
    private ArrayList<Aresta> arestas;

    public Vertice() {

    }

    public Vertice(int id) {
        this.id = id;
        this.grau = 0;
        this.arestas = new ArrayList<>();
    }

    public Vertice(int id, int grau, ArrayList<Aresta> arestas) {
        this.id = id;
        this.grau = grau;
        this.arestas = arestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrau() {
        return grau;
    }

    public void setgrau(int grau) {
        this.grau = grau;
    }

    public Aresta getArestaById(String id) {
        for (Aresta aresta: this.arestas) {
            if (aresta.getId().equals(id)){
                return aresta;
            }
        }
        return null;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setAresta(Aresta aresta) {
        this.arestas.add(aresta);
    }

}

