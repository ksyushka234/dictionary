package dictionary.impl;

import dictionary.service.DictionaryService;

import java.util.Map;

import java.util.HashMap;

public class LatinDictionary implements DictionaryService {
    Map<String, String> data = new HashMap<>();
    @Override
    public void add(String key, String value) {

    }

    @Override
    public String find(String key) {
        return "";
    }

    @Override
    public void remove(String key) {
    }
}


