/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.util.InputMismatchException;
import java.util.Scanner;
import yuri_galdino_fdj_tp2.Yuri_Galdino_FDJ_TP2;

/**
 *
 * @author Yuri Galdino
 */
public class Menu {

    //Output variable
    static int choiceApproved;

    public static int menu() {
        System.out.println("\n-------------------------------------------------------------\nSistema de cadastro e consulta de docentes e discentes INFNET\n-------------------------------------------------------------\nMENU:\n");

        System.out.println("[1] Registrar um novo aluno.\n"
                + "[2] Registrar um novo professor.\n"
                + "[3] Consultar alunos e professores.\n"
                + "[4] Sair.");
        System.out.println("Digite escolha abaixo ↓");

        Scanner input = new Scanner(System.in);

        //Try/Catch to check if the input is int
        try {
            int choice = input.nextInt();
            //Check if the input is a valid number.
            if (choice > 4 || choice < 1) {
                System.out.println("ERRO: O número digitado não é válido.");
                redoMenuChoice();

            } else {
                //Pass checked value to output variable "choiceApproved"
                choiceApproved = choice;
            }
            //Catch error when its not a number
        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números inteiros.");
            redoMenuChoice();
        }

        return choiceApproved;
    }

    public static void redoMenuChoice() {
        System.out.println("\nPor favor, escolha uma das opções permitidas...\n");

        //Thread.sleep for 2.4 seconds
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        //Force user to choose again.
        menu();
        //Yuri_Galdino_TP1.main(new String[0]);
    }
}
