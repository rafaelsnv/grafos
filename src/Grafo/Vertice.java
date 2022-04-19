package Grafo;

import java.util.ArrayList;

public class Vertice {
    private String id;
    private int grau;
    private  ArrayList<Aresta> arestas;
    private int cor;
    private Vertice pai;
    private int termino;
    private int descoberta;
    private int componente;

    public Vertice(String id) {
        this.id = id;
        this.grau = 0;
        this.arestas = new ArrayList<>();
    }
    public int getDescoberta() {
        return descoberta;
    }

    public void setDescoberta(int descoberta) {
        this.descoberta = descoberta;
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

    public boolean hasLoop (){
        if (this != null){
            for (Aresta aresta : this.getArestas()) {
                String v1ID = aresta.getV1().getId();
                String v2ID = aresta.getV2().getId();
                return v1ID.equals(v2ID);
            }
        }
        return false;
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
        if (aresta != null){ // Verifica se a aresta passada existe
            String idAresta = aresta.getId();
            Aresta arestaVertice = this.getArestaById(idAresta);
            if( arestaVertice == null){ // Verifica se a aresta passada não existe no vértice
                String v1ID = aresta.getV1().getId();
                String v2ID = aresta.getV2().getId();
                if (!v1ID.equals(v2ID)){ // Condição padrão
                    this.setGrau();
                }else {                  // Condição para loop
                    this.setGrau();
                    this.setGrau();
                }
                this.arestas.add(aresta);
            }
        }
    }

    public void removeAresta(Aresta aresta){
        this.arestas.remove(aresta);
        this.grau--;
    }

    public int getCor(){
        return this.cor;
    }

    public boolean setCor(int cor){
        if(cor >=0 &&cor <=2) {
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

    public int getComponente() {
        return componente;
    }

    public void setComponente(int componente) {
        this.componente = componente;
    }
}