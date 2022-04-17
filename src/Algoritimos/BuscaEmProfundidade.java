package Algoritimos;

import Grafo.*;

import java.util.ArrayList;

public class BuscaEmProfundidade {
    public static final byte branco = 0;
    public static final byte cinza = 1;
    public static final byte preto = 2;
    private int []d;
    private int []t;
    private int []antecessor;
    private Grafo grafo;
    public BuscaEmProfundidade (Grafo grafo)
    {
        this.grafo = grafo; int n = this.grafo.getVertices().size();
        d = new int[n]; t = new int[n]; antecessor = new int[n];
    }
    public int getD (int v) { return this.d[v]; }
    public int getT (int v) { return this.t[v]; }
    public int antecessor (int v) { return this.antecessor[v]; }
    public void buscaEmProfundidade () {
        int tempo = 0;
        for (Vertice vertice: this.grafo.getVertices()
             ) {
            vertice.setCor(0);
        }

        for (int u = 0; u < grafo.getVertices().size(); u++) {
            grafo.getVertices().get(u).setCor(0);
            tempo = visitaDfs(grafo.getVertices().get(u), tempo, u);
        }
    }
    private int visitaDfs (Vertice v, int tempo, int pos) {
        tempo++;
        v.setCor(1); v.setDescoberta(tempo);
        //cor[u] = cinza; this.d[u] = ++tempo;
        ArrayList<Aresta> listaAD = this.grafo.getLISTA_ADJACENCIA_POR_POSICAO(pos);
        if (listaAD.size()!=0)
        {
            //Aresta a = this.grafo.matrizToLista(u).;
            for(Aresta aresta :listaAD){
                Vertice v2 = aresta.getV2();
                if(v2.getCor() == 0){
                    v2.setPai(v);
                    tempo = this.visitaDfs(v2, tempo, pos);
                }
            }
        }
        v.setCor(2); tempo++;
        return tempo;
    }
}
