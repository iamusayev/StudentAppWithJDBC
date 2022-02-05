package StudentsJdbc.app;

import java.util.Scanner;

public class Info {


    public static String nameOfSchool() {
        System.out.println("Input name of school please");
        Scanner sc = new Scanner(System.in);
        String nameOfSchool = sc.next();
        return nameOfSchool;
    }

    public static void mainMenu() {
        System.out.println("1.Login & Registration app");
        System.out.println("2.School management system");
    }


    public static void loginAndRegistration() {
        System.out.println("1.Sign in");
        System.out.println("2.Registration");
        System.out.println("3.Reset password");
    }

    public static void schoolManagementSystem() {
        System.out.println("1.Teacher page");
        System.out.println("2.Student page");
        System.out.println("3.About school page");
    }

    public static void registration() {

    }


    public static void signIn() {
        {
        }
    }

    public static void resetPassword() {
    }

    public static void baseMenu() {
        System.out.println("1.Teacher page");
        System.out.println("2.Student page");
        System.out.println("3.About school page");
    }

    public static void aboutTeacherPage() {
        System.out.println("1.Add new teacher");
        System.out.println("2.Get teacher by name");
        System.out.println("3.List of teacher");
        System.out.println("4.Delete teacher");
        System.out.println("5.Update salary of teacher");
        System.out.println("6.Back to base menu");
    }

    public static void aboutStudentPage() {
        System.out.println("1.Add new student");
        System.out.println("2.Get student by name");
        System.out.println("3.List of students");
        System.out.println("4.Delete student");
        System.out.println("5.Update score of student");
        System.out.println("6.Back to base menu");
    }

    public static void aboutSchoolPage() {
        System.out.println("1.Name of school");
        System.out.println("2.Count of teacher");
        System.out.println("3.Count of students");
        System.out.println("4.Top 3 teacher with high salaries");
        System.out.println("5.Top 3 students with high scores");
        System.out.println("6.Back to base menu");
    }


    public static String name() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name");
        String name = sc.next();
        return name;
    }

    public static String password() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your password");
        String password = sc.next();
        return password;
    }
}
