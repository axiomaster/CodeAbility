# leetcode #172 Factorial Trailing Zeroes

## 题目
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

## 思路
- 对[1,n]的所有数分解因式，当出现一对（2,5）因子时，尾部出现一个0.
- 因为因子中2的个数远多于5，所以只需要计算5的个数即可

***这思路好神奇***


## AC code
``` cpp
int trailingZeroes(int n) {
    if(n<1) return 0;
    int c = 0;
    while(n/5!=0){
        n/=5;
        c+=n;
    }
    return c;
}
```