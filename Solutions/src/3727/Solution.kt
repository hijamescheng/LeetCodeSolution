package `3727`

class Solution {

    fun maxAlternatingSum(nums: IntArray): Long {
        // Square elements as Long to prevent 32-bit integer overflow
        val squares = LongArray(nums.size) { i ->
            val v = nums[i].toLong()
            v * v
        }

        // Sort in ascending order
        squares.sort()

        val n = nums.size
        val minusCount = n / 2 // Smallest half gets subtracted

        var sumMinus = 0L
        for (i in 0 until minusCount) {
            sumMinus += squares[i]
        }

        var sumPlus = 0L
        for (i in minusCount until n) {
            sumPlus += squares[i]
        }

        return sumPlus - sumMinus
    }
}