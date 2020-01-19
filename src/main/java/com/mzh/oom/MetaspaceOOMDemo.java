package com.mzh.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MetaspaceOOMDemo {
    static class MetaspaceOOM {}

    public static void main(String[] args) {
        int i=0;

        try{
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(MetaspaceOOM.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return method.invoke(o,args);
                    }
                });

                enhancer.create();
            }
        }catch (Exception e){
            System.out.println("多少次后元空间满了："+i);
            e.printStackTrace();
        }

    }
}
