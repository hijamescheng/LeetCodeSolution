package `921`

import kotlin.math.abs

class Solution {
    fun minAddToMakeValid(s: String): Int {
        var balance = 0
        var cnt = 0
        for (i in 0 until s.length) {
            if (s[i] == '(') {
                balance ++
            } else {
                balance --
            }
            if (balance < 0) {
                cnt += abs(balance)
                balance = 0
            }
        }
        cnt += balance
        return cnt
    }
}
