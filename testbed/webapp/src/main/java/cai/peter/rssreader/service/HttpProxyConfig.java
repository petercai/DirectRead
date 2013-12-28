/***********************************************
 * Copyright (c) 1995-2013 Peter Cai 
 * All rights reserved.
 * 
 * ***************************************************************
 * @Project: 	rssreader
 * @Filename: 	HttpProxyConfig.java
 * @Author:		Peter Cai
 * 
 * @Date: 	Dec 26, 2013
 *
 */
package cai.peter.rssreader.service;

/**
 * @author Peter
 *
 */
public class HttpProxyConfig
{
	String host;
	int port;
	public String getHost()
	{
		return host;
	}
	public void setHost(String host)
	{
		this.host = host;
	}
	public int getPort()
	{
		return port;
	}
	public void setPort(int port)
	{
		this.port = port;
	}
}
