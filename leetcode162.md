# leetcode #162.Find Peak Element
## 题目
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

*附加要求：lg(N)复杂度*
## 思路
http://blog.csdn.net/doc_sgl/article/details/41991809

1. 最直接的方法，就是逐个比较，比较次数是2N
2. N次比较方法
```cpp
int findPeakElement(const vector<int> &num) {//smart O(n), compare n times.  
    for(int i=1; i<num.size(); i++){  
        if(num[i] < num[i-1])  
            return i-1;  
    }  
    return num.size()-1;  
}  
```
其实，题目假设第0个元素比左边元素大，因此第i次只需比较右边就可以。因为能到达第i次，已经得到了第i个元素大于i-1的结论，否则第i-1已经是所求解了。
因此，可以近似认为数组是一个上升序列。因此就可以使用二分查找了。

3. 二分查找
```
int findPeakElement(vector<int>& nums) {
    int left = 0, right = nums.size() - 1;
    while (left <= right) {
        if (left == right) return left;
        int mid = (left + right) / 2;
        if (nums[mid] < nums[mid + 1]) left = mid + 1;
        else right = mid;
    }        
    return nums[nums.size()-1];
}
```