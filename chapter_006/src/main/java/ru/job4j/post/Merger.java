package ru.job4j.post;

import java.util.*;

/**
 * class Merger
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.10.2019
 */
public class Merger {

    /**
     * This method implements an algorithm that merges users who have the same email.
     *
     * @param userList - list of users, each of which has a list of emails.
     * @return a list of united users, each of which has a list of emails.
     */
    public List<User> mergeUsersByEmail(List<User> userList) {
        List<User> result = new ArrayList<>();
        result.add(userList.get(0));

        for (User in : userList) {
            boolean flag = true;

            for (User out : result) {
                if (!Collections.disjoint(out.getEmail(), in.getEmail())) {
                    out.getEmail().addAll(in.getEmail());
                    flag = false;
                }
            }

            if (flag) {
                result.add(in);
            }
        }

        return result;
    }
}