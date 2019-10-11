/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
********************************************************************************
*Trabalho apresentado à disciplina de Linguagens Formais e Autômatos           *
*Professor: José Ruy Castro                                                    *
*Autores: Darlan Roberto, Joana D'arc de Paula                                 *
********************************************************************************
*/
public class Arquivo {

    private String caminhoDoArquivo = "arquivos.txt";

    public void lerArquivo() throws FileNotFoundException {

        FileReader f = new FileReader(getCaminhoDoArquivo());
        try (Scanner arquivoLido = new Scanner(f)) {
            arquivoLido.useDelimiter(";");
            String aux = arquivoLido.next();
            while (arquivoLido.hasNext()) {
                String lido = arquivoLido.next();
                System.out.println(lido);
            }
        }
    }

    public void escreverEmArquivo() throws IOException {
        FileWriter arq = new FileWriter(getCaminhoDoArquivo());
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.print("q0;\nq0;a;q1;\nq1;b;q2;\nq2;a;q0;\nF;q0;q1;\n");
        arq.close();
    }

    /**
     * @return the caminhoDoArquivo
     */
    public String getCaminhoDoArquivo() {
        return caminhoDoArquivo;
    }

    /**
     * @param caminhoDoArquivo the caminhoDoArquivo to set
     */
    public void setCaminhoDoArquivo(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

}
