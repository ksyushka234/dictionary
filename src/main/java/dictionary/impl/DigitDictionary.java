package dictionary.impl;
import dictionary.service.DictionaryService;

import java.util.Map;

import java.util.HashMap;
public class DigitDictionary implements DictionaryService {
    Map<String, String> data = new HashMap<>();
    @Override
    public void add(String key, String value) {
        if (key.length()==5){
            boolean valid = true;
            for (int i = 0;i< key.length();i++){
                char c = key.charAt(i);
                if (!Character.isDigit(c)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                data.put(key, value);
            }
        }
    }

    @Override
    public String find(String key) {
        return data.get(key);
    }

    @Override
    public void remove(String key) {
        data.remove(key);
    }
}

