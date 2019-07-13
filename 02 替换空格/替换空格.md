# [替换空格](<https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking>)

## 题目描述

时间限制：1秒

空间限制：32768K

请实现一个函数，将一个字符串中的每个空格替换成`%20`。例如，当字符串为`We Are Happy`.则经过替换之后的字符串为`We%20Are%20Happy`。

## 解题思路

在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。

因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符。

令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。

P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。

从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。

### 解题代码

```java
public class Solution {
    public String replaceSpace(StringBuffer str) {
        /* 获取str初始尾部 */
        int p1 = str.length() - 1;

        /* 读取str中空格，并在str后填充两个空格
         * i = p1 时，在结尾的空格填充
        */
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        /* 获取str之后的尾部 */
        int p2 = str.length() - 1;

        /* p1 和 p2 向前遍历
         * 当 p1 遍历到空格时，p2 往前依次填充 0 2 %
         * 否则就填充当前 p1 位置的字符
         *
         */
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}
```

