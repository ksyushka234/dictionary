package dictionary.io;

import dictionary.service.DictionaryService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DictionaryFileLoader {
    public static void loadFromFile(DictionaryService dictionary, String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] parts = line.split("=");
                if (parts.length != 2) {
                    continue;
                }
                String key = parts[0];
                String value = parts[1];
                dictionary.add(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile(DictionaryService dictionary, String fileName) {
        Map<String, String> data = dictionary.getAll();
        List<String> lines = new ArrayList<>();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            lines.add(entry.getKey() + "=" + entry.getValue());
        }
        try {
            Files.write(Paths.get(fileName), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

