package ru.job4j.condition;
/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question вопрос от клиента.
     * @return ответ.
     */
    public  String answer(String question){
        String rs1 = "Это ставит меня в тупик. Спросите другой вопрос.";
        if("Привет, Бот.".equals(question)){
            rs1 = "Привет, умник.";
        } else if("Пока.".equals(question)){
            rs1 = "До скорой встречи.";
        }
        return rs1;
    }
}
