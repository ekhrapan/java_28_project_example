package academy.belhard.util;

import academy.belhard.entity.School;

import static academy.belhard.io.IoConstants.DELIMITER;

public class SchoolUtil {

    public static School toObject(String line) {
        String[] schoolArr = line.split(DELIMITER);

        int id = Integer.parseInt(schoolArr[0]);
        String title = schoolArr[1];
        String city = schoolArr[2];

        return new School(id, title, city);
    }
}
