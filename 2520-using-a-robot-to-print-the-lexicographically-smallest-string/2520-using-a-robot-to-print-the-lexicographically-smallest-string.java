class Solution {
    public String robotWithString(String s) {
        Stack<Character>stack=new Stack<>();
        int[]freq=new int[26];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        StringBuilder t=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            stack.push(ch);
            freq[ch-'a']--;

            while(!stack.isEmpty() && stack.peek()<=smallestCharFreq(freq)){
                t.append(stack.pop());
            }
        }
        while(!stack.isEmpty()){
            t.append(stack.pop());
        }
        return t.toString();
    }

    private char smallestCharFreq(int[]freq){
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                return (char)('a'+i);
            }
        }
        return 'a';
    }
}