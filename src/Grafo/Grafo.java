package Grafo;

import java.util.ArrayList;
import java.util.Arrays;
import Algoritimos.*;

public class Grafo{

    private int[][] MATRIZ_ADJACENCIA;
    private final ArrayList<Vertice> vertices;
    private final ArrayList<Aresta> arestas;
    private final ArrayList<Aresta>[] LISTA_ADJACENCIA;


    public Grafo(int numVertices) {
        this.MATRIZ_ADJACENCIA = new int[numVertices][numVertices];
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
        this.LISTA_ADJACENCIA = new ArrayList[numVertices];
        for (int v = 0; v < numVertices; v++)
            LISTA_ADJACENCIA[v] = new ArrayList<>();
    }

    public Grafo(
            int[][] MATRIZ_ADJACENCIA,
            ArrayList<Vertice> vertices,
            ArrayList<Aresta> arestas,
            ArrayList<Aresta>[] LISTA_ADJACENCIA){
        this.MATRIZ_ADJACENCIA = MATRIZ_ADJACENCIA;
        this.vertices = vertices;
        this.arestas = arestas;
        this.LISTA_ADJACENCIA = LISTA_ADJACENCIA;
    }

    public boolean isAdjacente (Vertice v1, Vertice v2 ){
        if (v1 != null && v2 != null)
        for (Aresta aresta1 : v1.getArestas())
            for (Aresta aresta2 : v2.getArestas())
                if (aresta1.getId().equals(aresta2.getId()))
                    return true;
        return false;
    }

    public Vertice getVertice(int i){
        return this.getVertices().get(i);
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public ArrayList<Vertice> getVertices() {return vertices;}

    public int getGrau ( Vertice v1 ){
        if (!this.isNulo())
            return v1.getGrau();
        return 0;
    }

    public boolean isIsolado ( Vertice v1 ){
        if (!this.isNulo())
            return v1.getGrau() == 0;
        return true;
    }

    public boolean isPendente ( Vertice v1 ){
        if (!this.isNulo())
            return v1.getGrau() == 1;
        return false;
    }

    public boolean isRegular (  ){
        if (!this.isNulo()) {
            int aux = this.vertices.get(0).getGrau();
            for (Vertice v :vertices)
                if(v.getGrau() != aux)
                    return false;
            return true;
        }
        return false;
    }

    public boolean isNulo (  ){
        // Michelle um grafo nulo pode ter loop?
        if (this.vertices.size()>0){
            for (Vertice v :this.vertices) {
                if (v.getGrau() != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasLoop( ){
        if (!this.isNulo()){
            for (Vertice vert:this.getVertices()) {
                return vert.hasLoop();
            }
        }
        return false;
    }

    public boolean isCompleto (  ){
        // Verificar se existe loop antes
//        if (!this.hasLoop()){
            if(vertices.size()>=3){
                int n = vertices.size();
                int qtdArestas = (n*(n-1))/2;
                return qtdArestas == arestas.size();
            }
//        }
        return false;
    }

    public boolean isConexo (  ){
        if(!isCompleto()){
            DFS dfs = new DFS(this);
            int componentes = dfs.DFSConexo();
            if (componentes == 1){
                return true;
            }
            return false;
        }
        return true;
    }

//    public boolean isConexo(){
//        ArrayList<Vertice> vetorVertices = this.getVertices();
//
//        for (int i = 0; i < vetorVertices.size(); i++) {
//            Vertice v1 = vetorVertices.get(i);
//
//            for (int j = 0; j < vetorVertices.size() ; j++) {
//
//                Vertice v2 = vetorVertices.get(j);
//                if (v1.getId()!=v2.getId()){
//                    if (!isAdjacente(v1,v2)){
//                        return false;
//                    }
//                }
//            }
//        }
//
//
//    }

    public boolean isEuleriano (  ){
//        if(isConexo()){
            int aux=0;
            for (Vertice v:this.vertices)
                if(v.getGrau()%2==0)
                    aux++;
            return aux == vertices.size();
//        }
//        return false;
    }

    public boolean isUnicursal (  ){
//        if(isConexo()){
            int aux=0;
            for (Vertice v:this.vertices)
                if(v.getGrau()%2 != 0)
                    aux++;
            return aux == 2;
//        }
//        else
//            return false;
    }

    public Grafo getComplementar () {
        int qtdVertices = this.getVertices().size();

        Grafo complementar = this;
        complementar.getArestas().clear();
        complementar.setMATRIZ_ADJACENCIA(new int[qtdVertices][qtdVertices]);
        complementar.clearLISTA_ADJACENCIA();

        if (!this.isCompleto() && !this.hasLoop()){
            for (Vertice v1:this.getVertices()) {
                int pos1 = 0;
                if (v1.getGrau() != qtdVertices -1){
                    v1.setGrau(0);
                    for (int pos2 = pos1 + 1; pos2 < qtdVertices; pos2++) {
                        Vertice v2 = this.getVertice(pos2);
                        if(!this.isAdjacente(v1, v2)){
                            String v1ID = v1.getId();
                            String v2ID = v2.getId();

                            Aresta arestaComp = new Aresta(
                                    v1ID + v2ID,
                                    1,
                                    0,
                                    v1,
                                    v2
                            );

                            complementar.getArestas().add(arestaComp);

                            complementar.getVerticeByID(v1ID).getArestas().clear();
                            complementar.getVerticeByID(v1ID).getArestas().add(arestaComp);
                            v1.setGrau();

                            complementar.getVerticeByID(v2ID).getArestas().clear();
                            complementar.getVerticeByID(v2ID).getArestas().add(arestaComp);
                            v2.setGrau();

                            complementar.setMATRIZ_ADJACENCIA(pos1,pos2,1);
                            complementar.setLISTA_ADJACENCIA(pos1, arestaComp);
                            complementar.setLISTA_ADJACENCIA(pos2, arestaComp);
                        }
                    }
                }
                pos1++;
            }
            return complementar;
        }
        return null;
    }

    public Grafo getAGMPrim ( Vertice v1 ){
        return null;
    }

    public Grafo getAGMKruskal ( ){
        Kruskal kruskal = new Kruskal(this);
        return kruskal.buildAGM();
    }

    public int getCutVertices (){
        Grafo cutGrafo = this;
        int cutVertices = 0;

        for (Vertice v:cutGrafo.getVertices()) {
            cutGrafo.removeVertice(v);

            if (!cutGrafo.isConexo()){
                cutVertices++;
            }
            cutGrafo = this;
        }
        return cutVertices;
    }

    public void removeVertice (Vertice v1){
        if (v1 != null){
            for (Aresta aresta : v1.getArestas()) {
                this.getArestas().remove(aresta);
            }
            this.getVertices().remove(v1);
        }
    }

    public Vertice getVerticeByID(String id){
        for (Vertice vertice: this.vertices) {
            if (vertice.getId().equals(id)){
                return vertice;
            }
        }
        return null;
    }

    public String toStringMATRIZ(){
        StringBuilder matriz = new StringBuilder();
        // Percorrer cada linha da matriz e concatenar o vetor na String de retorno
        for (int[] linha: this.MATRIZ_ADJACENCIA) {
            matriz.append(Arrays.toString(linha));
            matriz.append("\n");
        }
        return matriz.toString();
    }

    public void setMATRIZ_ADJACENCIA(int[][] MATRIZ_ADJACENCIA) {
        this.MATRIZ_ADJACENCIA = MATRIZ_ADJACENCIA;
    }

    public void setMATRIZ_ADJACENCIA(int v1, int v2, int peso){
        this.MATRIZ_ADJACENCIA[v1][v2] = peso;
        this.MATRIZ_ADJACENCIA[v2][v1] = peso;
    }

    public void clearLISTA_ADJACENCIA() {
        for (ArrayList<Aresta> array:this.LISTA_ADJACENCIA) {
            array.clear();
        }
    }

    public ArrayList<Aresta>[] getLISTA_ADJACENCIA() {
        return LISTA_ADJACENCIA;
    }
    public ArrayList<Aresta> getLISTA_ADJACENCIA_POR_POSICAO(int num) {
        return LISTA_ADJACENCIA[num];
    }

    public void setLISTA_ADJACENCIA(int i, Aresta aresta) {
        this.LISTA_ADJACENCIA[i].add(aresta);
    }

    public Aresta getArestaById(String id){
        for (Aresta aresta: this.arestas) {
            if (aresta.getId().equals(id)){
                return aresta;
            }
        }
        return null;
    }

}

