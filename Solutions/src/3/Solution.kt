package `3`

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var len = 0
        while (right < s.length) {
            if (map.contains(s[right])) {
                var newLeft = map[s[right]]!!
                while (left <= newLeft) {
                    map.remove(s[left])
                    left ++
                }
            } else {
                len = max(len, right - left + 1)
            }
            map[s[right]] = right
            right ++
        }
        return len
    }
}