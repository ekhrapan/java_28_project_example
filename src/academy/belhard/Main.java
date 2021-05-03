package academy.belhard;

import academy.belhard.db.joiner.DataJoiner;
import academy.belhard.db.writer.SchoolDbWriter;
import academy.belhard.db.writer.StudentsDbWriter;
import academy.belhard.entity.JoinedDataItem;
import academy.belhard.entity.School;
import academy.belhard.entity.Student;
import academy.belhard.io.IoConstants;
import academy.belhard.io.reader.SchoolDataFileReader;
import academy.belhard.io.reader.StudentDataFileReader;
import academy.belhard.io.writer.JoinedDataFileWriter;

import java.util.List;

import static academy.belhard.io.IoConstants.*;

public class Main {

    public static void main(String[] args) {
        SchoolDataFileReader dataFileReader = new SchoolDataFileReader(SCHOOLS_SOURCE_FILE);
        List<School> schools = dataFileReader.read();

        SchoolDbWriter.insert(schools);

        StudentDataFileReader studentsReader = new StudentDataFileReader(STUDENTS_SOURCE_FILE);
        List<Student> students = studentsReader.read();

        StudentsDbWriter.insert(students);

        List<JoinedDataItem> items  = DataJoiner.getJoinedData();

        System.out.println(items);

        JoinedDataFileWriter dataFileWriter = new JoinedDataFileWriter(RESULT_FILE);
        dataFileWriter.write(items);
    }
}
