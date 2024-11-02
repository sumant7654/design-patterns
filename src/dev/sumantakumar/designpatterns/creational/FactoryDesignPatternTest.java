package dev.sumantakumar.designpatterns.creational;

public class FactoryDesignPatternTest {
    public static void main(String[] args) {
        FactoryDesignPattern factoryDesignPattern = new FactoryDesignPattern();
        Notification email = factoryDesignPattern.createNotification(NotificationMode.EMAIL);
        email.sendNotification();
        Notification text = factoryDesignPattern.createNotification(NotificationMode.TEXT);
        text.sendNotification();
        Notification whatsApp = factoryDesignPattern.createNotification(NotificationMode.WHATS_APP);
        whatsApp.sendNotification();
    }
}

interface Notification{
    void sendNotification();
}

class EmailNotification implements Notification{

    @Override
    public void sendNotification() {
        System.out.println("Email Notification");
    }

}

class TextNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("Text Notification");
    }
}

class WhatsAppNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("WhatsApp Notification");
    }
}

class FactoryDesignPattern{
    public Notification createNotification(NotificationMode mode){
        return switch (mode) {
            case EMAIL -> new EmailNotification();
            case TEXT -> new TextNotification();
            case WHATS_APP -> new WhatsAppNotification();
        };
    }
}

enum NotificationMode{
    TEXT,
    EMAIL,
    WHATS_APP
}



