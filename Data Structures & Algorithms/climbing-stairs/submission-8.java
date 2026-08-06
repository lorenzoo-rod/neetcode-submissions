class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int val = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, val);

        return val;
    }
}
