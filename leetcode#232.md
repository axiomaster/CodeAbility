# leetcode #232 Implement Queue using Stacks

## 题目
Implement the following operations of a queue using stacks.

- push(x) -- Push element x to the back of queue.
- pop() -- Removes the element from in front of queue.
- peek() -- Get the front element.
- empty() -- Return whether the queue is empty.

## 思路
使用2个stack来模拟队列

## AC code

``` cpp
class Queue {
public:
    // Push element x to the back of queue.
    void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    void pop(void) {
        if(out.empty()){ 
            adap();
        }
        if(!out.empty()){  //只要out不为空，其中所有元素均在in之前进队列，不需要考虑in
            out.pop();
        }
    }

    // Get the front element.
    int peek(void) {
        if(out.empty()) adap();
        //if(!out.empty()) 
        return out.top();
    }

    // Return whether the queue is empty.
    bool empty(void) {
        return in.empty()&&out.empty();
    }
private:
    stack<int> in, out;
    void adap(){
        while(!in.empty()){
            int x= in.top();
            in.pop();
            out.push(x);
        }
    }
};
```