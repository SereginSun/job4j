package ru.job4j.post;

import java.util.*;

/**
 * class MainPost
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.10.2019
 */
public class MainPost {

    public static void main(String[] args) {

        Set<String> mailSet1 = new HashSet<>();
        mailSet1.add("xxx@ya.ru");
        mailSet1.add("foo@gmail.com");
        mailSet1.add("lol@mail.ru");
        User theFirstUser = new User("theFirst", mailSet1);

        Set<String> mailSet2 = new HashSet<>();
        mailSet2.add("foo@gmail.com");
        mailSet2.add("ups@pisem.net");
        User theSecondUser = new User("theSecond", mailSet2);

        Set<String> mailSet3 = new HashSet<>();
        mailSet3.add("xyz@pisem.net");
        mailSet3.add("vasya@pupkin.com");
        User theThirdUser = new User("theThird", mailSet3);

        Set<String> mailSet4 = new HashSet<>();
        mailSet4.add("ups@pisem.net");
        mailSet4.add("aaa@bbb.ru");
        User theFourthUser = new User("theFourth", mailSet4);

        Set<String> mailSet5 = new HashSet<>();
        mailSet5.add("xyz@pisem.net");
        User theFifthUser = new User("theFifth", mailSet5);

        List<User> userList = new ArrayList<>();
        userList.add(theFirstUser);
        userList.add(theSecondUser);
        userList.add(theThirdUser);
        userList.add(theFourthUser);
        userList.add(theFifthUser);

        List<User> result = new Merger().mergeUsersByEmail(userList);
        System.out.println(result);
    }
}