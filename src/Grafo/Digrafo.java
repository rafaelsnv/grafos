package Grafo;

import java.util.ArrayList;
import java.util.Arrays;

public class Digrafo {

    private int[][] MATRIZ_ADJACENCIA;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    private ArrayList<Aresta> [] LISTA_ADJACENCIA;

    public Digrafo(int[][] MATRIZ_ADJACENCIA, ArrayList<Vertice> vertices, ArrayList<Aresta> arestas, ArrayList<Aresta> [] LISTA_ADJACENCIA) {
        this.MATRIZ_ADJACENCIA = MATRIZ_ADJACENCIA;
        this.vertices = vertices;
        this.arestas = arestas;
        this.LISTA_ADJACENCIA = LISTA_ADJACENCIA;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public int getGrauEntrada (Vertice v1 ){
        int grauEntrada = 0;
        if (v1 != null){
            for (Aresta aresta: v1.getArestas()) {
                if (aresta.getDirecao() < 0){
                    grauEntrada++;
                }
            }
            return grauEntrada;
        }
        return grauEntrada;
    }

    public int getGrauSaida ( Vertice v1 ){
        int grauSaida = 0;
        if (v1 != null){
            for (Aresta aresta: v1.getArestas()) {
                if (aresta.getDirecao() > 0){
                    grauSaida++;
                }
            }
            return grauSaida;
        }
        return 0;
    }

    public boolean hasCiclo (  ){
        if (this.getVertices().size() > 0 ){
            ArrayList<Vertice> listaOrdenada = new ArrayList<Vertice>(); // Lista vazia que irá conter os elementos ordenados
            ArrayList<Vertice> verticesSemEntrada = new ArrayList<Vertice>(); // Vértices sem arestas de entrada

            for (Vertice v: this.getVertices()) {
                if (this.getGrauEntrada(v) == 0){ // Verifica se não existe aresta de entrada
                    verticesSemEntrada.add(v);
                }
            }

            int i = 0;
            while (verticesSemEntrada.size() > 0){
                Vertice v1 = verticesSemEntrada.get(i);

                verticesSemEntrada.remove(i);
                listaOrdenada.add(v1);

                for (Aresta aresta: v1.getArestas()) {
                    v1.removeAresta(aresta);
                    Vertice v2 = aresta.getV2();
                    if (this.getGrauEntrada(v2) == 0){ // Verifica se não existe aresta de entrada
                        verticesSemEntrada.add(v2);
                    }
                }
                i++;
            }
            return this.getVertices().size() > 0; // Se o grafo ainda possui arestas, existe pelo menos 1 ciclo
        }
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

    public Vertice getVerticeByID(String id){
        for (Vertice vertice: this.vertices) {
            if (vertice.getId().equals(id)){
                return vertice;
            }
        }
        return null;
    }

}

