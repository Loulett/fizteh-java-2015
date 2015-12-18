package ru.fizteh.fivt.students.loulett.ModuleTests.library;

import twitter4j.*;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Sasha on 18.12.2015.
 */
public class SearchTweets {
    private static Twitter twitter = new TwitterFactory().getInstance();

    public SearchTweets(Twitter tw) {
        twitter = tw;
    }

    public static void search(JCommanderPar parameters, Consumer<Status> printer) throws TwitterException {
        Query query = new Query(parameters.getQueries());
        query.setCount(parameters.getLimit());
        QueryResult result = twitter.search(query);
        List<Status> tweets = result.getTweets();
        int limit = parameters.getLimit();
        Collections.reverse(tweets);
        for (Status status : tweets) {
            if (!(status.isRetweet() && parameters.isHideRetweets())) {
                printer.accept(status);
                limit--;
            }
            if (limit == 0) {
                break;
            }
        }
    }
}
