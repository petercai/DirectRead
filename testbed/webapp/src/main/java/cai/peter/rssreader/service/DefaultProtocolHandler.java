/***********************************************
 * Copyright (c) 1995-2013 Peter Cai 
 * All rights reserved.
 * 
 * ***************************************************************
 * @Project: 	rssreader
 * @Filename: 	DefaultProtocolHandler.java
 * @Author:		Peter Cai
 * 
 * @Date: 	Dec 26, 2013
 *
 */
package cai.peter.rssreader.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.protocol.DefaultProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Peter
 *
 */
public class DefaultProtocolHandler implements IProtocolHandler
{
//	@Autowired
	HttpProxyConfig httpProxy;
	
	
	/* (non-Javadoc)
	 * @see cai.peter.rssreader.service.IProtocolHandler#openStream(java.net.URI, java.util.Map)
	 */
	@Override
	public InputStream openStream(URI link, Map<Object, Object> properties)
			throws Exception
	{
		if("file".equals(link.getScheme()))
		{
			File file = new File(link);
			return new BufferedInputStream(new FileInputStream(file));
		}
		
		/*
		 * TODO: SSL
		 */
		
		if( "feed".equals(link.getScheme()))
		{
			Protocol feed = new Protocol("feed", new DefaultProtocolSocketFactory(), 80);
			Protocol.registerProtocol("feed", feed);
		}
		
		/*
		 * http client
		 */
		int timeout = 30000;
		HttpClient httpClient = new HttpClient(new SimpleHttpConnectionManager());
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeout);
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
		

		if( httpProxy != null )
		{
			httpClient.getParams().setAuthenticationPreemptive(true);
			httpClient.getHostConfiguration().setProxy(httpProxy.getHost(), httpProxy.getPort());
		}
		/*
		 * init connection
		 */
		HttpMethodBase method = new GetMethod(link.toString());
		method.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
		
		/*
		 * set headers
		 */
		method.setRequestHeader("Accept-Encoding", "gzip");
		method.setRequestHeader("User-Agent", "DirectRead/1.0 (Windows; U; en)");
		
		method.setFollowRedirects(true);
		
		httpClient.executeMethod(method);
		
		return method.getResponseBodyAsStream();
	}
}
