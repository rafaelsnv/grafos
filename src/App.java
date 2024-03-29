import Entrada.*;
import Grafo.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//       Digrafo
        LerDigrafo leitorDigrafo = new LerDigrafo();
        leitorDigrafo.lerEntrada("entradas/aciclico.txt");
//        leitorDigrafo.lerEntrada("entradas/ciclico.txt");
        Digrafo exemploDigrafo = leitorDigrafo.setDigrafo();
        Vertice vEntrada = exemploDigrafo.getVerticeByID("v1");
        Vertice vSaida = exemploDigrafo.getVerticeByID("v2");

        System.out.println(
                "DIGRAFO\n" +
                exemploDigrafo.toStringMATRIZ() +
                        "getGrauEntrada(vEntrada): " + exemploDigrafo.getGrauEntrada(vEntrada) +
                        "\ngetGrauSaida(vSaida): " + exemploDigrafo.getGrauSaida(vSaida)
//                        "\nhasCiclo(): " + exemploDigrafo.hasCiclo()
        );

        // Grafo
        LerGrafo leitorGrafo = new LerGrafo();
//        leitorGrafo.lerEntrada("entradas/completo.txt");
//        leitorGrafo.lerEntrada("entradas/nulo.txt");
//        leitorGrafo.lerEntrada("entradas/pendente.txt");
        leitorGrafo.lerEntrada("entradas/completo.txt");
//        leitorGrafo.lerEntrada("entradas/unicursal.txt");
        Grafo exemploGrafo = leitorGrafo.setGrafo();
        Grafo agm = exemploGrafo.getAGMKruskal();
//        Grafo complementar = exemploGrafo.getComplementar();

        Vertice v1 = exemploGrafo.getVerticeByID("v1");
        Vertice v2 = exemploGrafo.getVerticeByID("v2");
        Vertice v3 = exemploGrafo.getVerticeByID("v3");

        System.out.println(
                "\n\nGRAFO\n" +
                        exemploGrafo.toStringMATRIZ() +
                        "isAdjacente(v1, v2): "   + exemploGrafo.isAdjacente(v1, v2) +
                        "\ngetGrau(v1): "           + exemploGrafo.getGrau(v1) +
                        "\nisIsolado(v1): "         + exemploGrafo.isIsolado(v1) +
                        "\nisPendente(v1): "        + exemploGrafo.isPendente(v1) +
                        "\nisRegular(): "           + exemploGrafo.isRegular() +
                        "\nisNulo(): "              + exemploGrafo.isNulo() +
                        "\nisCompleto(): "          + exemploGrafo.isCompleto() +
//                        "\nisConexo(): "            + exemploGrafo.isConexo() +         // Depende do DFS
                        "\nisEuleriano(): "         + exemploGrafo.isEuleriano() +        // Depende do isConexo
                        "\nisUnicursal(): "         + exemploGrafo.isUnicursal() +        // Depende do isConexo
//                        "\n\nCOMPLEMENTAR\n"        + complementar.toStringMATRIZ() +
//                        "\ngetAGMPrim(): "          + exemploGrafo.getAGMPrim(v3) +
                        "\n\ngetAGMKruskal(): \n"       + agm.toStringMATRIZ()
//                        "\ngetCutVertices(): "      + exemploGrafo.getCutVertices()       // Depende do isConexo
        );
//
//        LerGrafo leitorIncompleto = new LerGrafo();
//        leitorIncompleto.lerEntrada("entradas/grafoIncompleto.txt");
//        Grafo incompleto = leitorIncompleto.setGrafo();
//
//        Vertice v1in = incompleto.getVerticeByID("v1");
//        Vertice v2in = incompleto.getVerticeByID("v2");
//        Vertice v3in = incompleto.getVerticeByID("v3");
//
//        System.out.println(
//                "INCOMPLETO\n" +
//                        incompleto.toStringMATRIZ() +
//                        "\nisAdjacente(v1, v3): "   + incompleto.isAdjacente(v1in, v3in) +
//                        "\ngetGrau(v1): "           + incompleto.getGrau(v1in) +
//                        "\nisIsolado(v1): "         + incompleto.isIsolado(v1in) +
//                        "\nisPendente(v1): "        + incompleto.isPendente(v1in) +
//                        "\nisRegular(): "           + incompleto.isRegular() +
//                        "\nisNulo(): "              + incompleto.isNulo() +
//                        "\nisCompleto(): "          + incompleto.isCompleto() +
////                        "\nisConexo(): "            + incompleto.isConexo() +           // Felipe está implementando
////                        "\nisEuleriano(): "         + incompleto.isEuleriano() +        // Depende do isConexo
////                        "\nisUnicursal(): "         + incompleto.isUnicursal() +        // Depende do isConexo
//                        "\n\nCOMPLEMENTAR\n"        + incompleto.getComplementar().toStringMATRIZ()
////                        "\ngetAGMPrim(): "          + incompleto.getAGMPrim(v3) +
////                        "\ngetAGMKruskal(): "       + incompleto.getAGMKruskal(v3) +
////                        "\ngetCutVertices(): "      + incompleto.getCutVertices()       // Depende do isConexo
//        );
//        LerGrafo leitorNulo = new LerGrafo();
//        leitorNulo.lerEntrada("entradas/grafoNulo.txt");
//        Grafo nulo = leitorNulo.setGrafo();
//
//        Vertice v1null = nulo.getVerticeByID("v1");
//        Vertice v2null = nulo.getVerticeByID("v2");
//        Vertice v3null = nulo.getVerticeByID("v3");
//
//        System.out.println(
//                "NULO\n" +
//                        nulo.toStringMATRIZ() +
//                        "\nisAdjacente(v1, v3): "   + nulo.isAdjacente(v1null, v3null) +
//                        "\ngetGrau(v1): "           + nulo.getGrau(v1null) +
//                        "\nisIsolado(v1): "         + nulo.isIsolado(v2null) +
//                        "\nisPendente(v1): "        + nulo.isPendente(v3null) +
//                        "\nisRegular(): "           + nulo.isRegular() +
//                        "\nisNulo(): "              + nulo.isNulo() +
//                        "\nisCompleto(): "          + nulo.isCompleto() +
////                        "\nisConexo(): "            + nulo.isConexo() +           // Felipe está implementando
////                        "\nisEuleriano(): "         + nulo.isEuleriano() +        // Depende do isConexo
////                        "\nisUnicursal(): "         + nulo.isUnicursal() +        // Depende do isConexo
//                        "\n\nCOMPLEMENTAR\n"        + nulo.getComplementar().toStringMATRIZ()
////                        "\ngetAGMPrim(): "          + nulo.getAGMPrim(v3) +       // Falta implementar
////                        "\ngetAGMKruskal(): "       + nulo.getAGMKruskal(v3) +    // Falta implementar
////                        "\ngetCutVertices(): "      + nulo.getCutVertices()       // Depende do isConexo
//        );
    }
}
