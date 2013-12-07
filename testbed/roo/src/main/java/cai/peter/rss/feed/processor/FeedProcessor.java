package cai.peter.rss.feed.processor;


import it.sauronsoftware.feed4j.FeedIOException;
import it.sauronsoftware.feed4j.FeedParser;
import it.sauronsoftware.feed4j.FeedXMLParseException;
import it.sauronsoftware.feed4j.UnsupportedFeedException;
import it.sauronsoftware.feed4j.bean.Feed;
import it.sauronsoftware.feed4j.bean.FeedHeader;
import it.sauronsoftware.feed4j.bean.FeedItem;

import java.io.IOException;
import java.net.URL;

import org.jsoup.nodes.Element;

public class FeedProcessor
{
	public void process(String siteUrl, String className) throws FeedIOException, FeedXMLParseException, UnsupportedFeedException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Feed feed = FeedParser.parse(new URL(siteUrl));
		System.out.println("** HEADER **");
		FeedHeader header = feed.getHeader();
		System.out.println("Title: " + header.getTitle());
		System.out.println("Link: " + header.getLink());
		System.out.println("Description: " + header.getDescription());
		System.out.println("Language: " + header.getLanguage());
		System.out.println("PubDate: " + header.getPubDate());
		System.out.println("** ITEMS **");
		int items = feed.getItemCount();
		for (int i = 0; i < items; i++)
		{
			FeedItem item = feed.getItem(i);
			System.out.println("Title: " + item.getTitle());
			URL link = item.getLink();
//			Class<IStripper> forName = (Class<IStripper>) Class.forName(className);
//			IStripper stripper = forName.newInstance();
//			Element content = stripper.getContent(stripper.getPage(link.toString()));
//			System.out.println(content.parent().html());
			System.out.println("Link: " + link);
			System.out.println("Plain text description: "
					+ item.getDescriptionAsText());
			System.out.println("HTML description: "
					+ item.getDescriptionAsHTML());
			System.out.println("PubDate: " + item.getPubDate());
		}
	}
	
//	public static void main(String[] args) throws Exception
//	{
//		URL url = new URL("http://www.mingpaofun.com/RSS/MingPaoRSS.xml");
//		Feed feed = FeedParser.parse(url);
//		System.out.println("** HEADER **");
//		FeedHeader header = feed.getHeader();
//		System.out.println("Title: " + header.getTitle());
//		System.out.println("Link: " + header.getLink());
//		System.out.println("Description: " + header.getDescription());
//		System.out.println("Language: " + header.getLanguage());
//		System.out.println("PubDate: " + header.getPubDate());
//		System.out.println("** ITEMS **");
//		int items = feed.getItemCount();
//		for (int i = 0; i < items; i++)
//		{
//			FeedItem item = feed.getItem(i);
//			System.out.println("Title: " + item.getTitle());
//			URL link = item.getLink();
//			IStripper ming = new MingpaoStripper(link.toExternalForm());
//			Element content = ming.getContent(ming.getPage(link.toString()));
//			System.out.println(content.parent().html());
//			System.out.println("Link: " + link);
//			System.out.println("Plain text description: "
//					+ item.getDescriptionAsText());
//			System.out.println("HTML description: "
//					+ item.getDescriptionAsHTML());
//			System.out.println("PubDate: " + item.getPubDate());
//		}
//	}
}
