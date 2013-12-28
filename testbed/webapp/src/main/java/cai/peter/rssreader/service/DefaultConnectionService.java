/***********************************************
 * Copyright (c) 1995-2013 Peter Cai 
 * All rights reserved.
 * 
 * ***************************************************************
 * @Project: 	rssreader
 * @Filename: 	DefaultConnectionService.java
 * @Author:		Peter Cai
 * 
 * @Date: 	Dec 25, 2013
 */
package cai.peter.rssreader.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Peter
 *
 */
public class DefaultConnectionService implements IConnectionService
{
	@Autowired
	IProtocolHandler protocolHandler;
	
	
	@Override
	public IProtocolHandler getHandler(URI uri)
	{
		/*
		 * TODO: get protocol hander by uri
		 */
		return protocolHandler;
	}
}
