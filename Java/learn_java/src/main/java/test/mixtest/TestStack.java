/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.mixtest;

import java.util.LinkedList;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: TestStack.java, v 0.1 2018年04月14日 下午6:22 chuanshi.hzh Exp $
 */
public class TestStack {

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<Character>();
        String s = "+u+n+c---+e+r+t";
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if ('+' == a) {
                stack.push(s.charAt(++i));
                System.out.println(stack.toString());
            } else if ('-' == a) {
                Character character = stack.pop();
                System.out.println(character);
            }
        }
    }
}

class Stack<T> {
    private LinkedList<T> stack = new LinkedList<T>();

    public void push(T t) {//加入栈顶
        stack.addFirst(t);
    }

    public T peek() {//获取栈顶元素
        return stack.getFirst();
    }

    public T pop() {//弹出栈顶元素
        return stack.removeFirst();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public String toString() {
        return stack.toString();
    }
}