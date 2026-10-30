class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int weight: stones) {
            heap.add(-weight);
        }

        while (heap.size() > 1) {
            int w1 = -heap.poll();
            int w2 = -heap.poll();

            if (w1 > w2) {
                w2 = w1 - w2;
                heap.add(-w2);
            }
        }

        return heap.size() == 0 ? 0 : -heap.peek();
    }
}
