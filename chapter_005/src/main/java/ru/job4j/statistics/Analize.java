package ru.job4j.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * class Analize
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.07.2019
 */
public class Analize {

    /**
     * This method returns the difference between the initial state
     * of the collection and the current one.
     * @param previous - initial data.
     * @param current - changed data.
     * @return static class Info which contains information
     * about the difference between the initial and current collection.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info statInfo = new Info();
        Map<Integer, String> allUsers = new HashMap<>();
        for (User index : current) {
            allUsers.put(index.getId(), index.getName());
        }

        for (User index : previous) {
            if (!allUsers.containsKey(index.getId())) {
                statInfo.deleted++;
            } else if (!allUsers.get(index.getId()).equals(index.getName())) {
                statInfo.changed++;
            }
            allUsers.put(index.getId(), index.getName());
        }

        statInfo.added = allUsers.size() - previous.size();

        return statInfo;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
