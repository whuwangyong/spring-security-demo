# 说明

本项目主要利用Spring Security实现登录和权限管理。

- 主页面无需登录；

- 拥有`USER`权限的普通用户（如小王）登陆后可以修改自己的用户信息（如手机号）；
- 拥有`ADMIN`权限的管理员（如张小龙）可以修改员工的薪酬；但是操作会被审计系统记录；
- 拥有`ROOT`权限的超级管理员（如马化腾）不能修改员工的薪酬，但是能审计张小龙的操作；



## 编译 &  运行
程序完整运行需要数据库和Kafka。

默认不启动Kafka组件，将自带的数据(位于`src\main\resources\sql\`)导入数据库即可运行。
```bash
> gradle build
> cd build\libs
> java -jar spring-security-demo-0.0.4-SNAPSHOT.jar
```

所有账户登录密码为`123456`，数据库中存储的是密文。

### 如果你要启用Kafka

Kafka起的作用是，管理员在修改员工的工资时，会发一条消息到Kafka，记录这个操作。

另外有个消费者，读取这个消息，并写到数据库中。

如果有Kafka的环境，修改以下三个地方，即可连接到你的Kafka：

1. 撤销配置文件`application.properties`中Kafka相关注释；

2. 撤销`cn.whu.wy.usermanager.controller.SalaryManageController.java`中下面代码的注释：

   ```java
   auditService.writeLog(OperationLog.builder()
   	.dateTime(LocalDateTime.now())
   	.operation("name=" + user.getName() + ",salary=" + user.getSalary())
   	.operator("张小龙")
   	.build());
   ```

3. 撤销`cn.whu.wy.usermanager.service.Receiver.java`文件中对`@Component`的注释。



# 遇到的坑

## 1. ajax post提交遇到403  
本次使用的Thymeleaf 模板，在表单中使用 `<form th:action`，将在页面自动生成`<input name="_csrf"`   

解决（二选一）：  

1. 在ajax的url中补全csrf

2. 禁用CSRF    
    ```java
    http.csrf().disable();
    ```

第一种没尝试成功，暂时采用第二种。

## 2. 静态资源无法加载

spring secutiry 默认保护了静态资源，因此，在登录之前，css、nav.html 等文件无法访问，造成页面混乱。  

解决：  

```java
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
```

```java
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =true) // 启用授权注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/html/**").antMatchers("/js/**").antMatchers("/css/**");
    }
}
```

下面的写法无效：

```java
web.ignoring().antMatchers("/static/**"); 
```

因为 thymeleaf 对静态资源的引用没有写 static，而是直接写的下面的子目录：

```html
<head>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
    <script type="application/javascript" th:src="@{/js/jquery-3.3.1.min.js}"></script>
</head>
```








