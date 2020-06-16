package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * class HRReport - describing the generation of a report for the HR department.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 15.06.2020
 */
public class HRReport implements Report {
    private final Store store;

    private static final String LN = System.lineSeparator();

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary").append(LN);
        List<Employee> workers = store.findBy(filter);
        workers.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee employee: workers) {
            text.append(employee.getName()).append(";").append(employee.getSalary()).append(LN);
        }
        return text.toString();
    }
}
