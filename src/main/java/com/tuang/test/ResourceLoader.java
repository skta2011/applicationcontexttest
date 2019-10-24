package com.tuang.test;

import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.ResourceUtils;

public interface ResourceLoader {

	String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;
	
	Resource getResouce(String location);
	
	@Nullable
	ClassLoader getClassLoader();
}
