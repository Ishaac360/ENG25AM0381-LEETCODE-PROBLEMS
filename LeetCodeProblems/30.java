import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (words.length == 0)
            return result;

        int len = words[0].length();
        int total = words.length;

        Map<String, Integer> required = new HashMap<>();

        for (String word : words)
            required.put(word, required.getOrDefault(word, 0) + 1);

        for (int i = 0; i < len; i++) {
            Map<String, Integer> window = new HashMap<>();

            int left = i, count = 0;

            for (int right = i; right + len <= s.length(); right += len) {
                String word = s.substring(right, right + len);

                if (required.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > required.get(word)) {
                        String removed = s.substring(left, left + len);

                        window.put(removed, window.get(removed) - 1);
                        left += len;
                        count--;
                    }

                    if (count == total) {
                        result.add(left);

                        String removed = s.substring(left, left + len);
                        window.put(removed, window.get(removed) - 1);

                        left += len;
                        count--;
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = right + len;
                }
            }
        }

        return result;
    }
}
