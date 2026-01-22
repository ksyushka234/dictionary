package dictionary.impl;

import dictionary.service.DictionaryService;

import java.util.Map;

import java.util.HashMap;

public class LatinDictionary implements DictionaryService {
    Map<String, String> data = new HashMap<>();
    @Override
    public void add(String key, String value) {
        data.put(key, value);
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


