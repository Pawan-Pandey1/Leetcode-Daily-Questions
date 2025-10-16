class Solution {
    public int findSmallestInteger(int[] nums, int value) 
    {

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0&&nums[i]%value!=0)
            nums[i]=value+(nums[i]%value);
            else
            nums[i]%=value;

        }

        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i:nums)
        map.put(i,map.getOrDefault(i,0)+1);

        int ans=0;
        while(true)
        {
            if(map.containsKey(ans))
            {
                if(map.get(ans)==1)
                map.remove(ans);
                else
                map.put(ans,map.get(ans)-1);
                ans++;
            }
            else 
            {
                int key=ans%value;
                if(map.containsKey(key))
                {
                     if(map.get(key)==1)
                        map.remove(key);
                    else
                        map.put(key,map.get(key)-1);
                        ans++;
                }
                else
                return ans;
            }
        }
    }
}