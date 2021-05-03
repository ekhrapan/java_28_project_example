package academy.belhard.db.writer;

import academy.belhard.db.DbConnection;
import academy.belhard.entity.School;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SchoolDbWriter {

    public static final String INSERT = "INSERT INTO schools (id, title, city) VALUES(?,?,?)";

    public static void insert(List<School> schools) {
        for (School school : schools) {
            insert(school);
        }
    }

    public static void insert(School school) {
        Connection connection = DbConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, school.getId());
            statement.setString(2, school.getTitle());
            statement.setString(3, school.getCity());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
