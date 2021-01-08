package com.sample.spring.lifecycle;

import javax.annotation.PreDestroy;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


/**
 * @author kyo_y
 * 実行の順序を指定して、EventをListenするクラス.
 * Bean登録は、Configクラスに集約.
 */
@Service
public class LifecycleTestServiceHavingSensitiveOrder{
	
	private String class_name = this.getClass().toString();
	
	@PreDestroy
	public void testPreDestroy() throws InterruptedException {
		System.out.println("sensitive Order PreDestroy called");
		
		System.out.println("PreDestroy Started in Bean:" + class_name);
		
		System.out.println("PreDestroy method Called in Bean:" + class_name);
		Thread.sleep(10000);
		System.out.println("PreDestroy Completed　in Bean:" + class_name);
	}
	
	public void close() {
		System.out.println("close method Called in Bean:" + class_name);
	}
	
	@EventListener
	@Order(100)
	public void onApplicationEventForCSE_Order100(ContextStoppedEvent event) throws InterruptedException {
		System.out.println("Order:100 EventListener called");
		LifecycleTestUtil.threadSleepAndStdout(10000,"CSE", class_name);
	}

	@EventListener
	@Order(200)
	public void onApplicationEventForCSE_Order200(ContextStoppedEvent event) throws InterruptedException {
		System.out.println("Order:200 EventListener called");
		LifecycleTestUtil.threadSleepAndStdout(10000,"CSE", class_name);
	}

	@EventListener
	@Order(100)
	public void onApplicationEventForCCE_Order100(ContextClosedEvent event) throws InterruptedException {
		System.out.println("Order:100 EventListener called");
		LifecycleTestUtil.threadSleepAndStdout(10000,"CCE", class_name);
	}

	@EventListener
	@Order(200)
	public void onApplicationEventForCCE_Order200(ContextClosedEvent event) throws InterruptedException {
		System.out.println("Order:200 EventListener called");
		LifecycleTestUtil.threadSleepAndStdout(10000,"CCE", class_name);
	}

}
