package `3550`

class Solution {
    fun smallestIndex(nums: IntArray): Int {
        for (i in nums.indices) {
            if (i == digitSum(nums[i])) return i
        }
        return -1
    }

    fun digitSum(num: Int): Int {
        var n = num
        var sum = 0
        while (n > 0) {
            sum += n % 10
            n /= 10
        }
        return sum
    }
}