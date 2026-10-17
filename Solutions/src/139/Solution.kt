package `139`

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val set = wordDict.toSet()
        val dp = BooleanArray(s.length + 1)
        dp[0] = true
        for (i in 0 until s.length) {
            for (k in 0 until i + 1) {
                dp[i+1] = dp[k] && s.substring(k, i+1) in set
                if (dp[i+1]) break
            }
        }
        return dp[dp.size - 1]
    }
}