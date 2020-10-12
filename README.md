## 工程简介

Spring Boot 边学边敲——[视频教程](https://www.bilibili.com/video/BV1Et411Y7tQ?p=1)

## 模块简介

### hello-world

体验 Spring Boot 工程的创建过程。

### config

感受配置文件要点

### log

spring boot 日志框架的简单使用。

### web

主要涉及的知识点：
1. 静态资源的引入和管理
2. thymeleaf 的简单使用
    - 循环
    - 片段抽取及引用
    - 自定义属性
3. 国际化
    - 切换浏览器语言
    - 超链接切换
4. Restful 风格的增删改查
5. 异常处理
    - 页面定制
    - json 定制
    - 自适应
6. servlet三大组件注册

### web-jsp

将工程打包成 war 包，使用外部而不是内嵌的 tomcat，这样可以完美支持 jsp。

### jdbc

springboot 使用原生 jdbc 对数据库操作。

### druid

将默认数据源换成 druid 数据源，并且简单的实现数据源的监控。

### mybatis

spring boot 整合 mybatis。

### jpa

springboot 整合 Spring Data JPA。

### cache

主要涉及：
 - spring 缓存抽象的注解的使用；
 - 整合 redis。
 
### message-amqp

主要是 springboot 与 rabbitmq 的整合。

### search-elastic

主要是 springboot 与 ElasticSearch 的整合。
ElasticSearch 博大精深，这只是试水而已。

### task

包括：
- 异步任务
- 定时任务
- 邮件任务