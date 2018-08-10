package per.yang.forkAndJoin;

import java.util.concurrent.*;

/**
 * Created by songbao.yang on 2017/6/18.
 */
public class CountTask extends RecursiveTask<Integer> {

    private int start;
    private int end;
    private static final int M = 10000000;
    private static final int THRESHOLD = M / 2;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    protected Integer compute() {

        int sum = 0;

        if (end - start <= THRESHOLD){
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int mid = (start + end) / 2;
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid + 1, end);

            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResut = rightTask.join();

            sum += leftResult + rightResut;
        }
        return sum;
    }

    public static void main(String[] args) {


        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, M);
        long s1 = System.currentTimeMillis();
        Future<Integer> result = forkJoinPool.submit(countTask);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long e1 = System.currentTimeMillis();
        System.out.println("time1: " + String.valueOf(e1 - s1));


        long s2 = System.currentTimeMillis();
        int sum = 0;
        for (int i = 1; i < M ; i++) {
            sum += i;
        }
        System.out.println(sum);
        long e2 = System.currentTimeMillis();
        System.out.println("time2: " + String.valueOf(e2 - s2));
    }
}
