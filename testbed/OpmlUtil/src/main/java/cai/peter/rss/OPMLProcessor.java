/***********************************************
 * @Project: 	OpmlUtil
 * @Filename: 	OPMLProcessor.java
 * @Author:		Peter Cai
 * 
 * @Date/Time: 	Dec 1, 2013 12:39:29 AM
 *
 */
package cai.peter.rss;

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

import cai.peter.directread.model.Group;
import cai.peter.directread.model.Outline;

public class OPMLProcessor
{
	public OPMLProcessor()
	{
		super();
		root = new Group("root", null);
		currentGroup = root;
	}

	Group root = null, currentGroup = null; 
	
	
	boolean nested = true;
	public Group process(InputStream is) throws JDOMException, IOException, FeedParserException
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
//				System.out.println("title: "+title);
//				System.out.println("feed: "+feed);
				currentGroup.addOutline(new Outline(title, feed));
				nested = false;
			}
			
			public void onFolderEnd() throws FeedParserException
			{
			}
			
			public void onFolder(FeedParserState state, String name)
					throws FeedParserException
			{
				if( !nested )
					currentGroup = currentGroup.getParent();
				Group newGroup = new Group(name, currentGroup);
				currentGroup.addGroup(newGroup);
				currentGroup = newGroup;
			}
		}, doc);

        return root;
	}
}
