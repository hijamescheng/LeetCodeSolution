package `2472`

import kotlin.math.max

class Solution {
    fun maxPalindromes(s: String, k: Int): Int {
        val dp = IntArray(s.length+1)

        // use a pre-computed 2D array to tell if a section of a string is a palindrome
        val n = s.length
        val isPali = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            for (j in 0..i) {
                if (s[j] == s[i] && (i - j < 2 || isPali[j + 1][i - 1])) {
                    isPali[j][i] = true
                }
            }
        }

        for (i in 0 until s.length) {
            for (j in i downTo 0) {
                val str = s.substring(j, i+1)
                if (isPali[j][i] && str.length >= k) {
                    dp[i+1] = max(dp[i+1], dp[j] + 1)
                } else {
                    dp[i+1] = max(dp[i+1], dp[j])
                }
            }
        }

        return dp[s.length]
    }
}