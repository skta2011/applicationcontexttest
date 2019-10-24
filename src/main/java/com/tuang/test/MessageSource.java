package com.tuang.test;

import java.util.Locale;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.lang.Nullable;

public interface MessageSource {

	@Nullable
	String getMessage(String code, @Nullable Object[] args, @Nullable String defaultMessage, Locale locale);
	
	String getMessage(String code, @Nullable Object[] args, Locale locale);
	
	String getMessage(MessageSourceResolvable resolvable, Locale locale);
}
