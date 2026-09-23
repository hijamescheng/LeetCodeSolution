package `1658`

import kotlin.math.max

class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        var left = 0
        var right = 0
        var sum = 0
        val target = nums.sum() - x
        if (target == 0) return nums.size
        var len = -1
        while (right < nums.size) {
            sum += nums[right]
            while (sum > target && left < right) {
                sum -= nums[left]
                left ++
            }
            if (sum == target) len = max(len, right - left + 1)
            right ++
        }
        return if (len == -1) return len else nums.size - len
    }
}