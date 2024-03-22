package geek._57.demo03;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 17:40
 */
public class ObserverRegistry {
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    /**
     * 注册 Observer 到 registry 中
     * @param observer
     */
    public void register(Object observer) {
        // 找到当前观察者的所有observerActions
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        // 和registry中的其他observerActions合并
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if (registeredEventActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    /**
     * 找到event可以匹配的类（同类或父类）
     * @param event
     * @return
     */
    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> eventActions = entry.getValue();
            if (postedEventType.isAssignableFrom(eventType)) { // 在这里判断只要 postedEventType 是 eventType 的同类或子类，就会匹配成功!!!
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }

    /**
     *
     * @param observer
     * @return Map<方法参数类型，Collection<ObserverAction>
     */
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Class<?> clazz = observer.getClass();
        // 找到Observer中带有 @Subscribe 注解且只有一个方法入参的所有方法
        List<Method> methods = getAnnotatedMethods(clazz);
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();    // result：按<参数类型, 方法位置>分类保存
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                // 新增
                observerActions.put(eventType, new ArrayList<>());
            }
            // 更新
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    /**
     * 找到一个类中带有 @Subscribe 注解且只有一个方法入参的所有方法
     * @param clazz
     * @return
     */
    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) { // 获取clazz中的所有方法（包括私有方法）
            if (method.isAnnotationPresent(Subscribe.class)) {
                // 校验参数类型：EventBus的观察者只允许有1个参数
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                // 收集符合条件的方法
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
