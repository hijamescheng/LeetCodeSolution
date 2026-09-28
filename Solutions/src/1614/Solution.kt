package `1614`

import kotlin.math.max

class Solution {
    fun maxDepth(s: String): Int {
        var balance = 0
        var ans = 0
        for (c in s) {
            if (c == '(') balance += 1
            if (c == ')') balance -= 1
            ans = max(ans, balance)
        }
        return ans
    }
}