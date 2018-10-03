package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

	/**
	 * Test.
	 *
	 * @author Vladimir Seregin (SereginSun@yandex.ru)
	 * @version 1.0.1
	 * @since 03.10.2018
	 */
	public class CalculateTest {
		 /**
		  * Test echo.
		  */
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Vladimir Seregin";
    String expect = "Echo, echo, echo : Vladimir Seregin"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
	}
 
}