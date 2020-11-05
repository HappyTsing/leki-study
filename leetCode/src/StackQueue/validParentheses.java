package StackQueue;

import java.util.HashMap;
import java.util.LinkedList;

class validParentheses {
    public boolean isValid(String s) {
        //1. 判断字符串奇偶，若为奇数，则放回false
        if (s.length() % 2 == 1) {
            return false;
        }

        //2. 构造一个HashMap，存放括号
        var pairsMap=new HashMap<Character,Character>(){
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        //3. 定义一个栈，用于存放左括号
        var stack = new LinkedList<Character>();

        //4. 判定
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairsMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairsMap.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}