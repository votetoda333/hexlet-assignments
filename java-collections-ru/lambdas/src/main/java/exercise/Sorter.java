package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;


public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        List<String> oldestMans = new ArrayList<>();
        users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Comparator.comparing(user -> user.get("birthday")))
                .forEach(user -> oldestMans.add(user.get("name")));

        return oldestMans;


    }
}