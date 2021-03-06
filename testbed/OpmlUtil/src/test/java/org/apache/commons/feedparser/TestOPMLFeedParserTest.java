package org.apache.commons.feedparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cai.peter.directread.model.Group;
import cai.peter.rss.OPMLProcessor;

public class TestOPMLFeedParserTest
{
	/**
	 * Logger for this class
	 */
	private static final Logger	logger		= Logger.getLogger(TestOPMLFeedParserTest.class);
//	String opmlFile = "org/apache/commons/feedparser/christian1.opml";
//	String opmlFile = "org/apache/commons/feedparser/subscriptions.xml";
	String opmlFile = "org/apache/commons/feedparser/rssowl.opml";
	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

	@Test
	public void testParse() throws FeedParserException, IOException, JDOMException
	{
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(opmlFile);
        Group root = new OPMLProcessor().process(is);
        logger.info("testParse() - Group root=" + root);
        printGroup(root.getGroups());
	}
	
	void printGroup(List<Group> groups)
	{
		for( Group group : groups)
		{
			logger.info("testParse() - Group group=" + group);
			printGroup(group.getGroups());
			
		}
	}
}
