![Java](https://s2.ax1x.com/2019/10/29/KRNvw9.md.jpg)

> IoC( 控制反转，Inversion of Control )，是面向对象编程中的一种设计原则，通过描述（在 Java 中可以使用 XML 或 注解 ）并通过第三方去生产获取特定对象的方式，这样可以用来降低计算机代码间之间的耦合度。最为常见的使用方式是 依赖注入( DI, Dependency Injection)，还有一种方式叫做 依赖查找( Dependency Lookup )，因此 IoC( 控制反转 ) 只是一种思想，而 DI (依赖注入) 才是具体的实现。

## Spring 框架的容器

Spring 框架中的一切 Java 类都是资源，这些资源都是 Bean，而容纳这些 Bean 的是 Spring 框架所提供的 Ioc 容器，Spring 框架提供了两个核心容器，分别是 `BeanFactory` 和 `ApplicationContext`。

### BeanFactory

> BeanFactory 由 `org.springframework.beans.factory.BeanFactory` 接口定义，是基础类型的 IoC 容器，提供完整的 IoC 服务支持。相当于就是一个关闭 Bean 的工厂，主要负责管理初始化各种 Bean，并调用它们的生命周期。 BeanFactory 接口提供了几个实现类，，最为常用的是 XmlBeanFactory 类，该类会根据 XML 配置文件中的定义来装配 Bean。

### ApplicationContext

> ApplicatoinContext 是 BeanFactory 的子接口，也被称为应用上下文，它不仅包含了 BeanFactory 的所有功能，还添加了 国际化、资源访问、事件传播等方面的支持。通常使用以下两种方式创建：

- ClassPathXmlApplicationContext：从类路径 `classPath` 中寻找执行的 XML 配置文件；
- FileSystemXmlApplicationContext：从指定的文件系统路径（绝对路径） 中寻找指定的 XML 配置文件；

创建完 Spring 容器后，Spring 获取 Bean 的实例通常使用以下两种方法：

- getBean(String):Object ：根据容器中 Bean 的名称或 ID 获取指定的 Bean 实例；
- getBean(Class<T>):T ：根据类的类型获取 Bean 的实例；

**BeanFactory 与 ApplicationContext 的区别主要在于，如果 Bean 有一个属性未注入，BeanFactory 在加载后，第一次调用 getBean() 方法时会抛出异常，而 ApplicationContext 会在初始化时自检，因此在实际开发环境中，通常使用 ApplicationContext。**

## Spring 中的 Bean

Spring 容器最常用的的就是 XML 格式的配置方法，配置文件的根元素是 `<beans>`，`<beans>` 元素中包含多个 `<bean>` 节点，每个 `<bean>` 元素定义了一个 Bean，并描述了该 Bean 如何被装配到 Spring 容器中。

`<bean>` 元素中同样包含多个属性以及子元素，其常用属性子元素如下表所示：

| 属性或子元素名称 | 描述                                                                                                                                                                                                                        |
| ---------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id               | 是一个 Bean 的唯一标识符，Spring 容器对 Bean 的配置、管理都通过该属性来完成                                                                                                                                                 |
| name             | Spring 容器同样可以通过此属性对容器的 Bean 进行配置和管理，name 属性中可以为 Bean 执行多个名称，以逗号或分号隔开                                                                                                            |
| class            | 该属性指定 Bean 的具体实现类，它必须是一个完整的类名，使用类的全限定名                                                                                                                                                      |
| factory-bean     | 指向工厂实例 Bean                                                                                                                                                                                                           |
| factory-method   | 确定使用工厂中的哪个方法                                                                                                                                                                                                    |
| scope            | 用来设定 Bean 实例的作用域，其属性有 singleton(单例)、prototype(原型)、request、session、global Session、application 和 websocket。其默认值为 singleton                                                                     |
| constructor-arg  | `<bean>` 元素的子元素，使用此元素传入构造参数进行实例化。该元素的 index 属性指定构造参数的序号( 从 0 开始 )，type 属性指定构造参数的类型，参数值可以通过 ref 属性 或 value 属性直接指定，也可以通过 ref 或 value 子元素指定 |
| property         | `<bean>` 元素的子元素，用于调用 Bean 实例中的 setter 方法完成属性赋值，从而完成依赖注入。该元素的 name 属性指定 Bean 实例中的相应属性名， ref 属性或 value 属性用于指定参数值                                               |
| ref              | `<property>`、`<constructor-arg>` 等元素的属性或子元素、可以用于指定对 Bean 工厂中某个 Bea 实例的引用                                                                                                                       |
| value            | `<property>`、`<constructor-arg>` 等元素的属性或子元素、可以用于指定一个常量值                                                                                                                                              |
| list             | 用于封装 List 或数组类型的依赖注入                                                                                                                                                                                          |
| set              | 用于封装 Set 类型的依赖注入                                                                                                                                                                                                 |
| map              | 用于封装 Map 类型的依赖注入                                                                                                                                                                                                 |
| entry            | `<map>` 元素的子元素，用于设置一个键值对。其 key 属性指定字符串类型的键值，ref 或 value 子元素指定其值，也可以通过 value-ref 或 value 属性指定其值                                                                          |

### Bean 的作用域

Spring 容器创建一个 Bean 的实例时，不仅可以完成 Bean 的实例化，还可以为 Bean 指定特定的作用域。

- singleton (单例)

> 使用 `singleton` 定义的 Bean 在 Spring 容器中将只有一个实例，只要 id 或 name 与该 Bean 的 id 或 name 属性相匹配，就会返回同一个 Bean 实例。这也是 Spring 容器的默认作用域。**singleton 作用域通常用在无会话的 Bean( 如 Dao 组件，Service 组件 )中。**

- prototype (原型)

> 对需要保持会话状态的 Bean 应该使用 `prototype` 作用域，Spring 容器会为每个对该 Bean 的请求都创建一个新的实例。
