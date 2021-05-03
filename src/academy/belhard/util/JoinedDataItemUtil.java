package academy.belhard.util;

import academy.belhard.entity.JoinedDataItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static academy.belhard.io.IoConstants.DELIMITER;

public class JoinedDataItemUtil {

    public static List<JoinedDataItem> parseResultSet(ResultSet resultSet) throws SQLException {
        List<JoinedDataItem> items = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int age = resultSet.getInt("age");
            String title = resultSet.getString("title");
            String city = resultSet.getString("city");

            JoinedDataItem item = new JoinedDataItem(id, firstName, lastName, age, title, city);
            items.add(item);
        }

        return items;
    }

    public static String makeString(JoinedDataItem item) {
        return item.getId() + DELIMITER
                + item.getFirstName() + DELIMITER
                + item.getLastName() + DELIMITER
                + item.getAge() + DELIMITER
                + item.getTitle() + DELIMITER
                + item.getCity() + "\n";
    }
}
