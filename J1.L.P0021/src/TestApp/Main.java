/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestApp;

import MainFunction.Function;
import MainFunction.Student;
import CheckValidation.Validation;
import java.util.ArrayList;

/**
 *
 * @author NhanNT
 */
public class Main {

    public static String filename;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Student> list = new ArrayList<>();

        System.out.println("Please enter source file name: ");
        filename = Validation.checkInput();
        Function.loadFile(filename, list);
        int count = list.size();
        int choice;

        do {
            Function.menu();
            choice = Validation.checkLimit(1, 5);
            switch (choice) {
                case 1:
                    Function.createStudent(count, list);
                    break;
                case 2:
                    int choiceFind;
                    do {

                        Function.findMenu();
                        choiceFind = Validation.checkLimit(1, 3);
                        switch (choiceFind) {
                            case 1:
                                Function.findAndSortByName(list);
                                break;
                            case 2:
                                Function.findByID(list);
                                break;
                            case 3:
                                break;

                        }
                    } while (choiceFind != 3);
                    break;
                case 3:
                    int choiceUorD;
                    do {
                        Function.UorDMenu();
                        choiceUorD = Validation.checkLimit(1, 3);
                        switch (choiceUorD) {
                            case 1:
                                Function.update(count, list);
                                break;
                            case 2:
                                Function.delete(count, list);
                                break;
                            case 3:
                                break;
                        }
                    } while (choiceUorD != 3);
                    break;
                case 4:
                    Function.report(list);
                    break;
                case 5:
                    Function.writeFile(list, filename);
                    return;
            }

        } while (choice != 5);
    }

}
