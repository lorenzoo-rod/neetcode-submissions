class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preToNext = new HashMap<>();

        for (int[] pair: prerequisites) {
            int next = pair[0];
            int pre = pair[1];

            if (preToNext.containsKey(pre)) {
                preToNext.get(pre).add(next);
            } else {
                Set<Integer> temp = new HashSet<>();
                temp.add(next);
                preToNext.put(pre, temp);
            }
        }

        int[] state = new int[numCourses];
        for (int pre: preToNext.keySet()) {
            if (containsCycle(pre, preToNext, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean containsCycle(int pre, Map<Integer, Set<Integer>> preToNext, int[] state) {
        
        if (state[pre] == 1) {
            return true;
        }

        if (state[pre] == 2) {
            return false;
        }

        state[pre] = 1;

        if (!preToNext.containsKey(pre)) {
            state[pre] = 2;
            return false;
        }

        for (int nextClass: preToNext.get(pre)) {
            if (containsCycle(nextClass, preToNext, state)) {
                return true;
            }
        }

        state[pre] = 2;

        return false;
    }
}
