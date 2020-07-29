package Java8.f2_stream.parallel;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class testForkJoin {
    private static final long target = 10000000000L;

    @Test
    public void test1() {
        Instant now = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        Fork_Join forkJoin = new Fork_Join(1L, target);
        Long result = pool.invoke(forkJoin);
        System.out.println(result);

        Instant end = Instant.now();
        System.out.println(Duration.between(now,end).toMillis());
    }

    @Test
    public void test2() {
        Instant now = Instant.now();

        long sum = 0L;
        for (long i = 0L; i < target; i++) {
            sum += i;
        }
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(now,end).toMillis());
    }

    @Test
    public void test() {
        Instant now = Instant.now();

        long result = LongStream.rangeClosed(0L, target)
                //切换到顺序流
                .sequential()
                //切换到并行流
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(result);

        Instant end = Instant.now();
        System.out.println(Duration.between(now,end).toMillis());
    }
}
