package academy.belhard.util;

import academy.belhard.entity.Student;

public class StudentUtil {

    public static Student toObject(String line) {
        String[] schoolArr = line.split(";");

        int id = Integer.parseInt(schoolArr[0]);
        String firstName = schoolArr[1];
        String lastName = schoolArr[2];
        int age = Integer.parseInt(schoolArr[3]);
        int schoolId = Integer.parseInt(schoolArr[4]);

        return new Student(id, firstName, lastName, age, schoolId);
    }
}
