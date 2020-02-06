### 一、总结@SpringBootApplication启动原理
把bean注册到spring ioc容器。
通过4种方式来实现：
1. @SpringBootConfiguration 通过@Configuration 与@Bean结合，注册到Spring ioc 容器。
2. @ComponentScan  通过范围扫描的方式，扫描特定注解类，将其注册到Spring ioc 容器。
3. @Import 通过导入的方式，将指定的class注入到spring ioc容器里面 。
4. @EnableAutoConfiguration 通过spring.factories的配置，来实现bean的注册到Spring ioc 容器。
