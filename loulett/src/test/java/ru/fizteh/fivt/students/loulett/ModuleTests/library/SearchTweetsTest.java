package ru.fizteh.fivt.students.loulett.ModuleTests.library;

import com.beust.jcommander.JCommander;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.Twitter4jTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

/**
 * Created by Sasha on 17.12.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchTweetsTest {
    @Mock
    private Twitter twitter;

    @InjectMocks
    private SearchTweets search;

    public static List<Status> statuses;

    @BeforeClass
    public static void Sample() {
        statuses =  Twitter4jTestUtils.tweetsFromJson("/statuses.json");
    }

    @Before
    public void Start() throws Exception {
        QueryResult queryResult = mock(QueryResult.class);
        when(queryResult.getTweets()).thenReturn(statuses);

        QueryResult emptyResult = mock(QueryResult.class);
        when(emptyResult.getTweets()).thenReturn(new ArrayList<>());

        when(twitter.search(argThat(hasProperty("query", equalTo("Sherlock"))))).thenReturn(queryResult);
        when(twitter.search(argThat(hasProperty("query", not(equalTo(("Sherlock"))))))).thenReturn(emptyResult);
    }

    @Test
    public void testGetTweet() throws Exception {
        JCommanderPar param = new JCommanderPar();
        String[] args = {"-q", "Sherlock", "-l", "100", "-p", ""};
        JCommander cmd = new JCommander(param, args);

        List<Status> tweets = new ArrayList<>();
        search.search(param, tweets::add);
        assertThat(tweets, hasSize(13));

        verify(twitter).search(argThat(hasProperty("query", equalTo("Sherlock"))));
    }

    @Test
    public void testLimit() throws Exception {
        JCommanderPar param = new JCommanderPar();
        String[] args = {"-q", "Sherlock", "-s", "-l", "5", "-p", ""};
        JCommander cmd = new JCommander(param, args);

        List<Status> tweets = new ArrayList<>();
        search.search(param, tweets::add);

        assertThat(tweets, hasSize(5));
        verify(twitter).search(argThat(hasProperty("query", equalTo("Sherlock"))));
    }

    @Test
    public void testEmptyResult() throws Exception {
        JCommanderPar param = new JCommanderPar();
        String[] args = {"-q", "DoctorWho", "-s", "-l", "100", "-p", ""};
        JCommander cmd = new JCommander(param, args);

        List<Status> tweets = new ArrayList<>();
        search.search(param, tweets::add);
        assertThat(tweets, hasSize(0));
    }


}
