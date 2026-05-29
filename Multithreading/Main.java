public class Main {

    public static void main(String[] args) throws Exception {
        // 1. Trạng thái của thread
        // Multithreading1 t1 = new Multithreading1();
        // t1.start();

        //2. Chạy nhiều thread
        // Multithreading2 t2 = new Multithreading2();
        // t2.run();

        //3. Race condition
        // Multithreading3 t3 = new Multithreading3();
        // t3.run();

        //4. Volatile
        // Multithreading4 t4 = new Multithreading4();
        // t4.run();

        //5. ThreadLocal
        Multithreading5 t5 = new Multithreading5();
        t5.run();
    }
}