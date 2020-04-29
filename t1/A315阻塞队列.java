import java.util.Scanner;

/*
单生产者-单消费者情况

1. 是不是线程安全的？   是否有共享，是否有修改?
2. 怎么修改成线程安全的版本？ 通过加锁解决
                              volatile 不可以解决问题
3. 生产者在队列满时等待-消费者在队列空时等待
4. 生产者需要唤醒可能在等消费者；消费者需要唤醒可能在等的生产者
*/
public class A315阻塞队列 {
    int[] array = new int[10];  // 下标处的数据可能出现生产者和消费者修改同一处的情况
    int front = 0;  // 只有消费者修改 front
    int rear = 0;   // 只有生产者修改 rear
    int size = 0;   // size 是生产者消费者都会修改的

    // 生产者才会调用 put
    synchronized void put(int value) throws InterruptedException {
        // 考虑满的情况
        if (size == array.length) {
            // 队列已满
            //throw new RuntimeException("队列已满");
            wait();
        }

        array[rear] = value;
        rear++;
        if (rear == array.length) {
            rear = 0;
        }
        //rear = (rear + 1) % array.length;
        size++;     // 我们需要保障的是 size++ 的原子性，所以 volatile 无法解决
        notify();
    }

    // 调用 take 的一定是消费者
    synchronized int take() throws InterruptedException {
        // 考虑空的情况
        if (size == 0) {
            // 空的
            //throw new RuntimeException("队列已空");
            wait();
        }

        int value = array[front];
        front++;
        if (front == array.length) {
            front = 0;
        }
        //front = (front + 1) % array.length;
        size--;
        notify();

        return value;
    }

    static A315阻塞队列 queue = new A315阻塞队列();

    static class Producer extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println("准备放入 " + i);
                    queue.put(i);
                    System.out.println("放入成功");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        producer.start();

        Thread.sleep(2 * 1000);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            scanner.nextLine();
            System.out.println(queue.take());
        }
    }
}