/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
********************************************************************************
*Trabalho apresentado à disciplina de Linguagens Formais e Autômatos           *
*Professor: José Ruy Castro                                                    *
*Autores: Darlan Roberto, Joana D'arc de Paula                                 *
********************************************************************************
*/
public class Automato {

    private String estadoInicial;
    //ArrayList de String para guardar estados finais
    private final ArrayList<String> estadosFinais;
    //ArrayList do Objeto Função de Trans~ção para guardas as funcões de transição
    private final ArrayList<FuncaoTransicao> funcoesTransicao;

    public Automato(){
        //Instanciando um arraylist de estados finais
        estadosFinais = new ArrayList<>();
        //Instanciando um arraylist de funções de transição
        funcoesTransicao = new ArrayList<>();
    }

    //Retorna o estado Destino da Transição funcaoT
    public String getDestino(String origem, char caracter) {
        for (FuncaoTransicao funcaoT : funcoesTransicao) {
            if (funcaoT.getEstadoOrigem().equals(origem) && funcaoT.getSimbolo() == caracter) {
                return funcaoT.getEstadoDestino();
            }
        }
        return "Erro";
    }
     public void lerAutomato() throws FileNotFoundException {
        //Criando e passando nome do arquivoa ser lido
        FileReader arquivo = new FileReader("arquivo1.txt");
        //Cria um objeto da Classe Scanner passando o objeto File
        try (Scanner arquivoLido = new Scanner(arquivo)) {
            //Dizendo qual caractere deve ser considerado o divisor de campos
            arquivoLido.useDelimiter(";");
            //Ler a primeira palavra do arquivo, ou seja o estado inicial
            estadoInicial = arquivoLido.next();
            System.out.println("Estado inicial: " + estadoInicial + "\n");
            //Lê a proxima linha
            arquivoLido.nextLine();
            // testando se há uma linha para ser lida
            while (arquivoLido.hasNextLine()) {
                //Criando novas funções para adicionar no ArrayList
                FuncaoTransicao funcaoNova = new FuncaoTransicao();
                //Leê a proxima palavra do Arquivo
                funcaoNova.setEstadoOrigem(arquivoLido.next());
                if (funcaoNova.getEstadoOrigem().equals("F")) {
                    System.out.println("Estados Finais: ");
                    //Testando se há uma palavra há ser lida
                    while (arquivoLido.hasNext()) {
                        String estadoTemp;
                        //Lendo uma palavra por vez
                        estadoTemp = arquivoLido.next();
                        //adicionando os estados finais no ArrayList
                        estadosFinais.add(estadoTemp);
                        //Imprime estados finais
                        System.out.println(estadoTemp);

                    }
                } else {
                    funcaoNova.setSimbolo(arquivoLido.next().charAt(0));
                    funcaoNova.setEstadoDestino(arquivoLido.next());
                    funcoesTransicao.add(funcaoNova);
                    System.out.println("δ(" + funcaoNova.getEstadoOrigem() + "," + funcaoNova.getSimbolo() + ") = " + funcaoNova.getEstadoDestino() + "\n");
                    //Lendo uma linha por vez
                    arquivoLido.nextLine();
                   
                }
            }
            //Fechando o Scanner
            arquivoLido.close();
        }

    }


    public boolean verificaSentenca(String palavra) {
        String estadoAtual = estadoInicial;
        if (palavra.isEmpty()) {
            System.err.println("Este autômato não aceita transições vazias!\n\n");
            System.exit(0);
        }
        //pega o tamanho da palavra a ser analisada 
        for (int i = 0; i < palavra.length(); i++) {
            System.out.println("Está no estado " + estadoAtual + ". ");
            //char caracterAtual recebe o caracter da posição i da palavra
            char caracterAtual = palavra.charAt(i);
            System.out.println("Leu o símbolo " + palavra.charAt(i) + ". ");
            estadoAtual = getDestino(estadoAtual, caracterAtual);
            //Se não achou um estado para o simbolo lido , termina
            if (estadoAtual.equals("Erro")) {
                System.out.println("Sem destino para o símbolo:" + palavra.charAt(i));
                break;
            }else {
                //mostra o estado correspondente
                System.out.println("Foi para o estado " + estadoAtual + ".\n");
            }
        }//Terminou de percorrer a palavra
        //Verifica se estado atual está n alista de estados finais
        if (estadosFinais.contains(estadoAtual)) {
            if (!estadoAtual.equals("Erro")) {
                System.out.println(estadoAtual + " é estado final.\n");
                System.out.println("ACEITA");
            }
            return true;
        } else {
                if (!estadoAtual.equals("Erro")) {
                System.out.println(estadoAtual + " não é  final.\n");
                System.out.println("REJEITA");
           
            
        }
                return false;
    }
        
  }
}