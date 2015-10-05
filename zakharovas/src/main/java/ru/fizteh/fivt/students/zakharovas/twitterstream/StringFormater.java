package ru.fizteh.fivt.students.zakharovas.twitterstream;

import twitter4j.Status;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class StringFormater {
    private static final String COLOR_BLUE = "\u001B[34m";
    private static final String COLOR_RESET = "\u001B[0m";
    private static final int MINUTE = 60 * 1000;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;
    private static final String[] ENDING_RETWEETS = {"ретвитов", "ретвит", "ретвита"};
    private static final String[] ENDING_DAYS = {"дней", "день", "дня"};
    private static final String[] ENDING_MUNUTES = {"минут", "минуту", "минуты"};
    private static final String[] ENDING_HOURS = {"часов", "час", "часа"};


    public static String fineWords(int number, String[] endings) {
        number %= Numbers.HUNDRED;
        if (number >= Numbers.ELEVEN
                && number <= Numbers.NINETEEN) {
            return endings[0];
        }
        if (number % Numbers.TEN == Numbers.ZERO) {
            return endings[0];
        } else if (number % Numbers.TEN == Numbers.ONE) {
            return endings[1];
        } else if (number % Numbers.TEN >= Numbers.TWO
                && number % Numbers.TEN <= Numbers.FOUR) {
            return endings[2];
        } else if (number % Numbers.TEN >= Numbers.FIVE) {
            return endings[0];
        }
        return null;

    }

    public static String dateFormater(Date date) {
        LocalDateTime tweetTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime currentTime = LocalDateTime.now();
        long minuteDifference = ChronoUnit.MINUTES.between(tweetTime, currentTime);
        long hourDifference = ChronoUnit.HOURS.between(tweetTime, currentTime);
        long daysDifference = tweetTime.toLocalDate().until(currentTime.toLocalDate(), ChronoUnit.DAYS);
        if (minuteDifference < Numbers.NOW_CONSTANT) {
            return "только что";
        }
        if (daysDifference == 0) {
            //today
            if (hourDifference == 0) {
                return minuteDifference + " " + fineWords((int) minuteDifference, ENDING_MUNUTES) + " назад";
            }
            return hourDifference + " " + fineWords((int) hourDifference, ENDING_HOURS) + " назад";
        } else if (daysDifference == 1) {
            return "вчера";
        }
        return daysDifference + " " + fineWords((int) daysDifference, ENDING_DAYS) + " назад";

    }

    public static String tweetForOutput(Status tweet) {
        return dateFormater(tweet.getCreatedAt()) + tweetForOutputWithoutDate(tweet);

    }

    public static String tweetForOutputWithoutDate(Status tweet) {
        String formatedTweet = "";
        if (!tweet.isRetweet()) {
            formatedTweet += COLOR_BLUE
                    + " @" + tweet.getUser().getName() + COLOR_RESET + ": "
                    + tweet.getText();
            if (tweet.getRetweetCount() > 0) {
                formatedTweet += "(" + tweet.getRetweetCount() + " "
                        + fineWords(tweet.getRetweetCount(), ENDING_RETWEETS) + ")";
            }
        } else {
            formatedTweet += COLOR_BLUE
                    + " @" + tweet.getUser().getName() + COLOR_RESET + ": "
                    + "ретвитнул " + COLOR_BLUE + "@"
                    + tweet.getRetweetedStatus().getUser().getName() + COLOR_RESET
                    + ": " + tweet.getRetweetedStatus().getText();
        }
        return formatedTweet;
    }
}
