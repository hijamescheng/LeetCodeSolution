package `74`

class Solution {

    // Slice the matrix by each row and glue them into a sorted array, perform binary search on it
    // map the selected index back into the matrix to access the selected value
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val row = matrix.size
        val col = matrix[0].size
        var low = 0
        var hi = row * col - 1
        while (low <= hi) {
            val mid = low + (hi - low) / 2
            val r = mid / col
            val c = mid % col
            when {
                matrix[r][c] == target -> return true
                matrix[r][c] > target -> hi = mid - 1
                else -> low = mid + 1
            }
        }
        return false
    }
}