package dictionary.service;

public interface DictionaryService {

    void add(String key, String value);

    String find(String key);

    void remove(String key);
}

