package Grafo;

import java.util.ArrayList;

public class Vertice {
    private String id;
    private int grau;
    private ArrayList<Aresta> arestas;

    public Vertice(String id) {
        this.id = id;
        this.grau = 0;
        this.arestas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau() {
        this.grau++;
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
        this.setGrau();
    }

}

