package com.tuang.test.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ContextResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import com.tuang.test.ResourceLoader;

public class DefualtResourceLoader implements ResourceLoader{

	@Nullable
	private ClassLoader classLoader;
	
	private final Set<ProtocolResolver> protocolResolvers = new LinkedHashSet<>(4);
	
	private final Map<Class<?>, Map<Resource, ?>> resourcesCaches = new ConcurrentHashMap<>(4);
	
	public DefualtResourceLoader() {
		this.classLoader = ClassUtils.getDefaultClassLoader();
	}
	
	public DefualtResourceLoader(@Nullable ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public void addProtocolResolver(ProtocolResolver resolver) {
		Assert.notNull(resolver, "ProtocolResolver must not be null");
		this.protocolResolvers.add(resolver);
	}
	
	public Collection<ProtocolResolver> getPortocolResolvers(){
		return this.protocolResolvers;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Map<Resource, T> getResourceCache(Class<T> valueType){
		return (Map<Resource, T>) this.resourcesCaches.computeIfAbsent(valueType,
				key -> new ConcurrentHashMap<>());
	}
	
	public void clearResourceCache() {
		this.resourcesCaches.clear();
	}
	
	@Override
	public Resource getResouce(String location) {
		Assert.notNull(location, "location must not bu null");
		
		for(ProtocolResolver resolver : protocolResolvers) {
//			Resource resource = resolver.resolve(location, this);
		}
		
		if(location.startsWith("/")) {
			return getResourceByPath(location);
		}else if(location.startsWith(CLASSPATH_URL_PREFIX)) {
			return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()), getClassLoader());
		}
		else {
			URL url;
			try {
				url = new URL(location);
				return (ResourceUtils.isFileURL(url)? new FileUrlResource(url) : new UrlResource(url) );
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return getResourceByPath(location);
			}
		}
		
	}

	
	
	protected Resource getResourceByPath(String location) {
		return new ClassPathContextResource(location, getClassLoader());
	}

	@Override
	@Nullable
	public ClassLoader getClassLoader() {
		return (this.classLoader != null) ? this.classLoader : ClassUtils.getDefaultClassLoader() ;
	}
	
	protected static class ClassPathContextResource extends ClassPathResource implements ContextResource{
		
		public ClassPathContextResource(String path, @Nullable ClassLoader classLoader) {
			super(path, classLoader);
		}
		
		public String getPathWithinContext() {
			return getPath();
		}
		
//		@Override
//		public Resource createRelative(String relativePath) {
//			String pathToUse = StringUtils.applyRelativePath(getPath(), relativePath);
//			return ClassPathContextResource(pathToUse, getClassLoader());
//		}
	}

}
