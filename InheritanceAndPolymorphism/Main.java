package Java.JavaExample.InheritanceAndPolymorphism;

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog("Buddy");
        Animal myCat = new Cat("Whiskers");

        myDog.sound(); // Output: Dog barks
        myCat.sound(); // Output: Cat meows

        System.out.println(myDog instanceof Dog); // Output: true
        System.out.println(myDog instanceof Cat); // Output: false
    }
}
