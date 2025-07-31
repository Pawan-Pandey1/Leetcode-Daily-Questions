class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer>result=new HashSet<>();
        HashSet<Integer>current=new HashSet<>();

        for(int num:arr){
            HashSet<Integer>next=new HashSet<>();

            next.add(num);

            for(int x:current){
                next.add(x|num);
            }
            current=next;
            result.addAll(current);
        }
        return result.size();
    }
}