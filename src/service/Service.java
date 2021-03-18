/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Aluno;
import model.Professor;
import model.Pessoa;
import system.Menu;
import java.util.Calendar;

/**
 *
 * @author Yuri Galdino
 *
 */
public class Service {

    //Dados
    static ArrayList<String> registeredCPFs = new ArrayList<String>();
    static ArrayList<Aluno> dataStudent = new ArrayList<Aluno>();
    static ArrayList<Professor> dataTeacher = new ArrayList<Professor>();

    //General info
    static String CPF = "";
    static String nome = "";
    static int idade = 0;

    //Scanner de Nome, CPF e Idade 
    public static void pearsonInfo(String errorCode) {
        Scanner input = new Scanner(System.in);

        //Try/Catch to check if the input is a String 
        System.out.println("CPF(Somente números) ↓");
        String inputStringCPF = input.nextLine();

        if (ValidaCPF.isCPF(inputStringCPF) == true) {
            for (String CPF : registeredCPFs) {
                if (CPF.matches(inputStringCPF)) {
                    System.out.println("ERRO: CPF já existente no sistema.");
                    if (errorCode == "teacherRegister") {
                        teacherRegister();
                    } else if (errorCode == "studentRegister") {
                        studentRegister();
                    }

                }
            }
            CPF = inputStringCPF;

        } else {
            System.out.println("ERRO: CPF inválido.");
            if (errorCode == "teacherRegister") {
                teacherRegister();
            } else if (errorCode == "studentRegister") {
                studentRegister();
            }
        }

        System.out.println("Nome ↓");;
        String inputStringNome = input.nextLine();

        String regex = "^[\\\\p{L} .'-]+$";
        if (inputStringNome.matches(regex) == false) {
            nome = inputStringNome;
        } else {
            System.out.println("ERRO: Esta entrada só aceita itens do tipo String.");
            if (errorCode == "teacherRegister") {
                teacherRegister();
            } else if (errorCode == "studentRegister") {
                studentRegister();
            }
        }

        try {
            System.out.println("Idade ↓");
            int inputIdadeInt = input.nextInt();

            if (inputIdadeInt < 0 || inputIdadeInt > 112) {
                System.out.println("ERRO: Insira uma idade compatível.");
                if (errorCode == "teacherRegister") {
                    teacherRegister();
                } else if (errorCode == "studentRegister") {
                    studentRegister();
                }
            } else {
                idade = inputIdadeInt;
            }
            //Catch error when its not a int
        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita itens do tipo inteiro.");
            if (errorCode == "teacherRegister") {
                teacherRegister();
            } else if (errorCode == "studentRegister") {
                studentRegister();
            }
        }

    }

    public static void studentRegister() {

        int anoMatricula = 0;

        System.out.println("\n~REGISTRO DE UM(A) NOVO(A) ALUNO(A)~");

        //Infos gerais de qualquer pessoa
        pearsonInfo("studentRegister");

        Scanner input = new Scanner(System.in);
        try {

            System.out.println("Ano de matrícula ↓");
            int inputAnoMatriculaInt = input.nextInt();

            Calendar d = Calendar.getInstance();
            int anoAtual = d.get(Calendar.YEAR);

            if (inputAnoMatriculaInt > anoAtual || inputAnoMatriculaInt < 1909) {
                System.out.println("ERRO: Insira um ano compatível.");
                studentRegister();
            } else {
                anoMatricula = inputAnoMatriculaInt;
            }

            //Catch error when its not a int
        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita itens do tipo inteiro.");
            studentRegister();
        }
        //Register CPF when everything is correct
        registeredCPFs.add(CPF);
        Aluno Aluno = new Aluno(nome, idade, anoMatricula, CPF);

        dataStudent.add(Aluno);

        System.out.println("O registro de " + nome + " foi feito com o CPF " + CPF + ".");

        yuri_galdino_fdj_tp2.Yuri_Galdino_FDJ_TP2.main(new String[0]);
    }

    public static void teacherRegister() {

        String especialidade = "";

        System.out.println("\n~REGISTRO DE UM(A) NOVO(A) PROFESSOR(A)~");

        //Infos gerais de qualquer pessoa
        pearsonInfo("teacherRegister");

        Scanner input = new Scanner(System.in);

        System.out.println("Especialidade ↓");;
        String inputStringEspecialidade = input.nextLine();

        String regex = "^[\\\\p{L} .'-]+$";
        if (inputStringEspecialidade.matches(regex) == false) {
            especialidade = inputStringEspecialidade;
        } else {
            System.out.println("ERRO: Esta entrada só aceita itens do tipo String.");
            teacherRegister();
        }
        //Register CPF when everything is correct
        registeredCPFs.add(CPF);
        Professor Professor = new Professor(nome, idade, especialidade, CPF);

        dataTeacher.add(Professor);

        System.out.println("O registro de " + nome + " foi feito com o CPF " + CPF + ".");

        yuri_galdino_fdj_tp2.Yuri_Galdino_FDJ_TP2.main(new String[0]);
    }

    public static void checkTeachersAndStudents() {
        System.out.println("\n~CONSULTA DE ALUNOS E PROFESSORES~");

        String cpf = "88888888888";
        cpf = String.format("xxx.xxx.xxx-xx", cpf);

        System.out.println(cpf);

        System.out.println("\nProfessores:");
        for (Professor p : dataTeacher) {;
            System.out.println("Nome: " + p.getNome() + "\nCPF: " + ValidaCPF.formatCPF(p.getCPF()) + "\nEspecialidade: " + p.getEspecialidade() + "\nIdade: " + p.getIdade());
            System.out.println("");
        }

        System.out.println("\nAlunos:");
        for (Aluno a : dataStudent) {
            System.out.println("Nome: " + a.getNome() + "\nCPF: " + ValidaCPF.formatCPF(a.getCPF()) + "\nAno de matrícula: " + a.getAnoMatricula() + "\nIdade: " + a.getIdade());
            System.out.println();
        }

        yuri_galdino_fdj_tp2.Yuri_Galdino_FDJ_TP2.main(new String[0]);
    }

}
