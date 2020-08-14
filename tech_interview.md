

# Basic

## OS

linux常用命令 ls ps kill mkdir chmod 

## Network

### TCP 3次握手

第一次：发送syn请求到服务器，并进入SYN_SENT状态，等待服务器确认。 SYN（Synchronize Sequence Number）
第二次：服务端收到syn请求，确认客户端的syn并返回ack应答；同时也发送一个syn包，服务器进入SYN_RECV状态。
第三次：客户端收到syn请求，确认后返回ack应答到服务器。

重点在于客户端和服务端协调唯一的isn（initial sequence number），为了避免延时、掉包等网络问题，syn请求可能会存在多次发送并带有不同的isn。TCP协议假设syn包的接收端无法确认在接收到带有不同isn的包时哪个包是真正想要的，只有发起端能判断哪些包是超时或者其它原因发送的。因此通过对所有的syn包回复ack发给syn包的发起端，让发起端发送RST（reset）指令拒绝所有不正常的ack应答。

### TCP 4次挥手

3次握手用于连接，4次挥手用于中断连接。

第一次：客户端数据发送完毕时，向服务端发送FIN包通知服务端停止，此时客户端无法发送数据。
第二次：服务端收到FIN请求后回复ack，并等待服务端的数据传输完。
第三次：服务端数据传输晚后发送FIN到客户端。
第四次：客户端确认服务端FIN请求并回复ack，等待2MSL的时候后释放资源（ack可能会丟，此时服务端会重发FIN）。服务端收到ack请求后释放资源。


## JVM

 3、零拷贝。
4、线程池的核心参数以及流程。
5、synchronized 和 lock 的区别。
6、类加载器有哪些，类加载过程。
7、volatile 关键字用处。 

作者：苟一个offer
链接：https://www.nowcoder.com/discuss/474434?type=2&channel=666&source_id=discuss_terminal_discuss_hot
来源：牛客网

讲讲项目中多线程是如何优化下载的？
如果你要下载的文件是静态的呢？能用多线程优化吗？要怎么做？（这个hape问题一个月被问了三次了，每次都答不上，一会去搜搜）
有哪些实现线程同步的方式？
synchronized的底层是怎么实现的？和ReentrantLock的区别？
ThreadLocal的原理是什么，你们在实际项目中用过吗？能讲讲在Spring中的应用吗？
现在有很多线程，我们希望main线程在所有线程执行完后才能执行，你有什么办法？
除了CountdownLatch，其他线程协作的方式你了解吗？
我们知道多进程和多线程都是实现多任务的一种手段，那么你觉得什么时候需要用多进程，什么时候需要用多线程？你自己项目中有没有用到过多进程的情况？
Linux io了解吗？挨个讲讲
讲讲多路复用机制，你觉得什么时候多路复用性能会比较好？
讲讲netty的io模型
讲讲可见性是什么？为什么要有Java内存模型？它给我们的开发带来了什么便利？
数据库用的mysql是吧，hash索引和b+树索引你觉得有什么区别，什么时候用hash索引比较好？
为什么是b+树，而不是红黑树或者bst？
讲讲事务的四个特性
持久性是怎么保证的？为什么不直接把修改的page给刷到盘上，用日志不是多此一举吗？
为什么顺序io比随机io快？随机io的过程是什么？
mvcc是怎么实现的，mvcc能避免幻读吗？
id是auto_increment的，多个事务同时插入数据，为什么能保证id不被重复分配呢？
现在有这样一个需求，用户消费后需要生成订单号，我们希望这个订单号是不唯一的。并且这会涉及很高的并发量，同时需要有很好的性能，你要怎么设计这个系统？
算法题，链表循环右移动k位置，例如1->2->3->4->5，k=2，结果为4->5->1->2->3
还有什么问题？（问了下后续，面试官说还有3面，合着腾讯提前批4面？） 

https://jishuin.proginn.com/p/763bfbd22f89


## Database


# Cloud computing

# Hadoop

1.spark的组件有哪些
2.hadoop的架构
3.hadoop与spark区别
4.hadoop作业提交到yarn流程
5.sparkstreaming连接kafka的两种方式
6.项目中hdfs数据怎么写入hive中
7.项目中的难点，怎么解决的
8.mysql联合索引是什么
9.sparkstreaming直连kafka时，Kafka在某一时刻分区数增加了，下游的spark怎么知道的
10.kafka中消费者组是怎么回事？为什么kafka要设有消费者组？作用是什么
11.kafka中producer,broker,cousumer的关系
12.手撕代码：二叉树的序列化与反序列化 

 导入大文件到HDFS如何自定义分片 
  MR详细过程（没说完，嗯。。。） 
