package ru.job4j.statistics;

import java.util.*;

/**
 * class Script - list of scripts with their dependencies.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.07.2019
 */
public class Script<E> {

    /**
     * This method loads a list of all the scripts that are needed to load the incoming script.
     *
     * @param ds - a container in which key-value pairs are stored,
     * where the key is the incoming script and the value - a list of the scripts dependent on it.
     * @param scriptId - incoming script.
     * @return list of scripts to run the incoming script.
     */
    public List<E> load(Map<E, List<E>> ds, E scriptId) {
        Set<E> resultSet = new HashSet<>();
        List<E> temp = ds.get(scriptId);
        Queue<E> data = new LinkedList<>(temp);
            while (!data.isEmpty()) {
                E index = data.poll();
                resultSet.add(index);
                data.addAll(ds.get(index));
            }
        return new ArrayList<>(resultSet);
    }
}