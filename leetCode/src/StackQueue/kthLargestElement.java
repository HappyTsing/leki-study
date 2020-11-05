package StackQueue;

import java.util.PriorityQueue;

public class kthLargestElement {
    static class KthLargest {
        PriorityQueue<Integer> priorityQueue;
        int limit;

        public KthLargest(int k, int[] nums) {
            limit=k;
            priorityQueue=new PriorityQueue<Integer>(limit);
            for (int num: nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (priorityQueue.size() < limit) {
                priorityQueue.add(val);
            } else if (val > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(val);
            }
            return priorityQueue.peek();

        }
    }

    public static void main(String[] args) {
        int k =3;
        var nums = new int[]{6,3,8,4,1,2};


         KthLargest obj = new KthLargest(k, nums);
         int param_1 = obj.add(-3);
         int param_2 = obj.add(5);
         int param_3 = obj.add(-4);
         int param_4 = obj.add(0);
         int param_5 = obj.add(4);


         System.out.println(param_1);
         System.out.println(param_2);
         System.out.println(param_3);
         System.out.println(param_4);
         System.out.println(param_5);
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
