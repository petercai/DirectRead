/***********************************************
 * Copyright (c) 1995-2013 Peter Cai 
 * All rights reserved.
 * 
 * ***************************************************************
 * @Project: 	rssreader
 * @Filename: 	IConnectionService.java
 * @Author:		Peter Cai
 * 
 * @Date: 	Dec 25, 2013
 *
 */
package cai.peter.rssreader.service;

import java.net.URI;

public interface IConnectionService
{
	public IProtocolHandler getHandler(URI uri);
}
