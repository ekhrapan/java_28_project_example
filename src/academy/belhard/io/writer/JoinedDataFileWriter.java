package academy.belhard.io.writer;

import academy.belhard.entity.JoinedDataItem;
import academy.belhard.util.JoinedDataItemUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JoinedDataFileWriter {
    private String filepath;

    public JoinedDataFileWriter(String filepath) {
        this.filepath = filepath;
    }

    public void write(List<JoinedDataItem> items) {
        try (FileWriter writer = new FileWriter(filepath)) {
            for (JoinedDataItem item : items) {
                String str = JoinedDataItemUtil.makeString(item);
                writer.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
