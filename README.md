# swagger-demo

该项目为springboot整合swagger的小demo



swagger作用:实时生成API文档及接口测试

代码即接口文档，接口文档即代码。 

**注意**:在正式发布的时候配置类中要关闭swagger(处于安全考虑)

## 步骤

1.添加依赖

```xml
		<!--swagger-->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<!--swagger的ui-->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
```

2.添加config配置类

3.在controller层的方法上添加注解

4.启动项目后,访问页面: http://localhost:8080/swagger-ui.html 

