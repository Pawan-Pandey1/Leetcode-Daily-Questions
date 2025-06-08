class Solution {
    public void solve(int curr,int n,List<Integer>result){
        if(curr>n){
            return;
        }
        result.add(curr);

        for(int nextDig=0;nextDig<=9;nextDig++){
            int newNum=(curr*10)+nextDig;

            if(newNum>n){
                return;
            }else{
                solve(newNum,n,result);
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer>result=new ArrayList<>();
        for(int startsWith=1;startsWith<=9;startsWith++){
            solve(startsWith,n,result);
        }
        return result;
    }
}