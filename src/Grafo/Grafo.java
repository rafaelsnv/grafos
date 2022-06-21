package Grafo;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo{

    private int[][] MATRIZ_ADJACENCIA;
    private final ArrayList<Vertice> listaVertices;
    private final ArrayList<Vertice> listaPeriodos;
    private final ArrayList<Aresta> listaDisciplinas;
    private final ArrayList<Aresta>[] LISTA_ADJACENCIA;
    private final ArrayList<Cor> listaCores;

    public Grafo(
            int[][] MATRIZ_ADJACENCIA,
            ArrayList<Vertice> listaVertices,
            ArrayList<Aresta> listaDisciplinas,
            ArrayList<Aresta>[] LISTA_ADJACENCIA){
        this.MATRIZ_ADJACENCIA = MATRIZ_ADJACENCIA;
        this.listaVertices = listaVertices;

        this.listaPeriodos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            this.listaPeriodos.add(this.listaVertices.get(i));
        }

        this.listaDisciplinas = listaDisciplinas;
        this.LISTA_ADJACENCIA = LISTA_ADJACENCIA;
        this.listaCores = new ArrayList<>();
        this.listaCores.add(Cor.VERMELHO);
        this.listaCores.add(Cor.AMARELO);
        this.listaCores.add(Cor.VERDE);
        this.listaCores.add(Cor.AZUL);
        this.listaCores.add(Cor.ROXO);
    }

    public Vertice getVertice(int i){
        return this.getListaVertices().get(i);
    }

    public ArrayList<Aresta> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public ArrayList<Vertice> getListaVertices() {return listaVertices;}

    public void removeVertice (Vertice v1){
        if (v1 != null){
            for (Aresta aresta : v1.getArestas()) {
                this.getListaDisciplinas().remove(aresta);
            }
            this.getListaVertices().remove(v1);
        }
    }

    public Vertice getVerticeByID(String id){
        for (Vertice vertice: this.listaVertices) {
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
        for (Aresta aresta: this.listaDisciplinas) {
            if (aresta.getId().equals(id)){
                return aresta;
            }
        }
        return null;
    }

    private void resetCores (){
        for (Cor cor:this.listaCores) {
            if (cor.getQtdUsos() == 2){
                cor.resetQtdUso();
            }
        }
    }

    public void colorirArestas(){

//      Pinta arestas de peso 2
        for (Vertice periodo:this.listaPeriodos) {
            for (int i = 0; i < this.listaCores.size(); i++) {
                for (Aresta disciplina:periodo.getArestas()) {
                    int pesoAresta = disciplina.getPeso();
                    Cor cor = this.listaCores.get(i);
                    if (cor.getQtdUsos() == 0 && pesoAresta == 2 && disciplina.getCor() == null){
                        disciplina.setCor(cor);
                        cor.setQtdUsos(pesoAresta);
                        if (i<4){
                            i++;
                        }
                    }else if ( disciplina.getCor() == null && pesoAresta != 2){
                        disciplina.setCor(cor);
                        cor.setQtdUsos(pesoAresta);
                        if (cor.getQtdUsos() == 2){
                            if (i<4){
                                i++;
                            }
                        }
                    }
                }
            }
            this.resetCores();
        }

//      Pinta arestas de peso 1
//        for (Vertice periodo:this.listaPeriodos) {
//            for (int j = 0; j < this.listaCores.size(); j++) {
//                for (Aresta aresta:periodo.getArestas()) {
//                    int pesoAresta = aresta.getPeso();
//                    if (pesoAresta == 1){
//                        Cor cor = listaCores.get(j);
//                        if (cor.getQtdUsos() < 2){
//                            aresta.setCor(cor);
//                            cor.setQtdUsos(pesoAresta);
//                        }
//                    }
//                }
//            }
//        }
    }

    public String relatorio(){
        StringBuilder horarioPeriodo = new StringBuilder();

        for (Vertice periodo:this.listaPeriodos) {
            int numPeriodo = this.listaPeriodos.indexOf(periodo) + 1;
            String strPeriodo = numPeriodo + " º PERÍODO\n";
            horarioPeriodo.append(strPeriodo);
            StringBuilder disciplinaColorida = new StringBuilder();
            for (Aresta disciplina:periodo.getArestas()) {
                String disciplinaNome = disciplina.getId();
                disciplinaColorida.append(disciplinaNome);
                disciplinaColorida.append(": ");
                String cor = disciplina.getCor().name();
                disciplinaColorida.append(cor);
                disciplinaColorida.append("\n");
            }
            horarioPeriodo.append(disciplinaColorida);
            horarioPeriodo.append("\n");

        }
        return horarioPeriodo.toString();
    }

}

