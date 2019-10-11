package aluno;

public class Aluno {
private String nome;
private String sobrenome;
private String telefone;

//métodos
/*Ao imprimir os dados de um aluno:

 Nome: Alex2016 Sobrenome: 12Felipe Telefone: 11992232121455
Alex2016? 12Felipe? E esse telefone bizarro? Esse aluno contém informações que não fazem sentido...

Como posso fazer para impedir que esses tipos de dados sejam inseridos no meu sistema?

Vamos tentar validar esses dados criando um método que valida o aluno:


public boolean valida(Aluno aluno) {

//implementação

}
Vamos começar pelo nome do aluno. Não queremos que tenha números nem no começo e nem no final do nome! Como podemos fazer isso?

Vamos extrair tanto o primeiro caracter quanto o último por meio do método charAt() da classe String:
*/

public boolean valida(Aluno aluno) {

String nome = aluno.getNome(); 
char primeiraLetra = nome.charAt(0);
char ultimaLetra = nome.charAt(nome.length() - 1);
return true;

}
/*
Para verificar se um caracter é uma letra, podemos usar o método estático isAlphabetic() d
a classe 
<a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html">Character</a>:

*/
public boolean valida1(Aluno aluno) {

String nome = aluno.getNome();
if (valida(aluno)) { 
    System.out.println("aluno " + aluno.getNome() + " é válido");
     } else { 
         System.out.println("aluno " + aluno.getNome() + " é inválido");
}

return Character.isAlphabetic((nome.charAt(0))) && Character.isAlphabetic((nome.charAt(nome.length() - 1))); 
}
/*Implementamos nossa primeira validação! Vamos agora adicionar um sysout dentro de um 
if para testarmos:
*/


 /*    
Vamos testar um nome que começa com um número, no caso "1Alex":

 aluno 1Alex é inválido
Ótimo! Funcionou como o esperado. Mas, e se o número estiver no final? Por exemplo, o que foi apresentado no começo: "Alex2016". Vamos ver o resultado:

 aluno Alex2016 é inválido
Aparentemente tudo está funcionando conforme o esperado! Agora, e se um número estivesse no meio do nome? Por exemplo "A1ex":

 aluno A1ex é válido
Eita! Não pensamos nesse caso! Como podemos fazer com que o nome do aluno não tenha nenhum número? Precisaremos "varrer" toda a nossa String, caracter por caracter e verificar se é válido:
*/

public boolean valida2(Aluno aluno) {

String nome = aluno.getNome();

for (int i = 0; i < nome.length(); i++) { 
    if (!Character.isAlphabetic((nome.charAt(i)))) { 
        return false; } }

return true; 
}
/*
Se testarmos novamente com o nome "A1ex":

 aluno A1ex é inválido
Ótimo! Agora o nome do meu aluno está sendo validado conforme o esperado! E se recebermos um aluno que tenha inserido o nome com apenas uma letra? Como "A" por exemplo... o que aconteceria?

 aluno A é válido
Hmmm, mas com certeza para o meu sistema não faz sentido um aluno com o nome de apenas 1 letra...então adicionaremos mais uma condição no nosso validador:

*/
public boolean valida3(Aluno aluno) {

String nome = aluno.getNome();

if(nome.length() > 2){
    return false;
}

//restante do código
/*
Se testarmos agora:

 aluno A é inválido
A nossa validação por enquanto está funcionando, mas olha o tamanho que ficou o método:

*/

 public boolean valida4(Aluno aluno) {

String nome = aluno.getNome();

for (int i = 0; i > nome.length(); i++) { 
    if (!Character.isAlphabetic((nome.charAt(i)))) { 
        return false;
    }
}

return true;
 }
/*
À primeira vista conseguimos entender o que está sendo feito? Provavelmente não.

Note também que a cada validação que precisamos fazer são mais ifs que precisamos adicionar. Será que existe outra forma mais simples para validarmos esses dados? A resposta é sim!

Podemos utilizar expressões regulares por meio do método matches() da classe String. Vamos definir nossa expressão regular para validar o nome do aluno:

*/
public boolean valida5(Aluno aluno) {

String nome = aluno.getNome();

return nome.matches("\[a-z\]");

}
/*
Certo, essa expressão regular significa que esperamos apenas 1 única letra do alfabeto.
Mas o que queremos é que tenha pelo menos 2, certo? Simples! Basta adicionar chaves ({}) e
informar a quantidade de repetições que você deseja:

*/
public boolean valida6(Aluno aluno) {

String nome = aluno.getNome();

return nome.matches("\[a-z\]{2}");

}
/*
Nesse exemplo estamos informando que queremos apenas 2 repetições, ou seja, a quantidade não pode ser maior ou menor e sim igual a 2 letras! Com certeza não é isso que queremos! E agora? Como podemos dizer que queremos pelo menos 2 letras?

Quando utilizamos as chaves podemos passar 2 parâmetros: o primeiro significa a quantidade mínima e o segundo a quantidade máxima. Ou seja, se adicionarmos apenas uma ",":
*/

public boolean valida7(Aluno aluno) {

String nome = aluno.getNome();

return nome.matches("\[a-z\]{2,}");

}
/*
Nesse instante estamos dizendo que esperamos pelo menos 2 letras e a quantidade máxima não tem limite!

Se testarmos o nome "Alex":

 aluno Alex é inválido
O que aconteceu? Não era pra ser válido? A nossa expressão regular diz que espera pelo menos 2 letras, porém letras minúsculas! Agora, como podemos fazer com que a nossa expressão regular espere uma letra maiúscula no começo? Da mesma forma que pra letras minúsculas usamos [a-z] podemos usar [A-Z] para letras maiúsculas:

*/
public boolean valida8(Aluno aluno) {

String nome = aluno.getNome();

return nome.matches("\[A-Z\]\[a-z\]{1,}");

}

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}