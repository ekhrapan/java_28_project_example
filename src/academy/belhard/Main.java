package academy.belhard;

import academy.belhard.db.joiner.DataJoiner;
import academy.belhard.entity.JoinedDataItem;
import academy.belhard.io.writer.JoinedDataFileWriter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        SchoolDataFileReader dataFileReader = new SchoolDataFileReader("data\\schools.csv");
//        List<School> schools = dataFileReader.read();
//
//        SchoolDbWriter.insert(schools);

//        StudentDataFileReader studentsReader = new StudentDataFileReader("data\\students.csv");
//        List<Student> students = studentsReader.read();
//
//        StudentsDbWriter.insert(students);

        List<JoinedDataItem> items  = DataJoiner.getJoinedData();

        System.out.println(items);

        JoinedDataFileWriter dataFileWriter = new JoinedDataFileWriter("data\\result.csv");
        dataFileWriter.write(items);
    }
}
