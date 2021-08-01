/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckValidation;

import MainFunction.Report;
import MainFunction.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Validation class
 * 
 * @author NhanNT
 */
public class Validation {

    private final static Scanner sc = new Scanner(System.in);
    /**
     * 
     * @param min
     * @param max
     * 
     * This function will check the input number are valid in a range or not
     * 
     * @return The valid input (result)
     * @throws Exception 
     */
    public static int checkLimit(int min, int max) throws Exception {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Please input number in rage [ " + min + ", " + max + " ]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    /**
     * This function will check the input are empty or not
     * 
     * @return 
     */

    public static String checkInput() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Check input is yes or no
     * 
     * @return if yes return true, if no return false
     */
    public static boolean checkYorN() {
        while (true) {
            String result = checkInput();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input Y(yes) or N(no) .");
            System.out.print("Enter again: ");
        }
    }

    /**
     * Check input is update or delete
     * 
     * @return if update return true, if delete return false
     */
    public static boolean checkUorD() {
        while (true) {
            String result = checkInput();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }
    /**
     * Check input course is valid or not, if not valid -> require input again
     * 
     * @return the name of valid course
     */
    public static String checkInputCourse() {
        while (true) {
            String result = checkInput();
            if (result.equalsIgnoreCase("JPD") || result.equalsIgnoreCase("OSG") || result.equalsIgnoreCase("CSD") || result.equalsIgnoreCase("PRJ") || result.equalsIgnoreCase("LAB")) {
                return result;
            }
            System.out.println("There are only three courses: JPD, OSG, CSD, PRJ, LAB");
            System.out.print("Enter again: ");
        }
    }
    
    /**
     * Check course is valid or not
     * 
     * @param courceName 
     */
    public static void checkCourse(String courceName)
    {
        while(true)
        {
        if (courceName.equalsIgnoreCase("JPD") || courceName.equalsIgnoreCase("OSG") || courceName.equalsIgnoreCase("CSD") || courceName.equalsIgnoreCase("PRJ") || courceName.equalsIgnoreCase("LAB")) {
                return;
            }else
        {
            System.out.println("There are only three courses: JPD, OSG, CSD, PRJ, LAB");
            System.out.print("Enter again: ");
            courceName=checkInput();
        }
        }
    }
    /**
     * 
     * @param listStudent
     * @param id
     * @param studentName
     * @param semester
     * @param courseName
     * 
     * Check student is exist or not
     * 
     * @return true/false
     */

    public static boolean checkStudentExist(ArrayList<Student> listStudent, String id, String studentName, String semester, String courseName) {
        for (Student student : listStudent) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param listReport
     * @param name
     * @param course
     * @param total
     * 
     * Check report is exist or not
     * 
     * @return true/false
     */

    public static boolean checkReportExist(ArrayList<Report> listReport, String name, String course, int total) {
        for (Report report : listReport) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param list
     * @param id
     * @param name
     * 
     * Check id exist or not
     * 
     * @return true/false
     */

    public static boolean checkIdExist(ArrayList<Student> list, String id, String name) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param student
     * @param semester
     * @param course
     * 
     * Check information change or not
     * 
     * @return true/false
     */
    public static boolean checkChangeInfomation(Student student, String semester, String course) {
        return !(semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName()));
    }
    
    /**
     * Check sort or not
     * 
     * @return true/false
     */
    public static boolean checkSort() {
        System.out.println("Do you want to sort list after find? (Y/N)");
        System.out.println("Your choice: ");
        boolean sort = checkYorN();
        return sort;
    }
}
