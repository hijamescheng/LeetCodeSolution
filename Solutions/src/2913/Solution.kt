package `2913`

class Solution {
    fun sumCounts(nums: List<Int>): Int {
        var ans = 0
        for (i in 0 until nums.size) {
            val set = mutableSetOf<Int>()
            for (j in i until nums.size) {
                set.add(nums[j])
                ans += set.size * set.size
            }
        }
        return ans
    }
}