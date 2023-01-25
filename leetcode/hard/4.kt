class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        
        
        val pq = PriorityQueue<Int>()
        nums1.forEach { num ->
            pq.add(num)
        }
        nums2.forEach { num ->
            pq.add(num)
        }      

        var median = -1.0
        val size = pq.size
        if (size % 2 == 0)  {
            println("size ${size}")
            for (i in 0 until size/2 -1) {
                pq.poll()
            }

            val one = pq.poll()
            val two = pq.poll()
            // println(one)
            // println(two)
            median = (one.toDouble() + two.toDouble()) / 2

        } else {
            for (i in 0 until size/2) {
                pq.poll()
            }
            median = pq.poll().toDouble()
        }

        // println(median)
        // println(pq.poll())
        // println(pq.poll())
        return median
    }
}