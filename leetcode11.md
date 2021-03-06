# leetcode #11. Container With Most Water

## 题目
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

## 分析
http://blog.csdn.net/a83610312/article/details/8548519


1. 首先假设我们找到能取最大容积的纵线为 i , j (假定i<j)，那么得到的最大容积 C = min( ai , aj ) * ( j- i) ；

2. 下面我们看这么一条性质：

- 在 j 的右端没有一条线会比它高！ 假设存在 k |( j<k && ak > aj) ，那么  由 ak> aj，所以 min( ai,aj, ak) =min(ai,aj) ，所以由i, k构成的容器的容积C' = min(ai,aj ) * ( k-i) > C，与C是最值矛盾，所以得证j的后边不会有比它还高的线；

- 同理，在i的左边也不会有比它高的线；

这说明什么呢？如果我们目前得到的候选： 设为 x, y两条线（x< y)，那么能够得到比它更大容积的新的两条边必然在  [x,y]区间内并且 ax' > =ax , ay'>= ay;

3. 所以我们从两头向中间靠拢，同时更新候选值；在收缩区间的时候优先从  x, y中较小的边开始收缩；

这样只需从两边向中间遍历就好，O(N)复杂度，之前为O(N^2)

```
int maxArea(vector<int>& h) {
    int ret = 0;
    int n = h.size();
    int l = 0, r = n-1;
    while(l<r){
        ret = max(ret, min(h[l], h[r])*(r-l));
        if(h[l]<h[r]){
            int k = l;
            while(k<r&&h[k]<=h[l]) k++;
            l = k;
        }else{
            int k = r;
            while(k>l&&h[k]<=h[r]) k--;
            r = k;
        }
    }
    return ret;
}
```