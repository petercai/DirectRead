/***********************************************
 * @Project: 	opml
 * @Filename: 	IStripper.java
 * @Author:		Peter Cai
 * 
 * @Date/Time: 	Dec 7, 2013 12:44:31 AM
 *
 */
package cai.peter.rss.feed.processor;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public interface IStripper
{
	public abstract Document getPage(String url) throws IOException;

	public abstract Element getContent(Document doc);
}
