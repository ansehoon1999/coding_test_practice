class Solution {
    fun solution(s: String): Int {
        var answer = -1

        for(cur in 0 until s.length) {

            var flag = false
            var left = cur - 1
            var right = cur + 1
            if(cur <= s.length - 2 && s[cur] == s[cur+1]) {
                right += 1
                flag = true
            }

            var cnt = 0
            while((left in 0 .. s.length - 1) && (right in 0 .. s.length - 1)) {
                // println("${left} ${right}")

                if(s[left] != s[right]) {
                    if(flag) {
                        answer = maxOf(answer, cnt * 2 + 2)
                    } else {
                        answer = maxOf(answer, cnt * 2 + 1)
                    }
                    // println("answer: ${answer}")
                    break
                } else {

                    cnt ++
                    left -= 1
                    right += 1
                }
            }

            if(flag) {
                answer = maxOf(answer, cnt * 2 + 2)
            } else {
                answer = maxOf(answer, cnt * 2 + 1)
            }


            // println()

        }

        // 홀수

        for(cur in 0 until s.length) {

            var left = cur - 1
            var right = cur + 1

            var cnt = 0
            while((left in 0 .. s.length - 1) && (right in 0 .. s.length - 1)) {
                // println("${left} ${right}")

                if(s[left] != s[right]) {

                    answer = maxOf(answer, cnt * 2 + 1)

                    break
                } else {

                    cnt ++
                    left -= 1
                    right += 1
                }
            }

            answer = maxOf(answer, cnt * 2 + 1)

            // println()

        }

        return answer
    }
}