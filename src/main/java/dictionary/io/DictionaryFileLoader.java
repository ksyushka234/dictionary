package dictionary.io;

import dictionary.service.DictionaryService;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class DictionaryFileLoader {
    public static void loadFromFile(DictionaryService dictionary, String fileName){
        try{
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        }
        catch (IOException e){
        e.printStackTrace();
        }
    }
}

