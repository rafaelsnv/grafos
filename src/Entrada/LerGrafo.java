package Entrada;

import Grafo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class LerGrafo {

    private int qtdVertices;
    private ArrayList<Vertice> vertices = new ArrayList<>();
    private ArrayList<Aresta> arestas = new ArrayList<>();

    public void lerEntrada(String caminho) throws IOException {
        FileReader fr = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fr);
        this.qtdVertices = Integer.parseInt(br.readLine());

        String linha;

        while ((linha = br.readLine()) != null){
            String[] auxLinha = linha.split("; ");

            Vertice v1;
            Vertice v2;
            Aresta novaAresta;

            String v1ID = "v" + auxLinha[0];
            String v2ID = "v" + auxLinha[1];

            if ( this.buscarVertice(v1ID) == null && this.buscarVertice(v2ID) == null) {
                v1 = new Vertice(v1ID);
                v2 = new Vertice(v2ID);

                this.vertices.add(v1);
                this.vertices.add(v2);

            }else if(this.buscarVertice(v1ID) == null ){
                v1 = new Vertice(v1ID);
                this.vertices.add(v1);

                v2 = this.buscarVertice(v2ID);

            }else if(this.buscarVertice(v2ID) == null ) {
                v2 = new Vertice(v2ID);
                this.vertices.add(v2);

                v1 = this.buscarVertice(v1ID);

            }else {
                v1 = this.buscarVertice(v1ID);
                v2 = this.buscarVertice(v2ID);
            }

            String idAresta = 'v' + auxLinha[0] + 'v' + auxLinha[1];
            if (this.buscarAresta(idAresta) == null){
                novaAresta = new Aresta(idAresta, Integer.parseInt(auxLinha[2]), 0, v1, v2);
                this.arestas.add(novaAresta);
            }else {
                novaAresta = this.buscarAresta(idAresta);
            }

            if ( !novaAresta.getV1().getId().equals(v1.getId()) ){
                v1.setAresta(novaAresta);
            }else if ( !novaAresta.getV2().getId().equals(v2.getId()) ){
                v2.setAresta(novaAresta);
            }

        }
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

}