# SOLID原则

## 依赖反转原则

> DIP；Dependency Inversion Principe；依赖反转原则；依赖倒置原则



### Question？

- “依赖反转”这个概念指的是“谁跟谁”的“什么依赖”被反转了？“反转”二字该如何理解？
- 我们还经常听到另外两个概念：『控制反转』和『依赖注入』。这两个概念跟“依赖反转”有什么区别和联系呢？
- Spring 中的 IoC 跟这些概念又有什么区别呢？



### IoC

在学习『**依赖反转**』之前，我们得先了解一下『**控制反转**』。注意：这里的 IoC 和 Spring 的 IoC 还不太一样，不要把它们混为一谈。



我们先通过一个例子来看一下：什么是控制反转？

```java
package cn.lnd.methodology.solid.dip.ioc;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:36
 */
public class UserServiceTest {

    public static boolean doTest(){
        // 编写测试代码
        // return true or false
        return true;
    }
    
    public static void main(String[] args) {
        if (doTest()){
            System.out.println("Test succeed");
        }else {
            System.out.println("Test failed");
        }
    }
}
```

在上面的代码中，所有流程都由程序员来控制。如果我们抽象出一个下面这样的框架，我们再来看看，如何利用框架来实现同样的功能。

```java
package cn.lnd.methodology.solid.dip.ioc.second;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:42
 */
public abstract class TestCase {
    public void run() {
        if (doTest()){//doTest()是测试代码运行的结果，成功或失败
            System.out.println("Test succeed");
        }else {
            System.out.println("Test failed");
        }
    }

    protected abstract boolean doTest();
}


package cn.lnd.methodology.solid.dip.ioc.second;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:41
 */
public class JunitApplication {

    private static final List<TestCase> testCases = Lists.newArrayList();

    public static void register(TestCase testCase){
        testCases.add(testCase);
    }

    public static void main(String[] args) {
        for (TestCase aCase : testCases) {
            aCase.run();
        }
    }
}
```

把这个简化版的测试框架引入到工程中之后，我们只需要在框架预留的扩展点，也就是让 TestCase 的子类重写 doTest() 抽象方法，填充具体的测试代码，并将其 register 到 testCases 中，就可以实现之前的功能，完全不需要写负责控制执行流程的 main() 函数了。具体代码如下：

```java
package cn.lnd.methodology.solid.dip.ioc.third;

import cn.lnd.methodology.solid.dip.ioc.second.TestCase;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:52
 */
public class UserServiceTest extends TestCase {
    // 重写 doTest 抽象方法
    @Override
    protected boolean doTest() {
        // 编写测试代码
        // return true or false
        return false;
    }
}


package cn.lnd.methodology.solid.dip.ioc.third;

import cn.lnd.methodology.solid.dip.ioc.second.JunitApplication;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:55
 */
public class MainTest {
    public static void main(String[] args) {
        // 注册测试代码实例
        JunitApplication.register(new UserServiceTest());
    	// 注册操作还可以通过配置的方式来实现，不需要程序员显式调用 register
    }
}
```

刚刚这个例子，就是典型的通过框架来实现『控制反转』的例子。**框架提供了一个可扩展的代码骨架，用来组装对象、管理整个执行流程。程序员利用框架进行开发的时候，只需要在预留的扩展点上，添加跟自己业务相关的代码，就可以利用框架来驱动整个程序流程的执行。**

这里的“**控制**”指的是对程序执行流程的控制，而“**反转**”指的是在没有使用框架之前，程序员自己控制整个程序的执行。在使用了框架之后，整个程序的执行流程可以通过框架来控制。流程的控制权从程序员“反转”到了框架。

实际上，实现控制反转的方法有很多，除了刚才例子中类似于『模板设计模式』的方式之外，还有『依赖注入』等方式。所以，控制反转并不是一种具体的实现技巧，而是一个比较笼统的设计思想，一般用来指导框架层面的设计。





### DI

> DI；Dependency Injection；依赖注入

DI 跟 IoC 恰恰相反，它是一种具体的编码技巧。对于这个概念，有一个非常形象的说法就是：依赖注入是一个标价25美元，实际上只值5美分的概念。也就是说，这个概念听起来非常“高大上”，但实际上，理解起来非常简单。





**什么是DI？**

一句话概括就是：**不通过 new() 的方式在类内部创建依赖类对象，而是将依赖的类对象在外部创建好后，通过构造函数或某个函数的入参传递（或注入）给类使用。**



我们通过一个例子来感受一下。在这个例子中，Notification 类负责消息推送，这个类依赖 MessageSender 类实现发送商品促销、验证码等消息给用户。我们分别用依赖注入和非依赖注入两种方式来实现一下。

- **非DI的实现方式**

```java
package cn.lnd.methodology.solid.dip.di.first;

/**
 * @Author lnd
 * @Description 非DI的实现方式
 * @Date 2022/7/24 23:15
 */
public class Notification {
    
    private MessageSender messageSender;

    public Notification() {
        this.messageSender = new MessageSender(); // 有点像hardcode
    }
    
    public void sendMessage(String cellphone, String message){
        // 省略校验逻辑等
        this.messageSender.send(cellphone, message);
    }
}


package cn.lnd.methodology.solid.dip.di.first;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 23:16
 */
public class MessageSender {
    public void send(String cellphone, String message) {
        // TODO send message to cellphone
    }
}


package cn.lnd.methodology.solid.dip.di.first;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 23:19
 */
public class MainTest {

    public static void main(String[] args) {
        // 使用Notification
        Notification notification = new Notification();
    }
}

```

- **DI的实现方式**

```java
package cn.lnd.methodology.solid.dip.di.second;

import cn.lnd.methodology.solid.dip.di.first.MessageSender;

/**
 * @Author lnd
 * @Description DI的实现方式
 * @Date 2022/7/24 23:25
 */
public class Notification {
    
    private MessageSender messageSender;

    // 通过构造函数将 messageSender 传进来
    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message){
        // 省略校验逻辑等
        this.messageSender.send(cellphone, message);
    }
}


package cn.lnd.methodology.solid.dip.di.second;

import cn.lnd.methodology.solid.dip.di.first.MessageSender;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 23:27
 */
public class MainTest {
    public static void main(String[] args) {
        // 使用 Notification
        MessageSender messageSender = new MessageSender();
        Notification notification = new Notification(messageSender);
    }
}
```

通过依赖注入的方式将依赖的类对象传递进来，这样就提高了代码的扩展性，我们可以灵活地替换依赖的类对象。

当然，上面的类还可以继续优化，我们还可以把 MessageSender 定义成接口，基于接口编程而非实现编程。

```java
package cn.lnd.methodology.solid.dip.di.third;

/**
 * @Author lnd
 * @Description DI的实现方式
 * @Date 2022/7/24 23:25
 */
public class Notification {

    private MessageSender messageSender;

    // 通过构造函数将 messageSender 传进来
    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message){
        // 省略校验逻辑等
        this.messageSender.send(cellphone, message);
    }
}


package cn.lnd.methodology.solid.dip.di.third;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 23:38
 */
public interface MessageSender {
    void send(String cellphone, String message);
}

package cn.lnd.methodology.solid.dip.di.third;

/**
 * @Author lnd
 * @Description 短信发送类
 * @Date 2022/7/24 23:38
 */
public class SmsSender implements MessageSender{
    @Override
    public void send(String cellphone, String message) {
        // TODO 发送短信
    }
}

package cn.lnd.methodology.solid.dip.di.third;

/**
 * @Author lnd
 * @Description 邮件发送类
 * @Date 2022/7/24 23:39
 */
public class EmailSender implements MessageSender{
    @Override
    public void send(String cellphone, String message) {
        // TODO 发送邮件
    }
}


package cn.lnd.methodology.solid.dip.di.third;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 23:41
 */
public class MainTest {

    public static void main(String[] args) {
        // 使用 Notification
        MessageSender messageSender = new SmsSender();
        Notification notification1 = new Notification(messageSender);
    }
}
```

事实上，你只需要掌握了上面这个例子，就等于完全掌握了依赖注入。尽管 DI 非常简单，但非常有用。



**那为什么说DI也是一种IoC呢？**

如果把上面的代码抽象成框架，同样，我们只是通过扩展点将我们的核心功能 SmsSender 和 EmailSender 对象构造了出来，对于其之后的处理流程是一概不知的。之后的流程由“框架”帮我们去实现。



### DI Framework

顾名思义，DI Framework 就是『依赖注入框架』。

在刚刚的例子中，虽然我们不需要使用类似于 hardcode 的方式，在类内部通过 new 来创建依赖的对象。但是，这个创建对象、组装（或注入）对象的工作仅仅是被移动到了更上层的代码而已，还是需要我们程序员来自己实现。具体代码如下：

```java
public static void main(String[] args) {
    // 使用 Notification
    MessageSender messageSender = new SmsSender(); // 创建对象
    Notification notification1 = new Notification(messageSender); // 依赖注入
    notification1.sendMessage("13998752418", "短信验证码：257885");
}
```

在实际的项目开发中，一些项目可能会涉及大几百个类，类对象的创建和依赖注入会变得非常复杂。如果这部分工作都靠程序员自己写代码来完成，容易出错且开发成本高。而*对象的创建和依赖注入的工作，本身跟具体的业务无关，我们完全可以抽象成框架来自动完成*。这个框架就是所谓的“DI Framework”。我们只需要通过依赖注入框架提供的扩展点，简单配置一下需要创建的类对象、类与类之间的依赖关系，接下来就可以由框架自动帮我们完成创建对象、管理对象的生命周期、依赖注入等本来需要程序员自己做的事情。

Java 开发中最常见的 DI Framework 就是 Spring。当然，Spring 声称自己是**控制反转容器（Inversion Of Control Container）**。这两种说法都是OK的。控制反转容器表达的是一种更为宽泛的概念，DI Framework 的表述则更为具体。因为实现控制反转的方式有很多，除了依赖注入，还有模板模式等等。而 Spring 框架的控制反转主要是通过依赖注入来实现的。





### DIP

> DIP；Dependency Inversion Principe；依赖反转原则；依赖倒置原则

**定义：**

> High-level modules shouldn't depend on low-level modules. Both modules should depend on abstractions. In addition, abstractions shouldn't depend on details. Details depend on abstractions.

翻译一下就是：高层模块（high-level modules）不要依赖低层模块（low-level modules）。它们共同依赖同一个抽象。除此之外，抽象（abstractions）不要依赖具体实现细节（details），具体实现细节（details）依赖抽象（abstractions）。



所谓的高层模块和低层模块的划分，简单来说就是：在调用链上，调用者属于高层，被调用者属于低层。

在平时的业务代码开发中，高层模块依赖低层模块是没有任何问题的。

实际上，这条原则主要是用来指导框架层面的设计，以 Tomcat 为例。Tomcat 是运行 JavaWeb 应用程序的容器，我们编写的 Web 应用代码只需要部署在 Tomcat 上，就可以被 Tomcat 容器调用执行。按照上面的原则划分，Tomcat 属于高层模块，我们编写的 Web 应用程序代码就是低层模块。Tomcat 和应用程序代码之间并没有直接的依赖关系，但是两者都依赖同一个“抽象”，就是 Servlet 规范。Servlet 规范不依赖具体的 Tomcat 容器和应用程序的实现细节，而 Tomcat 容器和应用程序依赖 Servlet 规范。



