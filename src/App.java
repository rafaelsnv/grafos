import Entrada.*;
import Grafo.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//        LerDigrafo leitorDigrafo = new LerDigrafo();
//        leitorDigrafo.lerEntrada("entradas/digrafo.txt");
//        Digrafo exemploDigrafo = leitorDigrafo.setDigrafo();
//
//        System.out.println(
//                "DIGRAFO\n" +
//                exemploDigrafo.toStringMATRIZ()
//        );

        LerGrafo leitorGrafo = new LerGrafo();
        leitorGrafo.lerEntrada("entradas/digrafo.txt");
        Grafo exemploGrafo = leitorGrafo.setGrafo();

        Vertice v1 = exemploGrafo.getVerticeByID("v1");
        Vertice v2 = exemploGrafo.getVerticeByID("v2");
        Vertice v3 = exemploGrafo.getVerticeByID("v3");
        System.out.println(
                "GRAFO\n" +
                exemploGrafo.toStringMATRIZ() +
                "\nisAdjacente(v1, v2): " + exemploGrafo.isAdjacente(v1, v2) +
                "\ngetGrau(v1): "       + exemploGrafo.getGrau(v1) +
                "\nisIsolado(v1): "     + exemploGrafo.isIsolado(v1) +
                "\nisPendente(v1): "    + exemploGrafo.isPendente(v1) +
                "\nisRegular(): "       + exemploGrafo.isRegular() +
                "\nisNulo(): "          + exemploGrafo.isNulo() +
                "\nisCompleto(): "      + exemploGrafo.isCompleto() +
                "\nisConexo(): "        + exemploGrafo.isConexo()
        );
    }
}
