/***********************************************
 * @Project: 	OpmlUtil
 * @Filename: 	Outline.java
 * @Author:		Peter Cai
 * 
 * @Date/Time: 	Dec 1, 2013 12:23:32 AM
 *
 */
package cai.peter.directread.model;

public class Outline
{
	private String url;
	public Outline(String title, String url )
	{
		super();
		this.url = url;
		this.title = title;
	}
	private String title;
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	/**
	 * @autogenerated by CodeHaggis (http://sourceforge.net/projects/haggis)
	 * @overwrite toString()
	 * @return String returns this object in a String
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Outline::[");
		sb.append(" title:=");
		sb.append(title);
		sb.append(" url:=");
		sb.append(url);
		sb.append(']');
		return sb.toString();
	}
}