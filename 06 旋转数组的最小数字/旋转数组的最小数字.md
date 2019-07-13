# [旋转数组的最小数字](<https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking>)

## 题目描述

时间限制：3秒

空间限制：32768K

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 

输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 

例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 

NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

## 解题思路

### 二分法查找

把输入的旋转数组对半分，可以分为一个非减排序数组和一个新的旋转数组，这个新的旋转数组包含最小元素。

非减排序数组的第一个元素一定小于等于最后一个元素。

设`l`为数组第一个元素的索引，`m`为`mid`，`h`为`high`。

- `array[m] <= array[h]`，表示`[m, h]`为非减排序数组，`[l, m]` 为新旋转数组，令`h = m`；
- 否则 `[m, h]`是旋转数组，令`l = m+1`。

```java
public int minNumberInRotateArray(int [] array) {
    if (array.length == 0 || null == array) {
        return 0;
    }

    int l = 0, h = array.length - 1;
    while (l < h) {
        int m = (l + h) / 2;
        if (array[m] <= array[h]) {
            h = m;
        } else {
            l = m + 1;
        }
    }
    return array[l];
}
```

