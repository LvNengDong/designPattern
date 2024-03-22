package geek._57.demo03;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author lnd
 * @Description 表示被 @Subscribe 注解修饰的方法
 * @Date 2024/3/22 17:49
 */
@Slf4j
public class ObserverAction {

    private Object target;

    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true); //只有现在这里设置方法可访问才能访问其私有方法
    }

    public void execute(Object event) { // event是method方法的参数
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
