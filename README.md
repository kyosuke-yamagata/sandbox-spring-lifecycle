# sandbox-spring-lifecycle
sandbox project for Spring Boot Bean Lifecycle

# Console logs
・コメント無し版  
https://github.com/kyosuke-yamagata/sandbox-spring-lifecycle/blob/master/sandbox-spring-lifecycle/log-summary

・コメント付与版

```java
/** ここよりも前は、割愛 **/
2021-01-08 19:32:15.220  INFO 9356 --- [on(8)-127.0.0.1] inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
2021-01-08 19:32:15.223 DEBUG 9356 --- [on(8)-127.0.0.1] ConfigServletWebServerApplicationContext : Closing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@522a32b1, started on Fri Jan 08 19:32:07 GMT+09:00 2021
// AnnotationConfigServletWebServerApplicationContextが出してくれるイベントにhook
// 1.Order 小さい方=100から呼ばれる
Order:100 EventListener called
ContextClosedEvent Received 　in Bean:class com.sample.spring.lifecycle.LifecycleTestServiceHavingSensitiveOrder
ContextClosedEvent Completed in Bean:class com.sample.spring.lifecycle.LifecycleTestServiceHavingSensitiveOrder
Order:200 EventListener called
ContextClosedEvent Received 　in Bean:class com.sample.spring.lifecycle.LifecycleTestServiceHavingSensitiveOrder
ContextClosedEvent Completed in Bean:class com.sample.spring.lifecycle.LifecycleTestServiceHavingSensitiveOrder
// 2.Order 付けてない場合、@Componentが優先で呼ばれる...ようだ
Component Bean called
ContextClosedEvent Received 　in Bean:class com.sample.spring.lifecycle.ContextStopEventHandler
ContextClosedEvent Completed in Bean:class com.sample.spring.lifecycle.ContextStopEventHandler
// 3.Order 付けてないService
non Order EventListener called
ContextClosedEvent Received 　in Bean:class com.sample.spring.lifecycle.LifecycleTestService
ContextClosedEvent Completed in Bean:class com.sample.spring.lifecycle.LifecycleTestService
// x.DefaultLifecycleProcessor以降が動く
2021-01-08 19:32:55.251 DEBUG 9356 --- [on(8)-127.0.0.1] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 2147483647
2021-01-08 19:32:55.252  INFO 9356 --- [on(8)-127.0.0.1] o.s.b.w.e.tomcat.GracefulShutdown        : Commencing graceful shutdown. Waiting for active requests to complete
2021-01-08 19:32:55.282  INFO 9356 --- [tomcat-shutdown] o.s.b.w.e.tomcat.GracefulShutdown        : Graceful shutdown complete
2021-01-08 19:32:55.282 DEBUG 9356 --- [tomcat-shutdown] o.s.c.support.DefaultLifecycleProcessor  : Bean 'webServerGracefulShutdown' completed its stop procedure
2021-01-08 19:32:55.282 DEBUG 9356 --- [on(8)-127.0.0.1] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 2147483646
2021-01-08 19:32:55.316 DEBUG 9356 --- [on(8)-127.0.0.1] o.s.c.support.DefaultLifecycleProcessor  : Bean 'webServerStartStop' completed its stop procedure
2021-01-08 19:32:55.317 DEBUG 9356 --- [on(8)-127.0.0.1] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
2021-01-08 19:32:55.317  INFO 9356 --- [on(8)-127.0.0.1] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
// 1:Order 付けたEventListenerメソッド持つクラスPreDestroy
sensitive Order PreDestroy called
PreDestroy Started in Bean:class com.sample.spring.lifecycle.LifecycleTestServiceHavingSensitiveOrder
PreDestroy method Called in Bean:class com.sample.spring.lifecycle.LifecycleTestServiceHavingSensitiveOrder
PreDestroy Completed　in Bean:class com.sample.spring.lifecycle.LifecycleTestServiceHavingSensitiveOrder
// 2:Order 付けてないEventListenerメソッド持つクラスPreDestroy *:開発中、2.と3.は順番が入れ替わること有った気がする
non Order PreDestroy called
PreDestroy Started in Bean:class com.sample.spring.lifecycle.LifecycleTestService
PreDestroy method Called in Bean:class com.sample.spring.lifecycle.LifecycleTestService
PreDestroy Completed　in Bean:class com.sample.spring.lifecycle.LifecycleTestService
// 3:@ComponentクラスPreDestroy *:開発中、2.と3.は順番が入れ替わること有った気がする
Component Bean PreDestroy called
PreDestroy Started in Bean:class com.sample.spring.lifecycle.ContextStopEventHandler
PreDestroy method Called in Bean:class com.sample.spring.lifecycle.ContextStopEventHandler
PreDestroy Completed　in Bean:class com.sample.spring.lifecycle.ContextStopEventHandler
// 4:ご参考...closeメソッドは@Beanで登録したときのみ呼ばれる様子であり、@Serviceでは呼ばれない
```
