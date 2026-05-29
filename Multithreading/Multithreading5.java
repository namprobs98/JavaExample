import java.util.concurrent.atomic.AtomicInteger;


public class Multithreading5 {
    public void run() {
        BankAccountWithAtomic account = new BankAccountWithAtomic();

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

class BankAccountWithAtomic {
    // Thay vì dùng int balance = 100, ta dùng AtomicInteger
    private AtomicInteger balance = new AtomicInteger(100);

    public void withdraw(int amount) {
        while (true) {
            // Bước 1: Lấy số dư hiện tại trong tài khoản
            int currentBalance = balance.get();

            // Bước 2: Kiểm tra xem có đủ tiền để rút không
            if (currentBalance < amount) {
                System.out.println(Thread.currentThread().getName() + " thất bại: Không đủ tiền để rút.");
                break; // Thoát vòng lặp vì chắc chắn không rút được nữa
            }

            // Bước 3: Tính số dư mới sau khi rút
            int newBalance = currentBalance - amount;

            // Bước 4: Dùng lệnh CAS (compareAndSet) để cập nhật an toàn
            // "Nếu số dư thực tế tại giây này VẪN LÀ currentBalance, thì hãy đổi nó thành newBalance"
            if (balance.compareAndSet(currentBalance, newBalance)) {
                System.out.println(Thread.currentThread().getName() + " RÚT THÀNH CÔNG " + amount + "$");
                System.out.println("Số dư còn lại: " + balance.get() + "$");
                break; // Rút tiền thành công, thoát vòng lặp
            }

            // Nếu compareAndSet trả về false (đứa kia đã nhanh tay rút trước và làm thay đổi số dư)
            // Vòng lặp 'while(true)' sẽ tự động chạy lại, lấy số dư mới và kiểm tra lại từ đầu.
        }
    }
}