package Algoritimos;

import Grafo.Grafo;

public class BuscaEmProfundidade {
    public static const byte branco = 0;
    public static const byte cinza = 1;
    public static const byte preto = 2;
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
        int[] cor = new int[this.grafo.getVertices().size()];
        for (int u = 0; u < grafo.getVertices().size(); u++) {
            cor[u] = branco;
            this.antecessor[u] = -1;
        }
        for (int u = 0; u < grafo.getVertices().size(); u++)
            if (cor[u] == branco)
                tempo = this.visitaDfs(u, tempo, cor);
    }
    private int visitaDfs (int u, int tempo, int []cor) {
        cor[u] = cinza; this.d[u] = ++tempo;
        if (this.grafo.matrizToLista(u).size!=0)
        {
            Grafo.Aresta a = this.grafo.matrizToLista(u).;
            for()
            while (a != null)
            {
                int v = a. get_v2 ();
                if (cor[v] == branco)
                {
                    this.antecessor[v] = u;
                    tempo = this.visitaDfs (v, tempo, cor);
                }
                a = this.grafo.proxAdj (u);
            }
        }
        cor[u] = preto; this.t[u] = ++tempo;
        return tempo;
    }
}
