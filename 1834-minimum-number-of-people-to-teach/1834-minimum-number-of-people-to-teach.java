class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            int person = i + 1;
            map.put(person, new HashSet<>());
            for (int lang : languages[i]) {
                map.get(person).add(lang);
            }
        }

        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            Set<Integer> set1 = map.get(f[0]);
            Set<Integer> set2 = map.get(f[1]);

            boolean talk = false;
            for (int l : set1) {
                if (set2.contains(l)) {
                    talk = true;
                    break;
                }
            }
            if (!talk) {
                needTeach.add(f[0]);
                needTeach.add(f[1]);
            }
        }

        int[] freq = new int[n + 1];
        int popularLang = 0;
        for (int person : needTeach) {
            for (int lang : map.get(person)) {
                freq[lang]++;
                popularLang = Math.max(popularLang, freq[lang]);
            }
        }
        return needTeach.size() - popularLang;
    }
}