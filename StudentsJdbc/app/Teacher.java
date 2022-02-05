package StudentsJdbc.app;

import StudentsJdbc.app.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Teacher implements Comparable<Teacher> {

    public String name;
    public String password;
    public int salary;

    public Teacher() {
    }

    public Teacher(String name, String password, int salary) {
        this.name = name;
        this.password = password;
        this.salary = salary;
    }

    static List<Teacher> list = new ArrayList<>();


    public static void addTeacher(String name, String password, int salary) throws SQLException {
        String sql = """
                INSERT INTO teachers (name,password,salary) VALUES (?,?,?);
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, salary);
            var i = preparedStatement.executeUpdate();
        }

    }

    public static void getTeacherByName(String name) throws SQLException {
        String sql = """
                SELECT * FROM teachers WHERE name = ?;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            preparedStatement.setString(1, name);
            var executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()) {
                System.out.println(executeQuery.getString("name"));
                System.out.println(executeQuery.getInt("salary"));
            }
        }

    }


    public static void allTeachersInDataBase() throws SQLException {
        String sql = """
                SELECT * FROM teachers;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            var executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                System.out.println(executeQuery.getInt("Id is " + "id"));
                System.out.println(executeQuery.getString("Name is " + "name"));
                System.out.println("---------------------------------");
            }
        }
    }


    public static void deleteTeacher(String name, String password) throws SQLException {
        String sql = """
                DELETE FROM teachers WHERE  name = ? AND password = ?""";


        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            var i = preparedStatement.executeUpdate();
        }

    }

    public static void updateSalary(String name, String password) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input new salary");
        int salary = sc.nextInt();

        String sql = """
                UPDATE teachers SET salary = ? WHERE name = ? AND password = ?;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            preparedStatement.setInt(1, salary);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            var i = preparedStatement.executeUpdate();
            if (i == 0) {
                System.out.println("not found");
            } else System.out.println("You updated " + i + " rows");
        }
    }

    public static void countOfTeacher() throws SQLException {

        String sql = """
                SELECT count(id), name FROM teachers GROUP BY name;
                """;

        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            var executeQuery = preparedStatement.executeQuery();
            int count = 0;
            while (executeQuery.next()) {
                count++;
            }
            System.out.println("count of teachers is " + count);
        }


    }


    public static void firstThreeHighSalary() throws SQLException {

        String sql = """
                SELECT * FROM teachers ORDER BY salary DESC LIMIT 3 ;
                """;


        try (var open = ConnectionManager.open()) {
            var preparedStatement = open.prepareStatement(sql);
            var executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                System.out.println(executeQuery.getString("name"));
                System.out.println(executeQuery.getInt("salary"));
                System.out.println("-------------------------\n-------------------------");
            }
        }


    }


    @Override
    public int compareTo(Teacher o) {
        return Integer.compare(o.salary, salary);
    }


    public void setName() {
        System.out.println("Input name please");
        Scanner sc = new Scanner(System.in);
        this.name = sc.next();
    }

    public void setPassword() {
        System.out.println("Input password please");
        Scanner sc = new Scanner(System.in);
        this.password = sc.next();
    }

    public void setSalary() {
        System.out.println("Input salary please");
        Scanner sc = new Scanner(System.in);
        this.salary = sc.nextInt();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
               "name='" + name + '\'' +
               ", password='" + password + '\'' +
               ", salary=" + salary +
               '}';
    }
}
