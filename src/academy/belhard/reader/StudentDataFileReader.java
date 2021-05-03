package academy.belhard.reader;

import academy.belhard.entity.Student;
import academy.belhard.exception.EmptySourceFile;
import academy.belhard.util.StudentUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataFileReader {
    private String filepath;

    public StudentDataFileReader(String filepath) {
        this.filepath = filepath;
    }

    public List<Student> read() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            checkFile();

            String line;
            while ((line = reader.readLine()) != null) {
                Student student = StudentUtil.toObject(line);
                students.add(student);
            }

        } catch (IOException | EmptySourceFile e) {
            e.printStackTrace();
        }

        return students;
    }

    private void checkFile() throws EmptySourceFile {
        File sourceFile = new File(filepath);

        if (sourceFile.length() == 0) {
            throw new EmptySourceFile("Файл пуст");
        }
    }
}
