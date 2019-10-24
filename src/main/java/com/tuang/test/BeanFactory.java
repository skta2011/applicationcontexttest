package com.tuang.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

public interface BeanFactory {

	String FACTORY_BEAN_PREFIX = "&";
	
	Object getBean(String name) throws BeansException;
	
	<T> T getBean(String name, Class<T> requiredType) throws BeansException;
	
	Object getBean(String name,Object... args) throws BeansException;
	
	<T> T getBean(Class<T> requiredType) throws BeansException;
	
	<T> T getBean(Class<T> requiredType, Object... args) throws BeansException;
	
	boolean containsBean(String name);
	
	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;
	
	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;
	
	boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;
	
	boolean isTypeMatch(String name, @Nullable Class<?> typeToMatch) throws NoSuchBeanDefinitionException;
	
	@Nullable
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;
	
	String[] getAliases(String name);
}
