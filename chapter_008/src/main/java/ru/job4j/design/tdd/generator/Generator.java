package ru.job4j.design.tdd.generator;

import java.util.Map;

/**
 * interface Generator.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.08.2020
 */
public interface Generator {

    /**
     * The method replaces the keys in the template with the values ​​in the map by key.
     * @param template - String type template.
     * @param args - Key-value map to replace in a template.
     * @return modified template.
     */
    String produce(String template, Map<String, String> args);
}
