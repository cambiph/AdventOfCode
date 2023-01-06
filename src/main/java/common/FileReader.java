package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    public static List<String> readFile(int year, int day) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("src/main/java/y")
                    .append(year)
                    .append("/day")
                    .append(day)
                    .append("/input.txt");
            return Files.readAllLines(Path.of(builder.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
