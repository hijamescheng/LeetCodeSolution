package `4`

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val arr = IntArray(nums1.size + nums2.size)
        var first = 0
        var second = 0
        var i = 0
        while (first < nums1.size && second < nums2.size) {
            if (nums1[first] >= nums2[second]) {
                arr[i] = nums2[second]
                second ++
            } else if (nums1[first] < nums2[second]) {
                arr[i] = nums1[first]
                first ++
            }
            i++
        }

        while (first < nums1.size) {
            arr[i] = nums1[first]
            first ++
            i++
        }

        while (second < nums2.size) {
            arr[i] = nums2[second]
            second ++
            i++
        }

        return if (arr.size % 2 == 0) {
            val l = (arr.size - 1) / 2
            val h = l + 1
            (arr[l] + arr[h]) / 2.0
        } else {
            val index = (arr.size - 1) / 2
            arr[index] * 1.0
        }
    }
}

