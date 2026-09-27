package `1190`

import java.util.LinkedList

class Solution {
    fun reverseParentheses(s: String): String {
        val stack = LinkedList<Char>()
        val queue = LinkedList<Char>()
        for (c in s) {
            if (c != ')') {
                stack.push(c)
            } else {
                while (stack.isNotEmpty()) {
                    if (stack.peek() == '(') break
                    queue.offer(stack.pop())
                }

                if (stack.peek() == '(') stack.pop()

                while (queue.isNotEmpty()) {
                    stack.push(queue.poll())
                }
            }
        }
        return stack.joinToString("").reversed()
    }
}