class Solution 
{
    public int minimumOneBitOperations(int n) 
    {
   
        if (n == 0)
        {
            return 0;
        } 


        int msb = 31 - Integer.numberOfLeadingZeros(n);
        int mask = 1 << msb;                
        int range = (1 << (msb + 1)) - 1;   

        int next = n ^ mask;         

        int resNext = minimumOneBitOperations(next);

        return range - resNext;
    }
}