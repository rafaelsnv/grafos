package Entrada;

import Grafo.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerDigrafo {

    private final ArrayList<Vertice> vertices = new ArrayList<>();
    private final ArrayList<Aresta> arestas = new ArrayList<>();
    private int[][] MATRIZ_ADJACENCIA;
    private ArrayList<Aresta> [] LISTA_ADJACENCIA;

    public void setMATRIZ_ADJACENCIA(int v1, int v2, int peso, int direcao){
        v1--;
        v2--;
        if (direcao>0)
            this.MATRIZ_ADJACENCIA[v1][v2] = peso * direcao;
        else
            this.MATRIZ_ADJACENCIA[v2][v1] = peso * direcao;
    }

    public void setLISTA_ADJACENCIA(int i, Aresta aresta) {
        this.LISTA_ADJACENCIA[i].add(aresta);
    }

    public Vertice getVerticeByID(String id){
        for (Vertice vertice: this.vertices) {
            if (vertice.getId().equals(id)){
                return vertice;
            }
        }
        return null;
    }

    public Aresta getArestaById(String id){
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
        if (this.getVerticeByID(v1ID) == null && this.getVerticeByID(v2ID) == null) {
            v1 = new Vertice(v1ID);
            v2 = new Vertice(v2ID);

            this.vertices.add(v1);
            this.vertices.add(v2);

        } else if (this.getVerticeByID(v1ID) == null && this.getVerticeByID(v2ID) != null) {
            v1 = new Vertice(v1ID);
            this.vertices.add(v1);

        } else if (this.getVerticeByID(v1ID) != null && this.getVerticeByID(v2ID) == null) {
            v2 = new Vertice(v2ID);
            this.vertices.add(v2);

        }
    }

    public void addAresta(String idAresta, int peso, int direcao, Vertice v1, Vertice v2){
        Aresta novaAresta;

        if (this.getArestaById(idAresta) == null) {
            novaAresta = new Aresta(idAresta, peso, direcao, v1, v2);
            this.arestas.add(novaAresta);
        } else {
            novaAresta = this.getArestaById(idAresta);
        }
        v1.setAresta(novaAresta);
        v2.setAresta(novaAresta);
    }

    public void lerEntrada (String caminho) throws IOException {
        FileReader fr = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fr);
        int qtdVertices = Integer.parseInt(br.readLine());
        this.MATRIZ_ADJACENCIA = new int[qtdVertices][qtdVertices];
        for (int i=0; i < qtdVertices; i++){
            this.LISTA_ADJACENCIA[i] = new ArrayList<Aresta>();
        }

        String linha;

        while ((linha = br.readLine()) != null) {
            String[] auxLinha = linha.split("; ");


            String v1ID = "v" + auxLinha[0];
            String v2ID = "v" + auxLinha[1];
            int direcao = Integer.parseInt(auxLinha[3]);
            int peso = Integer.parseInt(auxLinha[2]);

            this.setMATRIZ_ADJACENCIA(
                    Integer.parseInt(auxLinha[0]),
                    Integer.parseInt(auxLinha[1]),
                    peso,
                    direcao
            );

            this.addVertice(v1ID, v2ID);

            Vertice v1 = this.getVerticeByID(v1ID);
            Vertice v2 = this.getVerticeByID(v2ID);

            if (direcao >0){
                String idAresta = 'v' + auxLinha[0] + 'v' + auxLinha[1];
                this.addAresta(
                        idAresta,
                        peso,
                        direcao,
                        v1,
                        v2
                );

                this.setLISTA_ADJACENCIA(
                        Integer.parseInt(auxLinha[0]) - 1,
                        this.getArestaById(idAresta)
                );

            }else {
                String idAresta = 'v' + auxLinha[1] + 'v' + auxLinha[0];
                this.addAresta(
                        idAresta,
                        peso,
                        direcao,
                        v2,
                        v1
                );

                this.setLISTA_ADJACENCIA(
                        Integer.parseInt(auxLinha[1]) - 1,
                        this.getArestaById(idAresta)
                );
            }


        }
    }

    public Digrafo setDigrafo(){
        return new Digrafo(this.MATRIZ_ADJACENCIA, this.vertices, this.arestas, this.LISTA_ADJACENCIA);
    }

}
