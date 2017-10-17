package cc.selfdem.cookbook.adder;

/**
 * 使用了https://github.com/palominolabs/java-8-benchmarks.git的代码
 * 修改感觉不合理的代码
 */
class IncrementingBenchmarkThread implements Runnable {
    protected IncrementingBenchmark controller;

    IncrementingBenchmarkThread(IncrementingBenchmark controller) {
        this.controller = controller;
    }

    public void run() {
        for (int i = 0; i < controller.addCount; i++) {
            controller.incrementCounter();
        }
        controller.waitForBarrier();
    }
}