package org.apache.commons.feedparser;

import java.io.IOException;
import java.io.InputStream;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestOPMLFeedParserTest
{
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
		Document doc = new SAXBuilder().build(is);
        
        OPMLFeedParser.parse(new FeedDirectoryParserListener()
		{
			public void setContext(Object context) throws FeedParserException
			{
			}
			
			public void init() throws FeedParserException
			{
			}
			
			public Object getContext() throws FeedParserException
			{
				return null;
			}
			
			public void finished() throws FeedParserException
			{
			}
			
			public void onImageEnd() throws FeedParserException
			{
			}
			
			public void onImage(FeedParserState state, String title, String link,
					String url) throws FeedParserException
			{
			}
			
			public void onFeedVersion(FeedVersion version) throws FeedParserException
			{
			}
			
			public void onChannelEnd() throws FeedParserException
			{
			}
			
			public void onChannel(FeedParserState state, String title, String link,
					String description) throws FeedParserException
			{
			}
			
			public void onRelationEnd()
			{
			}
			
			public void onRelation(FeedParserState state, String value)
			{
			}
			
			public void onItemEnd() throws FeedParserException
			{
			}
			
			public void onItem(FeedParserState state, String title, String weblog,
					String description, String feed) throws FeedParserException
			{
				System.out.println("title: "+title);
				System.out.println("feed: "+feed);
//				System.out.println("weblog: "+weblog);
//				System.out.println("description: "+description);
			}
			
			public void onFolderEnd() throws FeedParserException
			{
			}
			
			public void onFolder(FeedParserState state, String name)
					throws FeedParserException
			{
						System.out.println(new Object(){}.getClass().getEnclosingMethod().getName()+":"+name);
			}
		}, doc);

	}
}
