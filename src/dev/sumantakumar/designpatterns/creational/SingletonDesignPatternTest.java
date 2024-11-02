package dev.sumantakumar.designpatterns.creational;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDesignPatternTest implements Runnable {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
        SingletonDesignPattern obj0 = SingletonDesignPattern.getInstance();
        SingletonDesignPattern obj1 = SingletonDesignPattern.getInstance();
        SingletonDesignPattern obj2 = SingletonDesignPattern.getInstance();
        System.out.println(obj0.hashCode());
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());


        System.out.println("-------Serialization Started-------");

        FileOutputStream fos = new FileOutputStream("C:/Users/suman/IdeaProjects/Design Patterns/files/SingletonDesignPatternSerialization.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(obj0);

        FileInputStream fis = new FileInputStream("C:/Users/suman/IdeaProjects/Design Patterns/files/SingletonDesignPatternSerialization.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        SingletonDesignPattern obj = (SingletonDesignPattern) objectInputStream.readObject();
        System.out.println(obj.hashCode());

        System.out.println("#######Serialization Ended#######");


        System.out.println("-------Multithreading Started-------");

        SingletonDesignPatternTest firstThread = new SingletonDesignPatternTest();
        SingletonDesignPatternTest secondThread = new SingletonDesignPatternTest();

        Thread thread1 = new Thread(firstThread);
        Thread thread2 = new Thread(secondThread);

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        thread1.start();
        thread2.start();



        System.out.println("#######Multithreading Ended#######");

        System.out.println("-------Clone Started-------");
        SingletonDesignPattern clone = (SingletonDesignPattern) obj0.clone();
        System.out.println(clone.hashCode());


        System.out.println("#######Clone Ended#######");

        System.out.println("-------Reflection Started-------");

        Constructor<SingletonDesignPattern> declaredConstructor = SingletonDesignPattern.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingletonDesignPattern object = declaredConstructor.newInstance();
        System.out.println(object.hashCode());

        System.out.println("#######Reflection Ended#######");











    }

    @Override
    public void run() {
        SingletonDesignPattern object = SingletonDesignPattern.getInstance();
        System.out.println(object.hashCode()+"\t"+Thread.currentThread().getName());
    }
}
