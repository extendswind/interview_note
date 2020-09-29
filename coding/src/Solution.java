import java.util.*;


public class Solution {

  // f(n) = max(f(left), f(right))
  // 5 4
  // 4 30 5
  //
  // 5 4 30 11

  int recursive(int[] coins, int left, int right){

    if(left == right){
      return coins[left];
    } else if(right - left <= 1){
      return Math.max(coins[left], coins[right]);
    }

    // player1 拿左
    int left1 = coins[left];
    // player2 从left+1，right范围内拿 如果拿左比拿右大
    int player2Left = recursive(coins, left+2, right);
    int player2Right = recursive(coins, left+1, right - 1);
    if(player2Left > player2Right){
      left1 += recursive(coins, left1 + 2, right);
    } else {
      left1 += recursive(coins, left1 + 1, right - 1);
    }

    // player1 拿右
    int right1 = coins[right];
    // player2 从left，right - 1范围内拿 如果拿左比拿右大
    player2Left = recursive(coins, left+1, right - 1);
    player2Right = recursive(coins, left, right - 2) ;
    if(player2Left > player2Right){
      right1 += recursive(coins, left1 + 1, right - 1);
    } else {
      right1 += recursive(coins, left1, right - 2);
    }

    if(left1 > right1){
      return left1;
    } else {
      return right1;
    }

  }


  /**
   * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
   * 计算你最多能拿走多少面值的硬币？
   * @param coins int整型一维数组 排成一排的硬币的面值
   * @return int整型
   */
  public int maxValue (int[] coins) {
    // write code here
    return recursive(coins, 0, coins.length - 1);
  }

  public static void main(String[] argv){
    Solution solution = new Solution();
    solution.maxValue(new int[]{1, 3, 5});
  }

}