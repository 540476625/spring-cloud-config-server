package utils;

import java.util.concurrent.*;

public class NettyServer {
    public static void init(){
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println(222);
        });
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new Roommate(barrier, i));
        }
    }

    static class Roommate implements Runnable {
        private CyclicBarrier barrier;
        private int id;

        public Roommate(CyclicBarrier barrier, int i) {
            this.barrier = barrier;
            this.id = i;
        }

        @Override
        public void run() {
            System.out.println(id + " : 我到了");
            try {
                //通知barrier，已经完成动作，在等待
                barrier.await();
                System.out.println("Id " + id + " : 点菜吧!我要吃"+id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (BrokenBarrierException e){
            }
        }
    }

    public static void main(String[] args) {
        init();
    }
}