package com.example.design_pattern.behavior.observer.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObserverAction {

    private final Object target;
    private final Method method;

    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }

    public void execute(Object event){
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
