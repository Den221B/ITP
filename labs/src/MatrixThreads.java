import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MatrixThreads {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 45115, 3, 4},
                {5, 841, 74451, 15},
                {9, 10, 89, 12},
                {13, 845, 15, 16}
        };
        int numThreads = 2;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        AtomicInteger maxValue = new AtomicInteger(matrix[0][0]);
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            executor.submit(() -> {
                int localMax = findMaxInPart(matrix, threadId, numThreads);
                maxValue.updateAndGet(current -> Math.max(current, localMax));
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Max value: " + maxValue);
    }
    private static int findMaxInPart(int[][] matrix, int start, int step) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < matrix.length; i += step) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }
}
