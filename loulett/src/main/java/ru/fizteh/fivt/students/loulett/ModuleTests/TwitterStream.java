package ru.fizteh.fivt.students.loulett.ModuleTests;


import com.beust.jcommander.JCommander;
import ru.fizteh.fivt.students.loulett.ModuleTests.library.JCommanderPar;
import ru.fizteh.fivt.students.loulett.ModuleTests.library.TweetPrinter;
import twitter4j.TwitterException;

import static ru.fizteh.fivt.students.loulett.ModuleTests.library.SearchTweets.search;
import static ru.fizteh.fivt.students.loulett.ModuleTests.library.StreamTweet.stream;

/**
 * Created by Sasha on 18.12.2015.
 */
public class TwitterStream {
    public static void main(String[] args) throws TwitterException {
        JCommanderPar jCommanderParameters = new JCommanderPar();
        JCommander jCommander = new JCommander(jCommanderParameters, args);
        if (jCommanderParameters.isHelp()) {
            jCommander.usage();
        }
        TweetPrinter.setStream(jCommanderParameters.isStream());
        if (!jCommanderParameters.isStream()) {
            search(jCommanderParameters, TweetPrinter::print);
        } else{
            stream(jCommanderParameters, TweetPrinter::print);
        }
    }
}
