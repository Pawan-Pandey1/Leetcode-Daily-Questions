class Solution {
    private List<Integer> generateRow(int row){
        
        List<Integer>ansRow=new ArrayList<>();
        ansRow.add(1);
        
        int ans=1;

        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans=ans/col;
            ansRow.add(ans);
        }
        return ansRow;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<>();
        
        for(int i=1;i<=numRows;i++){
            result.add(generateRow(i));
        }
        return result;
    }
}