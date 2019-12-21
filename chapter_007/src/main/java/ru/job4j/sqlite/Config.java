package ru.job4j.sqlite;

import java.io.InputStream;
import java.util.Properties;

/**
 * class Config
 * Configures settings for connecting to the database
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.12.2019
 */
public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("sqlite.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
