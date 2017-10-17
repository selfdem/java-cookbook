#### 6.1 多线程下的计数器
在多线程的环境下，普通的计算器将不能正常工作。当前JAVA有两种解决方案：
- Atomic相关类
- Adder相关类  

（凡是都想自己加解锁的大神除外）

这两种有什么区别呢，该如何使用呢，简单一句话：追求高性能用Adder，否则，用Atomic（据传Atomic在极端情况下会出错，反正我没测出来）。
为了验证性能，做了如下实验：（代码参见：cc.selfdem.cookbook.adder目录）
- 实验环境：JAVA8，mac pro 4核 16G，idea
- 以Long类加器作为case
- 每个线程计数10000000次，每种参数迭代20次，求相关统计值
- 结果中Mean表示每ms平均执行计数的次数，stdev为标准差

AtomicLong实验结果如下：
```
thread_num: 1 Mean: 152498 ops/ms, stdev: 6949 ops/ms (min: 140211, max: 162579)  
thread_num: 2 Mean: 41814 ops/ms, stdev: 1664 ops/ms (min: 39053, max: 44570)  
thread_num: 3 Mean: 44645 ops/ms, stdev: 1146 ops/ms (min: 43141, max: 47051)  
thread_num: 4 Mean: 32740 ops/ms, stdev: 1365 ops/ms (min: 31630, max: 37150)  
thread_num: 5 Mean: 32203 ops/ms, stdev: 506 ops/ms (min: 31177, max: 33204)  
thread_num: 6 Mean: 35676 ops/ms, stdev: 1697 ops/ms (min: 33764, max: 39385)  
thread_num: 7 Mean: 32245 ops/ms, stdev: 1076 ops/ms (min: 30901, max: 35093)  
thread_num: 8 Mean: 31501 ops/ms, stdev: 253 ops/ms (min: 31231, max: 32241)  
thread_num: 9 Mean: 33564 ops/ms, stdev: 1532 ops/ms (min: 31408, max: 36635)  
thread_num: 10 Mean: 36830 ops/ms, stdev: 2336 ops/ms (min: 31940, max: 41377)
```
LongAdder实验结果如下：
```
thread_num: 1 Mean: 87663 ops/ms, stdev: 5369 ops/ms (min: 81107, max: 99633)
thread_num: 2 Mean: 187460 ops/ms, stdev: 5602 ops/ms (min: 168395, max: 194601)
thread_num: 3 Mean: 282770 ops/ms, stdev: 4975 ops/ms (min: 268761, max: 288266)
thread_num: 4 Mean: 368081 ops/ms, stdev: 19482 ops/ms (min: 298827, max: 383649)
thread_num: 5 Mean: 404446 ops/ms, stdev: 12542 ops/ms (min: 378003, max: 418959)
thread_num: 6 Mean: 451809 ops/ms, stdev: 6099 ops/ms (min: 439129, max: 464760)
thread_num: 7 Mean: 491976 ops/ms, stdev: 12950 ops/ms (min: 450113, max: 507836)
thread_num: 8 Mean: 527518 ops/ms, stdev: 22440 ops/ms (min: 484248, max: 561902)
thread_num: 9 Mean: 547394 ops/ms, stdev: 21160 ops/ms (min: 494768, max: 580660)
thread_num: 10 Mean: 579443 ops/ms, stdev: 14233 ops/ms (min: 563640, max: 612671)
```
> 从结果中可以看出，Atomic在多线程下远不及Adder，那就使用Adder吧。
