/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatofinitodeterministico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import model.Automato;

/*
********************************************************************************
*Trabalho apresentado à disciplina de Linguagens Formais e Autômatos           *
*Professor: José Ruy Castro                                                    *
*Autores: Darlan Roberto, Joana D'arc de Paula                                 *
********************************************************************************
*/
public class AutomatoFinitoDeterministico {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //Scanner ler tudo que  é digitado do teclado
        Scanner scan = new Scanner(System.in);
        //Instanciando a classe Automato
        Automato a = new Automato();
        try{
        int escolha = 3;
        while(escolha!=0){
        System.out.println("\nAFD Reconhecedor da Linguagem a^n b^n  | m+n é par\n ");
        System.out.println("Escolha sua opçãoa\n"
                + "\n1 Ler Automato do TXT"
                + "\n2 Verificar Sentença"
                + "\n0 sair"
        );
        
         escolha = scan.nextInt();
         switch(escolha){
             case 1:
                 //Ler o automato do Txt
                 a.lerAutomato();
                 break;
             case 2:
                 //Verificcar se a sentença foi aceita
                 a.verificaSentenca("aaabbbb");
                 break;
             case 0:
         }
        }
        }catch(FileNotFoundException erro){
                 System.out.print("opcao Invalida");
        }
    }
}
