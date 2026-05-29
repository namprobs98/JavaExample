public class Multithreading2 {
    public void run() {
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 1: " + i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2: " + i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
            }
        });
        
        t1.start();

        try {

            t1.join();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        t2.start();
    }
}
