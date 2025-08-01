class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        
        if(j==-1) return;

        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                swap(i, j, nums);
                j++;
            }
        }
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}