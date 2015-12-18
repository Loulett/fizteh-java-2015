package ru.fizteh.fivt.students.loulett.ModuleTests.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Created by Sasha on 14.11.2015.
 */
public class TimeFormatterTest{

    @Test
    public void testTimeFromatter() throws Exception {
        LocalDateTime start = LocalDateTime.of(2004, Month.MARCH,1, 5, 5, 12);
        LocalDateTime finish = LocalDateTime.of(2004, Month.MARCH, 1, 5, 5, 10);

        Assert.assertEquals("Только что", TimeFormatter.timeFromPublish(finish, start));

        finish = LocalDateTime.of(2004, Month.MARCH, 1, 5, 1, 1);

        Assert.assertEquals("4 минуты назад", TimeFormatter.timeFromPublish(finish, start));

        finish = LocalDateTime.of(2004, Month.MARCH, 1, 4, 1, 12);

        Assert.assertEquals("1 час назад", TimeFormatter.timeFromPublish(finish, start));

        finish = LocalDateTime.of(2004, Month.MARCH, 1, 4, 1, 5);

        Assert.assertEquals("1 час назад", TimeFormatter.timeFromPublish(finish, start));

        finish = LocalDateTime.of(2004, Month.FEBRUARY, 29, 0, 1, 2);

        Assert.assertEquals("Вчера", TimeFormatter.timeFromPublish(finish, start));

        finish = LocalDateTime.of(2003, Month.FEBRUARY, 26, 0, 1, 2);

        Assert.assertEquals("369 дней назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2013, Month.FEBRUARY, 21, 9, 43, 6);
        finish = LocalDateTime.of(2004, Month.SEPTEMBER, 1, 7, 33, 54);
        Assert.assertEquals("3095 дней назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2009, Month.JANUARY, 14, 9, 15, 12);
        finish = LocalDateTime.of(2009, Month.JANUARY, 14, 2, 26, 56);
        Assert.assertEquals("6 часов назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2009, Month.OCTOBER, 18, 7, 30, 39);
        finish = LocalDateTime.of(2004, Month.JULY, 13, 5, 57, 45);
        Assert.assertEquals("1923 дня назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2006, 12, 12, 9, 13, 34);
        finish = LocalDateTime.of(2006, 12, 12, 8, 36, 1);
        Assert.assertEquals("37 минут назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2001, 4, 3, 9, 51, 25);
        finish = LocalDateTime.of(2001, 3, 4, 11, 48, 54);
        Assert.assertEquals("29 дней назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2009, 5, 10, 5, 45, 6);
        finish = LocalDateTime.of(2007, 8, 21, 1, 8, 58);
        Assert.assertEquals("628 дней назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2017, 4, 28, 2, 27, 4);
        finish = LocalDateTime.of(2013, 4, 27, 5, 31, 31);
        Assert.assertEquals("1461 день назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2006, 11, 2, 9, 7, 36);
        finish = LocalDateTime.of(2005, 7, 4, 11, 17, 9);
        Assert.assertEquals("485 дней назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2020, 11, 21, 3, 32, 41);
        finish = LocalDateTime.of(2020, 5, 22, 11, 16, 21);
        Assert.assertEquals("182 дня назад", TimeFormatter.timeFromPublish(finish, start));

        start = LocalDateTime.of(2011, 7, 8, 2, 24, 52);
        finish = LocalDateTime.of(2011, 5, 1, 4, 18, 36);
        Assert.assertEquals("67 дней назад", TimeFormatter.timeFromPublish(finish, start));
    }
}
