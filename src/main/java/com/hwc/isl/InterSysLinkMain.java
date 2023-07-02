package com.hwc.isl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = { "com.hwc" })
@EnableScheduling
public class InterSysLinkMain {

	public static void main(final String[] args) {
		SpringApplication.run(InterSysLinkMain.class, args);
	}
}
