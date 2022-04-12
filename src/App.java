import Entrada.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        LerGrafo leitor = new LerGrafo();
        leitor.lerEntrada("entradas/grafo.txt");
        System.out.println("fim");
    }
}
