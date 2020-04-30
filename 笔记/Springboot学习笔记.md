

# 一、什么是SprintBoot

> Spring Boot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，开发者能快速上手。



# 二、SpringBoot的优点与缺点

## 1、优点

1）：快速创建独立运行的Spring项目以及与主流框架集成

2）：使用嵌入式的Servlet容器，应用无需打成war包

3）：starters自动依赖与版本控制

4）：大量的自动配置，简化开发，也可修改默认值

5）：无需配置XML，无代码生成，开箱即用

6）：准生产环境的运行时应用监控

7）：与云计算天然集成

## 2、缺点

1）：入门比较容易，精通难



# 三、微服务简介

## 1、单体应用（ALL IN ONE）

> 所有的页面以及代码都部署在一起

![](./images/1.jpg)

### 1）优点

便于共享：单个归档文件包含所有功能，便于在团队之间以及不同的部署阶段之间共享。
易于测试：单体应用一旦部署，所有的服务或特性就都可以使用了，这简化了测试过程，因为没有额外的依赖，每项测试都可以在部署完成后立刻开始。
易于部署：只需将单个归档文件复制到单个目录下。

### 2）缺点

复杂性高：由于是单个归档文件，所以整个项目文件包含的模块非常多，导致模块的边界模糊、依赖关系不清晰、代码的质量参差不齐，混乱的堆在一起，使得整个项目非常复杂。以致每次修改代码，都非常小心，可能添加一个简单的功能，或者修改一个Bug都会带来隐藏的缺陷。
技术债务：随着时间的推移、需求的变更和技术人员的更替，会逐渐形成应用程序的技术债务，并且越积越多。
扩展能力受限：单体应用只能作为一个整体进行扩展，无法根据业务模块的需要进行伸缩。
阻碍技术创新：对于单体应用来说，技术是在开发之前经过慎重评估后选定的，每个团队成员都必须使用相同的开发语言、持久化存储及消息系统



## 2、微服务

> 微服务，又叫微服务架构，是一种软件架构方式。它将应用构建成一系列按业务领域划分模块的、小的自治服务。每一个功能元素最终都是一个可独立替换和独立升级的软件单元。

​	![](./images/2.jpg)



### 1）优点

易于开发和维护：一个微服务只会关注一个特定的业务功能，所以业务清晰、代码量较少。开发和维护单个微服务相对简单。
单个微服务启动较快
局部修改容易部署：单体应用只要有修改，就得重新部署整个应用。微服务解决了这样的问题。一般来说，对某个微服务进行修改，只需要重新部署这个服务即可。
技术栈不受限制：在微服务架构中，可以结合项目业务及团队的特点，合理的选择技术栈。
按需伸缩：可根据需求，实现细粒度的扩展。

### 2）缺点

运维要求高：更多的服务意味着要投入更多的运维。
分布式固有的复杂性：使用微服务构建的是分布式系统。对于一个分布式系统，系统容错、网络延迟、分布式事务等都会带来巨大的问题。
接口调整成本高：微服务之间通过接口进行通信。如果修改某一个微服务的API，可能所有用到这个接口的微服务都需要进行调整。

# 四、SpringBoot项目创建流程

第一步：

![](./images/3.jpg)

第二步：

![](./images/4.jpg)

第三步：选择版本和需要的依赖

![](./images/5.jpg)

第四步：

![](./images/6.jpg)

第七步：删除多余文件

![](./images/7.jpg)

# 五、HelloWorld实例

**代码：springboot_example项目**

第一步：创建一个Springboot项目

第二步：创建一个HelloWorld的Controller

第三步：编写代码

```java
package com.rock.controller.hello_word;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World";
    }
}

```



第四步：运行main方法，访问路径：http://127.0.0.1:8080/

```java
/**
 *  @SpringBootApplication  用来标注一个主程序类，说明这是一个Springboot应用
 */
@SpringBootApplication
public class SpringbootExampleApplication {

    public static void main(String[] args) {
        //SpringBoot启动
        SpringApplication.run(SpringbootExampleApplication.class, args);
    }

}
```



![](./images/8.jpg)



# 六、HelloWord探究

## 1、POM文件

父项目

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.5.RELEASE</version>
    <relativePath/>
</parent>
以上项目的父项目
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.1.5.RELEASE</version>
    <relativePath>../../spring-boot-dependencies</relativePath>
</parent>

该项目定义了SpringBoot使用其他组件的版本号，如果dependencies没有定义的依赖就需要声明版本号

```

## 2、场景启动器

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

spring-boot-starter：SpringBoot场景启动器

spring-boot-starter-web：web场景的启动器，包含web项目所用的基础依赖

## 3、主程序类，主入口类

```java
/**
 *  @SpringBootApplication  用来标注一个主程序类，说明这是一个Springboot应用
 */
@SpringBootApplication
public class SpringbootExampleApplication {

    public static void main(String[] args) {
        //SpringBoot启动
        SpringApplication.run(SpringbootExampleApplication.class, args);
    }

}
```

### **@SpringBootApplication**

> SpringBoot应用标注在某个类上说明这个类是SpringBoot的主配置类，SpringBoot就应该运行这个类的main方法来启动SpringBoot应用

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
```

#### **@SpringBootConfiguration**

> Spring Boot的配置类，标注在某个类上表示这个类是一个SpringBoot配置类

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {
}
```

##### **@Configuration**

> 容器中的一个组件，用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，，并用于构建bean定义，初始化Spring容器。SpringBootConfiguration注解继承了该注解

### **@EnableAutoConfiguration**

> 开启自动配置功能

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
```

#### **@AutoConfigurationPackage**

> 自动配置包

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({Registrar.class})
public @interface AutoConfigurationPackage {
}
```

##### **@Import({Registrar.class})**

> Spring的底层注解@Import，给容器中导入一个组件，导入的组件由Registrar.class来指定

```java
//metadata：@SpringBootApplication标注类的基本信息
public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
            AutoConfigurationPackages.register(registry, (new AutoConfigurationPackages.PackageImport(metadata)).getPackageName());
        }
//new AutoConfigurationPackages.PackageImport(metadata)).getPackageName() 会获取到标注了@SpringBootApplication注解的类所在的包以及下面所有子包里面的所有组件扫描到Spring容器
```



#### @Import({AutoConfigurationImportSelector.class})

AutoConfigurationImportSelector类

> 将所有需要导入的组件以全类名的方式返回；这些组件就会被添加到容器中

```java
/**
*	会给容器中导入非常多的自动配置类（xxxAutoConfiguration）；就是给容器中导入这个场景需要的所有组件，*   并配置好这些组件；
*/
protected AutoConfigurationImportSelector.AutoConfigurationEntry getAutoConfigurationEntry(AutoConfigurationMetadata autoConfigurationMetadata, AnnotationMetadata annotationMetadata) {
        if (!this.isEnabled(annotationMetadata)) {
            return EMPTY_ENTRY;
        } else {
            AnnotationAttributes attributes = this.getAttributes(annotationMetadata);
            List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes);
            configurations = this.removeDuplicates(configurations);
            Set<String> exclusions = this.getExclusions(annotationMetadata, attributes);
            this.checkExcludedClasses(configurations, exclusions);
            configurations.removeAll(exclusions);
            configurations = this.filter(configurations, autoConfigurationMetadata);
            this.fireAutoConfigurationImportEvents(configurations, exclusions);
            return new AutoConfigurationImportSelector.AutoConfigurationEntry(configurations, exclusions);
        }
    }
```

会给容器中导入非常多的自动配置类（xxxAutoConfiguration）；就是给容器中导入这个场景需要的所有组件，并配置好这些组件；		

![自动配置类](images/9.jpg)



# 七、SpringBoot的配置文件

**代码：springboot_config 项目中**

SpringBoot使用一个全局的配置文件，配置文件名是固定的；

•application.properties

•application.yml

配置文件的作用：修改SpringBoot自动配置的默认值；SpringBoot在底层都给我们自动配置好；

标记语言：

​	以前的配置文件；大多都使用的是  **xxxx.xml**文件；

​	YAML：**以数据为中心**，比json、xml等更适合做配置文件；

​	YAML：配置例子

```yaml
server:
  port: 8081
```

​	XML：

```xml
<server>
	<port>8081</port>
</server>
```

## 1、YAML语法

### 1）基本语法

K:(空格)V：表示一对键值对（空格必须有）

以空格的缩进来控制层级关系，只要左对齐的一列数据，都是同一个层级的

```yaml
server:
	port: 8081
	path: /test
```

属性和值的大小写敏感



## 2、值的写法

### 1）字面量：普通的值（数字、字符串、布尔）

k: v ：字面直接写

​		字符串默认不用加上单引号或者双引号

​		**双引号：**不会转义字符串里面的特殊字符，特殊字符会作为本身想表示的意思

​		例如： “test \n aa”

​		输出：test 换行 aa

​		**单引号：**会转义特殊字符，特殊字符最终只是一个普通的字符串数据

​		例如：‘test \n aa’

​		输出：test \n aa

### 2）对象、Map（属性和值）（键值对）

k: v：在下一行来写对象的属性和值的关系；注意缩进

​		对象还是k: v的方式

```yaml
friends:
		lastName: zhangsan
		age: 20
```

行内写法：

```yaml
friends: {lastName: zhangsan,age: 18}
```



#### 数组（List、Set）：

用- 值表示数组中的一个元素

```yaml
pets:
 - cat
 - dog
 - pig
```

行内写法

```yaml
pets: [cat,dog,pig]
```

### 3）配置文件值的注入

###### **使用@ConfigurationProperties**注入

**①：导入配置处理器**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

如果不导入文件处理器，编写YMAL的时候没有提示，并且会提示你添加

![提示导入配置处理器](./images/10.jpg)

**②：Bean对象**

```java
/**
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix = "friend" ：配置文件中哪个属性下面的属性进行一一映射
 *
 * 这个组件必须是容器中的组件，才能使用容器提供的@ConfigurationProperties 功能
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;

    private int age;

    private Date birthday;

    private List<String> list;

    private Map<String, String> maps;

    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", list=" + list +
                ", maps=" + maps +
                ", dog=" + dog +
                '}';
    }
}
```

```java
public class Dog {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

**③：YMAL编写**

```yam
person:
  name: 张三
  age: 18
  list:
    - list1
    - list2
    - list3
  maps:
    key1: value1
    key2:  value2
  dog:
    name: 旺财
    age: 2
  birthday: 1997/10/28 10:59:59

```

④：使用SpringBoot提供的测试类测试

![](./images/11.jpg)



**properties格式文件注入**

将application.yml 中的配置注释，在application.properties 配置文件中编写

```properties
person.name=张三
person.age=15
person.list=1,2,3
person.maps.key1=value1
person.maps.key2=value2
person.birthday=1999/12/10 10:30:44
person.dog.name=旺财
person.dog.age=3
```

其他不变，运行测试类

这时候会发现中文是乱码的

![](./images/12.jpg)

找到File Encodings  ，勾选运行时转换成ASCII码，就不会乱码了

![](./images/13.jpg)



###### 使用@Value注入

```java
@Component
public class PersonValue {

    @Value("${person.name}")
    private String name;

    @Value("#{11*2}")
    private int age;

    private Date birthday;

    private List<String> list;

    private Map<String, String> maps;

    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", list=" + list +
                ", maps=" + maps +
                ", dog=" + dog +
                '}';
    }
}
```



###### @ConfigurationProperties与@Value注入的区别

|                      | @ConfigurationProperties | @Value     |
| -------------------- | :----------------------- | ---------- |
| 功能                 | 批量注入配置文件中的属性 | 一个个指定 |
| 松散绑定（松散语法） | 支持                     | 不支持     |
| SpEL                 | 不支持                   | 支持       |
| JSR303数据校验       | 支持                     | 不支持     |
| 复杂类型封装         | 支持                     | 不支持     |
|                      |                          |            |



###### @PropertySource，指定读取的配置文件

```java
/**
 * @PropertySource：指定加载某个配置文件中配置
 * value：配置文件路径
 */
@Component
@PropertySource(value = {"classpath:personSource.properties"})
@ConfigurationProperties(prefix = "personsourcebean")
public class PersonSourceBean {
    private String name;

    private int age;

    private Date birthday;

    private List<String> list;

    private Map<String, String> maps;

    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PersonSourceBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", list=" + list +
                ", maps=" + maps +
                ", dog=" + dog +
                '}';
    }
}
```

@ImportResource

> 导入Spring的配置文件，让配置文件里面的内容生效；

Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；

想让Spring的配置文件生效，加载进来；@**ImportResource**标注在启动类上

```java
@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringbootConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConfigApplication.class, args);
    }

}
```

配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="importResourceService" class="com.rock.service.ImportResourceService"></bean>
</beans>
```

###### @Bean注入

```java
/**
 * @Configuration:表示该类为一个配置类
 */
@Configuration
public class ImportResourceConfig {

    /**
     * 将方法的返回值添加到容器中
     * 容器中组件的ID就是方法的名称
     * @return 需要注入的对象
     */
    @Bean
    public ImportResourceService importResourceService() {
        System.out.println("进入配置配置类方法");
        return new ImportResourceService();
    }
}
```

两者选其一，SpringBoot推荐使用@Bean注入

## 4）配置文件占位符

### ①、随机数

```java
${random.value}：产生一个随机字符串
${random.int}：产生一个随机整数
${random.long}：产生一个随机long类型数字
${random.int(10)}：产生一个小于10的整数
${random.int[1,4]}：产生一个大于等于1小于4的整数

```

### ②、获取之前配置的值

```java
${字段名}
```

实例：

```properties
person.name=张三${random.value}
person.age=${random.int[1,2]}
person.list=1,2,3
person.maps.key1=value1
person.maps.key2=value2
person.birthday=1999/12/10 10:30:44
person.dog.name=${person.name}旺财
person.dog.age=${random.int(1,4)}
```

# 八、Profile多环境配置

**代码：springboot_profile项目**

注意：如果application.properties与application.yml 同时存在时，application.properties生效

## 1、多Profile文件

> 将properties或者yml文件按：application-{profile}.properties，application-{profile}.yml

例如：application-dev.properties

## 2、yml支持多文档块方式

```yml
spring:
  profiles:
    active: dev
---
spring:
  profiles: prod
server:
  port: 8082

---
spring:
  profiles: dev
server:
  port: 8083

```

> 使用  ---  在yml文件中隔开多个document，可以用：spring:profiles:  给每个document取名，再使用active激活不同的document

## 3、激活指定profile

①：springboot默认使用：application.properties，可以再默认使用的配置文件中激活profile文件

spring.profiles.active=profile名称

例：

```properties
spring.profiles.active=dev
```

②：命令行激活

--spring.profiles.active=dev

![](./images/14.jpg)

> 如果使用命令行激活，会以命令行激活的为准

使用启动命令激活

java -jar （jar包名称） --spring.profiles.active=dev

![](./images/15.jpg)

③：虚拟机参数

-Dspring.profiles.active=dev

![](./images/16.jpg)

## 4、配置文件的加载位置

springboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文 件
–ﬁle:./conﬁg/

–ﬁle:./ 

–classpath:/conﬁg/ 

–classpath:/

**优先级由高到低，高优先级的配置会覆盖低优先级的配置；**

SpringBoot会从这四个位置全部加载主配置文件；互补配置；

我们还可以通过spring.conﬁg.location来改变默认的配置文件位置

项目打包好以后，我们可以使用命令行参数的形式，启动项目的时候来指定配置文件的新位置；指定配置文件和默 

认加载的这些配置文件共同起作用形成互补配置；

java -jar spring-boot-02-conﬁg-02-0.0.1-SNAPSHOT.jar --spring.conﬁg.location=G:/application.properties



## 5、外部配置加载顺序

**SpringBoot也可以从以下位置加载配置； 优先级从高到低；高优先级的配置覆盖低优先级的配置，所有的配置会 形成互补配置**

**由jar包外向jar包内进行寻找； 优先加载带proﬁle    再来加载不带proﬁle **

1.命令行参数

所有的配置都可以在命令行上进行指定

java -jar spring-boot-02-conﬁg-02-0.0.1-SNAPSHOT.jar --server.port=8087 --server.context-path=/abc 

多个配置用空格分开； --配置项=值  

2.来自java:comp/env的JNDI属性 

3.Java系统属性（System.getProperties()）

4.操作系统环境变量 

5.RandomValuePropertySource配置的random.* 属性值  

6.jar包外部的application-{proﬁle}.properties或application.yml(带spring.proﬁle)配置文件

7.jar包内部的application-{proﬁle}.properties或application.yml(带spring.proﬁle)配置文件  

8.jar包外部的application.properties或application.yml(不带spring.proﬁle)配置文件 

9.jar包内部的application.properties或application.yml(不带spring.proﬁle)配置文件

10.@Conﬁguration注解类上的@PropertySource

11.通过SpringApplication.setDefaultProperties指定的默认属性



# 九、自动配置原理

## 1、自动配置介绍

官方配置参考地址：

目录找：Common application properties

https://docs.spring.io/spring-boot/docs/1.5.9.RELEASE/reference/htmlsingle/#common-application-properties

**@SpringBootApplication注解：**

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
@ConfigurationPropertiesScan
```

**@EnableAutoConfiguration注解：利用AutoConfigurationImportSelector给容器中导入组件**

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
```

**AutoConfigurationImportSelector类**

**selectImports()方法**

```java
public String[] selectImports(AnnotationMetadata annotationMetadata) {
		if (!isEnabled(annotationMetadata)) {
			return NO_IMPORTS;
		}
		AutoConfigurationMetadata autoConfigurationMetadata = AutoConfigurationMetadataLoader
				.loadMetadata(this.beanClassLoader);
		AutoConfigurationEntry autoConfigurationEntry = getAutoConfigurationEntry(autoConfigurationMetadata,
				annotationMetadata);//注意该行代码
		return StringUtils.toStringArray(autoConfigurationEntry.getConfigurations());
	}
```

**getAutoConfigurationEntry()**

```java
protected AutoConfigurationEntry getAutoConfigurationEntry(AutoConfigurationMetadata autoConfigurationMetadata,
			AnnotationMetadata annotationMetadata) {
		if (!isEnabled(annotationMetadata)) {
			return EMPTY_ENTRY;
		}
		AnnotationAttributes attributes = getAttributes(annotationMetadata);
		List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);//注意这行代码
		configurations = removeDuplicates(configurations);
		Set<String> exclusions = getExclusions(annotationMetadata, attributes);
		checkExcludedClasses(configurations, exclusions);
		configurations.removeAll(exclusions);
		configurations = filter(configurations, autoConfigurationMetadata);
		fireAutoConfigurationImportEvents(configurations, exclusions);
		return new AutoConfigurationEntry(configurations, exclusions);
	}
```

**getCandidateConfigurations()**

```java
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
		List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
				getBeanClassLoader());//注意这行代码
		Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you "
				+ "are using a custom packaging, make sure that file is correct.");
		return configurations;
	}
```

**loadFactoryNames()**

```java
public static List<String> loadFactoryNames(Class<?> factoryType, @Nullable ClassLoader classLoader) {
    	//获取类的全路径
        String factoryTypeName = factoryType.getName();
        return (List)loadSpringFactories(classLoader).getOrDefault(factoryTypeName, Collections.emptyList());//注意这行代码
    }
```

**loadSpringFactories()**

```java
    private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
        MultiValueMap<String, String> result = (MultiValueMap)cache.get(classLoader);
        if (result != null) {
            return result;
        } else {
            try {
                //获取类路径下的资源"META-INF/spring.factories
                Enumeration<URL> urls = classLoader != null ? classLoader.getResources("META-INF/spring.factories") : ClassLoader.getSystemResources("META-INF/spring.factories");
                LinkedMultiValueMap result = new LinkedMultiValueMap();

                while(urls.hasMoreElements()) {
                    URL url = (URL)urls.nextElement();
                    UrlResource resource = new UrlResource(url);
                    //将URL转换成Properties
                    Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                    Iterator var6 = properties.entrySet().iterator();

                    while(var6.hasNext()) {
                        Entry<?, ?> entry = (Entry)var6.next();
                        String factoryTypeName = ((String)entry.getKey()).trim();
                        String[] var9 = StringUtils.commaDelimitedListToStringArray((String)entry.getValue());
                        int var10 = var9.length;

                        for(int var11 = 0; var11 < var10; ++var11) {
                            String factoryImplementationName = var9[var11];
                            result.add(factoryTypeName, factoryImplementationName.trim());
                        }
                    }
                }

                cache.put(classLoader, result);
                return result;
            } catch (IOException var13) {
                throw new IllegalArgumentException("Unable to load factories from location [META-INF/spring.factories]", var13);
            }
        }
    }
```



**以HttpEncodingAutoConfiguration类为例：**

```java
@Configuration(proxyBeanMethods = false)//表示这是一个配置类
@EnableConfigurationProperties(HttpProperties.class)//启动指定类的 ConfigurationProperties功能；将配置文件中对应的值和HttpEncodingProperties绑定起来；并把 HttpEncodingProperties加入到ioc容器中 
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)///判断当前应用是否为一个web应用，是则改配置类生效；@Conditional是Spring顶层注解，用来根据条件决定配置是否生效
@ConditionalOnClass(CharacterEncodingFilter.class)//判断当前项目有没有这个类 CharacterEncodingFilter；SpringMVC中进行乱码解决的过滤器； 
@ConditionalOnProperty(prefix = "spring.http.encoding", value = "enabled", matchIfMissing = true) //判断配置文件中是否存在某个配置  spring.http.encoding.enabled；如果不存在，判断也是成立的 //即使我们配置文件中不配置pring.http.encoding.enabled=true，也是默认生效的； 
public class HttpEncodingAutoConfiguration {

    //SpringBoot的配置文件映射了 
	private final HttpProperties.Encoding properties;

    //只有一个有参构造器的情况下，参数的值就会从容器中拿 
	public HttpEncodingAutoConfiguration(HttpProperties properties) {
		this.properties = properties.getEncoding();
	}

    ///给容器中添加一个组件，这个组件的某些值需要从properties中获取 
	@Bean
	@ConditionalOnMissingBean //判断容器没有这个组件
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
		filter.setEncoding(this.properties.getCharset().name());
		filter.setForceRequestEncoding(this.properties.shouldForce(Type.REQUEST));
		filter.setForceResponseEncoding(this.properties.shouldForce(Type.RESPONSE));
		return filter;
	}

	@Bean
	public LocaleCharsetMappingsCustomizer localeCharsetMappingsCustomizer() {
		return new LocaleCharsetMappingsCustomizer(this.properties);
	}

	private static class LocaleCharsetMappingsCustomizer
			implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, Ordered {

		private final HttpProperties.Encoding properties;

		LocaleCharsetMappingsCustomizer(HttpProperties.Encoding properties) {
			this.properties = properties;
		}

		@Override
		public void customize(ConfigurableServletWebServerFactory factory) {
			if (this.properties.getMapping() != null) {
				factory.setLocaleCharsetMappings(this.properties.getMapping());
			}
		}

		@Override
		public int getOrder() {
			return 0;
		}

	}

}
```

所有在配置文件中能配置的属性都是在xxxxProperties类中封装者；配置文件能配置什么就可以参照某个功 能对应的这个属性类

```java
@ConfigurationProperties(prefix = "spring.http")
public class HttpProperties {

	/**
	 * Whether logging of (potentially sensitive) request details at DEBUG and TRACE level
	 * is allowed.
	 */
	private boolean logRequestDetails;

	/**
	 * HTTP encoding properties.
	 */
	private final Encoding encoding = new Encoding();

	public boolean isLogRequestDetails() {
		return this.logRequestDetails;
	}

	public void setLogRequestDetails(boolean logRequestDetails) {
		this.logRequestDetails = logRequestDetails;
	}

	public Encoding getEncoding() {
		return this.encoding;
	}

	/**
	 * Configuration properties for http encoding.
	 在properties中可以配置的属性
	 */
	public static class Encoding {

		public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

		/**
		 * Charset of HTTP requests and responses. Added to the "Content-Type" header if
		 * not set explicitly.
		 */
		private Charset charset = DEFAULT_CHARSET;

		/**
		 * Whether to force the encoding to the configured charset on HTTP requests and
		 * responses.
		 */
		private Boolean force;

		/**
		 * Whether to force the encoding to the configured charset on HTTP requests.
		 * Defaults to true when "force" has not been specified.
		 */
		private Boolean forceRequest;

		/**
		 * Whether to force the encoding to the configured charset on HTTP responses.
		 */
		private Boolean forceResponse;

		/**
		 * Locale in which to encode mapping.
		 */
		private Map<Locale, Charset> mapping;

		public Charset getCharset() {
			return this.charset;
		}

		public void setCharset(Charset charset) {
			this.charset = charset;
		}

		public boolean isForce() {
			return Boolean.TRUE.equals(this.force);
		}

		public void setForce(boolean force) {
			this.force = force;
		}

		public boolean isForceRequest() {
			return Boolean.TRUE.equals(this.forceRequest);
		}

		public void setForceRequest(boolean forceRequest) {
			this.forceRequest = forceRequest;
		}

		public boolean isForceResponse() {
			return Boolean.TRUE.equals(this.forceResponse);
		}

		public void setForceResponse(boolean forceResponse) {
			this.forceResponse = forceResponse;
		}

		public Map<Locale, Charset> getMapping() {
			return this.mapping;
		}

		public void setMapping(Map<Locale, Charset> mapping) {
			this.mapping = mapping;
		}

		public boolean shouldForce(Type type) {
			Boolean force = (type != Type.REQUEST) ? this.forceResponse : this.forceRequest;
			if (force == null) {
				force = this.force;
			}
			if (force == null) {
				force = (type == Type.REQUEST);
			}
			return force;
		}

		public enum Type {

			REQUEST, RESPONSE

		}

	}

}
```

根据当前不同的条件判断，决定这个配置类是否生效

一但这个配置类生效，这个配置类就会给容器中添加各种组件，这些组件的属性是从对应的properties类中获取 的，这些类里面的每一个属性又是和配置文件绑定的



**精髓：**

 **1）、SpringBoot启动会加载大量的自动配置类**
  **2）、我们看我们需要的功能有没有SpringBoot默认写好的自动配置类；**
  **3）、我们再来看这个自动配置类中到底配置了哪些组件；（只要我们要用的组件有，我们就不需要再来配置了）**

 **4）、给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们就可以在配置文件中指定这 些属性的值；**

xxxxAutoConﬁgurartion：自动配置类；
给容器中添加组件

xxxxProperties:封装配置文件中相关属性；



## 2、@Conditional

@Conditional派生注解（Spring注解版原生的@Conditional作用） 
作用：必须是@Conditional指定的条件成立，才给容器中添加组件，配置配里面的所有内容才生效；

| @Conditional扩展注解            | 作用（判断是否满足当前指定条件）                 |
| :------------------------------ | :----------------------------------------------- |
| @ConditionalOnJava              | 系统的java版本是否符合要求                       |
| @ConditionalOnBean              | 容器中存在指定Bean                               |
| @ConditionalOnMissingBean       | 容器中不存在指定Bean                             |
| @ConditionalOnExpression        | 满足SpEL表达式指定                               |
| @ConditionalOnClass             | 系统中有指定的类                                 |
| @ConditionalOnMissingClass      | 系统中没有指定的类                               |
| @ConditionalOnSingleCandidate   | 容器中只有一个指定的Bean，或者这个Bean是首选Bean |
| @ConditionalOnProperty          | 系统中指定的属性是否有指定的值                   |
| @ConditionalOnResource          | 类路径下是否存在指定资源文件                     |
| @ConditionalOnWebApplication    | 当前是web环境                                    |
| @ConditionalOnNotWebApplication | 当前不是web环境                                  |
| @ConditionalOnJndi              | JNDI存在指定项                                   |

## 3、如何知道哪些自动配置类生效

在配置文件中添加：debug=true  来让控制台打印自动配置报告

```java
============================
CONDITIONS EVALUATION REPORT
============================


Positive matches:(启用的自动配置)
-----------------

   DispatcherServletAutoConfiguration matched:
      - @ConditionalOnClass found required class 'org.springframework.web.servlet.DispatcherServlet' (OnClassCondition)
      - found 'session' scope (OnWebApplicationCondition)

   DispatcherServletAutoConfiguration.DispatcherServletConfiguration matched:
      - @ConditionalOnClass found required class 'javax.servlet.ServletRegistration' (OnClassCondition)
      - Default DispatcherServlet did not find dispatcher servlet beans (DispatcherServletAutoConfiguration.DefaultDispatcherServletCondition)
          
          
          
          
Negative matches:(没用配置成功的自动配置类)
-----------------

   ActiveMQAutoConfiguration:
      Did not match:
         - @ConditionalOnClass did not find required class 'javax.jms.ConnectionFactory' (OnClassCondition)

   AopAutoConfiguration:
      Did not match:
         - @ConditionalOnClass did not find required class 'org.aspectj.lang.annotation.Aspect' (OnClassCondition)

```

# 十：日志框架分类和选择

## 1、日志框架的选择

| 日志门面  （日志的抽象层）                                   | 日志实现                                       |
| ------------------------------------------------------------ | ---------------------------------------------- |
| ~~JCL（Jakarta  Commons Logging）~~  ~~jboss-logging~~  SLF4j（Simple  Logging Facade for Java） | Log4j  JUL（java.util.logging）Log4j2  Logback |

JCL：上一次更新在2014年。

jboss-logging：不是为普通程序员用



Log4j：与LogBack，SLF4j是同一个人编写，有性能问题

Log4j2：没有和大多数框架适配

Logback：与SLF4j适配性更好

SpringBoot选用SLF4j与Logback做为日志框架



## 2、SLF4j的使用

1）如何在系统中使用SLF4j

以后开发的时候，日志记录方法的调用，不应该来直接调用日志的实现类，而是调用日志抽象层里面的方法；

导入slf4j以及Logback的实现jar（也可以使用其他的实现）

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    logger.info("Hello World");
  }
}
```

图示：

![](./images/17.jpg)

每一个日志的实现框架都有自己的配置文件，使用slf4j以后，**配置文件还是做成日志实现框架自己本身的配置文件**



## 3、遗留问题

各个框架，日志实现框架不一致问题

统一日志记录，所有的框架都使用slf4j

![](./images/18.jpg)

**如何让系统中所有的日志都统一到slf4j**

①、将系统中其他日志框架先排除出去

②、用中间包来替换原有的日志框架

③、导入slf4j其他的实现

## 4、SpringBoot与日志的关系

①：SpringBoot底层也是使用slf4j+logback的方式进行日志记录

②：SpringBoot也把其他的日志都替换成了slf4j

③：引用中间包

## 5、如果引入其他框架，一定要把这个框架的默认日志移除掉么？

SpringBoot能自动适配所有的日志，而且底层使用slf4j+Logback的方式记录日志，引入其他框架的时候，只需要把这个框架依赖的日志框架排除掉。



## 6、日志的使用

代码：唯一测试类中

### ①：默认配置

```java
@SpringBootTest
class SpringbootLoggingApplicationTests {

    //记录器
    Logger logger=LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        //日志级别
        //由低到高
        //可以调整输出的日志级别
        logger.trace("这是trace日志。");
        logger.debug("这是debug日志。");
        logger.info("这是info日志。");
        logger.warn("这是warn日志。");
        logger.error("这是error日志。");
    }

}
```

```txt
日志输出格式： 
	%d表示日期时间，
	%thread表示线程名，
    %‐5level：级别从左显示5个字符宽度 
    %logger{50} 表示logger名字长50个字符，否则按照句点分割。 
    %msg：日志消息， 
    %n是换行符           
    ‐‐>    
    %d{yyyy‐MM‐dd HH:mm:ss.SSS} [%thread] %‐5level %logger{50} ‐ %msg%n

```

### ②：SpringBoot修改默认配置

```properties
# 日志级别
logging.level.com.rock=trace
# 不指定路径，在当前项目下生成springboot.log日志
#logging.file.name=springboot.log
# 可以指定完整路径
#logging.file.name=E:/springboot.log

# 在当前磁盘的根目录下创建springboot文件夹，使用spring.log作为默认文件  一般都配置这个
logging.file.path=/springboot

# 在控制台输出的日志格式
#logging.pattern.console=%d{yyyy‐MM‐dd} [%thread] %‐5level %logger{50} ‐ %msg%n
# 指定文件中日志输出的格式
#logging.pattern.file=%d{yyyy‐MM‐dd} === [%thread] === %‐5level === %logger{50} ==== %msg%n

```



### ③：指定配置

给类路径下放上每个日志框架自己的配置文件即可；SpringBoot就不使用他默认配置的了

| Logging System          | Customization                                                |
| ----------------------- | ------------------------------------------------------------ |
| Logback                 | logback-spring.xml , logback-spring.groovy , logback.xml or logback.groovy |
| Log4j2                  | log4j2-spring.xml or log4j2.xml                              |
| JDK (Java Util Logging) | logging.properties                                           |

logback.xml：直接就被日志框架识别了； 

logback-spring.xml：日志框架就不直接加载日志的配置项，由SpringBoot解析日志配置，可以使用SpringBoot 的高级Proﬁle功能

```xml
<springProfile name="staging">     <!‐‐ configuration to be enabled when the "staging" profile is active ‐‐>    可以指定某段配置只在某个环境下生效    </springProfile> 
```

例如：

```xml
    <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
        <!--
        日志输出格式：
			%d表示日期时间，
			%thread表示线程名，
			%-5level：级别从左显示5个字符宽度
			%logger{50} 表示logger名字最长50个字符，否则按照句点分割。
			%msg：日志消息，
			%n是换行符
        -->
        <layout class="ch.qos.logback.classic.PatternLayout">
            <springProfile name="dev">
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS}---> [%thread] %level ---> %logger{50} - %msg%n</pattern>
            </springProfile>
            <springProfile name="!dev">
                <pattern>%d{yyyy‐MM‐dd HH:mm:ss.SSS} ==== [%thread] ==== %‐5level  %logger{50} ‐ %msg%n</pattern>
            </springProfile>
        </layout>
    </appender>
```

如果使用logback.xml作为日志配置文件，还要使用proﬁle功能，会有以下错误
**no applicable action for [springProfile]** 



# 十一、SpringBoot与WEB开发

## 1、SpringBoot对静态资源的映射规则

```java
@ConfigurationProperties(prefix = "spring.resources", ignoreUnknownFields = false)
public class ResourceProperties {
//可以设置和静态资源有关的参数，缓存时间等
```

```java
public void addResourceHandlers(ResourceHandlerRegistry registry) {
            if (!this.resourceProperties.isAddMappings()) {
                logger.debug("Default resource handling disabled");
            } else {
                Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
                CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
                if (!registry.hasMappingForPattern("/webjars/**")) {
                    this.customizeResourceHandlerRegistration(registry.addResourceHandler(new String[]{"/webjars/**"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/"}).setCachePeriod(this.getSeconds(cachePeriod)).setCacheControl(cacheControl));
                }

                String staticPathPattern = this.mvcProperties.getStaticPathPattern();
                if (!registry.hasMappingForPattern(staticPathPattern)) {
                    this.customizeResourceHandlerRegistration(registry.addResourceHandler(new String[]{staticPathPattern}).addResourceLocations(WebMvcAutoConfiguration.getResourceLocations(this.resourceProperties.getStaticLocations())).setCachePeriod(this.getSeconds(cachePeriod)).setCacheControl(cacheControl));
                }

            }
        }


//配置首页
		@Bean
		public WelcomePageHandlerMapping welcomePageHandlerMapping(ApplicationContext applicationContext,
				FormattingConversionService mvcConversionService, ResourceUrlProvider mvcResourceUrlProvider) {
			WelcomePageHandlerMapping welcomePageHandlerMapping = new WelcomePageHandlerMapping(
					new TemplateAvailabilityProviders(applicationContext), applicationContext, getWelcomePage(),
					this.mvcProperties.getStaticPathPattern());
			welcomePageHandlerMapping.setInterceptors(getInterceptors(mvcConversionService, mvcResourceUrlProvider));
			return welcomePageHandlerMapping;
		}
```

**1)、所有的/webjars/**，都去 classpath:/METAINF/resources/webjars/ 找资源**

​		webjars：以jar包的方式引入   https://www.webjars.org/

```xml
<!--引入jQuery-->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.3.1</version>
        </dependency>
```

**2）、"/**"：访问当前项目的任何资源（静态资源的文件夹）**

```java
"classpath:/META-INF/resources/"
"classpath:/resources/"
"classpath:/static/"
"classpath:/public/"
"/**":当前项目根路径
```

**3）、欢迎页；静态资源文件夹下所有index.html页面**



## 2、模板引擎

thymeleaf：语法更简单，功能更强大

### 1)、引入thymeleaf

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

### 2)、thymeleaf自动配置

```java
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {

	private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;

	public static final String DEFAULT_PREFIX = "classpath:/templates/";//前缀

	public static final String DEFAULT_SUFFIX = ".html";//后缀
	//只需要吧HTML页面放在classpath:/templates/，templates就会自动渲染
```

### 3）、测试thymeleaf的使用

①：引入thymeleaf

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

②：在resources/templates下编写success.html

③：编写Controller，访问该地址

```java
@Controller//注意这里不要用RestController
public class HelloController {

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "success";//返回的字符串和HTML页面名称一致
    }
}
```

### 4）、thymeleaf语法

1、导入thymeleaf的名称空间

```html
<html lang="en" xmlns:th="http://www.thymeleaf.org">
```

2、使用thymeleaf语法

```java
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--th:text 将div里面的文本内容设置为指定内容-->
<div th:text="${hello}">div中的信息</div>
</body>
</html>
```

3、注意后台代码的变化

```java
 @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Map<String,Object> map) {
        map.put("hello","你好啊");
        return "success";
    }
```

### 5)、语法规则

| 标签                                                  | 作用               |
| ----------------------------------------------------- | ------------------ |
| th:insert、th:replace                                 | 片段包含           |
| th:each                                               | 遍历               |
| th:if、th:unless、th:switch、th:case                  | 条件判断           |
| th:object、th:with                                    | 变量声明           |
| th:attr、th:attrprepend、th:attrappend                | 任意属性修改       |
| th: value、th:href、th:src.....                       | 修改指定属性默认值 |
| th:text（转义特殊字符）、th:utext（不转义特殊字符）、 | 修改标签体文本内容 |
| th:fragment                                           | 声明片段           |
| th:remove                                             | 删除               |

表达式：

```properties
Simple expressions:(表达式语法)
Variable Expressions: ${...} ：获取变量值；OGNL
Selection Variable Expressions: *{...} 与 ${...}功能一样，补充功能配合th:object进行使用
Message Expressions: #{...} 获取国际化内容
Link URL Expressions: @{...} 定义URL链接
Fragment Expressions: ~{...}

Literals
Text literals: 'one text' , 'Another one!' ,… 
Number literals: 0 , 34 , 3.0 , 12.3 ,… 
Boolean literals: true , false 
Null literal: null 
Literal tokens: one , sometext , main ,…

Text operations:
String concatenation: + 
Literal substitutions: |The name is ${name}|

Arithmetic operations:
Binary operators: + , - , * , / , % 
Minus sign (unary operator): -

Boolean operations:
Binary operators: and , or 
Boolean negation (unary operator): ! , not
Comparisons and equality:
Comparators: > , < , >= , <= ( gt , lt , ge , le ) 
Equality operators: == , != ( eq , ne )

Conditional operators:
If-then: (if) ? (then) 
If-then-else: (if) ? (then) : (else)
Default: (value) ?: (defaultvalue)
Special tokens:
Page 17 of 106
No-Operation: _
```

内置对象

```properties
#ctx : the context object. 
#vars: the context variables. 
#locale : the context locale. 
#request : (only in Web Contexts) the HttpServletRequest object. 
#response : (only in Web Contexts) the HttpServletResponse object. 
#session : (only in Web Contexts) the HttpSession object. 
#servletContext : (only in Web Contexts) the ServletContext object.
#execInfo : information about the template being processed. 
#messages : methods for obtaining externalized messages inside variables expressions, in the same way as they would be obtained using 
#{…} syntax. 
#uris : methods for escaping parts of URLs/URIs
#conversions : methods for executing the configured conversion service (if any). 
#dates : methods for java.util.Date objects: formatting, component extraction, etc. #calendars : analogous to 
#dates , but for java.util.Calendar objects. 
#numbers : methods for formatting numeric objects. 
#strings : methods for String objects: contains, startsWith, prepending/appending, etc. #objects : methods for objects in general. 
#bools : methods for boolean evaluation. 
#arrays : methods for arrays. 
#lists : methods for lists. 
#sets : methods for sets.
#maps : methods for maps. 
#aggregates : methods for creating aggregates on arrays or collections. 
#ids : methods for dealing with id attributes that might be repeated (for example, as a result of an iteration).
```

## 3、SpringMVC自动配置

Spring Boot 自动配置好了SpringMVC

以下是SpringBoot对SpringMVC的默认配置:**(WebMvcAutoConfiguration)**

Inclusion of `ContentNegotiatingViewResolver` and `BeanNameViewResolver` beans.

- 自动配置了ViewResolver（视图解析器：根据方法的返回值得到视图对象（View），视图对象决定如何渲染（转发？重定向？））
- ContentNegotiatingViewResolver：组合所有的视图解析器的；
- 如何定制：我们可以自己给容器中添加一个视图解析器；自动的将其组合进来

```java
 @Bean
 public ViewResolver myView() {
      return new myViewResolver();
 }

 private static class myViewResolver implements ViewResolver {
   @Override
   public View resolveViewName(String s, Locale locale) throws Exception {
       return null;
   }
 }
```

可以在DispatcherServlet类的doDispatch方法打断点查看加载了哪些视图解析器

- Support for serving static resources, including support for WebJars (see below).静态资源文件夹路径,webjars
- Static `index.html` support. 静态首页访问
- Custom `Favicon` support (see below).  favicon.ico

自动注册了  `Converter`, `GenericConverter`, `Formatter` beans.

- Converter：转换器；  public String hello(User user)：类型转换使用Converter
- `Formatter`  格式化器；  2017.12.17===Date；

```java
//WebMvcAutoConfiguration类中
@Bean
@Override
public FormattingConversionService mvcConversionService() {
	WebConversionService conversionService =new WebConversionService(this.mvcProperties.getDateFormat());//在文件中配置日期格式化的规则
		addFormatters(conversionService);
	return conversionService;
}
```

自定义转换器

```java
@Bean
public myGenericConverter myGenericConverter() {
	return new myGenericConverter();
}

private static class myGenericConverter implements GenericConverter {
	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return null;
	}

	@Override
	public Object convert(Object o, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
		return null;
	}
}
```

Support for `HttpMessageConverters` (see below).

​	1、HttpMessageConverter：SpringMVC用来转换Http请求和响应的；User---Json；

​	2、`HttpMessageConverters` 是从容器中确定；获取所有的HttpMessageConverter；

​         自己给容器中添加HttpMessageConverter，只需要将自己的组件注册容器中（@Bean,@Component）

Automatic registration of `MessageCodesResolver` (see below).定义错误代码生成规则

Automatic use of a `ConfigurableWebBindingInitializer` bean (see below).

我们可以配置一个ConfigurableWebBindingInitializer来替换默认的；（添加到容器）

```java
初始化WebDataBinder；
请求数据=====JavaBean；
```

## 4、如何修改springBoot的默认配置

模式：

1）、springboot在自动配置很多组件的时候，先看容器中有没有用户自己配置的（@Bean、@Component）如果有就用用户配置的，如果没有，才自动配置；如果有些组件可以有多个（ViewResolver）将用户的配置和自己默认的组合起来

































