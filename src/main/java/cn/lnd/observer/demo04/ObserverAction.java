package cn.lnd.observer.demo04;

import com.google.common.base.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author lnd
 * @Description ObserverAction 类用来表示 @Subscribe 注解的方法，其中，Target表示观察者类，method表示类中的方法。
 * 它主要用在 ObserverRegistry 观察者注册表中
 * @Date 2022/9/20 20:32
 */
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }


    public void execute(Object event) { //event是method方法的参数
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
