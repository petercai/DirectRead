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
public class ParseMing {

	/**
	 * @param args
	 * @throws IOException 
	 */
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		File file = new File("C:\\Users\\PCAI01\\Documents\\scrapbook\\data\\20131029161950\\index.html");
//		doc = Jsoup.parse(file, "UTF-8");
//		Elements elements = doc.select("td>font");
//		for( Element e : elements)
//		{
//			System.out.println(new ParseMing().getPath(e));
//			String html = e.parent().html();
//			System.out.print("size[");
//			System.out.print(html.length());
//			System.out.print("]:");
//			System.out.println();
//			System.out.println(html);
//		}
//	}
	
	
	String url;
	private Document doc;
	
	public ParseMing(String url) {
		super();
		this.url = url;
	}

	
	public Document getPage(String url) throws IOException
	{
		return Jsoup.connect(url).get();
	}
	
	public Document getPage(File file) throws IOException
	{
		return Jsoup.parse(file, "UTF-8");
	}
	
	Map<String, Element> elMap = new HashMap<String, Element>();
	Map<String, Integer> pathMap = new HashMap<String, Integer>();
	
	class PathData
	{
		public PathData(String path, Element content, int count) {
			this.path = path;
			this.content = content;
			this.count = count;
		}
		String path;
		Element content;
		int count;
	}
	
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
				
//			System.out.println(path);
//			String html = e.parent().html();
//			System.out.print("size[");
//			System.out.print(html.length());
//			System.out.print("]:");
//			System.out.println();
//			System.out.println(html);
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
