package Algoritimos;

import Grafo.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
    private ArrayList<Aresta> arestas;
    private Grafo agm;
    private int[] chefe;
    private int numVertices;
    private int numArestasAdicionadas;

    public Kruskal(Grafo qual) {
        if (qual != null){
            this.arestas = qual.getArestas();
            Collections.sort(this.arestas);
            this.numVertices = qual.getVertices().size();

            this.agm = new Grafo(qual.getVertices().size());
            this.numArestasAdicionadas = 0;

            this.chefe = new int[qual.getVertices().size()];
            for (int i=0; i < qual.getVertices().size(); i++)
                this.chefe[i] = i;
        }
    }

    public Grafo buildAGM( ) {
        while (this.arestas.size() != 0) {
            Aresta atual = this.arestas.remove(0);
            if (atual != null){
                int idU = Integer.parseInt(atual.getV1().getId().substring(1)) - 1;
                int idV = Integer.parseInt(atual.getV2().getId().substring(1)) - 1;

                int chefeU = buscarChefe(idU);
                int chefeV = buscarChefe(idV);

                if (chefeU != chefeV) {
                    this.unir(atual);
                }
            }
        }
        return this.agm;
    }

    private int buscarChefe(int u) {
        if (this.chefe[u] == u)
            return u;
        return buscarChefe(this.chefe[u]);
    }

    private void unir( Aresta qual) {
        if (qual != null){
            String v1ID = qual.getV1().getId();
            String v2ID = qual.getV2().getId();

            int v1Int =  Integer.parseInt(v1ID.substring(1));
            int v2Int = Integer.parseInt(v2ID.substring(1));

            int chefeU = this.buscarChefe(v1Int-1);
            int chefeV = this.buscarChefe(v2Int-1);
            this.chefe[chefeU] = chefeV;

            this.setMATRIZ_ADJACENCIA(
                    v1Int,
                    v2Int,
                    qual.getPeso())
            ;

            this.addVertice(v1ID, v2ID);

            this.addAresta(
                    qual.getId(),
                    qual.getPeso(),
                    qual.getV1(),
                    qual.getV2()
            );
            this.numArestasAdicionadas++;

            this.agm.setLISTA_ADJACENCIA(v1Int, qual);
        }
    }

    private void setMATRIZ_ADJACENCIA(int v1, int v2, int peso){
        v1--;
        v2--;
        this.agm.setMATRIZ_ADJACENCIA(v1,v2, peso);
        this.agm.setMATRIZ_ADJACENCIA(v2, v1, peso);
    }

    private void addVertice(String v1ID, String v2ID) {
        Vertice v1;
        Vertice v2;

        // Verifica se os 2 vértices não existem no vetor de vértices
        if (this.agm.getVerticeByID(v1ID) == null && this.agm.getVerticeByID(v2ID) == null) {
            v1 = new Vertice(v1ID);
            v2 = new Vertice(v2ID);

            this.agm.getVertices().add(v1);
            this.agm.getVertices().add(v2);

            // Verifica se os v1 não existe no vetor de vértices
        } else if (this.agm.getVerticeByID(v1ID) == null && this.agm.getVerticeByID(v2ID) != null) {
            v1 = new Vertice(v1ID);
            this.agm.getVertices().add(v1);

            // Verifica se os v2 não existe no vetor de vértices
        } else if (this.agm.getVerticeByID(v1ID) != null && this.agm.getVerticeByID(v2ID) == null) {
            v2 = new Vertice(v2ID);
            this.agm.getVertices().add(v2);

        }
    }

    private void addAresta(String idAresta, int peso, Vertice v1, Vertice v2){
        Aresta novaAresta;

        // Verifica se a aresta passada não existe no vetor de arestas
        if (this.agm.getArestaById(idAresta) == null) {
            novaAresta = new Aresta(idAresta, peso, 0, v1, v2);
            this.arestas.add(novaAresta);
        } else {
            novaAresta = this.agm.getArestaById(idAresta);
        }
        v1.setAresta(novaAresta);
        v2.setAresta(novaAresta);
    }

}


