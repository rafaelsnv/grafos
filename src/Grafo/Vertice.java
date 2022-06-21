package Grafo;

import java.util.ArrayList;

public class Vertice {
    private String id;
    private ArrayList<Aresta> arestas;

    public Vertice(String id) {
        this.id = id;
        this.arestas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                this.arestas.add(aresta);
            }
        }
    }

    public void removeAresta(Aresta aresta){
        this.arestas.remove(aresta);
    }

    public boolean equals (Vertice outro){
        return this.getId().equals(outro.getId());
    }

    @Override
    public String toString(){
        StringBuilder vertice = new StringBuilder();
        vertice.append(this.getId());
        return vertice.toString();
    }

}