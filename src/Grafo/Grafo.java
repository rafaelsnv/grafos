package Grafo;

import java.util.ArrayList;

public class Grafo{

    private int[][] MATRIZ_ADJACENCIA;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;

    public Grafo(int[][] MATRIZ_ADJACENCIA, ArrayList<Vertice> vertices, ArrayList<Aresta> arestas) {
        this.MATRIZ_ADJACENCIA = MATRIZ_ADJACENCIA;
        this.vertices = vertices;
        this.arestas = arestas;
    }

    public boolean isAdjacente (Vertice v1, Vertice v2 ){
        return false;
    }

    public int getGrau ( Vertice v1 ){
        return v1.getGrau();
    }

    public boolean isIsolado ( Vertice v1 ){
        return v1.getGrau() == 0;
    }

    public boolean isPendente ( Vertice v1 ){
        return v1.getGrau() == 1;
    }

    public boolean isRegular (  ){

        return false;
    }

    public boolean isNulo (  ){
        for (Vertice v :vertices) {
            if (v.getGrau() != 0){
                return false;
            }
        }
        return true;
    }

    public boolean isCompleto (  ){
        return false;
    }

    public boolean isConexo (  ){
        return false;
    }

    public boolean isEuleriano (  ){
        return false;
    }

    public boolean isUnicursal (  ){
        return false;
    }

    public Grafo getComplementar (  ){
        return null;
    }

    public Grafo getAGMPrim ( Vertice v1 ){
        return null;
    }
    public Grafo getAGMKruskal ( Vertice v1 ){
        return null;
    }

    public int getCutVertices (  ){
        return 0;
    }
}

