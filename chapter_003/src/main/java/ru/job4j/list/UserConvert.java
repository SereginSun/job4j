package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * class UserConvert
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 22.03.2019
 */
public class UserConvert {

    /**
     * The mathod takes a list of users and converts it
     * to the Map with the Integer id key and the corresponding User.
     * @param list incoming list with type User.
     * @return list Map<Integer, User>.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> mapList = new HashMap<>();
        for (User value : list) {
            mapList.put(value.getId(), value);
        }
        return mapList;
    }
}
