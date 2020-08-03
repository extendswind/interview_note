package leetcode.leetcode3;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int begin = 0;
        int result = 1;
        for (int end = 1; end < s.length(); end++) {
            char next = s.charAt(end);
            int index = s.substring(begin, end).lastIndexOf(next);
            if (index == -1) {
                result = Math.max(result, end - begin + 1);
            } else {
                begin += index + 1;
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int begin = 0;
        int result = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int end = 1; end < s.length(); end++) {
            char next = s.charAt(end);
            Integer index = map.get(next);
            if (index == null || index < begin)
                result = Math.max(result, end - begin + 1);
            else
                begin = index + 1;
            map.put(next, end);
        }
        return result;
    }
}

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] argvs) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(s.lengthOfLongestSubstring2("tmmzuxt"));
        Map<Integer, Integer> test = new HashMap<>();
        test.put(1, 2);
        test.put(1, 3);
        test.get(1);
        System.out.println(test);
    }
}


/*
方案一暴力穷举，显然首先不考虑

方案二，上面的实现，取第一个数作为子串，向子串后添加字母，如果添加的字母在已有子串中已经存在相同的字母，则丢弃子串中已存在字母前放的所有字母。

方案二中查找子串里已经存在的字母使用了lastIndexOf函数，可以进一步改成hashMap提高查找效率（下面的lengthOfLongestSubstring2）

最快的解决方案是自己实现一个Map，使用一个128位的数组

leetcode 后面solution2有问题，运行结果出错
 */