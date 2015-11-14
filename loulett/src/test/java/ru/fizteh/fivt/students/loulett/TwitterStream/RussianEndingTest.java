package ru.fizteh.fivt.students.loulett.TwitterStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sasha on 10.11.2015.
 */
public class RussianEndingTest {

    @Test
    public void testRussianEndingMinutes() throws Exception {
        Assert.assertEquals("минут", RussianEnding.russianEnding(0, "минута"));
        Assert.assertEquals("минуту", RussianEnding.russianEnding(1, "минута"));
        Assert.assertEquals("минуты", RussianEnding.russianEnding(2, "минута"));
        Assert.assertEquals("минуты", RussianEnding.russianEnding(3, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(5, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(7, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(10, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(11, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(12, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(14, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(18, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(20, "минута"));
        Assert.assertEquals("минуту", RussianEnding.russianEnding(21, "минута"));
        Assert.assertEquals("минуты", RussianEnding.russianEnding(32, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(55, "минута"));
        Assert.assertEquals("минуту", RussianEnding.russianEnding(121, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(500, "минута"));
        Assert.assertEquals("минуты", RussianEnding.russianEnding(672, "минута"));
        Assert.assertEquals("минут", RussianEnding.russianEnding(765, "минута"));
    }

    @Test
    public void testRussianEndingDays() throws Exception {
        Assert.assertEquals("дней", RussianEnding.russianEnding(0, "день"));
        Assert.assertEquals("день", RussianEnding.russianEnding(1, "день"));
        Assert.assertEquals("дня", RussianEnding.russianEnding(2, "день"));
        Assert.assertEquals("дня", RussianEnding.russianEnding(3, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(5, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(7, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(10, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(11, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(12, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(14, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(18, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(20, "день"));
        Assert.assertEquals("день", RussianEnding.russianEnding(21, "день"));
        Assert.assertEquals("дня", RussianEnding.russianEnding(32, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(55, "день"));
        Assert.assertEquals("день", RussianEnding.russianEnding(121, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(500, "день"));
        Assert.assertEquals("дня", RussianEnding.russianEnding(672, "день"));
        Assert.assertEquals("дней", RussianEnding.russianEnding(765, "день"));
    }

    @Test
    public void testRussianEndingHours() throws Exception {
        Assert.assertEquals("часов", RussianEnding.russianEnding(0, "час"));
        Assert.assertEquals("час", RussianEnding.russianEnding(1, "час"));
        Assert.assertEquals("часа", RussianEnding.russianEnding(2, "час"));
        Assert.assertEquals("часа", RussianEnding.russianEnding(3, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(5, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(7, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(10, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(11, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(12, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(14, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(18, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(20, "час"));
        Assert.assertEquals("час", RussianEnding.russianEnding(21, "час"));
        Assert.assertEquals("часа", RussianEnding.russianEnding(32, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(55, "час"));
        Assert.assertEquals("час", RussianEnding.russianEnding(121, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(500, "час"));
        Assert.assertEquals("часа", RussianEnding.russianEnding(672, "час"));
        Assert.assertEquals("часов", RussianEnding.russianEnding(765, "час"));
    }

    @Test
    public void testRussianEndingRetweets() throws Exception {
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(0, "ретвит"));
        Assert.assertEquals("ретвит", RussianEnding.russianEnding(1, "ретвит"));
        Assert.assertEquals("ретвита", RussianEnding.russianEnding(2, "ретвит"));
        Assert.assertEquals("ретвита", RussianEnding.russianEnding(3, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(5, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(7, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(10, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(11, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(12, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(14, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(18, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(20, "ретвит"));
        Assert.assertEquals("ретвит", RussianEnding.russianEnding(21, "ретвит"));
        Assert.assertEquals("ретвита", RussianEnding.russianEnding(32, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(55, "ретвит"));
        Assert.assertEquals("ретвит", RussianEnding.russianEnding(121, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(500, "ретвит"));
        Assert.assertEquals("ретвита", RussianEnding.russianEnding(672, "ретвит"));
        Assert.assertEquals("ретвитов", RussianEnding.russianEnding(765, "ретвит"));
    }
}
