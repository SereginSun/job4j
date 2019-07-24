package ru.job4j.statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class ScriptTest
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.07.2019
 */
public class ScriptTest {
    private Map<Integer, List<Integer>> testMap;
    private Script<Integer> testScript;

    @Before
    public void setUp() {
        testMap = new HashMap<>();
        testScript = new Script<>();
        testMap.put(1, List.of(2, 3));
        testMap.put(2, List.of(4));
        testMap.put(3, List.of(4, 5));
        testMap.put(4, List.of());
        testMap.put(5, List.of());
    }

    @Test
    public void whenScript1ThenListOfDependentScripts12345() {
        assertThat(testScript.load(testMap, 1), is(List.of(2, 3, 4, 5)));
    }

    @Test
    public void whenScript2ThenListOfDependentScripts4() {
        assertThat(testScript.load(testMap, 2), is(List.of(4)));
    }

    @Test
    public void whenScript3ThenListOfDependentScripts45() {
        assertThat(testScript.load(testMap, 3), is(List.of(4, 5)));
    }
}