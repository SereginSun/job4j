package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * class XMLReport - XML report for IT.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 17.06.2020
 */

public class XMLReport implements Report {
    private final Store store;

    private static final String LN = System.lineSeparator();

    public XMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("?<xml version=\"1.0\" encoding=\"UNF-8\"?>").append(LN)
                .append("<employee>").append(LN);
        for (Employee employee : store.findBy(filter)) {
            text.append("<name>").append(employee.getName()).append("</name>").append(LN)
                    .append("<hired>").append(employee.getHired().getTime()).append("</hired>").append(LN)
                    .append("<fired>").append(employee.getFired().getTime()).append("</fired>").append(LN)
                    .append("<salary>").append(employee.getSalary()).append("</salary>").append(LN)
                    .append("</employee>");
        }
        return text.toString();
    }
}
