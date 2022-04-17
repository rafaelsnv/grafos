package Grafo;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo{

    private final int[][] MATRIZ_ADJACENCIA;
    private final ArrayList<Vertice> vertices;
    private final ArrayList<Aresta> arestas;
    private final ArrayList<Aresta>[] LISTA_ADJACENCIA;


    public Grafo(int[][] MATRIZ_ADJACENCIA, ArrayList<Vertice> vertices, ArrayList<Aresta> arestas, ArrayList<Aresta>[] LISTA_ADJACENCIA) {
        this.MATRIZ_ADJACENCIA = MATRIZ_ADJACENCIA;
        this.vertices = vertices;
        this.arestas = arestas;
        this.LISTA_ADJACENCIA = LISTA_ADJACENCIA;
    }

    public boolean isAdjacente (Vertice v1, Vertice v2 ){
        for (Aresta vertice1 : v1.getArestas())
            for (Aresta vertice2 : v2.getArestas())
                if (vertice1.getId().equals(vertice2.getId()))
                    return true;
        return false;
    }

    public ArrayList<Vertice> getVertices() {return vertices;}

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
        int aux = vertices.get(0).getGrau();
        for (Vertice v :vertices)
            if(v.getGrau() != aux)
                return false;
        return true;
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
            /*for (int i = 0; vertices.size()>i;i++)
            for (int v = 0; vertices.size()>v;v++)
                if(isAdjacente(vertices.get(i),vertices.get(v))){}
                else
                    return false;
        return true;*/
        if(vertices.size()>=3){
            int n = vertices.size();
            int qtdArestas = (n*(n-1))/2;
            if (qtdArestas!=arestas.size())
                return false;
            }
        else
            return false;
        return true;
    }

    public boolean isConexo (  ){
        if(isCompleto())
            return true;
        for (Vertice v :vertices){
            v.setCor(0);
            v.setPai(null);
        }
        int componentes = 1;
        int timestemp = 0;
        for(Vertice v :vertices){
//            if(v.getCor()==0)
        }

        return false;
    }

    public boolean isEuleriano (  ){
        if(isConexo()){
            int aux=0;
            for (Vertice v:vertices)
                if(v.getGrau()%2==0)
                    aux++;
            if (aux==vertices.size())
                return true;
        }
        return false;
    }

    public boolean isUnicursal (  ){
        if(isConexo()){
            int aux=0;
            for (Vertice v:vertices)
                if(v.getGrau()==2)
                    aux++;
            if (aux==2)
                return true;
        }
        else
            return false;
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
        for (int[] linha: this.MATRIZ_ADJACENCIA) {
            matriz.append(Arrays.toString(linha));
            matriz.append("\n");
        }
        return matriz.toString();
    }

    public ArrayList<Aresta>[] getLISTA_ADJACENCIA() {
        return LISTA_ADJACENCIA;
    }
    public ArrayList<Aresta> getLISTA_ADJACENCIA_POR_POSICAO(int num) {
        return LISTA_ADJACENCIA[num];
    }

}

