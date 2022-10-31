package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;
        Map<Integer, String> previousMap = new HashMap<>();
        for (User userMap : previous) {
            previousMap.put(userMap.getId(), userMap.getName());
        }
        for (User user : current) {
            int userId = user.getId();
            if (!previousMap.containsKey(userId)) {
                added++;
            } else {
                if (!user.getName().equals(previousMap.remove(userId))) {
                    changed++;
                }
            }
        }
        deleted = previousMap.size();
        return new Info(added, changed, deleted);
    }
}
