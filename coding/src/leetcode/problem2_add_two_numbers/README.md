
# Add two numbers

 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

## 基本流程

对于每一位

从第一位开始遍历两个list。

对每一位{
  相加两个list中的数以及前一位的进位
  取个位和十位（向后进位，相加时十位为0或1）。
  判断结果list中是否需要下一个节点（list有下一个节点或有进位）
  如果是则添加下一个节点，进入下一次循环。否则结束循环。
}

## 实现代码

```java
public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
  ListNode cur = new ListNode(0);
  ListNode first = cur;
  int value;
  int carry = 0;  //进位

  // 一种逻辑上更具备可读性的写法
  while(true){
    value = carry;
    if(l1 != null){
      value += l1.val;
      l1 = l1.next;
    }
    if(l2 != null){
      value += l2.val;
      l2 = l2.next;
    }
    carry = value / 10;
    value = value % 10;
    cur.val = value;
    if((l1 != null) || (l2 != null) || (carry != 0)){
      cur.next = new ListNode(0);
      cur = cur.next;
    } else {
      break;
    }
  } 
  return first;
}
```

## 一些考虑

1、由于if语句比较长，因此if语句用来赋值时经常使用以下表达式（上面不想让 l1 == null 判断两次）

`value += (l1 == null? 0 : l1.val) `

2、一些情况导致不怎么优雅，如果在进入循环后new第一个结果list节点，需要为两个输入list为空的情况加额外判断。如果在进入循环前new第一个节点，在每次的循环中，在循环体最后new下一个节点又需要多余一次判断（无法让每次循环使用相同的代码流程）。因此，while(true)用得不怎么优雅，跳出条件 `(l1 != null) || (l2 != null) || (carry != 0)` 判断为真时需要向结果list中添加新的节点。还可以考虑：

```java
// 将这两行拖到循环前
// 添加额外变量使第一次循环时不执行，或执行完后在结果list中删除第一个节点。
while ((l1 != null) || (l2 != null) || (carry != 0)) {
    if(isFisrst == true){
        isFisrst = false;
    }else{
        cur.next = new ListNode(0);
        cur = cur.next;
    }
    // ......
```



