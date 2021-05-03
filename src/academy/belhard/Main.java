package academy.belhard;

import academy.belhard.db.writer.SchoolDbWriter;
import academy.belhard.db.writer.StudentsDbWriter;
import academy.belhard.entity.School;
import academy.belhard.entity.Student;
import academy.belhard.reader.SchoolDataFileReader;
import academy.belhard.reader.StudentDataFileReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        SchoolDataFileReader dataFileReader = new SchoolDataFileReader("data\\schools.csv");
//        List<School> schools = dataFileReader.read();
//
//        SchoolDbWriter.insert(schools);

        StudentDataFileReader studentsReader = new StudentDataFileReader("data\\students.csv");
        List<Student> students = studentsReader.read();

        StudentsDbWriter.insert(students);
    }
}
