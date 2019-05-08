package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class ProfileTest.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.05.2019
 */
public class ProfileTest {

    @Test
    public void whenGetAddressListFromProfileList() {
        Address firstAddress = new Address("Moscow", "3rd Street Stroiteley", 25, 12);
        Address secondAddress = new Address("Voronezh", "Koltsovskaya", 35, 101);
        Address thirdAddress = new Address("St.Petersburg", "3rd Street Stroiteley", 25, 12);
        List<Profile> profileList = Arrays.asList(
                new Profile(firstAddress), new Profile(secondAddress), new Profile(thirdAddress)
        );
        List<Address> expected = Arrays.asList(firstAddress, secondAddress, thirdAddress);
        List<Address> result = new Profile().collect(profileList);
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetUniqueAddressListFromProfileList() {
        Address firstAddress = new Address("Moscow", "3rd Street Stroiteley", 25, 12);
        Address secondAddress = new Address("Rostov-on-don", "Zoological", 26, 3);
        Address thirdAddress = new Address("Voronezh", "Koltsovskaya", 35, 101);
        Address fourthAddress = new Address("Moscow", "3rd Street Stroiteley", 25, 12);
        Address fifthAddress = new Address("Rostov-on-don", "Zoological", 26, 3);
        List<Profile> profileList = Arrays.asList(
                new Profile(firstAddress),
                new Profile(secondAddress),
                new Profile(thirdAddress),
                new Profile(fourthAddress),
                new Profile(fifthAddress)
        );
        List<Address> expected = Arrays.asList(firstAddress, secondAddress, thirdAddress);
        List<Address> result = new Profile().unique(profileList);
        assertThat(result, is(expected));
    }
}