package com.sample.spring.lifecycle;

import javax.annotation.PreDestroy;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

public class LifecycleTestService {
	@PreDestroy
	public static void testPreDestroy() throws InterruptedException {
		System.out.println("testPreDestroy method Called");
		Thread.sleep(10000);
		System.out.println("testPreDestroy Completed:in bean");
	}
	
	public static void close() {
		System.out.println("close method Called");
	}
	
	@EventListener
	public void onApplicationEventForCSE(ContextStoppedEvent event) throws InterruptedException {
		System.out.println("ContextStoppedEvent Received:in bean");
		Thread.sleep(10000);
		System.out.println("ContextStoppedEvent Completed:in bean");
	}

	@EventListener
	public void onApplicationEventForCCE(ContextClosedEvent event) throws InterruptedException {
		System.out.println("ContextClosedEvent Received:in bean");
		Thread.sleep(10000);
		System.out.println("ContextClosedEvent Completed:in bean");
	}

}
