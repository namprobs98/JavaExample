package Java.JavaExample.Encapsulation;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alice", 20);
        System.out.println(student);

        // Update student information
        student.setName("Bob");
        student.setAge(22);
        System.out.println(student);
        //Muốn truy cập trực tiếp vào các thuộc tính phải thông qua các phương thức getter và setter
    }
}
