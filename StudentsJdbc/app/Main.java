package StudentsJdbc.app;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        String  nameOfSchool = Info.nameOfSchool();

        boolean is = true;
        while (true) {
            Info.mainMenu();
            String number = sc.next();
            if (number.equals("1")) {
                Info.loginAndRegistration();
                switch (sc.next()) {
                    case "1":
                        Info.signIn();
                        break;
                    case "2":
                        Info.registration();
                        break;
                    case "3":
                        Info.resetPassword();
                }
            } else if (number.equals("2")) {
                Info.baseMenu();
                String mainScanner = sc.next();
                if (mainScanner.equals("1")) {
                    Info.aboutTeacherPage();
                    switch (sc.next()) {
                        case "1":
                            Teacher teacher = new Teacher();
                            teacher.setName();
                            teacher.setPassword();
                            teacher.setSalary();
                            Teacher.addTeacher(teacher.getName(), teacher.getPassword(), teacher.getSalary());
                            break;
                        case "2":
                            Teacher.getTeacherByName(Info.name());
                            break;
                        case "3":
                            Teacher.allTeachersInDataBase();
                            break;
                        case "4":
                            Teacher.deleteTeacher(Info.name(), Info.password());
                            break;
                        case "5":
                            Teacher.updateSalary(Info.name(), Info.password());
                            break;
                        case "6":
                            Info.baseMenu();
                    }
                } else if (mainScanner.equals("2")) {
                    Info.aboutStudentPage();
                    switch (sc.next()) {
                        case "1":
                            Student student = new Student();
                            student.setName();
                            student.setPassword();
                            student.setScore();
                            Student.addStudent(student.getName(), student.getPassword(), student.getScore());
                            break;
                        case "2":
                            Student.getStudentByName(Info.name());
                            break;
                        case "3":
                            Student.allStudentsInDataBase();
                            break;
                        case "4":
                            Student.deleteStudent(Info.name(), Info.password());
                            break;
                        case "5": Student.updateScoreOfStudents(Info.name(),Info.password());
                        break;
                        case "6": Info.baseMenu();
                    }
                } else if (mainScanner.equals("3")) {
                    Info.aboutSchoolPage();
                    switch (sc.next()){
                        case "1":
                            System.out.println(nameOfSchool);
                            break;
                        case "2":
                            Teacher.countOfTeacher();
                            break;
                        case"3":
                            Student.countOfStudents();
                            break;
                        case "4":
                            Teacher.firstThreeHighSalary();
                            break;
                        case "5":
                            Student.firstThreeHighScore();
                        case "6":Info.baseMenu();
                    }
                }


            }
        }
    }


}


