import Entrada.*;
import Grafo.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        LerGrafo leitorGrafo = new LerGrafo();
        leitorGrafo.lerEntrada("entradas/matriz_curricular.txt"); // Usa carga horária
//        leitorGrafo.lerEntrada("entradas/matriz_curricular_sem_carga.txt"); // Não usa carga horária
        Grafo grafo = leitorGrafo.setGrafo();
        grafo.colorirArestas();

        System.out.println(
                "\nGRAFO\n" + grafo + // Exibe a matriz de adjacência do grafo bipartido
                "\nHorários:\n" +
//                        grafo.relatorioProf() // Exibe as aulas e horários de acordo com o prof
                        grafo.horarioToString() // Exibe a grade de horários

        );
    }
}
