/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testepersistencia;

import java.io.Serializable;

/**
 *
 * @author henrique
 */
public class Cliente implements Serializable{
private int codigo;
private String nome;
private String sobrenome;
private int tel;

    public Cliente(int codigo,String nome,String sobrenome,int tel) {
        this.nome = nome;
        this.codigo = codigo;
        this.sobrenome = sobrenome;
        this.tel = tel;
    }

    public String getNome() {
       return this.nome;
    }
    
}
