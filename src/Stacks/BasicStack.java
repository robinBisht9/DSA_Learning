package Stacks;

import java.util.ArrayDeque;

public class BasicStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.push(10);
        dq.push(20);
        dq.push(50);
        dq.push(80);
        System.out.println(dq.peek());
        System.out.println(dq.pop());
        System.out.println(dq.size());
        System.out.println(dq.isEmpty());
    }
    
}
