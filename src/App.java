import Entrada.*;
import Grafo.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // Grafo
        LerGrafo leitorGrafo = new LerGrafo();
        leitorGrafo.lerEntrada("entradas/matriz_curricular.txt");
//        leitorGrafo.lerEntrada("entradas/matriz_curricular_sem_carga.txt");
        Grafo exemploGrafo = leitorGrafo.setGrafo();
        exemploGrafo.colorirArestas();

        System.out.println(
                "\nGRAFO\n" +
                        exemploGrafo +
                "\nHorários:\n" +
//                        exemploGrafo.relatorio()
                        exemploGrafo.relatorioProf()
//                          exemploGrafo.horarioToString()

        );
    }
}
