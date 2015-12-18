package ru.fizteh.fivt.students.loulett.ModuleTests.library;

import com.beust.jcommander.JCommander;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Sasha on 18.12.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class StreamTweetTest {
    @Mock
    twitter4j.TwitterStream twitterStream;

    @InjectMocks
    StreamTweet stream;

    public static List<Status> statuses;

    @BeforeClass
    public static void loadSampleData() {
        statuses = Twitter4jTestUtils.tweetsFromJson("/statuses.json");
    }

    @Test
    public void streamResultTest() throws Exception {
        ArgumentCaptor<StatusListener> statusListener = ArgumentCaptor.forClass(StatusListener.class);
        doNothing().when(twitterStream).addListener((StatusListener) statusListener.capture());
        doAnswer(i -> {
            statuses.forEach(s -> statusListener.getValue().onStatus(s));
            return null;
        }).when(twitterStream).filter(any(FilterQuery.class));

        List<Status> tweets = new ArrayList<>();

        JCommanderPar param = new JCommanderPar();
        String[] args = {"-q", "Sherlock", "-s", "-l", "100", "-p", ""};
        JCommander cmd = new JCommander(param, args);

        stream.stream(param, tweets::add);

        assertTrue(tweets.size() == 13);

        verify(twitterStream).addListener((StatusListener) any(StatusAdapter.class));
        verify(twitterStream).filter(any(FilterQuery.class));
    }
}
