package Grafo;

import java.util.ArrayList;
import java.util.Arrays;

public class Digrafo {

    private int[][] MATRIZ_ADJACENCIA;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;

    public Digrafo(int[][] MATRIZ_ADJACENCIA, ArrayList<Vertice> vertices, ArrayList<Aresta> arestas) {
        this.MATRIZ_ADJACENCIA = MATRIZ_ADJACENCIA;
        this.vertices = vertices;
        this.arestas = arestas;
    }

    public int getGrauEntrada (Vertice v1 ){
        return 0;
    }

    public int getGrauSaida ( Vertice v1 ){
        return 0;
    }

    public boolean hasCiclo (  ){
        return false;
    }

    public String toStringMATRIZ(){
        StringBuilder matriz = new StringBuilder();
        for (int[] linha: this.MATRIZ_ADJACENCIA) {
            matriz.append(Arrays.toString(linha));
            matriz.append("\n");
        }
        return matriz.toString();
    }

}

