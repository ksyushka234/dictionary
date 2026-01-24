package dictionary;

import dictionary.impl.DigitDictionary;
import dictionary.impl.LatinDictionary;
import dictionary.io.DictionaryFileLoader;
import dictionary.service.DictionaryService;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DictionaryService latin = new LatinDictionary();
        DictionaryService digit = new DigitDictionary();
        DictionaryFileLoader.loadFromFile(latin, "latin.txt");
        DictionaryFileLoader.loadFromFile(digit, "digit.txt");
        System.out.println("LATIN DICTIONARY:");
        System.out.println(latin.getAll());
        System.out.println("DIGIT DICTIONARY:");
        System.out.println(digit.getAll());
    }
}
