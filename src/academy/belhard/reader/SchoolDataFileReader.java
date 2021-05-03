package academy.belhard.reader;

import academy.belhard.entity.School;
import academy.belhard.exception.EmptySourceFile;
import academy.belhard.util.SchoolUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolDataFileReader {
    private String filepath;

    public SchoolDataFileReader(String filepath) {
        this.filepath = filepath;
    }

    public List<School> read() {
        List<School> schools = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            checkFile();

            String line;
            while ((line = reader.readLine()) != null) {
                School school = SchoolUtil.toObject(line);
                schools.add(school);
            }

        } catch (IOException | EmptySourceFile e) {
            e.printStackTrace();
        }

        return schools;
    }

    private void checkFile() throws EmptySourceFile {
        File sourceFile = new File(filepath);

        if (sourceFile.length() == 0) {
            throw new EmptySourceFile("Файл пуст");
        }
    }
}
