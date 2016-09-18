# leetcode #204 Count Primes

## 题目
Count the number of prime numbers less than a non-negative number, n.

## 思路1
依次检测[2,n]之间的每个数是否为质数，最后求个数。
这种方法会超时。

## 思路2
从[2,n]中，依次删掉质数的倍数。
超时之后，也想到了这种方法，但确定一边删掉合数，一边确定质数，需要一点儿技巧。

## AC code
```cpp
int countPrimes(int n) {
    vector<bool> primes(n, true);
    int ret = 0;
    for (int i = 2; i*i <= n; i++) {
        if (primes[i]) {
            for (int j = i*i; j <= n; j += i)
                primes[j] = false;
        }
    }
    for (int i = 2; i < n; i++)
        if (primes[i]) ret++;
    return ret;
}
```
