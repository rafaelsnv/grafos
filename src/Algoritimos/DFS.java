package Algoritimos;

import Grafo.*;

import java.util.ArrayList;

public class DFS {
    public static final byte branco = 0;
    public static final byte cinza = 1;
    public static final byte preto = 2;
    private final Grafo grafo;

    public DFS(Grafo grafo){
        this.grafo = grafo;
        int n = this.grafo.getVertices().size();
    }

    private int init(){
        for (Vertice vertice: this.grafo.getVertices()) {
            vertice.setCor(branco);
            vertice.setPai(null);
        }
        return 0;
    }

    public void DFSPadrao() {
        int timestamp = this.init();
        for (int posU = 0; posU < this.grafo.getVertices().size(); posU++) {
            Vertice u = this.grafo.getVertice(posU);
            if (u.getCor()==branco){
                timestamp = visitaPadrao(u, timestamp, posU);
            }
        }
    }

 public int DFSConexo() {
        int componentes = 1;
        int timestamp = this.init();
        for (int posU = 0; posU < this.grafo.getVertices().size(); posU++) {
            Vertice u = this.grafo.getVertice(posU);
            if (u.getCor()==branco){
                timestamp = visitaConexo(u, timestamp, posU, componentes);
                componentes++;
            }
        }
        return componentes;
    }

    private int visitaPadrao(Vertice u, int timestamp, int pos) {
        ++timestamp;
        u.setDescoberta(timestamp);
        u.setCor(cinza);

        ArrayList<Aresta> listaAD = this.grafo.getLISTA_ADJACENCIA_POR_POSICAO(pos);
        if (listaAD.size()!=0){
            Aresta a = listaAD.get(pos);
            while (a!=null){
                Vertice v = a.getV2();
                if (v.getCor()==branco){
                    v.setPai(u);
                    timestamp = this.visitaPadrao(v, timestamp, pos+1);
                }
                a = listaAD.get(pos+1);
            }
        }
        u.setCor(preto);
        timestamp++;
        u.setTermino(timestamp);
        return timestamp;
    }

    private int visitaConexo(Vertice u, int timestamp, int pos, int componentes) {
        ++timestamp;
        u.setDescoberta(timestamp);
        u.setCor(cinza);
        u.setComponente(componentes);

        ArrayList<Aresta> listaAD = this.grafo.getLISTA_ADJACENCIA_POR_POSICAO(pos);
        if (listaAD.size()!=0){
            Aresta a = listaAD.get(pos);
            while (a!=null){
                Vertice v = a.getV2();
                if (v.getCor()==branco){
                    v.setPai(u);
                    timestamp = this.visitaPadrao(v, timestamp, pos+1);
                }
                a = listaAD.get(pos+1);
            }
        }
        u.setCor(preto);
        timestamp++;
        u.setTermino(timestamp);
        return timestamp;
    }
}
