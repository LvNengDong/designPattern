package cn.lnd.observer.demo04;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author lnd
 * @Description ObserverRegistry 类就是前面讲到的 Observer 注册表，记录了消息类型与可接受消息的回调函数之间的对应关系
 * 对于观察者来说，需要将自身的类型，以及回调方法（包括回调方法的参数）注册到注册表中；
 * 对于被观察者而言，它在event事件发生后，需要通知所有满足条件的观察者，利用反射语法执行观察者的监听方法
 * <p>
 * 当调用 register() 函数注册观察者的时候，EventBus 通过解析 @Subscribe 注解，生成 Observer注册表
 * 当调用 post() 函数发送消息的时候，EventBus 通过注册表找到相应的可接收消息的函数，然后通过Java的反射语法来动态地创建对象，执行函数
 * <p>
 * 对于同步阻塞模式，EventBus 在一个线程内依次执行相应的函数；对于异步非阻塞模式，EventBus 通过一个线程池来执行相应的函数
 * @Date 2022/9/20 20:33
 */
public class ObserverRegistry {
    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    /**
     * 注册观察者
     * 解析 @Subscribe 注解，生成 Observer注册表
     *
     * @param observer 观察者
     */
    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue(); //观察者中对应的方法

            //使用写时复制技术将 消息类型与可接受消息的回调函数之间的对应关系 复制出去，以解决读写并发问题
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if (registeredEventActions == null) {
                registry.put(eventType, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }


    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> entryType = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> eventActions = entry.getValue();
            if(postedEventType.isAssignableFrom(entryType)){
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }

    /**
     * 找到某个观察者的所有注册成功的行为
     *
     * @param observer 观察者实例
     * @return
     */
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        //Map中的key是Class类型，值是Set类型，也就是说：一个Class可以对应多个值，这也对应了一个event可以被多个观察者的方法订阅
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();

        for (Method method : getAnnotatedMethods(clazz)) { //得到类中含有@Subscribe注解的方法
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0]; //取方法第一个参数的类型，作为event的类型
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
            /*
                集合中有多个元素，key是event的Class类型，value 是 Observer与对应methods 的集合
                {
                    Integer : (observerA, methodA),
                    String : (observerA, methodB))
                }
            */
        }
        return observerActions;
    }

    /**
     * 找到一个类中含有 @Subscribe 注解的方法
     *
     * @param clazz
     * @return
     */
    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
