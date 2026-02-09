package dictionary;

import dictionary.app.ConsoleApp;
import dictionary.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ConsoleApp app = context.getBean(ConsoleApp.class);
        app.run();

        context.close();
    }
}