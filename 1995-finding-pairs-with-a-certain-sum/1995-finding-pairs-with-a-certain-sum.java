class FindSumPairs {
    private List<Integer> nums1;
    private List<Integer> nums2;
    private Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = new ArrayList<>();
        for (int num : nums1) {
            this.nums1.add(num);
        }

        this.nums2 = new ArrayList<>();
        for (int num : nums2) {
            this.nums2.add(num);
        }

        freqMap = new HashMap<>();
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2.get(index);
        freqMap.put(oldVal, freqMap.getOrDefault(oldVal, 0) - 1);
        if (freqMap.get(oldVal) == 0) {
            freqMap.remove(oldVal);
        }

        int newVal = oldVal + val;
        nums2.set(index, newVal);
        freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            int complement = tot - num;
            count += freqMap.getOrDefault(complement, 0);
        }
        return count;
    }
}
