class Solution {
    public int possibleStringCount(String word) {
        int count=1;
        for(int i=1;i<word.length();i++){
            char ch1=word.charAt(i-1);
            char ch2=word.charAt(i);

            if(ch1==ch2){
                count++;
            }
        }
        return count;
    }
}