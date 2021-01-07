# sandbox-spring-lifecycle
sandbox project for Spring Boot Bean Lifecycle

# Console logs

```java
2021-01-07 23:27:17.584  INFO 4732 --- [on(8)-127.0.0.1] inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
2021-01-07 23:27:17.588 DEBUG 4732 --- [on(8)-127.0.0.1] ConfigServletWebServerApplicationContext : Closing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@522a32b1, started on Thu Jan 07 23:27:10 GMT+09:00 2021
ContextClosedEvent Received
ContextClosedEvent Completed
ContextClosedEvent Received:in bean
ContextClosedEvent Completed:in bean
2021-01-07 23:27:37.615 DEBUG 4732 --- [on(8)-127.0.0.1] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 2147483647
2021-01-07 23:27:37.616  INFO 4732 --- [on(8)-127.0.0.1] o.s.b.w.e.tomcat.GracefulShutdown        : Commencing graceful shutdown. Waiting for active requests to complete
2021-01-07 23:27:37.629  INFO 4732 --- [tomcat-shutdown] o.s.b.w.e.tomcat.GracefulShutdown        : Graceful shutdown complete
2021-01-07 23:27:37.629 DEBUG 4732 --- [tomcat-shutdown] o.s.c.support.DefaultLifecycleProcessor  : Bean 'webServerGracefulShutdown' completed its stop procedure
2021-01-07 23:27:37.629 DEBUG 4732 --- [on(8)-127.0.0.1] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 2147483646
2021-01-07 23:27:37.675 DEBUG 4732 --- [on(8)-127.0.0.1] o.s.c.support.DefaultLifecycleProcessor  : Bean 'webServerStartStop' completed its stop procedure
2021-01-07 23:27:37.676 DEBUG 4732 --- [on(8)-127.0.0.1] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
2021-01-07 23:27:37.676  INFO 4732 --- [on(8)-127.0.0.1] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
testPreDestroy method Called
testPreDestroy Completed:in bean
close method Called
```
