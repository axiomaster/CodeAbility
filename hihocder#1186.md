# hihocoder #1186 : Coordinates

## 备注
微软预科生计划-探星夏令营在线测试

## 描述
Give you two integers P and Q. Let all divisors of P be X-coordinates. Let all divisors of Q be Y-coordinates.

For example, when P=6 and Q=2, we can get the coordinates (1,1) (1,2) (2,1) (2,2) (3,1) (3,2) (6,1) (6,2).

You should print all possible coordinates in the order which is first sorted by X-coordinate when coincides, sorted by Y-coordinate.

## 输入
One line with two integers P and Q(1 <= P, Q <= 10000).


## 输出
The output may contains several lines , each line with two integers Xi and Yi, denoting the coordinates.

## 样例输入
```
6 2
```
## 样例输出
```
1 1
1 2
2 1
2 2
3 1
3 2
6 1
6 2
```
## code
```cpp
#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int p, q;
	while(cin >> p >> q){
    	vector<int> d1, d2, dd;
    	for (int i = 1; i <= p; i++) {
    		if (p%i == 0) d1.push_back(i);
    	}
    	for (int i = 1; i <= q; i++) {
    		if (q%i == 0) d2.push_back(i);
    	}
    	for (int i = 0; i < d1.size(); i++) {
    		for (int j = 0; j < d2.size(); j++) {
    			cout<<d1[i]<<" "<<d2[j]<<endl;
    		}
    	}
	}


	return 0;
}
```

## 说明

上去就想偏了，关注于怎么做排序。
做一个类似point的struct，然后重载实现比较函数，进行排序。
后来自以为聪明的想到了 a*10+b直接进行排序，然后再模运算拿到a,b...
额，原来已经自动有序了，囧rz