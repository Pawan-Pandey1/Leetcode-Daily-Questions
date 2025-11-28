class Solution {
    Pair[] seg;

    // Pair class to store (value, index)
    static class Pair implements Comparable<Pair> {
        int val, idx;
        Pair(int val, int idx) {
            this.val = val; // MIN_VALUE
            this.idx = idx; // INDEX
        }

        @Override
        public int compareTo(Pair other) {
            if (this.val != other.val)
                return Integer.compare(this.val, other.val);
            return Integer.compare(this.idx, other.idx);
        }
    }

    // Build the segment tree
    void build(int ind, int low, int high, int[] target) {
        if (low == high) {
            seg[ind] = new Pair(target[low], low);
            return;
        }
        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid, target);
        build(2 * ind + 2, mid + 1, high, target);
        seg[ind] = (seg[2 * ind + 1].compareTo(seg[2 * ind + 2]) < 0)
                ? seg[2 * ind + 1]
                : seg[2 * ind + 2];
    }

    // Query for {min value, index} in range [l, r]
    Pair query(int ind, int low, int high, int l, int r) {
        if (high < l || low > r) return new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        if (low >= l && high <= r) return seg[ind];

        int mid = (low + high) / 2;
        Pair left = query(2 * ind + 1, low, mid, l, r);
        Pair right = query(2 * ind + 2, mid + 1, high, l, r);
        return (left.compareTo(right) < 0) ? left : right;
    }

    public int minNumberOperations(int[] target) {
        int n = target.length;
        seg = new Pair[4 * n];
        build(0, 0, n - 1, target);

        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, n - 1, 0}); // {l, r, baseLevel}

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int l = cur[0], r = cur[1], level = cur[2];
            Pair res = query(0, 0, n - 1, l, r);
            int mini = res.val, idx = res.idx;

            ans += (mini - level);
            if (idx - 1 >= l) q.add(new int[]{l, idx - 1, mini});
            if (idx + 1 <= r) q.add(new int[]{idx + 1, r, mini});
        }

        return ans;
    }
}