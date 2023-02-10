class Solution {
    fun isPalindrome(x: Int): Boolean {
      if(x < 0) return false 
      var n = x
      var rev = 0
      while(n > 0){
          rev = rev * 10 + n % 10
          n = n / 10
      }
      return rev == x
    }
}