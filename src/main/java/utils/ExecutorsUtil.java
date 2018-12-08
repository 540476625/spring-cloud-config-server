package utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsUtil {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1, 5, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3));

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task());// 提交十个任务给线程池
        }
        executorService.shutdown();
    }

    static class Task implements Runnable {

        private static AtomicInteger number = new AtomicInteger(0);

        public int taskId = number.addAndGet(1);

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " task:" + taskId + " start...");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " task:" + taskId + " end...");
        }
    }
}
