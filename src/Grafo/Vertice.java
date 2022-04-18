package Grafo;

import java.util.ArrayList;

public class Vertice {
    private String id;
    private int grau;
    private  ArrayList<Aresta> arestas;
    private int cor;
    private Vertice pai;
    private int termino;

    public Vertice() {

    }

    public int getDescoberta() {
        return descoberta;
    }

    public void setDescoberta(int descoberta) {
        this.descoberta = descoberta;
    }

    private int descoberta;

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

    public void setGrau(int grau) {
        this.grau = grau;
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
        if(this.getArestaById(aresta.getId()) == null){
            this.arestas.add(aresta);
            this.setGrau();
        }
    }
    public int getCor(){
        return this.cor;
    }
    public boolean setCor(int cor){
        if(cor >=0&&cor<=2) {
            this.cor = cor;
            return true;
        }
        else
            return false;
    }

    public Vertice getPai(){
        return this.pai;
    }
    public void setPai(Vertice v){
        this.pai=v;
    }

    public int getTermino() {
        return termino;
    }
    public void setTermino(int termino) {
        this.termino = termino;
    }
    public boolean equals (Vertice outro){
        return this.getId().equals(outro.getId());
    }

}

