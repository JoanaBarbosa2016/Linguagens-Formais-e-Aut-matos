package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
********************************************************************************
*Trabalho apresentado à disciplina de Linguagens Formais e Autômatos           *
*Professor: José Ruy Castro                                                    *
*Autores: Darlan Roberto, Joana D'arc de Paula                                 *
********************************************************************************
*/
public class FuncaoTransicao {
    
    private String estadoOrigem;
    private String estadoDestino;
    private char simbolo;

    public FuncaoTransicao() {
        this.estadoOrigem = "";
        this.estadoDestino = "";
        this.simbolo = '-';
    }
    
    /**
     * @return the estadoOrigem
     */
    public String getEstadoOrigem() {
        return estadoOrigem;
    }

    /**
     * @param estadoOrigem the estadoOrigem to set
     */
    public void setEstadoOrigem(String estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    /**
     * @return the estadoDestino
     */
    public String getEstadoDestino() {
        return estadoDestino;
    }

    /**
     * @param estadoDestino the estadoDestino to set
     */
    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

    /**
     * @return the simbolo
     */
    public char getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
    
    
}
