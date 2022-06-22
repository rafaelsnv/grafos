package Grafo;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo{

    private final int[][] MATRIZ_ADJACENCIA;
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
        this.listaCores.add(Cor.PRETO);
    }

    private void resetCores (){
        for (Cor cor:this.listaCores) {
            cor.resetQtdUso();
        }
    }

    private boolean checkProf(Aresta discToCheck, Cor cor){
        if (discToCheck != null && cor != null){ // Só pro Java não reclamar de NULL

            Vertice prof = discToCheck.getV1(); // Pega o prof da disciplina

            ArrayList<Aresta> discLecionadas = prof.getArestas(); // Pega as disciplinas do prof

            for (Aresta disciplina:discLecionadas) { // Percorre todas as disciplinas do prof

                if (disciplina.getCor() == cor && disciplina.getPeso() == 2){ // Checa se a disciplina for da mesma cor
                                                                              // passada e se a disciplina é de 2
                                                                              // encontros (pesoAresta)
                    return false;
                }
            }
        }
        return true;
    }

    public void colorirArestas(){
        for (Vertice periodo:this.listaPeriodos){ // Percorre todos os periodos na lista de periodos

            for (Aresta disciplina:periodo.getArestas()) { // Percorre todas as disciplinas do periodo

                for (int i = 0; i < this.listaCores.size(); i++) { // Percorre todas as cores na lista de cores
                    int pesoAresta = disciplina.getPeso();
                    Cor cor = this.listaCores.get(i);
                    if (this.checkProf(disciplina, cor)){ // Checa se a prof já tem disciplina com a cor passada

                        if (disciplina.getCor() == null){ // Checa se a disciplina já tem cor

                            if ( cor.getQtdUsos() == 0 && pesoAresta == 2){ // Checa se a cor nunca foi usada e se a
                                                                            // disciplina é de 2 encontros (pesoAresta)
                                disciplina.setCor(cor);
                                cor.setQtdUsos(pesoAresta);
                            }else if ( cor.getQtdUsos() < 2 && pesoAresta != 2){ // Checa se a cor foi usada no
                                                                                 // máximo 1 vez e se a disciplina
                                                                                 // não é de 2 encontros (pesoAresta)
                                disciplina.setCor(cor);
                                cor.setQtdUsos(pesoAresta);
                            }
                        }
                    }
                }
            }
            this.resetCores(); // Reseta o uso das cores após percorrer as disciplinas do período
        }
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

    public String horarioToString (){
        StringBuilder horarioPeriodo = new StringBuilder();

        for (Vertice periodo:this.listaPeriodos) {
            int numPeriodo = this.listaPeriodos.indexOf(periodo) + 1;
            String strPeriodo = numPeriodo + "º PERÍODO\n";
//            horarioPeriodo.append(strPeriodo);

            String [] arrayDias = {
                    strPeriodo + "\nSegunda\n",
                    "\nTerça\n",
                    "\nQuarta\n",
                    "\nQuinta\n",
                    "\nSexta\n",
                    "\nSábado\n",
            };
            for (Aresta disciplina:periodo.getArestas()) {
                StringBuilder disciplinaColorida = new StringBuilder();
                String disciplinaNome = disciplina.getId();
                disciplinaColorida.append(disciplina);
//                disciplinaColorida.append("\n");

                String cor = disciplina.getCor().name();
                switch (cor){
                    case "VERMELHO":
                        arrayDias[0] += disciplinaColorida.toString();
                        break;
                    case "AMARELO":
                        arrayDias[1] += disciplinaColorida.toString();
                        break;
                    case "VERDE":
                        arrayDias[2] += disciplinaColorida.toString();
                        break;
                    case "AZUL":
                        arrayDias[3] += disciplinaColorida.toString();
                        break;
                    case "ROXO":
                        arrayDias[4] += disciplinaColorida.toString();
                        break;
                    case "PRETO":
                        arrayDias[5] += disciplinaColorida.toString();
                        break;
                }
            }
            horarioPeriodo.append(Arrays.toString(arrayDias));
            horarioPeriodo.append("\n\n");

        }
        return horarioPeriodo.toString();
    }

    public String relatorioProf(){
        StringBuilder horarioProf = new StringBuilder();

        for (int i = 8; i < this.listaVertices.size(); i++) {
            Vertice prof = this.listaVertices.get(i);
            String nomeProf = prof.getId();
            horarioProf.append(nomeProf);
            horarioProf.append("\n");
            ArrayList<Aresta> discLecionadas = prof.getArestas();
            for (Aresta disciplina:discLecionadas) {
                StringBuilder disciplinaStr = new StringBuilder();
                String corDisc = disciplina.getCor().name();
                switch (corDisc){
                    case "VERMELHO":
                        corDisc = "Segunda";
                        break;
                    case "AMARELO":
                        corDisc = "Terça";
                        break;
                    case "VERDE":
                        corDisc = "Quarta";
                        break;
                    case "AZUL":
                        corDisc = "Quinta";
                        break;
                    case "ROXO":
                        corDisc = "Sexta";
                        break;
                    case "PRETO":
                        corDisc = "Sábado";
                        break;
                }
                disciplinaStr.append(disciplina.getId());
                disciplinaStr.append(": ").append(disciplina.getPeso()).append(" Horário(s)");

                horarioProf.append(disciplinaStr);
                horarioProf.append(" - ").append(corDisc);
                horarioProf.append("\n");
            }
            horarioProf.append("\n");
        }
        return horarioProf.toString();
    }

    @Override
    public String toString(){
        StringBuilder matriz = new StringBuilder();
        // Percorrer cada linha da matriz e concatenar o vetor na String de retorno
        for (int[] linha: this.MATRIZ_ADJACENCIA) {
            matriz.append(Arrays.toString(linha));
            matriz.append("\n");
        }
        return matriz.toString();
    }
}