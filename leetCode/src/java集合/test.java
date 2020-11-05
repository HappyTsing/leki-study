package java集合;

import java.util.*;

public class test {
    public static void main(String[] args) {

        var staffLinked = new LinkedList<String>();
        var staffArray = new ArrayDeque<String>();
        Deque a =new ArrayDeque<String>();
        var map = new HashMap<String, String>();
        map.put("name", "jack");
        map.put("age", "19");

        var map2 = new HashMap<String, String>(){
            {
                put("name", "jack");
                put("age", "19");
            }
        };
        System.out.println(map2.get("name"));

        staffLinked.push("Amy");
        staffLinked.push("Boy");
        staffLinked.push("Cat");
        System.out.println(staffLinked.pop());
        System.out.println(staffLinked.peek());
        System.out.println(staffLinked.getFirst());
        System.out.println(staffLinked.peekFirst());
        System.out.println(staffLinked.getLast());

    }
    class Solution {
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
}
