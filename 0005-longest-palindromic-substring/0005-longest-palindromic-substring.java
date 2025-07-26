class Solution {
    private boolean checkIsPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n=s.length();

        int maxLength=1;
        String ans=s.substring(0,1);

        for(int i=0;i<n;i++){
            int len=0;
            for(int j=i;j<n;j++){
                if(checkIsPalindrome(i,j,s)){
                    len=j-i+1;
                    if(len>maxLength){
                        maxLength=len;
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}