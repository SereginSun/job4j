package ru.job4j.design.tdd.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class SimpleGenerator.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.08.2020
 */
public class SimpleGenerator implements Generator {
    private final Pattern data = Pattern.compile("\\{.+?\\}");

    @Override
    public String produce(String template, Map<String, String> args) {
        Matcher matcher = data.matcher(template);
        List<String> keys = new ArrayList<>();
        while (matcher.find()) {
            keys.add(template.substring(matcher.start() + 1, matcher.end() - 1));
        }
        for (String key : keys) {
            if (!args.containsKey(key) || args.keySet().size() > keys.size()) {
                throw new IllegalArgumentException("No key for value.");
            }
            template = template.replace(key, args.get(key));
        }
        template = template.replaceAll("\\$\\{|\\}", "");
        return template;
    }
}
