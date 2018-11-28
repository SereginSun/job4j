package ru.job4j.inheritance;
/**
 * Doctor
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 0.0.1
 * @since 28.11.2018
 */
public class Doctor extends Profession {
    /**
     * метод heal - Doctor лечит Patient
     * @param patient - пациент
     * @return sickness - болезнь класса Diagnose
     */
    public Diagnose heal(Patient patient) {
        Diagnose sickness;
        return sickness = new Diagnose();
    }
}
