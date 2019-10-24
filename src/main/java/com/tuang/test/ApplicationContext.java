package com.tuang.test;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.lang.Nullable;

public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
	MessageSource, ApplicationEventPublisher, ResourcePatternResolver{

	@Nullable
	String getId();
	
	String getApplicationName();
	
	String getDisplayName();
	
	long getStartupDate();
	
	@Nullable
	ApplicationContext getParent();
	
	AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;
	
}
