package `2267`

class Solution {
    fun hasValidPath(grid: Array<CharArray>): Boolean {
        return dfs(grid, 0, 0, 0)
    }

    val map = mutableMapOf<String, Boolean>()
    fun dfs(grid: Array<CharArray>, i: Int, j: Int, bal: Int): Boolean {
        if (i == grid.size || j == grid[0].size) return false

        val key = "${i},${j},${bal}"
        if (map.containsKey(key)) {
            return map[key]!!
        }

        val newBal = if (grid[i][j] == '(') bal + 1 else bal - 1
        if (newBal < 0) return false

        if (i == grid.size - 1 && j == grid[0].size - 1) return newBal == 0

        val hasValidPath = dfs(grid, i+1, j, newBal) || dfs(grid, i, j+1, newBal)
        map[key] = hasValidPath
        return hasValidPath
    }
}