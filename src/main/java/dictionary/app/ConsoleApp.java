package dictionary.app;

import dictionary.impl.DigitDictionary;
import dictionary.impl.LatinDictionary;
import dictionary.io.DictionaryFileLoader;
import dictionary.service.DictionaryService;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class ConsoleApp {
    public void run(){
        DictionaryService latin = new LatinDictionary();
        DictionaryService digit = new DigitDictionary();
        DictionaryFileLoader.loadFromFile(latin, "latin.txt");
        DictionaryFileLoader.loadFromFile(digit, "digit.txt");
        System.out.println("LATIN DICTIONARY:");
        System.out.println(latin.getAll());
        System.out.println("DIGIT DICTIONARY:");
        System.out.println(digit.getAll());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите словарь: 1 - Latin, 2 - Digit");
        int choice = scanner.nextInt();
        DictionaryService active;
        String activeFileName;
        if (choice == 1) {
            active = latin;
            activeFileName = "latin.txt";
        } else if (choice == 2) {
            active = digit;
            activeFileName="digit.txt";
        }
        else {
            System.out.println("Ошибка: неверный выбор");
            return;
        }
        System.out.println("Активный словарь: " + (choice == 1 ? "Latin" : "Digit"));
        System.out.println("Вы выбрали: " + choice);
        while (true) {
            System.out.println("Команды:");
            System.out.println("1 - Показать выбранный словарь");
            System.out.println("2 - Найти по ключу");
            System.out.println("3 - Добавить запись");
            System.out.println("4 - Удалить по ключу");
            System.out.println("5 - Показать оба словаря");
            System.out.println("0 - Выход");
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                System.out.println(active.getAll());
            } else if (cmd == 2) {
                System.out.println("Введите ключ:");
                String key = scanner.next();
                String value = active.find(key);

                if (value == null) {
                    System.out.println("Не найдено");
                } else {
                    System.out.println(value);
                }
            } else if (cmd == 3) {
                System.out.println("Введите ключ:");
                String key = scanner.next();

                scanner.nextLine();

                System.out.println("Введите перевод: ");
                String translation = scanner.nextLine();

                active.add(key, translation);
                DictionaryFileLoader.saveToFile(active, activeFileName);
                System.out.println("Проверка: " + active.find(key));
                System.out.println("Добавлено");
            } else if (cmd == 4){
                System.out.println("Введите ключ: ");
                String key = scanner.next();
                active.remove(key);
                DictionaryFileLoader.saveToFile(active, activeFileName);
                System.out.println("Удалено");
            }
            else if (cmd == 5){
                System.out.println("LATIN DICTIONARY:");
                System.out.println(latin.getAll());
                System.out.println("DIGIT DICTIONARY:");
                System.out.println(digit.getAll());
            }

            else if (cmd == 0) {
                break;
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }
}

