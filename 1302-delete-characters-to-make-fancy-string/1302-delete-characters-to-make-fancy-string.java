class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans=new StringBuilder();
        ans.append(s.charAt(0));

        int count=1;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i)){
                count++;
            }else{
                count=1;
            }
            if(count<3){
                ans.append(s.charAt(i));
            }
        }  
        return ans.toString(); 
    }
}