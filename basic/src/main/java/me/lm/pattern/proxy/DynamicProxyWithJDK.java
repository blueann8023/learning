package me.lm.pattern.proxy;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/18
 */
public class DynamicProxyWithJDK {

    public static void main(String[] args) {

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("I am 11 years old");
//                return InvocationHandler.invokeDefault(proxy, method, args);
                return proxy;
            }
        };

        Person girl = new Girl();
        girl.sayHello();

        Person girlProxy = (Person) Proxy.newProxyInstance(girl.getClass().getClassLoader(),
                new Class<?>[]{Person.class},
                handler);
        girlProxy.sayHello();
    }

}
