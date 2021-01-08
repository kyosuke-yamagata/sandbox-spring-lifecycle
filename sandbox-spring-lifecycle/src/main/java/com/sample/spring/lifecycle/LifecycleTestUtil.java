package com.sample.spring.lifecycle;

public class LifecycleTestUtil {

	public static void threadSleepAndStdout(int millisec,String eventName,String class_name) throws InterruptedException {
		String officialEventName = "";
		switch(eventName) {
			case "CSE":
				officialEventName="ContextStoppedEvent";
			case "CCE":
				officialEventName="ContextClosedEvent";
			break;
		}
		
		System.out.println(officialEventName + " Received 　in Bean:" + class_name);
		Thread.sleep(10000);
		System.out.println(officialEventName + " Completed in Bean:" + class_name);
	}

}
