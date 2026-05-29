public class Multithreading3 {
    public void run() {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            account.withdraw(80);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            account.withdraw(80);
        }, "Thread-2");

        t1.start();
        t2.start();
    }

}

class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
//  public  void withdraw(int amount) {
        if (balance >= amount) {

            System.out.println(Thread.currentThread().getName()
                    + " đang chuẩn bị rút tiền...");

            // Giả lập delay
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            balance -= amount;

            System.out.println(Thread.currentThread().getName()
                    + " rút thành công " + amount
                    + "$ | Số dư còn lại: " + balance + "$");

        } else {
            System.out.println(Thread.currentThread().getName()
                    + " không đủ tiền để rút.");
        }
    }
}
public class VolatileExample {

    private static boolean running = true;
    public static void main(String[] args) {

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