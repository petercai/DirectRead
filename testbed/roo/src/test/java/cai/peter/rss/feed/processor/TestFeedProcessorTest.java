/***********************************************
 * @Project: 	opml
 * @Filename: 	TestFeedProcessorTest.java
 * @Author:		Peter Cai
 * 
 * @Date/Time: 	Dec 7, 2013 12:55:03 AM
 *
 */
package cai.peter.rss.feed.processor;

import it.sauronsoftware.feed4j.FeedIOException;
import it.sauronsoftware.feed4j.FeedXMLParseException;
import it.sauronsoftware.feed4j.UnsupportedFeedException;

import java.io.IOException;

import org.junit.Test;

public class TestFeedProcessorTest
{
	@Test
	public void testMingpao() throws FeedIOException, FeedXMLParseException, UnsupportedFeedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
	{
		new FeedProcessor().process("http://www.mingpaofun.com/RSS/MingPaoRSS.xml", 
				"cai.peter.rss.feed.processor.MingpaoStripper");
	}
	@Test
	public void testWowebook() throws FeedIOException, FeedXMLParseException, UnsupportedFeedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
	{
		new FeedProcessor().process("http://feeds.feedburner.com/wowebook", 
				"cai.peter.rss.feed.processor.NoStripping");
	}
	@Test
	public void testSmartcanucks() throws FeedIOException, FeedXMLParseException, UnsupportedFeedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
	{
		new FeedProcessor().process("http://feeds2.feedburner.com/smartcanucks", 
				"cai.peter.rss.feed.processor.NoStripping");
	}
	@Test
	public void testAddictivetipsIos() throws FeedIOException, FeedXMLParseException, UnsupportedFeedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
	{
		new FeedProcessor().process("http://feeds.feedburner.com/Addictivetips/iOS", 
				"cai.peter.rss.feed.processor.NoStripping");
	}
	@Test
	public void testAddictivetipsWindows() throws FeedIOException, FeedXMLParseException, UnsupportedFeedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
	{
		new FeedProcessor().process("http://www.addictivetips.com/category/windows-tips/feed/", 
				"cai.peter.rss.feed.processor.NoStripping");
	}
}
