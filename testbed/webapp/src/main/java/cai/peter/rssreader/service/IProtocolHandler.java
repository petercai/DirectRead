/***********************************************
 * Copyright (c) 1995-2013 Peter Cai 
 * All rights reserved.
 * 
 * ***************************************************************
 * @Project: 	rssreader
 * @Filename: 	IProtocolHandler.java
 * @Author:		Peter Cai
 * 
 * @Date: 	Dec 25, 2013
 */



package cai.peter.rssreader.service;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/**
 * @author Peter
 *
 */
public interface IProtocolHandler
{
	InputStream openStream(URI link, Map<Object, Object> properties) throws Exception;
}
