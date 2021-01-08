package com.sample.spring.lifecycle;

import javax.annotation.PreDestroy;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author kyo_y
 * EventをListenする場合のServiceクラス.
 * 実行の順序を指定していない.
 * 
 * Bean登録は、Configクラスに集約.
 */
@Service
public class LifecycleTestService {
	
	private String class_name = this.getClass().toString();
	
	@PreDestroy
	public void testPreDestroy() throws InterruptedException {
		System.out.println("non Order PreDestroy called");
		
		System.out.println("PreDestroy Started in Bean:" + class_name);

		System.out.println("PreDestroy method Called in Bean:" + class_name);
		Thread.sleep(10000);
		System.out.println("PreDestroy Completed　in Bean:" + class_name);
	}
	
	public void close() {
		System.out.println("close method Called in Bean:" + class_name);
	}
	
	@EventListener
	public void onApplicationEventForCSE(ContextStoppedEvent event) throws InterruptedException {
		System.out.println("non Order EventListener called");
		LifecycleTestUtil.threadSleepAndStdout(10000,"CSE", class_name);
	}

	@EventListener
	public void onApplicationEventForCCE(ContextClosedEvent event) throws InterruptedException {
		System.out.println("non Order EventListener called");
		LifecycleTestUtil.threadSleepAndStdout(10000,"CCE", class_name);
	}

}
