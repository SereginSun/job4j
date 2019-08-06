package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * class Config - reads a settings file app.properties
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.08.2019
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * This method reads all keys and values into the values map.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String str;
            while ((str = read.readLine()) != null) {
                if (str.length() != 0 && str.contains("=")) {
                    String[] temp = str.split("=");
                    this.values.put(temp[0].trim(), temp[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the value of property by name of property.
     * @param key - property's name.
     * @return property's value.
     */
    public String value(String key) {
        String result = values.get(key);
        if (result == null) {
            throw new UnsupportedOperationException("Don't impl this method yed!");
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}