## 工程简介

Spring Boot 边学边敲——[视频教程](https://www.bilibili.com/video/BV1Et411Y7tQ?p=1)

## 模块简介

### 01-hello-world

体验 Spring Boot 工程的创建过程。

### 02-config

感受配置文件要点

### 03-log

spring boot 日志框架的简单使用。

### 04-web

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

#### 04-web-jsp

将工程打包成 war 包，使用外部而不是内嵌的 tomcat，这样可以完美支持 jsp。

### 05-jdbc

springboot 使用原生 jdbc 对数据库操作。

#### 05-jdbc-druid

将默认数据源换成 druid 数据源，并且简单的实现数据源的监控。

#### 05-jdbc-mybatis

spring boot 整合 mybatis。

### 05-jdbc-jpa

springboot 整合 Spring Data JPA。

### 06-cache

主要涉及：
 - spring 缓存抽象的注解的使用；
 - 整合 redis。
 
### 07-message-amqp

主要是 springboot 与 rabbitmq 的整合。

### 08-search-elastic

主要是 springboot 与 ElasticSearch 的整合。
ElasticSearch 博大精深，这只是试水而已。

### 09-task

包括：
- 异步任务
- 定时任务
- 邮件任务

### 10-security

使用 spring security 框架实现：
- 授权
- 认证
- 页面定制等

PS.页面来自拷贝

### 11-distributed

整合分布式

#### 11-distributed-dubbo

整合 ZooKeeper + dubbo 包括两部分
- provider: 11-distributed-dubbo-provider-ticket
- consumer: 11-distributed-dubbo-consumer-user

#### 11-distributed-springcloud

整合 spring cloud 包括三部分：
- 注册中心：11-distributed-springcloud-eureka-server
- provider: 11-distributed-springcloud-provider-ticket
- consumer: 11-distributed-springcloud-consumer-user