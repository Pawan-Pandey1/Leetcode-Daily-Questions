class Solution {
    public String clearStars(String s) {
        int n = s.length();

        PriorityQueue<int[]> minH = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                int[] top = minH.poll();
                visited[top[1]] = true;
            } else {
                minH.offer(new int[] { ch, i });
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i] || s.charAt(i) == '*')
                continue;
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}