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
public class Aluno extends Pessoa {

    int anoMatricula;

    //Construtor da classe
    public Aluno(String nome, int idade, int anoMatricula, String CPF) {
        this.nome = nome;
        this.idade = idade;
        this.anoMatricula = anoMatricula;
        setCPF(CPF);
    }

    public int getAnoMatricula() {
        return anoMatricula;
    }

    public void setAnoMatricula(int anoMatricula) {
        this.anoMatricula = anoMatricula;
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
    
    public void showAllStudents (){
        
    }

}
