package `1621`

class Solution {
    fun numberOfSets(n: Int, k: Int): Int {
        val MOD = 1_000_000_007L

        val f = Array(n + 1) { LongArray(k + 1) }
        val g = Array(n + 1) { LongArray(k + 1) }

        // 1 point, 0 segments
        f[1][0] = 1

        for (i in 2..n) {
            for (j in 0..k) {

                // Not currently inside a segment
                f[i][j] = (f[i - 1][j] + g[i - 1][j]) % MOD

                // Currently inside a segment:
                // 1. Continue an existing segment
                g[i][j] = g[i - 1][j]

                if (j > 0) {
                    // 2. Start a new segment
                    g[i][j] += f[i - 1][j - 1]

                    // 3. Extend a previous segment
                    g[i][j] += g[i - 1][j - 1]

                    g[i][j] %= MOD
                }
            }
        }

        return ((f[n][k] + g[n][k]) % MOD).toInt()
    }
}