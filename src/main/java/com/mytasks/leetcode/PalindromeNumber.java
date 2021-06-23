//https://leetcode.com/problems/palindrome-number/

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length() - (i + 1))) {return false;}
        }
        return true;
    }
}


'''
    Faster solution:

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x!=0 && x%10==0)) {
            return false;
        }
        int result = 0;
        while(x > result) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return (x==result || x==result/10);
    }
}
'''
