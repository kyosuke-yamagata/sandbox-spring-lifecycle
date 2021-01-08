package com.sample.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kyo_y
 *当初は、ただのBeanとして登録していた.<br>
 *<code>@Service</code>を用いた場合にも、普通にListener動いたのでコメントアウト.<br>
 *<br>
 *なお、複数回、コメントアウトを外して実行してみた限りでは<br>
 *<code>@Bean</code>を用いた場合も<br>
 *Order指定が同値となっている箇所を除いて、<br>
 *Order指定の順番で各種メソッドが呼ばれているように見受けられる。
 */
@Configuration
public class AppConfig {
	/*
	 * @Bean public LifecycleTestService transferService() { return new
	 * LifecycleTestService(); }
	 * 
	 * @Bean public LifecycleTestServiceHavingSensitiveOrder
	 * transferServiceHavingSensitiveOrder() { return new
	 * LifecycleTestServiceHavingSensitiveOrder(); }
	 */    
}
