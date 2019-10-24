package com.tuang.test;

import java.io.IOException;

import org.springframework.core.io.Resource;

public interface ResourcePatternResolver extends ResourceLoader{

	String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
	
	Resource[] getResources(String locationPattern) throws IOException;
}
