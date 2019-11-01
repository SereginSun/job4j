package ru.job4j.post;

import java.io.*;
import java.util.*;

/**
 * class Merger
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.10.2019
 */
public class Merger {
    private Map<String, String> mapIn = new HashMap<>();
    private Map<String, Set<String>> mapOut = new HashMap<>();

    /**
     * This method starts application execution.
     */
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String message = br.readLine();
            while (!"finish".equals(message) && message != null) {
                String userName = message;
                message = br.readLine();
                if (message.length() != 0 && message.matches("^(.+)@(.+)$")) {
                    String[] listEmail = message.split(", ");
                    Set<String> emailHashSet = new HashSet<>(Arrays.asList(listEmail));
                    User user = new User(userName, emailHashSet);
                    String oldUser = null;
                    for (String email : user.getEmail()) {
                        if (mapIn.get(email) == null) {
                            this.mapIn.put(email, userName);
                        } else {
                            oldUser = mapIn.get(email);
                        }
                    }
                    if (oldUser != null) {
                        for (String email : emailHashSet) {
                            this.mapIn.put(email, oldUser);
                        }
                    }
                }
                message = br.readLine();
            }
            mergeUsersByEmail();
            writeResultLog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method implements an algorithm that merges users who have the same email.
     */
    public void mergeUsersByEmail() {

        for (Map.Entry<String, String> entry : mapIn.entrySet()) {
            Set<String> emailSet = new HashSet<>();
            if (mapOut.get(entry.getValue()) == null) {
                emailSet.clear();
                emailSet.add(entry.getKey());
                mapOut.put(entry.getValue(), emailSet);
            } else {
                emailSet = mapOut.get(entry.getValue());
                emailSet.add(entry.getKey());
                mapOut.put(entry.getValue(), emailSet);
            }
        }
    }

    /**
     * This method writes merged users by e-mail to the console.
     */
    public void writeResultLog() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (Map.Entry<String, Set<String>> entry : mapOut.entrySet()) {
                bw.write(entry.getKey() + '\n' + entry.getValue() + '\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}