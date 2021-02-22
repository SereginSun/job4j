package ru.job4j.gc.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Cache implementations on SoftReference
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @since 21.02.2021
 */
public class SoftCachedProcessor {
    private final Map<String, SoftReference<String>> storage;
    private final String path;

    public SoftCachedProcessor(String path) {
        this.storage = new HashMap<>();
        this.path = path;
    }

    /**
     * Method for getting the contents of a text file by file name.
     * @param key File name.
     * @return the contents of the text file.
     */
    public String getValue(String key) {
        String strong;
        if (storage.containsKey(key)) {
            strong = storage.get(key).get();
            if (strong == null) {
                strong = loadFile(key);
            }
        } else {
            strong = put(key);
        }
        return strong;
    }

    /**
     * This method adds a key to the map and wraps the contents of the file in a SoftReference.
     * @param key File name.
     * @return the contents of the text file.
     */
    private String put(String key)  {
        String value = loadFile(key);
        storage.put(key, new SoftReference<>(value));
        return value;
    }

    /**
     * This method loads the contents of a text file from a file if it is not in the map.
     * @param fileName File name.
     * @return the contents of the text file.
     */
    private String loadFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.path, fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
                text.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
