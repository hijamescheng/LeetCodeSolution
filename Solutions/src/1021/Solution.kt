package `1021`

class Solution {
    fun removeOuterParentheses(S: String): String {
        if (S.isEmpty()) return ""
        var sbTemp = StringBuffer()
        val sb = StringBuffer()
        var isMatched = 0
        for (i in 0 until S.length) {
            if (S[i] == '(') {
                isMatched++
                sbTemp.append("${S[i]}")
            } else {
                isMatched--
                sbTemp.append("${S[i]}")
            }
            if (isMatched == 0) {
                sb.append(sbTemp.substring(1, sbTemp.length - 1))
                sbTemp = StringBuffer()
            }
        }
        return sb.toString()
    }
}