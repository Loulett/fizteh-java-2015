package ru.fizteh.fivt.students.loulett.ModuleTests.library;

import twitter4j.*;

import java.util.function.Consumer;

/**
 * Created by Sasha on 18.12.2015.
 */
public class StreamTweet {
    private static TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

    public StreamTweet(TwitterStream ts) {
        twitterStream = ts;
    }

    public static void stream(JCommanderPar parameters, Consumer<Status> printer) {
        twitterStream.addListener(new StatusAdapter() {
            @Override
            public void onStatus(Status status) {
                if (!(status.isRetweet() && parameters.isHideRetweets())) {
                    printer.accept(status);
                }
            }
        });

        String[] trackArray = new String[1];
        trackArray[0] = parameters.getQueries();
        FilterQuery filterQuery = new FilterQuery(0, new long[0], trackArray);
        twitterStream.filter(filterQuery);
    }
}
