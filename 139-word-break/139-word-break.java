public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int end = start; end < s.length(); end++) {
                sb.append(s.charAt(end));
                if (wordDictSet.contains(sb.toString())) {
                    queue.add(end + 1);
                    if (end + 1 == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }
}