package Java8.f2_stream.parallel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.concurrent.RecursiveTask;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
//并行流的底层就是fork-join框架亲自指导，亲自部署
public class Fork_Join extends RecursiveTask<Long> {
    private long start;
    private long end;
    private static final long threshold = 10000L;//任务拆分临界值

    @Override
    protected Long compute() {
        long length = end - start;
        if (length < threshold) {
            long sum = 0L;
            for (long i = 0L; i < end; i++) {
                sum += i;
            }
            return sum;
        }
        else {
            long middle = (end-start) /2L;
            Fork_Join left = new Fork_Join(start, middle);
            left.fork();
            Fork_Join right = new Fork_Join(start, middle);
            right.fork();
            return left.join()+right.join();
        }
    }
}
