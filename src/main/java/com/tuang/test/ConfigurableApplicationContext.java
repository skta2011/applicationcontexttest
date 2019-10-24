package com.tuang.test;

import java.io.Closeable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.lang.Nullable;

public interface ConfigurableApplicationContext extends ApplicationContext, LifeCycle, Closeable{
	
	String CONFIG_LOCATION_DELIMITERS = ",; \t\n";

	String CONVERSION_SERVICE_BEAN_NAME = "conversionService";
	
	String LOAD_TIME_WEAVER_BEAN_NAME = "loadTimeWeaver";
	
	String ENVIRONMENT_BEAN_NAME = "environment";
	
	String SYSTEM_PROPERTIES_BEAN_NAME = "systemProperties";
	
	String SYSTEM_ENVIRONMENT_BEAN_NAME = "systemEnvironment";
	
	void setId(String id);
	
	void setParent(@Nullable ApplicationContext context);
	
	void setEnvironment(ConfigurableEnvironment environment);
	
	@Override
	ConfigurableEnvironment getEnvironment();
	
	void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);
	
	void addApplicationListener(ApplicationListener<?> listener);
	
	void addProtocolResolver(ProtocolResolver resolver);
	
	void refresh() throws BeansException, IllegalStateException;
	
	void registerShutdownHook();
	
	@Override
	void close();
	
	boolean isActive();
	
	
}
