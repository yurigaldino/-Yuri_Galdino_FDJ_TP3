/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Yuri Galdino
 */
public class Professor extends Pessoa {

    String especialidade;

    //Construtor da classe
    public Professor(String nome, int idade, String especialidade, String CPF) {
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
        setCPF(CPF);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
