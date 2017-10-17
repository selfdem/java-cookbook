package cc.selfdem.cookbook.adder;

import java.util.concurrent.atomic.LongAdder;

/**
 * 使用了https://github.com/palominolabs/java-8-benchmarks.git的代码
 */
final class LongAdderBenchmark extends IncrementingBenchmark {
    LongAdder counter;

    public LongAdderBenchmark(int numThreads) {
        super(numThreads);
    }

    @Override
    protected void initializeCounter() {
        counter = new LongAdder();
    }

    @Override
    protected void incrementCounter() {
        counter.increment();
    }

    @Override
    protected void clearCounter() {
        counter.reset();
    }

    @Override
    protected long getCounterValue() {
        return counter.longValue();
    }

    public static void main(String[] args) {
        LongAdderBenchmark longAdderBenchmark = new LongAdderBenchmark(getNumThreads(args));
        try {
            longAdderBenchmark.benchmark();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}