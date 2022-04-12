package Entrada;

import Grafo.*;
import java.io.*;
import java.util.ArrayList;

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

            int idV1 = Integer.parseInt(auxLinha[0]);
            int idV2 = Integer.parseInt(auxLinha[1]);
            Vertice v1 = new Vertice(idV1);
            Vertice v2 = new Vertice(idV2);

            String idAresta = 'v' + auxLinha[0] + 'v' + auxLinha[1];
            Aresta novaAresta = new Aresta(idAresta, Integer.parseInt(auxLinha[2]), 0, v1, v2);
            this.arestas.add(novaAresta);

            if (v1.getArestaById(idAresta) == null){
                v1.setAresta(novaAresta);
            }

            if (v2.getArestaById(idAresta) == null){
                v2.setAresta(novaAresta);
            }

            if ( this.buscarVertice(idV1) == null) {
                vertices.add(v1);
            }
            if ( this.buscarVertice(idV2) == null) {
                vertices.add(v2);
            }
        }

    }

    public Vertice buscarVertice(int id){
        for (Vertice vertice: this.vertices) {
            if (vertice.getId() == id){
                return vertice;
            }
        }
        return null;
    }

}