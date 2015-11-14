package ru.fizteh.fivt.students.loulett.TwitterStream;

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

    }
}
