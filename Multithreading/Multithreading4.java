public class Multithreading4 {

    private static volatile boolean running = true;

    public void run() {

        // Thread 1: chạy vòng lặp
        Thread thread1 = new Thread(() -> {

            while (running) {
                System.out.println("Thread 1 đang chạy...");
            }

            System.out.println("Thread 1 đã dừng!");
        });

        // Thread 2: đổi giá trị sau 3 giây
        Thread thread2 = new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            running = false;

            System.out.println("Thread 2 đã đổi running = false");
        });

        thread1.start();
        thread2.start();
    }

}
