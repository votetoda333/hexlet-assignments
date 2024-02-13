package exercise;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        int count = 0;
        for (String email : emails) {
            if (email.endsWith("gmail.com") || email.endsWith("yandex.ru") || email.endsWith("hotmail.com")) {
                count++;
            }

        }
        return count;
    }

}
