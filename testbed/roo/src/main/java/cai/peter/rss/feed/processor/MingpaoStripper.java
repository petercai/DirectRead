package cai.peter.rss.feed.processor;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 */

/**
 * @author pcai01
 *
 */
public class MingpaoStripper implements IStripper {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	public MingpaoStripper() {
		super();
	}

	
	/* (non-Javadoc)
	 * @see cai.peter.rss.feed.processor.IStripper#getPage(java.lang.String)
	 */
	@Override
	public Document getPage(String url) throws IOException
	{
		return Jsoup.connect(url).get();
	}

	
	Map<String, Element> elMap = new HashMap<String, Element>();
	Map<String, Integer> pathMap = new HashMap<String, Integer>();

	
	/* (non-Javadoc)
	 * @see cai.peter.rss.feed.processor.IStripper#getContent(org.jsoup.nodes.Document)
	 */
	@Override
	public Element getContent(Document doc)
	{
		Elements elements = doc.select("td>font");
		for( Element e : elements)
		{
			String path = getPath(e);
			if( pathMap.containsKey(path))
				pathMap.put(path, pathMap.get(path)+1);
			else
			{
				pathMap.put(path, 1);
				elMap.put(path, e);
			}
		}
		
		int top = 0;
		String topPath = null;
		for(String path : pathMap.keySet())
		{
			Integer count = pathMap.get(path);
			if( count>top) {
				top =  count;
				topPath = path;
			} 
		}
		
		return elMap.get(topPath);
	}
	
	public String getPath(Element el)
	{
		StringBuilder sb = new StringBuilder();
		
		Elements parents = el.parents();
		Collections.reverse(parents);
		for( Element p : parents)
		{
			sb.append("/"+p.tagName());
			if( p.siblingElements().size() > 0 )
				sb.append("["+p.elementSiblingIndex()+"]");
		}
		
		return sb.toString();
	}
	
}
