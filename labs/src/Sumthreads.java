import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Sumthreads {
    public static int Threads=10;
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ExecutorService executor = Executors.newFixedThreadPool(Threads);
        int partSize = array.length / Threads;

        for (int i = 0; i < Threads; i++) {
            int start = i * partSize;
            int end = (i + 1) * partSize;
            if (i == Threads-1) {
                end = array.length;
            }
            int[] part = new int[end - start];
            System.arraycopy(array, start, part, 0, end - start);
            executor.execute(new ArrayProcessor(part));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int totalSum = ArrayProcessor.getTotalSum();
        System.out.println("Total sum: " + totalSum);
    }
}
class ArrayProcessor implements Runnable {
    private int[] part;
    private static int totalSum = 0;
    public ArrayProcessor(int[] part) {
        this.part = part;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int num : part) {
            sum += num;
        }
        totalSum += sum;
    }
    public static int getTotalSum() {
        return totalSum;
    }
}