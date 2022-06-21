import Entrada.*;
import Grafo.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // Grafo
        LerGrafo leitorGrafo = new LerGrafo();
        leitorGrafo.lerEntrada("entradas/matriz_curricular.txt");
        Grafo exemploGrafo = leitorGrafo.setGrafo();
        exemploGrafo.colorirArestas();

        System.out.println(
                "\nGRAFO\n" +
                        exemploGrafo.toStringMATRIZ() +
                "\nHorários:\n" +
                        exemploGrafo.relatorio()
        );


//        Vertice v1 = exemploGrafo.getVerticeByID("v1");
//        Vertice v2 = exemploGrafo.getVerticeByID("v2");
//        Vertice v3 = exemploGrafo.getVerticeByID("v3");
//
//        System.out.println(
//                "\n\nGRAFO\n" +
//                        exemploGrafo.toStringMATRIZ() +
//                        "isAdjacente(v1, v2): "   + exemploGrafo.isAdjacente(v1, v2) +
//                        "\ngetGrau(v1): "           + exemploGrafo.getGrau(v1) +
//                        "\nisIsolado(v1): "         + exemploGrafo.isIsolado(v1) +
//                        "\nisPendente(v1): "        + exemploGrafo.isPendente(v1) +
//                        "\nisRegular(): "           + exemploGrafo.isRegular() +
//                        "\nisNulo(): "              + exemploGrafo.isNulo() +
//                        "\nisCompleto(): "          + exemploGrafo.isCompleto() +
////                        "\nisConexo(): "            + exemploGrafo.isConexo() +         // Depende do DFS
//                        "\nisEuleriano(): "         + exemploGrafo.isEuleriano() +        // Depende do isConexo
//                        "\nisUnicursal(): "         + exemploGrafo.isUnicursal()         // Depende do isConexo
////                        "\n\nCOMPLEMENTAR\n"        + complementar.toStringMATRIZ() +
////                        "\ngetAGMPrim(): "          + exemploGrafo.getAGMPrim(v3) +
////                        "\ngetCutVertices(): "      + exemploGrafo.getCutVertices()       // Depende do isConexo
//        );
    }
}
