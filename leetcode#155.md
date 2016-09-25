# leetcode #155 Min Stack

## 题目
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

- push(x) -- Push element x onto stack.
- pop() -- Removes the element on top of the stack.
- top() -- Get the top element.
- getMin() -- Retrieve the minimum element in the stack.

## 
``` cpp
public:
    /** initialize your data structure here. */
    MinStack() {
        
    }
    
    void push(int x) {
        content.push(x);
        if(mins.empty()||x<=mins.top())
            mins.push(x);
    }
    
    void pop() {
        int top = content.top();
        content.pop();
        if(top == mins.top()) mins.pop();
    }
    
    int top() {
        return content.top();
    }
    
    int getMin() {
        return mins.top();
    }
private:
    stack<int> content;
    stack<int> mins;
};
```