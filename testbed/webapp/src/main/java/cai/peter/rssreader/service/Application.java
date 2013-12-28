/***********************************************
 * Copyright (c) 1995-2013 Peter Cai 
 * All rights reserved.
 * 
 * ***************************************************************
 * @Project: 	rssreader
 * @Filename: 	Application.java
 * @Author:		Peter Cai
 * 
 * @Date: 	Dec 26, 2013
 *
 */
package cai.peter.rssreader.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Application implements ApplicationContextAware
{
	static ApplicationContext context = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException
	{
		context = applicationContext;
	}
	
	public static IConnectionService getConnectionService()
	{
		return context.getBean(IConnectionService.class);
	}
}
