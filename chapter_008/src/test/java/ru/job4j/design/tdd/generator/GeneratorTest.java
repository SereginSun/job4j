package ru.job4j.design.tdd.generator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void whenGeneratorRun() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String,String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String result = generator.produce(template, args);
        String expected = "I am Petr Arsentev, Who are you?";
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThereAreNoKeys() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String,String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        String result = generator.produce(template, args);
        String expected = "I am Petr Arsentev, Who are ${subject}?";
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThereAreHaveExcessKeys() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String,String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("something", "something");
        String result = generator.produce(template, args);
        String expected = "I am Petr Arsentev, Who are you?";
        assertThat(result, is(expected));
    }
}