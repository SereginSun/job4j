package ru.job4j.design.srp;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * class ReportEngineTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 15.06.2020
 */
public class ReportEngineTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine report = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary").append(LN)
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(LN);
        assertThat(report.generate(employee -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedHTML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report itReport = new ITReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>").append(LN)
                .append("<html>").append(LN)
                .append("<head>").append(LN)
                .append("<title>").append("Report for IT department")
                .append("</title>").append(LN)
                .append("<meta charset=\"utf-8\">").append(LN)
                .append("</head>").append(LN)
                .append("<body>").append(LN)
                .append("<table>").append(LN)
                .append("<tr>").append(LN)
                .append("<th>").append("Name").append("</th>").append(LN)
                .append("<th>").append("Hired").append("</th>").append(LN)
                .append("<th>").append("Fired").append("</th>").append(LN)
                .append("<th>").append("Salary").append("</th>").append(LN)
                .append("</tr>").append(LN)
                .append("<tr>").append(LN)
                .append("<td>").append(worker.getName()).append("</td>").append(LN)
                .append("<td>").append(worker.getHired()).append("</td>").append(LN)
                .append("<td>").append(worker.getFired()).append("</td>").append(LN)
                .append("<td>").append(worker.getSalary()).append("</td>").append(LN)
                .append("</tr>").append(LN)
                .append("</table>").append(LN)
                .append("</body>").append(LN)
                .append("</html>");
        assertThat(itReport.generate(employee -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedAccountingReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report accReport = new AccReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary").append(LN)
                .append(worker.getName()).append(";").append(LN)
                .append(worker.getHired()).append(";").append(LN)
                .append(worker.getFired()).append(";").append(LN)
                .append(new BigDecimal(worker.getSalary() / 69.58)).append("$");
        assertThat(accReport.generate(employee -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedHRReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Ivan", now, now, 100);
        Employee workerSecond = new Employee("Petr", now, now, 300);
        Employee workerThird = new Employee("Vladimir", now, now, 250);
        store.add(workerFirst);
        store.add(workerSecond);
        store.add(workerThird);
        Report hrReport = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary").append(LN)
                .append(workerSecond.getName()).append(";").append(workerSecond.getSalary()).append(LN)
                .append(workerThird.getName()).append(";").append(workerThird.getSalary()).append(LN)
                .append(workerFirst.getName()).append(";").append(workerFirst.getSalary()).append(LN);
        assertThat(hrReport.generate(employee -> true), is(expect.toString()));
    }

}