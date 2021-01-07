package com.sample.spring.lifecycle;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextStopEventHandler{

	@EventListener
	public void onApplicationEventForCSE(ContextStoppedEvent event) throws InterruptedException {
		System.out.println("ContextStoppedEvent Received");
		Thread.sleep(10000);
		System.out.println("ContextStoppedEvent Completed");
	}

	@EventListener
	public void onApplicationEventForCCE(ContextClosedEvent event) throws InterruptedException {
		System.out.println("ContextClosedEvent Received");
		Thread.sleep(10000);
		System.out.println("ContextClosedEvent Completed");
	}

}
