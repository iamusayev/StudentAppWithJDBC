package StudentsJdbc.app;

import StudentsJdbc.app.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Student implements Comparable<Student> {

    private String name;
    private String password;
    private int score;

    public Student(String name, String password, int score) {
        this.name = name;
        this.password = password;
        this.score = score;
    }

    public Student() {
    }

    ;

    static List<Student> students = new ArrayList<>();

    public static void infoStudents() {
        System.out.println("Введи сканер плс");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Your name is " + name);
    }

    public static void addStudent(String name, String password, int score) throws SQLException {
        String sql = """
                INSERT INTO students (name,password,score) VALUES (?,?,?)
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, score);
            var i = preparedStatement.executeUpdate();
            if (i == 0) System.out.println("Something went wrong");
            else System.out.println("You inserted " + i + " rows");
        }

    }

    public static void getStudentByName(String name) throws SQLException {

        String sql = """
                SELECT id, name, score FROM students WHERE name = ?;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            preparedStatement.setString(1, name);
            var executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                System.out.println(executeQuery.getInt("id"));
                System.out.println(executeQuery.getString("name"));
                System.out.println(executeQuery.getInt("score"));
            }
        }

    }


    public static void allStudentsInDataBase() throws SQLException {
        String sql = """
                SELECT * FROM students;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            var executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                System.out.println(executeQuery.getInt("id"));
                System.out.println(executeQuery.getString("name"));
                System.out.println(executeQuery.getInt("score"));
                System.out.println("--------------------------\n--------------------------");
            }
        }

    }

    public static void deleteStudent(String name, String password) throws SQLException {

        String sql = """
                DELETE FROM students WHERE name = ? AND password = ?;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            var i = preparedStatement.executeUpdate();
            if (i == 0) {
                System.out.println("You didn't delete anything ");
            } else System.out.println("You deleted " + i + " rows");
        }
    }

    public static void updateScoreOfStudents(String name, String password) throws SQLException {
        System.out.println("Input new score");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        String sql = """
                UPDATE students SET score = ? WHERE name = ? AND password = ?;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            preparedStatement.setInt(1, score);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            var i = preparedStatement.executeUpdate();
            if (i == 0) {
                System.out.println("You didn't update anything");
            } else System.out.println("You updated " + i + " rows");

        }


    }

    public static void countOfStudents() throws SQLException {

        String sql = """
                SELECT count(id), name FROM  students GROUP BY name;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            var executeQuery = preparedStatement.executeQuery();
            int i = 0;
            while (executeQuery.next()) {
                i++;
            }
            System.out.println("count of students is " + i);
        }

    }


    public static void firstThreeHighScore() throws SQLException {

        String sql = """
             SELECT * FROM students ORDER BY score DESC LIMIT 3;
                """;


        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            var executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                System.out.println(executeQuery.getString("name"));
                System.out.println(executeQuery.getInt("score"));
                System.out.println("---------------------\n---------------------");
            }

        }


    }


    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.score, score);
    }

    public void setName() {
        System.out.println("Input name");
        Scanner sc = new Scanner(System.in);
        this.name = sc.next();
    }

    public void setPassword() {
        System.out.println("Input password");
        Scanner sc = new Scanner(System.in);
        this.password = sc.next();
    }

    public void setScore() {
        System.out.println("Input score");
        Scanner sc = new Scanner(System.in);
        this.score = sc.nextInt();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

}
