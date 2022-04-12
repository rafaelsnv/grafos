package Grafo;

import java.util.ArrayList;

public class Grafo

{

    private int[][] MATRIZ_ADJACENCIA;

    private ArrayList<Vertice> vertices;

    private ArrayList<Aresta> arestas;
    /**
     * Operation isAdjacente
     *
     * @param v1 -
     * @param v2 -
     * @return boolean
     */
    public boolean isAdjacente ( Vertice v1, Vertice v2 ){
        return false;
    }
    /**
     * Operation getGrau
     *
     * @param v1 - 
     * @return int
     */
    public int getGrau ( Vertice v1 ){
        return 0;
    }
    /**
     * Operation isIsolado
     * 0 -> true | 1 -> false
     *
     * @param v1 - 
     * @return boolean
     */
    public boolean isIsolado ( Vertice v1 ){
        return false;
    }
    /**
     * Operation isPendente
     * 1 -> true | 0 -> false
     *
     * @param v1 - 
     * @return boolean
     */
    public boolean isPendente ( Vertice v1 ){
        return false;
    }
    /**
     * Operation isRegular
     * percorre os vertices até encontrar um vértice com grau diferente
     *
     * @return boolean
     */
    public boolean isRegular (  ){
        return false;
    }
    /**
     * Operation isNulo
     * percorre os vértices até encontrar um com grau != 0
     *
     * @return boolean
     */
    public boolean isNulo (  ){
        return false;
    }
    /**
     * Operation isCompleto
     *
     * @return boolean
     */
    public boolean isCompleto (  ){
        return false;
    }
    /**
     * Operation isConexo
     *
     * @return boolean
     */
    public boolean isConexo (  ){
        return false;
    }
    /**
     * Operation isEuleriano
     *
     * @return boolean
     */
    public boolean isEuleriano (  ){
        return false;
    }
    /**
     * Operation isUnicursal
     *
     * @return boolean
     */
    public boolean isUnicursal (  ){
        return false;
    }
    /**
     * Operation getComplementar
     *
     * @return Graf
     */
    public Grafo getComplementar (  ){
        return null;
    }
    /**
     * Operation getAGMPrim
     *
     * @param v1 - 
     * @return Grafo.Grafo
     */
    public Grafo getAGMPrim ( Vertice v1 ){
        return null;
    }
    /**
     * Operation getAGMKruskal
     *
     * @param v1 - 
     * @return Grafo.Grafo
     */
    public Grafo getAGMKruskal ( Vertice v1 ){
        return null;
    }
    /**
     * Operation getCutVertices
     *
     * @return int
     */
    public int getCutVertices (  ){
        return 0;
    }
}

