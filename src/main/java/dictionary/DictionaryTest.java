package dictionary;

import dictionary.impl.DigitDictionary;
import dictionary.impl.LatinDictionary;
import dictionary.io.DictionaryFileLoader;
import dictionary.service.DictionaryService;

    public class DictionaryTest {
        public static void main(String args[]){
            DictionaryService d1 = new LatinDictionary();
            DictionaryFileLoader.loadFromFile(d1, "latin.txt");
            System.out.println(d1.find("abcd"));
            System.out.println(d1.find("test"));
            DictionaryService d2 = new DigitDictionary();
            DictionaryFileLoader.loadFromFile(d2, "digit.txt");
            System.out.println(d2.find("12345"));
            System.out.println(d2.find("00001"));
        }
    }
