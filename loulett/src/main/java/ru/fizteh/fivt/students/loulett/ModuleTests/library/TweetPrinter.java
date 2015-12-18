package ru.fizteh.fivt.students.loulett.ModuleTests.library;

import twitter4j.Status;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Sasha on 18.12.2015.
 */
public class TweetPrinter {
    static final int HUNDRED = 100;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private static boolean isStream;

    public static void setStream(boolean s) {
        isStream = s;
    }

    private static void printMinuses() {
        System.out.println(new String(new char[HUNDRED]).replace('\0', '-'));
    }

    private static String retweetsCount(int retweets) {

        return "(" + retweets + " " + RussianEnding.russianEnding(retweets, "ретвит") + ")";
    }

    public static void print(Status status) {
        StringBuilder tweet = new StringBuilder();
        if (!isStream) {
            long tweetTime = status.getCreatedAt().getTime();
            LocalDateTime tweetTime1 = new
                    Date(tweetTime).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime currTime = LocalDateTime.now(ZoneId.systemDefault());
            //tweet.append("[").append(TimeFormatter.timeFromPublish(tweetTime1,
             //       currTime)).append("]");
        }
        tweet.append(" @").append(status.getUser().getScreenName());
        if (status.isRetweet()) {
            tweet.append(" ретвитнул @").append(status.getRetweetedStatus().getUser().getScreenName());
            tweet.append(" : ").append(status.getRetweetedStatus().getText());
        } else {
            tweet.append(" : ").append(status.getText());
            if (status.getRetweetCount() != 0) {
                tweet.append(retweetsCount(status.getRetweetCount()));
            }
        }
        //printMinuses();
        System.out.println(tweet.toString());
    }
}
