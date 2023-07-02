package com.hwc.isl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class InterSysLinkCloser implements ApplicationListener<ContextClosedEvent> {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// this method called when application is terminated
	// it contanins any closing action
	// etc. check resources, delete any files..
	@Override
	public void onApplicationEvent(final ContextClosedEvent event) {
		this.LOGGER.info("End InterSysLink application");
	}
}