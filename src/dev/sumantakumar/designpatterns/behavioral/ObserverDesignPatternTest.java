package dev.sumantakumar.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPatternTest {
    public static void main(String[] args) {
        Observer sumant = new ConcreteObserver("sumant");
        Observer sumair = new ConcreteObserver("sumair");
        Observer john = new ConcreteObserver("john");
        Observer joe = new ConcreteObserver("joe");

        ConcreteSubject java = new ConcreteSubject();
        java.registerObserver(sumant);
        java.registerObserver(sumair);
        java.registerObserver(joe);
        ConcreteSubject springboot = new ConcreteSubject();
        springboot.registerObserver(john);
        springboot.registerObserver(joe);

        java.notifyObservers("Our next batch is going to starts on next Monday.");
        springboot.notifyObservers("Our session has been completed. Material uploaded to cloud.");

    }
}

interface Observer{
    void update(String message);
}

class ConcreteObserver implements Observer{
    String name;
    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+" => Course Updates: " + message);
    }

}

interface Subject{
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(String message);
}

class ConcreteSubject implements Subject{
    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(" ->"+message));
    }
}

