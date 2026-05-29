public class Multithreading1 {
    public void run() {
        Thread t = new Thread(() -> {

            try {

                System.out.println("Thread đang chạy");

                Thread.sleep(3000);

                System.out.println("Thread kết thúc");

            } catch (Exception e) {

            }

        });

        // 1. Chưa start
        System.out.println("1: " + t.getState());

        // 2. Start thread
        t.start();

        // 3. Sau khi start
        System.out.println("2: " + t.getState());

        // đợi 1 chút để thread kịp sleep
        Thread.sleep(100);

        // 4. Trong lúc sleep
        System.out.println("3: " + t.getState());

        // đợi thread chạy xong
        t.join();

        // 5. Sau khi kết thúc
        System.out.println("4: " + t.getState());
    }
}
