package Java.JavaExample.Abstraction;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Duck quacks");
    }

    @Override
    public void fly() {
        System.out.println("Duck flies");
    }

    @Override
    public void swim() {
        System.out.println("Duck swims");
    }
}

