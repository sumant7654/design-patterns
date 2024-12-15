package dev.sumantakumar.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class MementoDesignPatternTest {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        CareTaker careTaker = new CareTaker();

        textEditor.type("Hello, ");
        careTaker.addMemento(textEditor.save());

        textEditor.type("Sumanta Kumar Sahoo!");
        careTaker.addMemento(textEditor.save());

        textEditor.type(" How are you?");
        careTaker.addMemento(textEditor.save());

        textEditor.restore(careTaker.getMemento(1));
        System.out.println("After Undo : "+textEditor.getText());

        textEditor.restore(careTaker.getMemento(0));
        System.out.println("After Undo : "+textEditor.getText());

    }
}

class Memento{
    private String state;
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}

class TextEditor{
    private StringBuilder text;

    public TextEditor() {
        text = new StringBuilder();
    }
    public void type(String text) {
        this.text.append(text);
    }
    public String getText() {
        return text.toString();
    }

    public Memento save() {
        return new Memento(text.toString());
    }

    public void restore(Memento memento) {
        text = new StringBuilder(memento.getState());
    }
}

class CareTaker{
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }
    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}