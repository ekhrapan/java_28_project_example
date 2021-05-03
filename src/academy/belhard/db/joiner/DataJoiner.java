package academy.belhard.db.joiner;

import academy.belhard.db.DbConnection;
import academy.belhard.entity.JoinedDataItem;
import academy.belhard.util.JoinedDataItemUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataJoiner {

    public static final String QUERY = "SELECT st.id, st.first_name, st.last_name, st.age, sc.title, sc.city " +
            "FROM students AS st " +
            "INNER JOIN schools AS sc " +
            "ON st.school_id = sc.id";

    public static List<JoinedDataItem> getJoinedData() {
        List<JoinedDataItem> result = null;

        Connection connection = DbConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            result = JoinedDataItemUtil.parseResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
