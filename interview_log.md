
随手记了两家公司的面试题，重点考的就直接写笔记里没单独记了。

# Shopee 虾皮

相对一线大厂还是简单了一个量级，难度比58这种略高一点，作为第一个面的公司什么准备都没有才被无脑凉了。

## 一面

自我介绍（要求重点介绍项目）

怼项目（重点在于Hadoop相关部分）

Hadoop相关问题的延伸（HDFS写数据流程，要求越详细越好）

TCP 4次挥手流程（要求越详细越好）

如果要实现一个HashMap怎么做，算法复杂度多少。

手撸快排。（有思路没撸出来）

面试官评价：各方面的知识虽然能说出大概，但都缺乏深入。


## 二面

没有自我介绍...

上来直接撸算法题，从排好序的数组中找相加的和为k的两个数。结果正确的基础上，如何优化代码提高可读性。

怼项目（Hadoop相关部分）

延伸到Hadoop相关问题：

- namenode的主要职责，元数据的形式
- 介绍namenode宕机的恢复过程
- namenode启动时datanode向namenode的心跳报告内容
- block划分的原因
- HDFS写数据流程

一个多线程代码，判断是否会跳出线程。（主要考察线程中对类静态成员变量的访问）

linux bash，一行命令，输出文件中某关键字的出现的行数。

有没有时间实习。

面试官评价：对java基本的多线程、GC等缺乏了解，对Hadoop源码的阅读不够。（和一面结论差不多，理解都不够深）

## 三面

问的三个问题都是盲点，凉凉。

怼项目

1. 一个线程生成key-value对，另外一个线程合并相同的key对value求和；
2. SQL语句，合并表里相同人姓名的成绩求和；
3. 最后linux bash脚本求去除表头后第二列值的和。 （看我动不了手允许google）

未来的发展规划

面试官评价：多重视基础。


# alibaba

最开始感觉面试范围略广，之后才发现是因为其它的公司要求太低...

## 一面  0827

不知道达到什么程度能够达到面试要求，不过这个面试范围和节奏，其它几家都没怎么见过...

网络：tcp流量控制（不会）

操作系统：fork一个进程会不会复制整个内存（不会）

进程之间的通信有哪几种形式（只知道文件和socket），127.0.0.1的socket传输过不过网卡

CAP理论有没有了解

有没有用过Redis （没有）

B+树优点

跳表 （不知道）

kafka用于什么场景

负载均衡算法有没有了解，比如随机、轮询（不会）

一致性hash有没有了解

怎么实现一个hash表

一个上百G文件电话号码里找到h重复的电话号码

缓存的LRU算法有没有了解


```java
//评测题目: 只有8MB内存，有大量用户信息存在于若干个文件或远程存储中，可以通过
//std::string GetUserInfoFromDisk(const std:string& uid)
//来获取某个用户的信息，本接口耗时约10ms+，且不稳定，可能出现较高的延迟毛刺。
//现有一个场景会随机或重复请求访问用户信息，请实现一个缓存类或一个方法，能够取得较高的期望性能。
//如std::string GetUserInfoFromCache(const std:string& uid)，
//其中可以调用GetUserInfoFromDisk来获取真实数据

GetUserInfoFromCache
{

    int maxCache = ...;  // 这个命名应该是maxCount
	Queue<String> uidQueue = new Queue<String>();
    
    Map<String, String> uinfoMap = new HashMap<String>();
    
    // 缓存命中
    if(uinfoMap.exist(uid)）{
    	return uinfoMap.get(uid);
    } else {
    	uidQueue.add(uid);
        String currentInfo = GetUserInfoFromDisk(uid);   // 这个函数能不能加锁（不能，避免磁盘问题导致整个并发挂了）
        uinfoMap.add(uid, currentInfo);
        
		if(uidQueue.size() > maxCache){ // 这个地方可以考虑用内存做标记
            String toRemoveUid = uidQueue.getFirst();   // 最好把访问频率高的放到队列后
            uidQueue.removeFirst();
            uinfoMap.remove(toRemoveUid);
        }
		return currentInfo;       
        
    }
    
    // 追问：高并发情况在哪加锁
    //      ConcurrentHashMap实现
}

```
