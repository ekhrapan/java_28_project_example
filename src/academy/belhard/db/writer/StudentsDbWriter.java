package academy.belhard.db.writer;

import academy.belhard.db.DbConnection;
import academy.belhard.entity.School;
import academy.belhard.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentsDbWriter {

    public static final String INSERT = "INSERT INTO students (id, first_name, last_name, age, school_id) VALUES(?,?,?,?,?)";

    public static void insert(List<Student> students) {
        for (Student student : students) {
            insert(student);
        }
    }

    public static void insert(Student student) {
        Connection connection = DbConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setInt(4, student.getAge());
            statement.setInt(5, student.getSchoolId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
