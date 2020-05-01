import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    static class Worker extends Thread {
        private BlockingQueue<Runnable> workQueue;

        Worker(BlockingQueue<Runnable> workQueue) {
            this.workQueue = workQueue;
        }

        @Override
        public void run() {
            // 员工要的事情
            // 不停的

            while (true) {
                // 从队列中取任务，当队列为空时，线程就会阻塞，否则就一直工作
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 完成任务
                task.run();
            }
        }
    }

    // 1. 传递任务用的阻塞队列
    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

    // 2. 基础所有的线程对象
    // 公司里管理员工用的员工表
    List<Worker> workerList = new ArrayList<>();

    CustomThreadPool(int nThreads) {
        // 1. 创建阻塞队列，done
        // 2. 创建所有的工作线程
        for (int i = 0; i < nThreads; i++) {
            Worker worker = new Worker(workQueue); //给员工传入任务队列
            worker.start();//员工领任务
            workerList.add(worker);//员工进员工名单
        }
    }

    // 前台要做的就是把接到的任务放到队列中即可
    // 工作线程会在合适的时候过来取任务的
    void execute(Runnable task) throws InterruptedException {
        workQueue.put(task);
    }
}
