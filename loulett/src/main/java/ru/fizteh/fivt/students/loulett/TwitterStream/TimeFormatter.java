package ru.fizteh.fivt.students.loulett.TwitterStream;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeFormatter {

    public static String timeFromPublish(LocalDateTime tweetTime, LocalDateTime currTime) {
        if (ChronoUnit.MINUTES.between(tweetTime, currTime) < 2) {
            return "Только что";
        } else if (ChronoUnit.HOURS.between(tweetTime, currTime) == 0) {
            long minutes = ChronoUnit.MINUTES.between(tweetTime, currTime);
            return minutes + " " + RussianEnding.russianEnding((int) minutes, "минута") + " назад";
        } else if (ChronoUnit.DAYS.between(tweetTime, currTime) == 0) {
            long hours = ChronoUnit.HOURS.between(tweetTime, currTime);
            return hours + " " + RussianEnding.russianEnding((int) hours, "час") + " назад";
        } else if (ChronoUnit.DAYS.between(tweetTime, currTime) == 1) {
            return "Вчера";
        } else {
            long days = ChronoUnit.DAYS.between(tweetTime, currTime);
            return days + " " + RussianEnding.russianEnding((int) days, "день") + " назад";
        }
    }
}
