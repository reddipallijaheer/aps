class Solution {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            // descending order for max heap
            return p.val - this.val;
        }
    }

    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int ans[] = new int[n - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // First window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        ans[0] = pq.peek().val;

        // Sliding the window
        for (int i = k; i < n; i++) {

            // Remove elements outside the window
            while (!pq.isEmpty() && pq.peek().idx <= (i - k)) {
                pq.remove();
            }

            // Add current element
            pq.add(new Pair(arr[i], i));

            // Current maximum
            ans[i - k + 1] = pq.peek().val;
        }

        return ans;
    }
}