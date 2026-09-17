package `1477`

import kotlin.math.min

class Solution {

    fun minSumOfLengths(arr: IntArray, target: Int): Int {
        val n = arr.size
        val INF = n + 1

        // dp[i] = shortest target-sum subarray
        // found within arr[0 until i]
        val dp = IntArray(n + 1) { INF }

        // prefix sum -> index
        val prefixMap = HashMap<Int, Int>()
        prefixMap[0] = 0

        var prefix = 0
        var answer = INF

        for (i in arr.indices) {
            prefix += arr[i]

            // We need:
            // prefix - previousPrefix = target
            // previousPrefix = prefix - target
            val previousPrefix = prefix - target

            if (prefixMap.containsKey(previousPrefix)) {
                val start = prefixMap[previousPrefix]!!

                // Current subarray: arr[start..i]
                val length = i - start + 1

                // dp[start] is the shortest valid subarray
                // completely before the current one.
                answer = minOf(
                    answer,
                    dp[start] + length
                )

                // Current subarray becomes a candidate
                // for future subarrays.
                dp[i + 1] = minOf(dp[i], length)
            } else {
                // No target-sum subarray ending at i
                dp[i + 1] = dp[i]
            }

            // Store prefix sum with the current position.
            prefixMap[prefix] = i + 1
        }

        return if (answer == INF) -1 else answer
    }
}