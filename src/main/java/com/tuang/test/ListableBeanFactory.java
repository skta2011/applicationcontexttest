package com.tuang.test;

import java.lang.annotation.Annotation;
import java.util.Map;

import javax.validation.constraints.Null;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

public interface ListableBeanFactory extends BeanFactory{
	
	boolean containsBeanDefinition(String beanName);
	
	int getBeanDefinitionCount();
	
	String[] getBeanDefinitionNames();
	
	String[] getBeanNamesForType(@Nullable ResolvableType resolvableType);
	
	String[] getBeanNamesForType(@Nullable Class<?> type);
	
	String[] getBeanNamesForType(@Nullable Class<?> type, boolean includeNonSingletons, boolean allowEagerInit);
	
	<T> Map<String, T> getBeansOfType(@Nullable Class<T> type );
	
	<T> Map<String, T> getBeansOfType(@Nullable Class<T> type, boolean includeNonSingletons, boolean allowEagerInit );
	
	String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationClass);
	
	Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationClass) throws BeansException;
	
	@Nullable
	<A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType) throws NoSuchBeanDefinitionException;
	
	
}
