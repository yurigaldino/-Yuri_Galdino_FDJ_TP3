/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuri_galdino_fdj_tp2;

import model.Aluno;
import model.Professor;
import model.Pessoa;
import service.Service;
import system.Menu;

/**
 *
 * @author Yuri Galdino
 */
public class Yuri_Galdino_FDJ_TP2 {

    //Funções auxiliares
    public static String typeOf(Object o) {
        return o.getClass().getSimpleName();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int choice = Menu.menu();

        //If/Else way
        if (choice == 1) {
            Service.studentRegister();
        } else if (choice == 2) {
            Service.teacherRegister();
        } else if (choice == 3) {
            Service.checkTeachersAndStudents();
        } else if (choice == 4) {
            System.out.println("\nObrigado por utilizar nosso sistema.\n");
            System.exit(0);
        }

    }

}
