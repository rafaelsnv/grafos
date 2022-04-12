package Grafo;

import java.util.ArrayList;

public class Vertice {
    public Vertice() {

    }

    public Vertice(int id, int grau, ArrayList<Aresta> arestas) {
        this.id = id;
        this.grau = grau;
        this.arestas = arestas;
    }
/** Attributes */
    /**
     * 
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     */
    private int grau;
    public int getGrau() {
        return grau;
    }

    public void setgrau(int grau) {
        this.grau = grau;
    }




    /**
     * 
     */
    private ArrayList<Aresta> arestas;

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }
/**
     * Operation getGrau
     *
     * @return int
     */
}

