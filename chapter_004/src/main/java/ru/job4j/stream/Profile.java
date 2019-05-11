package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class Profile.
 * Customer profile contains his address.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.05.2019
 */
public class Profile {
    private Address address;

    public Profile() {
    }

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * This method returns a data structure with a list of customer addresses.
     *
     * @param profiles Data structure with customer profiles.
     * @return Data structure with addresses of customers obtained from customer profiles.
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    /**
     * This method returns a data structure with a list of unique sorted data.
     *
     * @param profiles Data structure with customer profiles.
     * @return Unique sorted data structure.
     */
    List<Address> unique(List<Profile> profiles) {
        return this.collect(profiles).stream()
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}