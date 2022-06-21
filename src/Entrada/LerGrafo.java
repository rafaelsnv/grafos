package Entrada;

import Grafo.*;
import java.io.*;
import java.util.ArrayList;

public class LerGrafo {

    private final ArrayList<Vertice> professores = new ArrayList<>();
    private final ArrayList<Vertice> periodos = new ArrayList<>();
    private final ArrayList<Aresta> arestas = new ArrayList<>();
    private int[][] MATRIZ_ADJACENCIA;
    private ArrayList<Aresta> [] LISTA_ADJACENCIA;

    public void setMATRIZ_ADJACENCIA(int v1, int v2, int peso){
        this.MATRIZ_ADJACENCIA[v1][v2] = peso;
        this.MATRIZ_ADJACENCIA[v2][v1] = peso;
    }

    public void setLISTA_ADJACENCIA(int i, Aresta aresta){
        this.LISTA_ADJACENCIA[i].add(aresta);
    }

    public Vertice getProf(String id){
        for (Vertice vertice: this.professores) {
            if (vertice.getId().equals(id)){
                return vertice;
            }
        }
        return null;
    }

    public void addProf(String prof) {
        Vertice v1;

        if (this.getProf(prof) == null) {
            v1 = new Vertice(prof);

            this.professores.add(v1);
        }
    }

    public Vertice getPeriodo(String id){
        for (Vertice vertice: this.periodos) {
            if (vertice.getId().equals(id)){
                return vertice;
            }
        }
        return null;
    }

    public void addPeriodo(String periodo) {
            Vertice v1;

            if (this.getPeriodo(periodo) == null) {
                v1 = new Vertice(periodo);

                this.periodos.add(v1);
            }
        }

    public void addAresta(String idAresta, int peso, Vertice v1, Vertice v2){
        Aresta novaAresta;

        // Verifica se a aresta passada não existe no vetor de arestas
        if (this.getArestaById(idAresta) == null) {
            novaAresta = new Aresta(idAresta, peso, v1, v2);
            this.arestas.add(novaAresta);
        } else {
            novaAresta = this.getArestaById(idAresta);
        }
        v1.setAresta(novaAresta);
        v2.setAresta(novaAresta);
    }

    public Aresta getArestaById(String id){
        for (Aresta aresta: this.arestas) {
            if (aresta.getId().equals(id)){
                return aresta;
            }
        }
        return null;
    }

    public void lerEntrada (String caminho) throws IOException {
        FileReader fr = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fr);
        String linha;

//       Popula os vetores de vértices e arestas
        while ((linha = br.readLine()) != null) {
            String[] auxLinha = linha.split(";");

            String disciplina = auxLinha[0];
            String professor = auxLinha[1];
            String periodo = auxLinha[2];
            String cargaHoraria = auxLinha[3];
            int numEncontros = Integer.parseInt(cargaHoraria) / 40;

            this.addProf(professor);
            this.addPeriodo(periodo);

            Vertice vProf = this.getProf(professor);
            Vertice vPeriodo = this.getPeriodo(periodo);

            if (numEncontros != 3){
                this.addAresta(
                        disciplina,
                        numEncontros,
                        vProf,
                        vPeriodo
                );
            }else {
                this.addAresta(
                        disciplina.concat(" 2"),
                        2,
                        vProf,
                        vPeriodo
                );

                this.addAresta(
                        disciplina.concat(" 1"),
                        1,
                        vProf,
                        vPeriodo
                );
            }


        }

//      Popula a lista e matriz de adjacência
        int qtdVertices = this.professores.size() + this.periodos.size();
        this.MATRIZ_ADJACENCIA = new int[qtdVertices][qtdVertices];
        this.LISTA_ADJACENCIA = new ArrayList[qtdVertices];
        for (int i=0; i < qtdVertices; i++){
            this.LISTA_ADJACENCIA[i] = new ArrayList<Aresta>();
        }

        for (Aresta disciplina : this.arestas) {
             Vertice vProf = disciplina.getV1();
             Vertice vPeriodo = disciplina.getV2();

             int indexProf =    this.professores.indexOf(vProf) + 8;
             int indexPeriodo = this.periodos.indexOf(vPeriodo);
             int peso = disciplina.getPeso();

             this.setMATRIZ_ADJACENCIA(indexProf, indexPeriodo, peso);

             int i = indexPeriodo;

             if (i > 8){
                 i = indexProf;
             }
             this.setLISTA_ADJACENCIA(i, disciplina);
        }

    }

    public Grafo setGrafo(){
        ArrayList<Vertice> vertices = new ArrayList<>(this.periodos.size()+this.professores.size());
        vertices.addAll(this.periodos);
        vertices.addAll(this.professores);

        return new Grafo(this.MATRIZ_ADJACENCIA, vertices, this.arestas, this.LISTA_ADJACENCIA);
    }

}