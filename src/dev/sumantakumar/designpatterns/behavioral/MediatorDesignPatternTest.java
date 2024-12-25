package dev.sumantakumar.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class MediatorDesignPatternTest {

    public static void main(String[] args) {

        ChatMediator chatMediator = new ChatMediatorImpl();
        User user = new UserImpl("Sumant", chatMediator);
        User user1 = new UserImpl("Sumair", chatMediator);
        User user2 = new UserImpl("Shadab", chatMediator);
        User user3 = new UserImpl("Swastik", chatMediator);
        chatMediator.addUser(user);
        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);
        user.send("Hello Team");
        user1.send("Hi");
        user2.send("Hello");


    }
}

interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

abstract class User{
    protected final String name;
    protected final ChatMediator chatMediator;

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    abstract void send(String message);
    abstract void receive(String message);
}

class UserImpl extends User{
    public UserImpl(String name, ChatMediator chatMediator) {
        super(name, chatMediator);

    }

    @Override
    void send(String message) {
        System.out.println(this.name+ ": Sending Message=" + message);
        chatMediator.sendMessage(message, this);

    }

    @Override
    void receive(String message) {
        System.out.println(this.name+ ": Received Message=" + message);

    }
}

class ChatMediatorImpl implements ChatMediator{

    private final List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        this.users.stream()
                .filter(each -> each != user)
                .forEach(each -> each.receive(message));


    }

    @Override
    public void addUser(User user) {
        users.add(user);

    }
}
