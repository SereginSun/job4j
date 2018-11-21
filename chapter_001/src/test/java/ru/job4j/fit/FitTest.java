package ru.job4j.fit;
import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {
    @Test
    public void manWeight() {
        Fit form = new Fit();
        double weight = form.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }
    @Test
    public void womanWeight() {
        Fit form = new Fit();
        double weight = form.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
