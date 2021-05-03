package academy.belhard;

import academy.belhard.reader.SchoolDataFileReader;
import academy.belhard.reader.StudentDataFileReader;

public class Main {

    public static void main(String[] args) {
//        SchoolDataFileReader dataFileReader = new SchoolDataFileReader("data\\schools.csv");
//        System.out.println(dataFileReader.read());

        StudentDataFileReader studentsReader = new StudentDataFileReader("data\\students.csv");
        System.out.println(studentsReader.read());
    }
}
