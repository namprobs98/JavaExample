package Java.JavaExample.InheritanceAndPolymorphism;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name); // Gọi constructor của lớp cha để khởi tạo thuộc tính name
    }

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name); // Gọi constructor của lớp cha để khởi tạo thuộc tính name
    }

    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}
