package Entrada;

import Grafo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class LerGrafo {

    private final ArrayList<Vertice> vertices = new ArrayList<>();
    private final ArrayList<Aresta> arestas = new ArrayList<>();
    private int[][] MATRIZ_ADJACENCIA;

    public void setMATRIZ_ADJACENCIA(int v1, int v2, int peso){
        v1--;
        v2--;
        this.MATRIZ_ADJACENCIA[v1][v2] = peso;
        this.MATRIZ_ADJACENCIA[v2][v1] = peso;
    }

    public Vertice buscarVertice(String id){
        for (Vertice vertice: this.vertices) {
            if (vertice.getId().equals(id)){
                return vertice;
            }
        }
        return null;
    }

    public Aresta buscarAresta(String id){
        for (Aresta aresta: this.arestas) {
            if (aresta.getId().equals(id)){
                return aresta;
            }
        }
        return null;
    }

    public void addVertice(String v1ID, String v2ID) {
        Vertice v1;
        Vertice v2;
        if (this.buscarVertice(v1ID) == null && this.buscarVertice(v2ID) == null) {
            v1 = new Vertice(v1ID);
            v2 = new Vertice(v2ID);

            this.vertices.add(v1);
            this.vertices.add(v2);

        } else if (this.buscarVertice(v1ID) == null && this.buscarVertice(v2ID) != null) {
            v1 = new Vertice(v1ID);
            this.vertices.add(v1);

        } else if (this.buscarVertice(v1ID) != null && this.buscarVertice(v2ID) == null) {
            v2 = new Vertice(v2ID);
            this.vertices.add(v2);

        }
    }

    public void addAresta(String idAresta, int peso, Vertice v1, Vertice v2){
        Aresta novaAresta;

        if (this.buscarAresta(idAresta) == null) {
            novaAresta = new Aresta(idAresta, peso, 0, v1, v2);
            this.arestas.add(novaAresta);
        } else {
            novaAresta = this.buscarAresta(idAresta);
        }
        v1.setAresta(novaAresta);
        v2.setAresta(novaAresta);
    }

    public void lerEntrada (String caminho) throws IOException {
        FileReader fr = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fr);
        int qtdVertices = Integer.parseInt(br.readLine());
        this.MATRIZ_ADJACENCIA = new int[qtdVertices][qtdVertices];

        String linha;

        while ((linha = br.readLine()) != null) {
            String[] auxLinha = linha.split("; ");


            String v1ID = "v" + auxLinha[0];
            String v2ID = "v" + auxLinha[1];

            this.setMATRIZ_ADJACENCIA(
                    Integer.parseInt(auxLinha[0]),
                    Integer.parseInt(auxLinha[1]),
                    Integer.parseInt(auxLinha[2])
            );

            this.addVertice(v1ID, v2ID);

            String idAresta = 'v' + auxLinha[0] + 'v' + auxLinha[1];
            Vertice v1 = this.buscarVertice(v1ID);
            Vertice v2 = this.buscarVertice(v2ID);

            this.addAresta(
                    idAresta,
                    Integer.parseInt(auxLinha[2]),
                    v1,
                    v2
            );

        }
    }
}