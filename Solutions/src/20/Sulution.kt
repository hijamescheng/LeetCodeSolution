package `20`

import java.util.Stack

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (i in 0 until s.length) {
            if (s[i] == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false
            } else if (s[i] == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false
            } else if (s[i] == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false
            } else {
                stack.push(s[i])
            }
        }
        return stack.isEmpty()
    }
}