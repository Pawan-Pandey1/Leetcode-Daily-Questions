class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int days = events[0][0];
        int count = 0;
        int i = 0;

        while (i < n || !pq.isEmpty()) {

            while (i < n && events[i][0] == days) {
                pq.add(events[i][1]);
                i++;
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }

            days++;

            while (!pq.isEmpty() && days > pq.peek()) {
                pq.poll();
            }
        }
        return count;
    }
}