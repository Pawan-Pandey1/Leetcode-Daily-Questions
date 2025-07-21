class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (char ch : map.keySet()) {
            pq.add(ch);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char c = pq.poll();
            int f = map.get(c);

            for (int i = 0; i < f; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}