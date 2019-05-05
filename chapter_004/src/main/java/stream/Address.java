package stream;

/**
 * class Address.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.05.2019
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartament;

    public Address(String city, String street, int home, int apartament) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartament = apartament;
    }
}