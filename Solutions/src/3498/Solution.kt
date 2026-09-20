package `3498`

class Solution {
    fun reverseDegree(s: String): Int {
        var ans = 0
        for (i in 0 until s.length) {
            val index = 26 - (s[i] - 'a')
            ans += index * (i + 1)
        }
        return ans
    }
}