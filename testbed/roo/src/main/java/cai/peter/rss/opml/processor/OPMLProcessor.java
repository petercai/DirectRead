/***********************************************
 * @Project: 	OpmlUtil
 * @Filename: 	OPMLProcessor.java
 * @Author:		Peter Cai
 * 
 * @Date/Time: 	Dec 1, 2013 12:39:29 AM
 *
 */
package cai.peter.rss.opml.processor;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.feedparser.FeedDirectoryParserListener;
import org.apache.commons.feedparser.FeedParserException;
import org.apache.commons.feedparser.FeedParserState;
import org.apache.commons.feedparser.FeedVersion;
import org.apache.commons.feedparser.OPMLFeedParser;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import cai.peter.rss.opml.model.Outline;
import cai.peter.rss.opml.model.Tag;

public class OPMLProcessor
{
	/**
	 * Logger for this class
	 */
	private static final Logger	logger	= Logger.getLogger(OPMLProcessor.class);

	public OPMLProcessor()
	{
		super();
	}

	Tag currentTag = null; 
	
	
	public void process(InputStream is) throws JDOMException, IOException, FeedParserException
	{
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
				Outline outline = new Outline(title, feed);
				outline.setHtmUrl(weblog);
				logger.info("process() - Outline outline=" + outline);
				currentTag.addOutline(outline);
				outline.setTag(currentTag);
				outline.persist();
			}
			
			public void onFolderEnd() throws FeedParserException
			{
				if( !currentTag.isRoot())
					currentTag = currentTag.getParent();
			}
			
			public void onFolder(FeedParserState state, String name)
					throws FeedParserException
			{
				Tag newTag = new Tag(name);
				logger.info("process() - Tag newTag=" + newTag);
				if( currentTag != null )
				{
					newTag.setParent(currentTag);
					currentTag.addTag(newTag);
				}
				currentTag = newTag;
				newTag.persist();
			}
		}, doc);
	}
}
