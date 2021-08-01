/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFunction;

import CheckValidation.Validation;
import static MainFunction.Function.listStudentFindByName;
import static TestApp.Main.filename;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

/**
 *
 * @author NhanNT
 */
public class Function {

    public static Scanner sc = new Scanner(System.in);
    /**
     * 
     * @param filename
     * @param list 
     * 
     * Load data form file
     */
    public static void loadFile(String filename, ArrayList<Student> list) {
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String tmp = bf.readLine();
                String[] arr = tmp.split(";");
                if (arr.length == 4) {
                    Student stu = new Student(arr[0], arr[1], arr[2], arr[3]);
                    list.add(stu);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        System.out.println("Loaded!");
    }
    
    /**
     * Write data to the file
     * @param list
     * @param filename 
     */

    public static void writeFile(ArrayList<Student> list, String filename) {
        if (list == null || list.isEmpty()) {
            return;
        }
        PrintWriter w = null;
        try {
            w = new PrintWriter(filename);
            for (Student student : list) {
                w.println(student.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
            }
        }
    }
    
    /**
     * Main menu
     */

    public static void menu() {
        System.out.println("");
        System.out.println("");
        System.out.println("-------Student Manager app-------");
        System.out.println("");
        System.out.println(" 1.	Add Student.");
        System.out.println(" 2.	Find student.");
        System.out.println(" 3.	Update/Delete.");
        System.out.println(" 4.	Report (All student).");
        System.out.println(" 5.	Exit.");
        System.out.println("");
        System.out.print(" Your choice (1->5): ");
    }
    
    /**
     * find Menu
     */

    public static void findMenu() {
        System.out.println("1. Find by name.");
        System.out.println("2. Find by ID.");
        System.out.println("3. Exit.");
        System.out.println("Your choice (1->3): ");
    }
    
    /**
     * Update or Delete Menu
     */

    public static void UorDMenu() {
        System.out.println("1. Update.");
        System.out.println("2. Delete.");
        System.out.println("3. Exit.");
        System.out.println("Your choice (1->3): ");
    }
    
    /**
     * Create a student and write to file
     * @param count
     * @param list 
     */

    public static void createStudent(int count, ArrayList<Student> list) {

        System.out.println("Enter EXIT to EXIT!");
        while (true) {
            System.out.print("Enter ID: ");
            String id = Validation.checkInput();
            if (id.equalsIgnoreCase("exit")) {
                return;
            }
            System.out.print("Enter student name: ");
            String name = Validation.checkInput();
            if (name.equalsIgnoreCase("exit")) {
                return;
            }
            if (!Validation.checkIdExist(list, id, name)) {
                System.out.println("ID has exist student. Pleas re-input!");
                continue;
            }
            System.out.print("Enter Semester: ");
            String semester = Validation.checkInput();
            if (semester.equalsIgnoreCase("exit")) {
                return;
            }
            System.out.print("Enter course name: ");
            String course = Validation.checkInputCourse();
            if (course.equalsIgnoreCase("exit")) {
                return;
            }
            if (Validation.checkStudentExist(list, id, name, semester, course)) {
                list.add(new Student(id, name, semester, course));
                count++;
                System.out.println("Add student success.");
            } else {
                System.out.println("Duplicate!");
            }
//            System.out.print("Do you want to continue (Enter Y(yes) or N(no) ): ");
//            if (!Validation.checkYorN()) {
//                return;
//            }
            writeFile(list, filename);
        }
    }
    
    /**
     * Find and sort list Student by name
     * @param listStudent
     */

    public static void findAndSortByName(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(listStudent);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("Not exist!");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-25s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for (Student student : listStudentFindByName) {
                student.display();
            }
        }
    }
    
    /**
     * Find student by name
     * @param listStudent 
     */

    public static void findByName(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(listStudent);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("Not exist!");
        } else {

            System.out.printf("%-25s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for (Student student : listStudentFindByName) {
                student.display();
            }
        }
    }

//    public static void findAndSortByID(ArrayList<Student> list) {
//        if (list.isEmpty()) {
//            System.out.println("List empty!");
//            return;
//        }
//        ArrayList<Student> listStudentFindByID = ListStudentFindByID(list);
//        if (listStudentFindByID.isEmpty()) {
//            System.out.println("Not exist!");
//        } else {
//            Collections.sort(listStudentFindByID);
//            System.out.printf("%-25s%-15s%-15s\n", "Student name", "semester", "Course Name");
//            for (Student student : listStudentFindByID) {
//                student.display();
//            }
//        }
//    }
    
    
    /**
     * Find student by ID
     * @param listStudent 
     */
    public static void findByID(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        ArrayList<Student> listStudentFindByID = ListStudentFindByID(listStudent);
        if (listStudentFindByID.isEmpty()) {
            System.out.println("Not exist!");
        } else {
            System.out.printf("%-25s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for (Student student : listStudentFindByID) {
                student.display();
            }
        }
    }
    
    
    /**
     * This function will find list student find by name and return it
     * @param listStudent
     * @return listStudentFindByName
     */
    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> listStudent) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = Validation.checkInput();
        for (Student student : listStudent) {
            if (student.getStudentName().toUpperCase().contains(name.toUpperCase())) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }
    
    /**
     * This function will find list student find by ID and return it
     * @param listStudent
     * @return listStudentFindByID
     */

    public static ArrayList<Student> ListStudentFindByID(ArrayList<Student> listStudent) {
        ArrayList<Student> listStudentFindByID = new ArrayList<>();
        System.out.print("Enter ID to search: ");
        String ID = Validation.checkInput();
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(ID)) {
                listStudentFindByID.add(student);
            }
        }
        return listStudentFindByID;
    }
    
    /**
     * Update information of student
     * @param count
     * @param listStudent
     * @throws Exception 
     */
    public static void update(int count, ArrayList<Student> listStudent) throws Exception {

        while (true) {
            if (listStudent.isEmpty()) {
                System.out.println("List empty.");

            } else {

                System.out.print("Enter id: ");
                String id = Validation.checkInput();
                ArrayList<Student> listStudentFindByID = getListStudentById(listStudent, id);
                if (listStudentFindByID.isEmpty()) {
                    System.out.println("Not found student.");

                } else {
                    Student student = getStudentByListFound(listStudentFindByID, listStudent);
                    System.out.print("Enter semester: ");
                    String semester = sc.nextLine().trim();
                    if (semester.equals("")) {
                        semester = student.getSemester();
                    }
                    System.out.print("Enter name course: ");
                    String courseName = sc.nextLine().trim();
                    if (courseName.equals("")) {
                        courseName = student.getCourseName();
                    } else {
                        Validation.checkCourse(courseName);
                    }
                    if (!Validation.checkChangeInfomation(student, semester, courseName)) {
                        System.out.println("Nothing change.");

                    } else {
                        student.setSemester(semester);
                        student.setCourseName(courseName);
                        System.out.println("Update success.");
                        writeFile(listStudent, filename);

                    }

                }

            }
            System.out.print("Do you want to continue (Enter Y(yes) or N(no) ): ");
            if (!Validation.checkYorN()) {
                return;
            }
        }

    }
    
    /**
     * Delete a student
     * @param count
     * @param listStudent 
     */
    public static void delete(int count, ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty.");

        } else {
            System.out.print("Enter id: ");
            String id = Validation.checkInput();
            ArrayList<Student> listStudentFindByID = getListStudentById(listStudent, id);
            if (listStudentFindByID.isEmpty()) {
                System.out.println("Not found student.");
            } else {
                ArrayList<Student> student = getListStudentByListFound(listStudentFindByID);
                    for (Student student1 : student) {
                    listStudent.remove(student1);
                    
                }
                    System.out.println("Deleted!");
                    writeFile(listStudent, filename);
                    

            }
        }

    }

    /**
     * 
     * @param listStudentFindByName
     * @param listStudent
     * @return
     * @throws Exception 
     */
    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName, ArrayList<Student> listStudent) throws Exception {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-25s%-15s%-15s\n", "Number", "Student name", "semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-25s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Validation.checkLimit(1, listStudentFindByName.size());
        Student st = listStudentFindByName.get(choice - 1);
        for (Student student : listStudent) {
            if (student.compareTo(st) == 0) {
                return student;
            }
        }
        return null;

    }
    
    /**
     * 
     * @param listStudentFindByID
     * @return 
     */
    public static ArrayList<Student> getListStudentByListFound(ArrayList<Student> listStudentFindByID) {
        ArrayList<Student> list = new ArrayList<>();
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-25s%-15s%-15s\n", "Number", "Student name", "semester", "Course Name");
        for (Student student : listStudentFindByID) {
            System.out.printf("%-10d%-25s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.println("If you want to delete a to b, Enter a-b, if you want to delete a, enter a,separated by , ");
        System.out.println("EX: 1-3,4 ");
        System.out.print("Enter student:  ");
        String s = Validation.checkInput();

        String[] arr = s.split(",");
        int length = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("-")) {
                String[] arr2 = arr[i].split("-");
                int from = Integer.parseInt(arr2[0]);
                int to = Integer.parseInt(arr2[1]);
                length = length + to - from;
            }
        }
        int[] choice = new int[length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            try {

                if (arr[i].contains("-")) {
                    String[] arr2 = arr[i].split("-");
                    int from = Integer.parseInt(arr2[0]);
                    int to = Integer.parseInt(arr2[1]);
                    for (int j = from; j <= to; j++) {
                        choice[index] = j;
                        index++;
                    }
                } else {
                    choice[index] = Integer.parseInt(arr[i]);
                    index++;
                }

            } catch (NumberFormatException e) {

            }

        }
        for (int i : choice) {
            list.add(listStudentFindByID.get(i - 1));
        }

        return list;
    }
    
    
    /**
     * Get listStudent by Id
     * @param listStudent
     * @param id
     * @return 
     */
    public static ArrayList<Student> getListStudentById(ArrayList<Student> listStudent, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : listStudent) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    public static void report(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int total = 0;
            for (Student student : list) {
                String id = student.getId();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();
                for (Student studentCountTotal : list) {
                    if (id.equalsIgnoreCase(studentCountTotal.getId())
                            && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if (Validation.checkReportExist(lr, studentName,
                        courseName, total)) {
                    lr.add(new Report(studentName, courseName, total));
                }
                total = 0;
            }
        }
        System.out.printf("%-25s|%-10s|%-15s\n", "Name", "Course", "Total Course");
        for (int i = 0; i < lr.size(); i++) {

            System.out.printf("%-25s|%-10s|%-15d\n", lr.get(i).getStudentName(),
                    lr.get(i).getCourseName(), lr.get(i).getTotalCourse());
        }
    }

}
