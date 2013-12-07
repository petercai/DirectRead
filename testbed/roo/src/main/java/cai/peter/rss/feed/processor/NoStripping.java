/***********************************************
 * @Project: 	opml
 * @Filename: 	NoStripping.java
 * @Author:		Peter Cai
 * 
 * @Date/Time: 	Dec 7, 2013 1:00:20 AM
 *
 */
package cai.peter.rss.feed.processor;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author Peter
 *
 */
public class NoStripping implements IStripper
{
	/* (non-Javadoc)
	 * @see cai.peter.rss.feed.processor.IStripper#getPage(java.lang.String)
	 */
	@Override
	public Document getPage(String url) throws IOException
	{
		return Jsoup.connect(url).get();
	}

	/* (non-Javadoc)
	 * @see cai.peter.rss.feed.processor.IStripper#getContent(org.jsoup.nodes.Document)
	 */
	@Override
	public Element getContent(Document doc)
	{
		return doc;
	}
}
