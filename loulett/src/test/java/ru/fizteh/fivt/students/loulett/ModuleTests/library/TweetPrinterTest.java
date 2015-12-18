package ru.fizteh.fivt.students.loulett.ModuleTests.library;

import org.junit.BeforeClass;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter4jTestUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sasha on 18.12.2015.
 */
public class TweetPrinterTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final int HUNDRED = 100;
    public static List<Status> statuses;

    @BeforeClass
    public static void loadSampleData() {
        statuses = Twitter4jTestUtils.tweetsFromJson("/statuses.json");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void statusPrinterTest() throws Exception {
        TweetPrinter.setStream(true);
        TweetPrinter.print(statuses.get(0));
        String expected =
                //new String(new char[HUNDRED]).replace('\0', '-') + '\n' +
                "@QuintetLive : #QuintetLaunch : welddon launched the Sherlock DGAP (Human Solo).\n"
                                .trim();
        String actual = outContent.toString().trim();
        assertEquals(expected, actual);

    }
}
