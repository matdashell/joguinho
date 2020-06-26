/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joguinho;

/**
 *
 * @author marcio
 */
public class Personagem {
    String nome;
    int vigor, defesa, vida;
    
    String getNome(){
        return this.nome;
    }
    void setNome(String nome){
        this.nome = nome;
    }
    int getVigor(){
        return this.vigor;
    }
    void setVigor(int vigor){
        this.vigor = vigor;
    }
    int getVida(){
        return this.vida;
    }
    void setVida(int vida){
        this.vida = vida;
    }
}
