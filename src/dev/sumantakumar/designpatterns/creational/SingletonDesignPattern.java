package dev.sumantakumar.designpatterns.creational;

import java.io.Serial;
import java.io.Serializable;

public class SingletonDesignPattern implements Serializable, Cloneable {
    private static SingletonDesignPattern instance;

    private SingletonDesignPattern() {
        if (instance != null) {
            throw new RuntimeException("SingletonDesignPattern is already initialized");
        }

    }

    public static SingletonDesignPattern getInstance() {
        if (instance == null) {
            synchronized (SingletonDesignPattern.class) {
                if (instance == null) {
                    instance = new SingletonDesignPattern();
                }
            }

        }
        return instance;
    }

    @Serial
    Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }
}
