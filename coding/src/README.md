# My Leetcode Note


几道[leetcode题](leetcode)加上[《剑指offer》](codingInterviews)和一些[基础](basic)

# 比较好的资料

https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/xue-xi-shu-ju-jie-gou-he-suan-fa-de-gao-xiao-fang-fa



# 动态规划（Dynamic Programming, DP）

似乎是笔试题拉开差距的必考。

https://blog.csdn.net/liukcqu/article/details/81545845

https://zhuanlan.zhihu.com/p/35707293?from=groupmessage  这个划分为一维DP和二维DP的方式可以参考。

https://zhuanlan.zhihu.com/p/126546914

[力扣] DP问题分类汇总

    线性DP；区间DP；背包DP；树形DP；状态压缩DP；数位DP；计数型DP；递推型DP；概率型DP；博弈型DP；记忆化搜索；

1. 线性DP

最经典单串：

300. 最长上升子序列 (LIS)

最经典双串：

1143. 最长公共子序列 (LCS)

经典问题：

120. 三角形最小路径和

53. 最大子序和

152. 乘积最大子数组

887. 鸡蛋掉落 (DP+二分)

354. 俄罗斯套娃信封问题 (隐晦的LIS)

打家劫舍系列: (打家劫舍3 是树形DP)

198. 打家劫舍

213. 打家劫舍 II

股票系列:

121. 买卖股票的最佳时机

122. 买卖股票的最佳时机 II

123. 买卖股票的最佳时机 III

188. 买卖股票的最佳时机 IV

309. 最佳买卖股票时机含冷冻期

714. 买卖股票的最佳时机含手续费

字符串匹配系列

72. 编辑距离

44. 通配符匹配

10. 正则表达式匹配
2. 区间DP

516. 最长回文子序列

730. 统计不同回文子字符串

1039. 多边形三角剖分的最低得分

664. 奇怪的打印机

312. 戳气球
3. 背包DP

416. 分割等和子集 (01背包-要求恰好取到背包容量)

494. 目标和 (01背包-求方案数)

322. 零钱兑换 (完全背包)

518. 零钱兑换 II (完全背包-求方案数)

474. 一和零 (二维费用背包)
4. 树形DP

124. 二叉树中的最大路径和

1245. 树的直径 (邻接表上的树形DP)

543. 二叉树的直径

333. 最大 BST 子树

337. 打家劫舍 III
5. 状态压缩DP

464. 我能赢吗

526. 优美的排列

935. 骑士拨号器

1349. 参加考试的最大学生数
6. 数位DP

233. 数字 1 的个数

902. 最大为 N 的数字组合

1015. 可被 K 整除的最小整数
7. 计数型DP

计数型DP都可以以组合数学的方法写出组合数，然后dp求组合数

62. 不同路径

63. 不同路径 II

96. 不同的二叉搜索树 (卡特兰数)

1259. 不相交的握手 (卢卡斯定理求大组合数模质数)
8. 递推型DP

所有线性递推关系都可以用矩阵快速幂做，可以O(logN)，最典型是斐波那契数列

70. 爬楼梯

509. 斐波那契数

935. 骑士拨号器

957. N 天后的牢房

1137. 第 N 个泰波那契数
9. 概率型DP

求概率，求数学期望

808. 分汤

837. 新21点
10. 博弈型DP

策梅洛定理，SG定理，minimax

翻转游戏

293. 翻转游戏

294. 翻转游戏 II

Nim游戏

292. Nim 游戏

石子游戏

877. 石子游戏

1140. 石子游戏 II

井字游戏

348. 判定井字棋胜负

794. 有效的井字游戏

1275. 找出井字棋的获胜者
11. 记忆化搜索

本质是 dfs + 记忆化，用在状态的转移方向不确定的情况

329. 矩阵中的最长递增路径

576. 出界的路径数


## 斐波拉契数列与跳台阶

> f(n) = f(n-1) + f(n-2)，f(0) = 0, f(1) = 1，求f(n)。

这个实现不复杂，就不上代码了。实现的重点在于直接 `return f(n-1) + f(n-2)` 这种递归的方式效率并不高，一方面在不断的递归过程中重复算了很多次数（如f(n-2)算了两次， f(n-3)算了3次），另一方面递归层数多且不是尾递归。

书中建议直接使用循环，直接按f(2)、f(3)...f(n)的顺序计算，每次记录前面的两个结果。

> 跳台阶：一只青蛙一次可以跳上一个台阶或者两个台阶，问跳上n个台阶一共有多少种方法。

可以先考虑青蛙如果第一次跳1个台阶，则后面一共的方法数为n-1个台阶的方法数；如果第一次跳2个台阶，则后面的方法数为n-2。因此 f(n) = f(n-1) + f(n-2)。（这思维方式...）


## 动态规划的思路

1. 划分子结构。通常是将动态规划的问题划分成f(n) = f(i) + f(n-i)  类似的拆分问题。
2. 子结构的结果可以复用。划分后实质上的求解和穷举类似，如f(n) = f(n-1) + f(i)，穷举i为[0, n)时的结果，直接计算会计算量很大，但是中间f(n-2), f(n-3)等计算了多次，结果可以复用。

## 整数拆分（切绳子）

https://leetcode-cn.com/problems/integer-break/

> 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
> 
> 示例 1:
> 
> 输入: 2
> 输出: 1
> 解释: 2 = 1 + 1, 1 × 1 = 1。
> 
> 示例 2:
> 
> 输入: 10
> 输出: 36
> 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
> 
> 说明: 你可以假设 n 不小于 2 且不大于 58。

剑指offer上有相同的题目，换了种说法叫剪绳子。《算法导论》上动态规划也用了一个类似的割钢筋的例子。

找规律的话可以发现分成的3越多得到的积越大，可以尽量多分成3即可（勉强可以算贪婪算法）。后面主要提DP解法。

### DP解

首先可以任意取第i个位置剪断第一次，绳子会被分成两段，如果设原式的结果为f(n)，则f(n) = max( f(i) * f(n-i) )   当 i=1...n-1 （题目中m>1）。

对于每一段划分后的f(n)，都可以遍历i=[0, n-1]的情况，最后问题转变成求n=[0, n-1]时一系列f(n)的最大值。

这种思维可以用递归从f(n)计算到f(0)，但是如同斐波拉契数列，通过顺序直接计算f(0)、f(1)....f(n)的自底向上的方式会比较容易。

```java
// 2<=n<=60
// 自底向上
public int cutRope(int target) {
    int[] f = new int[target + 1];
    f[2] = 2;
    if(target>=3)
        f[3] = 3;
    for(int i=5; i<=target; i++){
        int max = -1;
        for(int j=2; j<=i/2; j++){
            int fi = f[j] * f[i-j];
            if(fi > max){
                max = fi;
            }
        }
        f[i] = max;
    }
    return f[target];
}
```

动态规划的重点是f(n)与f(n-i)之间如果存在关系（存在子结构），而且子结构的计算结果可以复用，即可逐步推断f(n)的值。


## [leetcode 5](https://leetcode.com/problems/longest-palindromic-substring/) 最大回文子串（Longest Palindromic Substring）

回文子串指对称的字符串，如bb、abba、aba。

> Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
> 
> Example 1:
> 
> Input: "babad"
> Output: "bab"
> Note: "aba" is also a valid answer.
> 
> Example 2:
> 
> Input: "cbbd"
> Output: "bb"

这题感觉不太适合放在DP的题里，因为直接用回文字符串的规律来解更简单，而且思路和DP一致。

回文子串存在两种情况：一种关于一个字符对称，如aba、acbca；另一种直接对称，如abba、acbbca。

遍历整个数组，对于每个字符或者两个相同字符向两边扩展，如果两边出现的字符相同则进一步扩展，直到碰到数组的首尾或者两边出现的字符不同。


## [LeetCode10](https://leetcode.com/problems/regular-expression-matching/) 正则表达式的匹配 Regular Expression Matching

判断一个字符串与正则表达式字符串是否匹配

> Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
> 
> '.' Matches any single character.
> '*' Matches zero or more of the preceding element.
> 
> The matching should cover the entire input string (not partial).
> 
> Note:
> 
>     s could be empty and contains only lowercase letters a-z.
>     p could be empty and contains only lowercase letters a-z, and characters like . or *.

> Example 1:
> 
> Input:
> s = "aa"
> p = "a"
> Output: false
> Explanation: "a" does not match the entire string "aa".
> 
> Example 2:
> 
> Input:
> s = "aa"
> p = "a*"
> Output: true
> Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

题目中只要求对'.'  '*'两种符号进行解析，其中'.'较为容易，能够代替一个字符，重点在于*用来代替几个字符比较合适。

### Dp解

一种bool类型的二维DP。

将dp(i, j)定义为：字符串s的第i个字符向后的部分（s[i:]）与正则表达式第j个字符向后的部分（p[j:]）匹配。

因此dp(i,j)为true的条件为s[i] == p[j] && dp(i+1, j+1)  





