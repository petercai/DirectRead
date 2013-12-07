package org.apache.commons.feedparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cai.peter.rss.opml.model.Outline;
import cai.peter.rss.opml.model.Tag;
import cai.peter.rss.opml.processor.OPMLProcessor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class TestOPMLFeedParserTest
{
	/**
	 * Logger for this class
	 */
	private static final Logger	logger		= Logger.getLogger(TestOPMLFeedParserTest.class);
//	String opmlFile = "org/apache/commons/feedparser/christian1.opml";
	String opmlFile = "org/apache/commons/feedparser/subscriptions.xml";
//	String opmlFile = "org/apache/commons/feedparser/rssowl.opml";
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
        new OPMLProcessor().process(is);
	}
	
	
	@Test
	public void testPopulateTree()
	{
		EntityManager entityManager = Tag.entityManager();
		entityManager.createQuery("select t from Tag t left join fetch t.tags").getResultList();
		Tag root = entityManager.find( Tag.class, 1L);
		logger.info("Tag root=" + root.getName());
//		printOutlines(root.getOutlines());;
//		List<Tag> tags = root.getTags();
//		for( Tag t : tags)
//		{
//			printTag(t);
//		}
		
	}
	
	void printTag(Tag tag)
	{
		String tagName = tag.getName();
		logger.info("String tagName=" + tagName);
		printOutlines(tag.getOutlines());
		for( Tag t : tag.getTags())
		{
			printTag(tag);
		}
	}
	
	void printOutlines(Set<Outline> outlines)
	{
		
		for(Outline i : outlines)
		{
			String title = i.getTitle();
			logger.info("String title=" + title);
			String url = i.getUrl();
			logger.info("String url=" + url);
		}
	}
	
}
