package com.tuang.test;

import org.springframework.lang.Nullable;

public interface HierarchicalBeanFactory extends BeanFactory{

	@Nullable
	BeanFactory getParentBeanFactory();
	
	boolean containsLocalBean(String name);
}
