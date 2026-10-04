package `678`

class Solution {
    fun checkValidString(s: String): Boolean {
        var openCount = 0
        var closeCount = 0
        for (i in 0 until s.length) {
            if (s[i] == '(' || s[i] == '*') {
                openCount ++
            } else {
                openCount --
            }

            if (s[s.length - i - 1] == ')' || s[s.length - i - 1] == '*') {
                closeCount ++
            } else {
                closeCount --
            }

            if (openCount < 0 || closeCount < 0) return false
        }

        return true
    }
}