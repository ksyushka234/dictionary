package dictionary.service;
import java.util.Map;
public interface DictionaryService {

    void add(String key, String value);

    String find(String key);

    void remove(String key);
    Map<String, String> getAll();
}

