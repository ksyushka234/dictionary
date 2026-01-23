package dictionary;

import dictionary.impl.LatinDictionary;
import dictionary.service.DictionaryService;

public class DictionaryTest {
    public static void main(String args[]){
        DictionaryService d1 = new LatinDictionary();
                d1.add("lowd","hello");
                d1.find("lowd");
                d1.remove("lowd");
    }
}
